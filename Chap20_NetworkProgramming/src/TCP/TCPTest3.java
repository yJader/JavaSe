package TCP;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author yJade
 * @Date 2022-07-31 17:04
 * @Package inetAddress
 *  例3：从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。
 */
public class TCPTest3 {
    //客户端
    @Test
    public void client() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 8899);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream(new File("testFile\\mio.png"));

        byte[] buffer1 = new byte[1024];
        int len;
        while ((len = fis.read(buffer1)) != -1) {
            os.write(buffer1, 0, len);
        }
        //关闭数据的输入
        socket.shutdownOutput();

        //接收反馈
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer2 = new byte[20];
        while ((len = is.read(buffer2)) != -1) {
            baos.write(buffer2, 0, len);
        }
        System.out.println(baos);

        socket.close();
        os.close();
        fis.close();
        is.close();
        baos.close();
    }

    //服务端
    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8899);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        File file = new File("testFile\\mio_TCP2.png");
        FileOutputStream fos = new FileOutputStream(file);

        byte[] buffer = new byte[20];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }

        System.out.println("收到来自" + socket.getInetAddress().getHostAddress() + "的数据");

        //服务器端向客户端反馈
        OutputStream os = socket.getOutputStream();
        os.write(("已存储到" + file).getBytes());

        serverSocket.close();
        socket.close();
        is.close();
        fos.close();
        os.close();
    }
}
