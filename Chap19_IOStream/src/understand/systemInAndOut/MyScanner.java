package understand.systemInAndOut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author yJade
 * @Date 2022-07-29 10:46
 * @Package systemInAndOut
 */
public class MyScanner {
    public static void main(String[] args) {

    }
}

class MyInput {
    public static String readString() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;

        try {
            str = br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return str;
    }

    public static int readInt() {
        return Integer.parseInt(readString());
    }

    public static double readDouble() {
        return Double.parseDouble(readString());
    }

    public static double readByte() {
        return Byte.parseByte(readString());
    }

    public static double readShort() {
        return Short.parseShort(readString());
    }

    public static double readLong() {
        return Long.parseLong(readString());
    }

    public static double readFloat() {
        return Float.parseFloat(readString());
    }
}