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
 *  例2：客户端发送文件给服务端，服务端将文件保存在本地。
 */
public class TCPTest2 {
    //客户端
    @Test
    public void client() throws IOException {

        InetAddress inet = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(inet, 8899);
        OutputStream os = socket.getOutputStream();
        FileInputStream fis = new FileInputStream(new File("testFile\\mio.png"));

        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        fis.close();
        os.close();
        socket.close();
    }

    //服务端
    @Test
    public void server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8899);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("testFile\\mio_TCP1.png");

        byte[] buffer = new byte[20];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }
        System.out.println("收到来自" + socket.getInetAddress().getHostAddress() + "的数据");

        fos.close();
        is.close();
        socket.close();
        serverSocket.close();
    }
}
