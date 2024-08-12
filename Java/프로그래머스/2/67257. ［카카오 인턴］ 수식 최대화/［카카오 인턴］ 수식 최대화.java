import java.util.ArrayList;
class Solution {
    public long solution(String expression) {
        String[][] operator = {
                {"+", "-", "*"},
                {"+", "*", "-"},
                {"-", "+", "*"},
                {"-", "*", "+"},
                {"*", "-", "+"},
                {"*", "+", "-"}
        };
        long answer = Long.MIN_VALUE;

        ArrayList<String> tokens = new ArrayList<>();
        StringBuilder currentNumber = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                currentNumber.append(c);
            } else {
                if (currentNumber.length() > 0) {
                    tokens.add(currentNumber.toString());
                    currentNumber.setLength(0);
                }
                tokens.add(String.valueOf(c));
            }
        }
        if (currentNumber.length() > 0) {
            tokens.add(currentNumber.toString());
        }

        for (int i = 0; i < 6; i++) {
            ArrayList<String> list = new ArrayList<>(tokens);
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < list.size(); k++) {
                    if (operator[i][j].equals(list.get(k))) {
                        list.set(k - 1, calc(list.get(k - 1), list.get(k + 1), list.get(k)));
                        list.remove(k);
                        list.remove(k);
                        k--;
                    }
                }
            }
            answer = answer< Math.abs(Long.parseLong(list.get(0))) ? Math.abs(Long.parseLong(list.get(0))):answer;
        }
        return answer;
    }

    static String calc(String number1, String number2, String operator) {
        Long a = Long.parseLong(number1);
        Long b = Long.parseLong(number2);
        if (operator.equals("+")) {
            return String.valueOf(a + b);
        } else if (operator.equals("-")) {
            return String.valueOf(a - b);
        } else if (operator.equals("*")) {
            return String.valueOf(a * b);
        }
        return "0";
    }
}