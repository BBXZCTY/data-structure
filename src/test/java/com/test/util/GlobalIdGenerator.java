package com.test.util;

import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: hfr
 * @Date: 2019-09-04 12:26
 * @Version 1.0
 */
public class GlobalIdGenerator {


    private static GlobalIdGenerator instance = null;
    static{//由类加载机制保证只加载一次
        if(instance == null){
            try {
                instance = new GlobalIdGenerator();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    /** 机器id所占的位数，用来标识客户端 */
    private final long workerIdBits = 10L;

    /** 序列在id中占的位数 */
    private final long sequenceBits = 12L;

    /** 机器ID向左移12位 */
    private final long workerIdShift = sequenceBits;

    /** 时间截向左移22位(5+5+12) */
    private final long timestampLeftShift = sequenceBits + workerIdBits;

    /** 生成序列的掩码，这里为4095 (0b111111111111=0xfff=4095) */
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    /** 工作机器ID(0~31) */
    private long workerId;

    /** 毫秒内序列(0~4095) */
    private long sequence = 0L;


    /** 上次生成ID的时间截 */
    private long lastTimestamp = -1L;

    /** 开始时间截，通过服务端配置进行维护，防止客户端随意修改，一经确定，随意修改会导致生成的id重复 */
    /** 如果非要修改，只能改成比当前配置的 时间更早的时间，否则id会出现重复*/
    private long twepoch = 1504875714146L;

    protected long timeGen() {
        return System.currentTimeMillis();
    }

    /**
     * 阻塞到下一个毫秒，直到获得新的时间戳
     *
     * @param lastTimestamp
     *            上次生成ID的时间截
     * @return 当前时间戳
     */
    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    public synchronized long nextGlobalId() {
        long timestamp = timeGen();

        System.out.println("    timestamp = " + timestamp);
        System.out.println("lastTimestamp = " + lastTimestamp);
        // 如果当前时间小于上一次ID生成的时间戳，说明系统时钟回退过这个时候应当抛出异常
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds",lastTimestamp - timestamp));
        }

        // 如果是同一时间生成的，则进行毫秒内序列
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            // 毫秒内序列溢出
            if (sequence == 0) {
                // 阻塞到下一个毫秒,获得新的时间戳
                timestamp = tilNextMillis(lastTimestamp);
            }
        }else {// 时间戳改变，毫秒内序列重置
            sequence = 0L;
        }
        // 上次生成ID的时间截
        lastTimestamp = timestamp;
        // 移位并通过或运算拼到一起组成64位的ID
        return ((timestamp - twepoch) << timestampLeftShift)| (workerId << workerIdShift) | sequence;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                long id = GlobalIdGenerator.instance.nextGlobalId();
                System.out.println("      id = " + id + "\n");
            }).start();
        }
    }

}