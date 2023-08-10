package array.替换空格0剑指offer05;

/*

 */
public class Sulution {
    public static void main(String[] args) {
        System.out.println(replaceSpaces("We are happy."));
    }

    public static String replaceSpaces(String s) {
        // 版本一：太慢
        // return s.replaceAll("\\s", "%20");

        /*版本二：不够优雅
        char[] swap = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char s1 : swap) {
            if (s1 == ' ') {
                stringBuilder.append("%20");
                continue;
            }
            stringBuilder.append(s1);
        }
        return stringBuilder.toString();
         */

        // 版本三
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++)
            stringBuffer.append(s.charAt(i) == ' ' ? "%20" : s.charAt(i));
        return stringBuffer.toString();

    }
}
