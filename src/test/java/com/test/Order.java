package com.test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: hfr
 * @Date: 2019-06-11 11:26
 * @Version 1.0
 */
public class Order {

    /** 机器id所占的位数，用来标识客户端 */
    private final long workerIdBits = 10L;

    /** 支持的最大机器id，结果是31 (这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数) */
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);

    /** 序列在id中占的位数 */
    private final long sequenceBits = 12L;

    /** 生成序列的掩码，这里为4095 (0b111111111111=0xfff=4095) */
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    /** 工作机器ID(0~31) 每台机器上做配置 */
    private long workerId = 21;

    /** 毫秒内序列(0~4095) */
    private long sequence = 0L;

    /** 上次生成ID的时间截 */
    private long lastTimestamp = -1L;

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

    public synchronized String nextOrderId(String prefix) {
        long timestamp = timeGen();

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
        Date d = new Date(timestamp);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        if(null == prefix){
            return sdf.format(d) + String.format("%02d", workerId)+ String.format("%03d", sequence);
        }
        return prefix + sdf.format(d) + String.format("%02d", workerId)+ String.format("%03d", sequence);
    }

    public static void main(String[] args) {
        Order order = new Order();
        System.out.println(order.nextOrderId("DD"));
    }

}