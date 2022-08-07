public class HashCode {
    public static void main(String[] args) {
        Object a[] = new Object[4];

        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "].hashCode()=" + a[i].hashCode());
        }
    }
}
