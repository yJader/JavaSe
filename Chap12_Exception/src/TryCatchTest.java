public class TryCatchTest {
    public static void main(String[] args) {

        try {
            int a = Integer.parseInt("张江杰");
            System.out.println("a=" + a);
        } catch (NumberFormatException exception){
            System.out.println("异常信息" + exception);
        } finally {
            System.out.println("调用finally块");
        }
    }
}
