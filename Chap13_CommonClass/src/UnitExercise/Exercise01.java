package UnitExercise;

public class Exercise01 {
    public static void main(String[] args) {
        String test = "abcdefg";
        System.out.println(reverse(test, 1, 3));
    }

    static String reverse(String str, int begin, int end) {
        StringBuilder sb = new StringBuilder();
        //前部分
        for (int i = 0; i < begin; i++) {
            sb.append(str.charAt(i));
        }
        //逆转部分
        for (int i = end; i >= begin; i--) {
            sb.append(str.charAt(i));
        }
        //后部分
        for (int i = end+1; i < str.length(); i++) {
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }
}
