package bufferedStream;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author yJade
 * @Date 2022-07-28 18:04
 * @Package bufferedStream
 * 获取文本上每个字符出现的次数
 */
public class Homework03 {
    @Test
    public void count() {
        Map<Character, Integer> count = new HashMap<>();

        File file = new File("testFile/copyTest_src.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(file);

            char[] charBuffer = new char[10];
            int len;
            while ((len = fr.read(charBuffer)) != -1) {
                for (int i = 0; i < len; i++) {
                    Character data = charBuffer[i];
                    if (count.get(data) == null) {
                        count.put(data, 1);
                    } else {
                        count.put(data, count.get(data) + 1 );
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        Set<Map.Entry<Character, Integer>> entrySet = count.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + " 出现次数: " + entry.getValue());
        }
    }
}
