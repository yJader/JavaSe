package TCP;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @Author yJade
 * @Date 2022-07-31 15:55
 * @Package inetAddress
 * 例1：客户端发送信息给服务端，服务端将数据显示在控制台上
 */
public class TCPTest1 {
    //客户端
    @Test
    public void client()  {
        Socket socket = null;//端口号8899
        OutputStream os = null;
        try {
            //1.创建Socket对象，指明服务器端的ip和端口号
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 8899);

            //2. 获取一个输出流, 用于输出数据
            os = socket.getOutputStream();
            //3. 写出数据的操作
            os.write("你好, 我是客户端:)".getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //4. 资源的关闭
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (socket != null) {
                try {
                    socket.close(); //socket也不会被gc回收, 需要手动关闭
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    //服务端
    @Test
    public void server() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            //1. 创建服务器端的ServerSocket, 指名自己的端口号
            serverSocket = new ServerSocket(8899);
            System.out.println("服务端" + serverSocket.getInetAddress().getHostAddress() + "已启动");
            //2. 调用accept(方法, 接收来自于客户端的Socket
            socket = serverSocket.accept();
            System.out.println("已连接" + socket.getLocalAddress().getHostAddress());
            //3. 获取输入流
            is = socket.getInputStream();

            //因为buffer数组大小的问题, 会截断字节码, 可能会出现乱码
//        byte[] buffer = new byte[20];
//        int len;
//        while ((len = is.read(buffer)) != -1) {
//            String str = new String(buffer, 0, len);
//            System.out.println(str);
//        }
            //4. 获取流内的数据
            //使用ByteArrayOutputStream, 暂存数据, 等全部输入后再进行转换
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[20];
            int len;
            while ((len = is.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, len);
            }

            System.out.println(byteArrayOutputStream.toString());

            System.out.println("收到来自" + socket.getInetAddress().getHostAddress() + "的数据");
            System.out.println(serverSocket.getInetAddress().getHostAddress() + "即将关闭");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            //5. 关闭资源
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
