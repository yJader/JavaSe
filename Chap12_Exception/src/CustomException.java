import java.util.Scanner;

public class CustomException {
    public static void main(String[] args) {
        int age = 180;
        Scanner scanner = new Scanner(System.in);
        age = scanner.nextInt();
        if(age < 18 || age > 120) {
            throw new AgeException("年龄需要在18~120之间");
        }
        else System.out.println("年龄输入正确");
    }
}

class AgeException extends RuntimeException {
    public AgeException(String message) {
        super(message);
    }
}