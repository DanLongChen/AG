package L2019_4_12;

import java.beans.Encoder;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * Created by DanLongChen on 2019/4/12
 **/
public class Encode {
    public void Decoder(String message) throws UnsupportedEncodingException, CharacterCodingException {
        /**
         * 将message解码为二进制数组
         */
        byte[] bytes=message.getBytes("UTF-8");
        /**
         * 将二进制数组编码为GBK
         */
        String newMessage1=new String(bytes,"GBK");

        /**
         * 对于IO流可以使用如下方式
         */
        Charset cs=Charset.forName("GBK");
        CharsetEncoder encoder=cs.newEncoder();
        String newMessage2=encoder.encode(ByteBuffer.wrap(bytes).asCharBuffer()).toString();
    }
}
