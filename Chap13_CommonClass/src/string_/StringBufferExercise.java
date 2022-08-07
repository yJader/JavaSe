package string_;

import java.util.Scanner;

public class StringBufferExercise {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        StringBuffer stringBuffer = new StringBuffer(str);
        int pointPos = stringBuffer.indexOf(".") == -1 ? stringBuffer.length()-1 : stringBuffer.indexOf(".");
        //System.out.println(pointPos);

        for(int i = pointPos - 3; i>=0; i-=3) {
            stringBuffer.insert(i, ",");
        }
        System.out.println(stringBuffer);
    }
}
