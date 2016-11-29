package image;

import org.junit.Test;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Iterator;

/**
 * Created by MHorse on 2016/11/15.
 */
public class ImageTest {

    @Test
    public void testImageReader() throws IOException {

        File file = new File("c:/test/d63ab74bgw1f9ryp20mgzj20p01uttn4.jpg");
        System.out.println(file);
        System.out.println(String.format("%.0f",file.length()/1024.0));
        ImageInputStream imageInputStream  = ImageIO.createImageInputStream(new File("c:/test/6628711bgw1f9rmvaiyi0g206e05ee83.gif"));


        Iterator<ImageReader> iter = ImageIO.getImageReaders(imageInputStream);

        String format;
        if (null != iter && iter.hasNext()) {
            ImageReader reader = iter.next();
            format = reader.getFormatName(); //获得图片的类型
            System.out.println(format);
            reader.setInput(imageInputStream, true);

            reader.getWidth(0);  //获得图片的宽

            reader.getHeight(0); //获得图片的高
            System.out.println( reader.getWidth(0)  +"       " +  reader.getHeight(0));
        }
    }


    @Test
    public void testImgSize() throws IOException {
        FileInputStream is=new FileInputStream("c:/test/6628711bgw1f9rmvaiyi0g206e05ee83.gif");
        //把图片读取读取到内存的流
        ByteArrayOutputStream bos=new ByteArrayOutputStream();

        //原图保存位置
        FileOutputStream fos=new FileOutputStream("c:/test/gif.png");

        byte buffer[]=new byte[1024];
        int leng=0;
        while((leng=is.read(buffer))!=-1){
            fos.write(buffer, 0, leng);
            bos.write(buffer, 0, leng);
        }

        //截取第一张图
        BufferedImage bimage=ImageIO.read(new ByteArrayInputStream(bos.toByteArray(), 0, bos.size()));
        ImageIO.write(bimage, "png", new File("c:/test/gif02.png"));

        is.close();
        fos.close();
        bos.close();
    }
}
