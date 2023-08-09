package 替换空格05;

/*

 */
public class Sulution {
    public static void main(String[] args) {
        System.out.println(replaceSpaces("We are happy."));
    }

    public static String replaceSpaces(String s) {
        // return s.replaceAll("\\s", "%20"); 太慢
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
    }
}
