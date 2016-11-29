package com.common.zookeeper.io;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by MHorse on 2016/9/24.
 */
public class NIOTest {

    @Test
    public void testChannel() throws IOException {
        FileInputStream fin = new FileInputStream("C:\\document\\qingchifanRedis\\testNIO.txt");
//        FileInputStream fin = new FileInputStream("C:\\document\\qingchifanRedis\\historyVisitor201608030825.txt");

        // 获取通道
        FileChannel fc = fin.getChannel();

        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 读取数据到缓冲区
        fc.read(buffer);

        buffer.flip();

        while (buffer.remaining()>0) {
            byte b = buffer.get();
            System.out.print(((char)b));
        }

        fin.close();
    }

    static private final byte message[] = { 83, 111, 109, 101, 32,
            98, 121, 116, 101, 115, 46 };
    @Test
    public void testNIOWrite() throws IOException {
        FileOutputStream fout = new FileOutputStream( "C:\\document\\qingchifanRedis\\testNIO.txt" );

        FileChannel fc = fout.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate( 1024 );

        for (int i=0; i<message.length; ++i) {
            buffer.put( message[i] );
        }

        buffer.flip();

        fc.write( buffer );

        fout.close();
    }

    @Test
    public void testOutputStream() throws IOException {
        // 第1步：使用File类找到一个文件
        File f = new File("C:" + File.separator + "document" + File.separator + "qingchifanRedis" + File.separator + "test.txt"); // 声明File  对象
// 第2步：通过子类实例化父类对象
        OutputStream out = null;
// 准备好一个输出的对象
        out = new FileOutputStream(f);
// 通过对象多态性进行实例化
// 第3步：进行写操作
        String str = "Hello World!!!";
// 准备一个字符串
        byte b[] = str.getBytes();
// 字符串转byte数组
        out.write(b);
// 将内容输出
        // 第4步：关闭输出流
        // out.close();
// 此时没有关闭
    }

    @Test
    public void testFileWriter() throws IOException {
        // 第1步：使用File类找到一个文件
        File f = new File("C:\\document\\qingchifanRedis\\test.txt");// 声明File对象
        // 第2步：通过子类实例化父类对象
        Writer out = null;
// 准备好一个输出的对象
        out = new FileWriter(f);
// 通过对象多态性进行实例化
        // 第3步：进行写操作
        String str = "Hello 你好!!!";
// 准备一个字符串
        out.write(str);
// 将内容输出
        out.flush();
// 强制性清空缓冲区中的内容
        // 第4步：关闭输出流
        // out.close();
// 此时没有关闭
    }

    @Test
    public void testFileRead() throws IOException {
        File f = new File("C:\\document\\qingchifanRedis\\test.txt");// 声明File对象
        // 第2步：通过子类实例化父类对象
        Writer out = null;
// 准备好一个输出的对象
        out = new FileWriter(f);
// 通过对象多态性进行实例化
        // 第3步：进行写操作
        String str = "Hello 你好!!!";
// 准备一个字符串
        out.write(str);
// 将内容输出
        out.flush();
        Reader reader = null;
        reader = new FileReader(f);
        reader.read();
    }

    @Test
    public void testOutStream() throws IOException {
        File f = new File("C:\\document\\NIO\\testOutStream.txt");
        OutputStream out=new FileOutputStream(f, true);//如果文件不存在会自动创建
//        out = new FileOutputStream(f, true);
        String str="Hello World, 你好ma???";
        byte[] b=str.getBytes();
//        b = str.getBytes("utf-8");
        for (byte b1 :b){
            out.write(b1);
        }
//        out.write(b);//因为是字节流，所以要转化成字节数组进行输出
        out.close();
    }

    @Test
    public void testInputStream() throws IOException {
        File file = new File("C:\\document\\NIO\\testOutStream.txt");
        InputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        inputStream.read(bytes);
        inputStream.close();
        System.out.println(new String(bytes));
    }

    @Test
    public void testWriter() throws IOException {
        File file = new File("C:\\document\\NIO\\testWriter.txt");
        Writer writer = new FileWriter(file, true);
        String string = "\r\nappend 追加~";
        writer.write(string);
        writer.close();
    }

    @Test
    public void testReader() throws IOException {
        File file = new File("C:\\document\\NIO\\testWriter.txt");
        Reader reader = new FileReader(file);
        char[] c=new char[1024];
        int temp=0;
        int len=0;
        while((temp=reader.read())!=-1){
            c[len]=(char) temp;
            len++;
        }
//        reader.close();
        System.out.println(new String(c,0,len));
        reader.close();
    }
}
