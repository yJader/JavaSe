package string_;

public class StringBufferMethod {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("0123456789");

        //增
        stringBuffer.append("0xxx");
        System.out.println(stringBuffer);
        //删
        stringBuffer.delete(10, 1000);
        System.out.println(stringBuffer);
        //改
        stringBuffer.replace(1, 3, "0");
        System.out.println(stringBuffer);
        //查
        System.out.println(stringBuffer.indexOf("8"));
        //插
        stringBuffer.insert(2, "12");
        System.out.println(stringBuffer);
    }
}
