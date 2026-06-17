public class string_3612 {
    public String processStr(String str) {
        StringBuilder result = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                result.append(ch);
            } else if (ch == '*') {
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else if (ch == '#') {
                result.append(result.toString());
            } else if (ch == '%') {
                result.reverse();
            }
        }

        return result.toString();
    }
}
