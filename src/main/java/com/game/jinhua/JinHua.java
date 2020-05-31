package com.game.jinhua;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static java.math.BigDecimal.ROUND_HALF_UP;

/**
 * 规则：
 * 15元底牌，第一轮可以看牌，蒙牌5元起，看牌5*2元起，下一个玩家不能小于上一个玩家，如果蒙牌>=5元，看牌>=10元，封顶100元，轮数不限制。
 * 如果场上还剩三个极其以上玩家，连续蒙牌三轮之后，可以看其中一位玩家的牌，如果还剩两个玩家，随时可以看对方的牌。
 */
public class JinHua {

    static String[] COLOR = {"黑桃","红桃","方块","梅花"};
    static String[] NUMBER = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    static List<String> NUMBER_List = Arrays.asList(NUMBER);

    static String[] PERSON = {"曹操","刘备","孙权","袁绍","吕布"};
    static String[] TYPE_NAME = {"豹子","顺金","金花","顺子","对子","单牌"};
    static String[] TYPE_NAME_DETAIL = {"豹子","顺金","金花","顺子","对子","单A","单K","单Q","单J","单10","单9","单8","单7","单6","单5"};
    static List<String> TYPE_NAME_DETAIL_LIST = Arrays.asList(TYPE_NAME_DETAIL);
    // 所有组合的牌面
    static Stack<Stack<String>> allChancePokers = new Stack<>();
    // 部分组合牌面的数量
    static Map<String, Integer> TYPE_NAME_DETAIL_NUM = new TreeMap<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(TYPE_NAME_DETAIL_LIST.indexOf(o1), TYPE_NAME_DETAIL_LIST.indexOf(o2));
        }
    });
    // 每种牌出现的概率
    static Map<String, BigDecimal> POKERS_RATE = new TreeMap<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return Integer.compare(TYPE_NAME_DETAIL_LIST.indexOf(o1), TYPE_NAME_DETAIL_LIST.indexOf(o2));
        }
    });
    // 单牌K带队
    static Stack<String> DANPAI_K = new Stack<>();
    // 第几轮
    private static int ROUND = 1;
    // 场上剩余玩家数量（包括自己）
    private int PLAYER_COUNT = PERSON.length;
    // 待发扑克，每轮之间共享变量
    static Stack<String> initPokers = new Stack<>();
    private static Stack<String> tmpArr = new Stack<>();

    // 待发扑克，每轮之间不共享变量
    private Stack<String> pokers = new Stack<>();
    // 每位玩家手里的扑克，每轮之间不共享变量
    private Map<String, Player> map = new ConcurrentHashMap<>();
    // 轮数，每轮之间共享变量
    static final int COUNT = 50;
    // 玩家手里的余额，初始值为10000，每轮之间共享变量
    private volatile static Map<String, BigDecimal> balanceMap = new ConcurrentHashMap<>();

    // 初始化玩家余额数据
    static {
        for (String person : PERSON) {
            balanceMap.put(person, new BigDecimal(10000));
        }
        DANPAI_K.push("红桃K");
        DANPAI_K.push("黑桃10");
        DANPAI_K.push("方块2");
    }

    // 初始化52张牌
    static {
        for (String color : COLOR) {
            for (String number : NUMBER) {
                initPokers.push(color + number);
            }
        }
    }

    // 初始化所有组合的牌面
    static {
        int k = 3;
        combine(0, k, initPokers);
    }

    // 初始化所有牌面数量
    static {
        Map<String, Integer> map = new HashMap<>();
        for (String typName : TYPE_NAME_DETAIL) {
            map.put(typName, 0);
        }
        for (Stack<String> chancePoker : allChancePokers) {
            String type = getTypeNameDetail(chancePoker);
            map.put(type, map.get(type) + 1);
        }
        for (String s : map.keySet()) {
            TYPE_NAME_DETAIL_NUM.put(s, map.get(s));
        }
    }

    // 初始化所有牌面出现的概率
    static {
        BigDecimal num = new BigDecimal(allChancePokers.size());
        for (String s : TYPE_NAME_DETAIL_NUM.keySet()) {
            BigDecimal value = new BigDecimal(TYPE_NAME_DETAIL_NUM.get(s));
            BigDecimal rate = value.divide(num,4, ROUND_HALF_UP);
            POKERS_RATE.put(s, rate);
        }
    }

    // 是否看牌（默认不看牌）
    private boolean WATCH_CARDS = false;



    /**
     * 组合
     * 按一定的顺序取出元素，就是组合,元素个数[C arr.len 3]
     * @param index 元素位置
     * @param k 选取的元素个数
     * @param arr 数组
     */
    public static void combine(int index, int k, Stack<String> arr) {
        if(k == 1){
            for (int i = index; i < arr.size(); i++) {
                tmpArr.add(arr.get(i));
                Stack<String> item = new Stack<>();
                for (String s : tmpArr) {
                    item.push(s);
                }
                allChancePokers.push(item);
                tmpArr.remove(arr.get(i));
            }
        }else if(k > 1){
            for (int i = index; i <= arr.size() - k; i++) {
                tmpArr.add(arr.get(i)); //tmpArr都是临时性存储一下
                combine(i + 1,k - 1, arr); //索引右移，内部循环，自然排除已经选择的元素
                tmpArr.remove(arr.get(i)); //tmpArr因为是临时存储的，上一个组合找出后就该释放空间，存储下一个元素继续拼接组合了
            }
        }
    }


    /**
     * 洗牌
     */
    public void shuffle() {
        for (String initPoker : initPokers) {
            pokers.push(initPoker);
        }
        Collections.shuffle(pokers);
    }

    /**
     * 发一张牌
     * @return 牌
     */
    public String deal() {
        return pokers.pop();
    }

    /**
     * 发一局牌
     */
    public void dealAll() {
        JinHua jinHua = new JinHua();
        jinHua.shuffle();

        for (int i = 0; i < 3; i++) {
            for (String name : PERSON) {
                Player player = map.get(name);
                if (null != player) {
                    player.deal(jinHua.deal());
                } else {
                    player = new Player(name);
                    player.deal(jinHua.deal());
                    map.put(name, player);
                }
            }
        }
    }

    public Map<String, Player> getPlayerPokers() {
        return map;
    }

    /**
     * 豹子>顺金>金花>顺子>对子>单牌
     * 6 5 4 3 2 1
     * @param pokers
     * @return
     */
    public static int getType(Stack<String> pokers) {
        if (isDanPai(pokers)) {
            return 1;
        }
        if (isDuiZi(pokers)) {
            return 2;
        }
        if (isShunZi(pokers)) {
            return 3;
        }
        if (isJinHua(pokers)) {
            return 4;
        }
        if (isShunJin(pokers)) {
            return 5;
        }
        if (isBaoZi(pokers)) {
            return 6;
        }
        return 0;
    }

    /**
     * 豹子>顺金>金花>顺子>对子>单牌
     * 6 5 4 3 2 1
     * @param pokers
     * @return
     */
    public static String getTypeName(Stack<String> pokers) {
        if (isDanPai(pokers)) {
            return "单牌";
        }
        if (isDuiZi(pokers)) {
            return "对子";
        }
        if (isShunZi(pokers)) {
            return "顺子";
        }
        if (isJinHua(pokers)) {
            return "金花";
        }
        if (isShunJin(pokers)) {
            return "顺金";
        }
        if (isBaoZi(pokers)) {
            return "豹子";
        }
        return null;
    }


    /**
     * 豹子>顺金>金花>顺子>对子>单牌
     * 6 5 4 3 2 1
     * @param pokers
     * @return
     */
    public static String getTypeNameDetail(Stack<String> pokers) {
        String type = getTypeName(pokers);
        if ("单牌".equals(type)) {
            String poker = max(pokers);
            return "单" + getNumber(poker);
        }
        return type;
    }


    /**
     * 判断是否是豹子
     * 三张点相同的牌。例：AAA、222。
     * 第一大
     * @return
     */
    public static boolean isBaoZi(Stack<String> pokers) {
        String number1 = null;
        for (String poker : pokers) {
            String number2 = getNumber(poker);
            if (number1 != null) {
                if (!number1.equals(number2)) {
                    return false;
                }
            } else {
                number1 = number2;
            }

        }
        return true;
    }

    /**
     * 判断是否是顺金
     * 花色相同的顺子。例：黑桃456、红桃789。最大的顺金为花色相同的QKA，最小的顺金为花色相同的123。
     * 第二大
     * @return
     */
    public static boolean isShunJin(Stack<String> pokers) {
        return isContinuous(pokers) && isSameColor(pokers);
    }

    /**
     * 判断是否是金花
     * 花色相同，非顺子。例：黑桃368，方块145。
     * 第三大
     * @return
     */
    public static boolean isJinHua(Stack<String> pokers) {
        return !isContinuous(pokers) && isSameColor(pokers);
    }

    /**
     * 判断是否是顺子
     * 花色不同的顺子。例：黑桃5红桃6方块7。最大的顺子为花色不同的QKA，最小的顺子为花色不同的123。
     * 第四大
     * @return
     */
    public static boolean isShunZi(Stack<String> pokers) {
        return isContinuous(pokers) && !isSameColor(pokers);
    }

    /**
     * 判断是否是对子
     * 两张点数相同的牌。例：223，334。
     * 第五大
     * @return
     */
    public static boolean isDuiZi(Stack<String> pokers) {
        String number0 = getNumber(pokers.get(0));
        String number1 = getNumber(pokers.get(1));
        String number2 = getNumber(pokers.get(2));

        return number0.equals(number1) && !number0.equals(number2)
                || !number0.equals(number1) && number0.equals(number2)
                || !number0.equals(number1) && number1.equals(number2);
    }

    /**
     * 判断是否是单牌
     * 单张：三张牌不组成任何类型的牌。
     * 最小
     * @return
     */
    public static boolean isDanPai(Stack<String> pokers) {
        String number0 = getNumber(pokers.get(0));
        String number1 = getNumber(pokers.get(1));
        String number2 = getNumber(pokers.get(2));

        boolean danpai = !number0.equals(number1) && !number0.equals(number2) && !number1.equals(number2);

        return danpai && !isJinHua(pokers) && !isShunZi(pokers) && !isShunJin(pokers);
    }

    /**
     * 获取最大面值的牌
     * @param pokers
     * @return
     */
    public static String max(Stack<String> pokers) {
        int maxIndex = 0;
        String maxValue = "";
        for (String poker : pokers) {
            String number = getNumber(poker);
            int index = NUMBER_List.indexOf(number);
            if (index > maxIndex) {
                maxIndex = index;
                maxValue = number;
            }
        }
        return maxValue;
    }

    /**
     * 获取最小面值的牌
     * @param pokers
     * @return
     */
    public static String min(Stack<String> pokers) {
        int minIndex = 20;
        String minValue = "";
        for (String poker : pokers) {
            String number = getNumber(poker);
            int index = NUMBER_List.indexOf(number);
            if (index < minIndex) {
                minIndex = index;
                minValue = number;
            }
        }
        return minValue;
    }

    /**
     * 获取中间面值的牌
     * @param pokers
     * @return
     */
    public static String mid(Stack<String> pokers) {
        return sort(pokers).get(1);
    }

    /**
     * 从小到大排序
     * @param pokers
     * @return
     */
    public static Stack<String> sort(Stack<String> pokers) {

        pokers.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return Integer.compare(NUMBER_List.indexOf(getNumber(o1)), NUMBER_List.indexOf(getNumber(o2)));
            }
        });
        return pokers;

    }

    /**
     * 比较单张扑克牌大小
     * @param poker1 poker2
     * @return -1小 0一样 1大
     */
    public static int compareSinglePoker(String poker1, String poker2) {

        int index1 = NUMBER_List.indexOf(getNumber(poker1));
        int index2 = NUMBER_List.indexOf(getNumber(poker2));

        return Integer.compare(index1, index2);
    }

    /**
     * 判断是否相同花色
     * @param pokers
     * @return
     */
    public static boolean isSameColor(Stack<String> pokers) {
        String color1 = null;
        for (String poker : pokers) {
            String color2 = getColor(poker);
            if (color1 != null) {
                if (!color1.equals(color2)) {
                    return false;
                }
            } else {
                color1 = color2;
            }
        }
        return true;
    }

    /**
     * 判断是否连续
     * 索引下标的差值的绝对值相加等于4
     * @param pokers
     * @return
     */
    public static boolean isContinuous(Stack<String> pokers) {

        int sum = 0;

        int index0 = NUMBER_List.indexOf(getNumber(pokers.get(0)));
        int index1 = NUMBER_List.indexOf(getNumber(pokers.get(1)));
        int index2 = NUMBER_List.indexOf(getNumber(pokers.get(2)));

        if (index0 != index1 && index0 != index2 && index1 != index2) {
            // 对A(12) 2(0) 3(1) 这种情况特殊处理
            boolean A23 = false;
            A23 = (index0==12&&index1==0&&index2==1) || (index0==12&&index1==1&&index2==0)
               || (index0==0&&index1==12&&index2==1) || (index0==0&&index1==1&&index2==12)
               || (index0==1&&index1==0&&index2==12) || (index0==1&&index1==12&&index2==0) ;
            if (A23) {
                return true;
            }
            sum = Math.abs(index0 - index1) + Math.abs(index1 - index2) + Math.abs(index0 - index2);
        }
        return sum == 4;
    }

    /**
     * 获取颜色
     * @param poker
     * @return
     */
    public static String getColor(String poker) {
        return poker.substring(0, 2);
    }

    /**
     * 获取数字
     * @param poker
     * @return
     */
    public static String getNumber(String poker) {
        if (poker.length() < 3) return poker;
        return poker.substring(2);
    }

    /**
     * 比大小，pokers1的持有者开pokers2的持有者
     * 豹子>顺金>金花>顺子>对子>单牌
     * @param pokers1
     * @param pokers2
     * @return -1:(pokers1比pokers2小)  1:(pokers1比pokers大) 如果两者面值相等，则pokers1更小，因为pokers1开对方
     */
    public static int open(Stack<String> pokers1, Stack<String> pokers2) {
        int type1 = getType(pokers1);
        int type2 = getType(pokers2);
        if (type1 < type2) {
            return -1;
        }
        if (type1 > type2) {
            return 1;
        }
        // 以下类型相等
        // 比较最大值
        if (compareSinglePoker(max(pokers1), max(pokers2)) == -1) {
            return -1;
        }
        if (compareSinglePoker(max(pokers1), max(pokers2)) == 1) {
            return 1;
        }
        // 比较中间值
        if (compareSinglePoker(mid(pokers1), mid(pokers2)) == -1) {
            return -1;
        }
        if (compareSinglePoker(mid(pokers1), mid(pokers2)) == 1) {
            return 1;
        }
        // 比较最小值
        if (compareSinglePoker(min(pokers1), min(pokers2)) == -1) {
            return -1;
        }
        if (compareSinglePoker(min(pokers1), min(pokers2)) == 1) {
            return 1;
        }
        // 如果最小值都相等，谁开牌谁小
        return -1;
    }

    /**
     * 蒙牌策略1
     * 判断是弃牌还是蒙牌还是开牌
     *
     * 发完牌每个人都会看牌，从第一个玩家开始看牌，只要小于等于单牌Q的，都会弃牌
     * 第一轮弃牌过程中，如果还剩下两位玩家，
     * @return -1弃牌 0蒙牌 1开牌
     */
    public static int checkNext1(Stack<String> pokers) {
        if (open(pokers, DANPAI_K) == 1) {
            return 1;
        }
        return 0;
    }

    /**
     * 玩牌（上帝视角）
     */
    public static void run() {
        JinHua jinHua = new JinHua();
        jinHua.dealAll();
        while (jinHua.PLAYER_COUNT > 1) {
            Map<String, Player> map = jinHua.map;
            for (String s : map.keySet()) {
                Player player = map.get(s);
                player.setBalance(player.getBalance().subtract(new BigDecimal(15)));
                Stack<String> pokers = player.getPokers();
                // 大于等于K10则继续蒙牌
                if (open(pokers, DANPAI_K) == 1) {
                    run();
                } else {
                    jinHua.PLAYER_COUNT --;
                    map.remove(s);
                }
            }
        }
        System.out.println(jinHua.map);

    }

    public static void main(String[] args) {
        run();
    }



}

class Player {
    // 玩家姓名
    private String name;
    // 玩家手持的扑克
    private Stack<String> pokers;
    // 余额
    private BigDecimal balance = new BigDecimal(10000);

    public Player(String name) {
        this.name = name;
        pokers = new Stack<>();
    }

    public void deal(String poker) {
        pokers.push(poker);
    }

    public String getName() {
        return name;
    }

    public Stack<String> getPokers() {
        return pokers;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", pokers=" + pokers +
                ", balance=" + balance +
                '}';
    }
}
