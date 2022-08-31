package top.b0x0.sample.tracespringboot.logback.utils;

/**
 * 字符串操作工具类
 */
public class StringUtils {
    private static final String[] CHINESE_NUM = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
    private static final String[] CHINESE_UNIT = {"", "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千"};

    public static String int2chineseNum(int src) {
        StringBuilder dst = new StringBuilder();
        int count = 0;
        while (src > 0) {
            dst.insert(0, (CHINESE_NUM[src % 10] + CHINESE_UNIT[count]));
            src = src / 10;
            count++;
        }
        return dst.toString().replaceAll("零[千百十]", "零").replaceAll("零+万", "万")
                .replaceAll("零+亿", "亿").replaceAll("亿万", "亿零")
                .replaceAll("零+", "零").replaceAll("零$", "");
    }

    /**
     * 首字母变小写
     *
     * @param str /
     * @return /
     */
    public static String firstCharToLowerCase(String str) {
        char firstChar = str.charAt(0);
        if (firstChar >= 'A' && firstChar <= 'Z') {
            char[] arr = str.toCharArray();
            arr[0] += ('a' - 'A');
            return new String(arr);
        }
        return str;
    }

    /**
     * 首字母变大写
     *
     * @param str /
     * @return /
     */
    public static String firstCharToUpperCase(String str) {
        char firstChar = str.charAt(0);
        if (firstChar >= 'a' && firstChar <= 'z') {
            char[] arr = str.toCharArray();
            arr[0] -= ('a' - 'A');
            return new String(arr);
        }
        return str;
    }

}
