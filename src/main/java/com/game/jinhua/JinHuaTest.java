package com.game.jinhua;


import org.junit.Test;

import java.util.*;

import static com.game.jinhua.JinHua.*;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class JinHuaTest {

    @Test
    public void guessChance() {
        for (int i = 0; i < 1000; i++) {
            JinHua jinHua = new JinHua();
            jinHua.dealAll();
            System.out.println(jinHua.getPlayerPokers());
            Map<String, Player> map = jinHua.getPlayerPokers();
            for (String s : map.keySet()) {
                Stack<String> pokers = map.get(s).getPokers();
                System.out.println(s + " " + JinHua.isSameColor(pokers));
            }
        }
    }

    @Test
    public void testOpen() {
        JinHua jinHua = new JinHua();
        jinHua.dealAll();
        System.out.println(jinHua.getPlayerPokers());
        Map<String, Player> map = jinHua.getPlayerPokers();

        for (String s1 : map.keySet()) {
            for (String s2 : map.keySet()) {
                if (!s1.equals(s2)) {
                    Stack<String> pokers1 = map.get(s1).getPokers();
                    Stack<String> pokers2 = map.get(s2).getPokers();
                    String message =  s1 + "的牌为" + getTypeName(pokers1) + " ";
                    message += s2 + "的牌为" + getTypeName(pokers2) + " ";
                    message += s1 + "和" + s2 + "的比较结果为" + open(pokers1, pokers2);
                    System.out.println(message);
                }

            }
        }
    }

    @Test
    public void testMid() {
        JinHua jinHua = new JinHua();
        jinHua.dealAll();
        System.out.println(jinHua.getPlayerPokers());
        Map<String, Player> map = jinHua.getPlayerPokers();
        for (String s : map.keySet()) {
            Stack<String> pokers = map.get(s).getPokers();
            System.out.println("排序前" + pokers);
            System.out.println("中间牌" + mid(pokers));
        }
    }

    @Test
    public void testSort() {

        JinHua jinHua = new JinHua();
        jinHua.dealAll();
        System.out.println(jinHua.getPlayerPokers());
        Map<String, Player> map = jinHua.getPlayerPokers();
        for (String s : map.keySet()) {
            Stack<String> pokers = map.get(s).getPokers();
            System.out.println("排序前" + pokers);
            pokers = sort(pokers);
            System.out.println("排序后" + pokers);
        }
    }

    @Test
    public void testShunJin() {
        boolean shunjin = false;
        int count = 0;
        while (!shunjin) {
            count ++;
            JinHua jinHua = new JinHua();
            jinHua.dealAll();
            System.out.println(jinHua.getPlayerPokers());
            Map<String, Player> map = jinHua.getPlayerPokers();
            for (String s : map.keySet()) {
                Stack<String> pokers = map.get(s).getPokers();
                if (shunjin = isShunJin(pokers)) {
                    System.out.println(map);
                    System.out.println(s + "是顺金，" + pokers);
                    System.out.println(count);
                    break;
                }
            }
        }
    }

    @Test
    public void testDuiZi() {
        boolean duizi = false;
        int count = 0;
        while (!duizi) {
            count ++;
            JinHua jinHua = new JinHua();
            jinHua.dealAll();
            System.out.println(jinHua.getPlayerPokers());
            Map<String, Player> map = jinHua.getPlayerPokers();
            for (String s : map.keySet()) {
                Stack<String> pokers = map.get(s).getPokers();
                if (duizi = isDuiZi(pokers)) {
                    System.out.println(map);
                    System.out.println(s + "是对子，" + pokers);
                    System.out.println(count);
                    break;
                }
            }
        }
    }

    @Test
    public void testDanPai() {
        boolean danpai = false;
        int count = 0;
        while (!danpai) {
            count ++;
            JinHua jinHua = new JinHua();
            jinHua.dealAll();
            System.out.println(jinHua.getPlayerPokers());
            Map<String, Player> map = jinHua.getPlayerPokers();
            for (String s : map.keySet()) {
                Stack<String> pokers = map.get(s).getPokers();
                if (danpai = isDanPai(pokers)) {
                    System.out.println(map);
                    System.out.println(s + "是单牌，" + pokers);
                    System.out.println(count);
                    break;
                }
            }
        }
    }

    @Test
    public void testJinHua() {
        boolean jinhua = false;
        int count = 0;
        while (!jinhua) {
            count ++;
            JinHua jinHua = new JinHua();
            jinHua.dealAll();
            System.out.println(jinHua.getPlayerPokers());
            Map<String, Player> map = jinHua.getPlayerPokers();
            for (String s : map.keySet()) {
                Stack<String> pokers = map.get(s).getPokers();
                if (jinhua = isJinHua(pokers)) {
                    System.out.println(map);
                    System.out.println(s + "是金花，" + pokers);
                    System.out.println(count);
                    break;
                }
            }
        }
    }

    @Test
    public void testShunZi() {
        boolean shunzi = false;
        int count = 0;
        while (!shunzi) {
            count ++;
            JinHua jinHua = new JinHua();
            jinHua.dealAll();
            System.out.println(jinHua.getPlayerPokers());
            Map<String, Player> map = jinHua.getPlayerPokers();
            for (String s : map.keySet()) {
                Stack<String> pokers = map.get(s).getPokers();
                if (shunzi = isShunZi(pokers)) {
                    System.out.println(map);
                    System.out.println(s + "是顺子，" + pokers);
                    System.out.println(count);
                    break;
                }
            }
        }
    }

    @Test
    public void testContinuous() {
        boolean continuous = false;
        int count = 0;
        while (!continuous) {
            count ++;
            JinHua jinHua = new JinHua();
            jinHua.dealAll();
            System.out.println(jinHua.getPlayerPokers());
            Map<String, Player> map = jinHua.getPlayerPokers();
            for (String s : map.keySet()) {
                Stack<String> pokers = map.get(s).getPokers();
                if (continuous = isContinuous(pokers)) {
                    System.out.println(map);
                    System.out.println(s + "是连续的，" + pokers);
                    System.out.println(count);
                    break;
                }
            }
        }
    }

    @Test
    public void testBaoZi() {
        boolean baoZi = false;
        int count = 0;
        while (!baoZi) {
            count ++;
            JinHua jinHua = new JinHua();
            jinHua.dealAll();
            System.out.println(jinHua.getPlayerPokers());
            Map<String, Player> map = jinHua.getPlayerPokers();
            for (String s : map.keySet()) {
                Stack<String> pokers = map.get(s).getPokers();
                if (baoZi = isBaoZi(pokers)) {
                    System.out.println(map);
                    System.out.println(count);
                    break;
                }
            }
        }
    }

    @Test
    public void testSameColor() {
        JinHua jinHua = new JinHua();
        jinHua.dealAll();
        System.out.println(jinHua.getPlayerPokers());
        Map<String, Player> map = jinHua.getPlayerPokers();
        for (String s : map.keySet()) {
            Stack<String> pokers = map.get(s).getPokers();
            System.out.println(s + " " + JinHua.isSameColor(pokers));
        }
    }

    @Test
    public void testMax() {
        JinHua jinHua = new JinHua();
        jinHua.dealAll();
        System.out.println(jinHua.getPlayerPokers());
        Map<String, Player> map = jinHua.getPlayerPokers();
        for (String s : map.keySet()) {
            Stack<String> pokers = map.get(s).getPokers();
            String max = JinHua.max(pokers);
            System.out.println(s + "最大牌为 " + max);
        }
    }

    /**
     * 判断一定次数每种类型出现次数
     */
    @Test
    public void testCount() {
        // 豹子>顺金>金花>顺子>对子>单牌
        Map<String, Integer> typMap = new HashMap<>();
        Map<String, List<Integer>> typMapIndexDetail = new HashMap<>();
        Map<String, List<Integer>> typMapDetail = new HashMap<>();
        Map<Integer, Map<String, Player>> pokersDetail = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (String typName : TYPE_NAME) {
            typMap.put(typName, 0);
        }
        for (String typName : TYPE_NAME) {
            typMapIndexDetail.put(typName, new ArrayList<>());
        }

        for (int i = 0; i < COUNT; i++) {
            JinHua jinHua = new JinHua();
            jinHua.dealAll();
            System.out.println("第" + (i + 1) +  "轮 " + jinHua.getPlayerPokers());
            Map<String, Player> map = jinHua.getPlayerPokers();
            pokersDetail.put((i+1), map);
            for (String s : map.keySet()) {
                Stack<String> pokers = map.get(s).getPokers();
                String typName = getTypeName(pokers);
                typMap.put(typName, typMap.get(typName) + 1);
                list = typMapIndexDetail.get(typName);
                if (null == list) list = new ArrayList<>();
                list.add(i+1);
                typMapIndexDetail.put(typName, list);
            }
        }
        System.out.println(typMap);
        int sum = 0;
        for (String s : typMap.keySet()) {
            sum += typMap.get(s);
        }
        System.out.println("合计牌数：" + sum);
        System.out.println("豹子：" + typMapIndexDetail.get("豹子"));
        System.out.println("顺金：" + typMapIndexDetail.get("顺金"));
        System.out.println("金花：" + typMapIndexDetail.get("金花"));
        System.out.println("顺子：" + typMapIndexDetail.get("顺子"));
//        System.out.println(pokersDetail);

    }

    @Test
    public void getInitPokers() {
        System.out.println(initPokers.size());
        System.out.println("================");


        System.out.println("initPokers=>" + initPokers);


        System.out.println("================");
        System.out.println(allChancePokers);
    }

    @Test
    public void getAllChancePokers() {

        System.out.println(allChancePokers);
        System.out.println(TYPE_NAME_DETAIL_NUM);
        int sum = 0;
        for (String s : TYPE_NAME_DETAIL_NUM.keySet()) {
            sum += TYPE_NAME_DETAIL_NUM.get(s);
        }

        System.out.println(sum);

        System.out.println(POKERS_RATE);
    }

    @Test
    public void test() {
        System.out.println("1".compareTo("2"));
        System.out.println("9".compareTo("8"));
        System.out.println("10".compareTo("J"));
    }
}