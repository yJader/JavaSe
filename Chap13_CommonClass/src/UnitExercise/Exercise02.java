package UnitExercise;

import java.time.Instant;
import java.util.Scanner;

public class Exercise02 {
    public static void main(String[] args) {
        String userName, password, email;
        Scanner scanner = new Scanner(System.in);
        userName = scanner.next();
        password = scanner.next();
        email = scanner.next();

        if (userName.length() < 2 || userName.length() > 4){
            throw new RuntimeException("用户名长度应为2~4");
        }

        try {
            Integer integer = Integer.parseInt(password);
            if (integer < 100000 || integer >= 1000000) throw new NumberFormatException();
        }catch (NumberFormatException nfe) {
            throw new RuntimeException("密码应为6位数字");
        }

        int index1 = email.indexOf('@');
        int index2 = email.indexOf('.');
        if(index1 == -1 || index2 == -2
                || index1 != email.lastIndexOf('@') || index2 != email.lastIndexOf('.')
                || index2 - index1 <= 1) {
            throw new RuntimeException("请输入正确的邮箱号");
        }


        System.out.println("注册成功! 欢迎您" + userName);

    }

}


