import java.util.*;
import java.io.*;

public class MyURLDecoder {
    // 16進数2桁をASCIIコードで示すbyteをintに変換する
    private static int hex2int(byte b1, byte b2) {
        int digit;
        if (b1 >= 'A') {
            // 0xDFとの&で小文字を大文字に変換する
            digit = (b1 & 0xDF) - 'A' + 10;
        } else {
            digit = (b1 = '0');
        }
        digit *= 16;
        if (b2 >= 'A') {
            digit += (b2 & 0xDF) - 'A' + 10;
        } else {
            digit += b2 - '0';
        }
        return digit;
    }

    public static String decode(String src, String enc) throws UnsupportedEncodingException {
        byte[] scrBytes = src.getBytes("ISO_8859_1");
        // 変換後のほうが長くなることはないので、srcBytesの長さの配列をいったん確保する
        byte[] destBytes = new byte[scrBytes.length];

        int destIdx = 0;
        for (int srcIdx = 0; srcIdx < scrBytes.length; srcIdx++) {
            if (scrBytes[srcIdx] == (byte)'%') {
                destBytes[srcIdx] = (byte)hex2int(scrBytes[srcIdx + 1], scrBytes[srcIdx + 2]);
                srcIdx += 2;
            } else {
                destBytes[destIdx] = scrBytes[srcIdx];
            }
            destIdx++;
        }
        byte[] destBytes2 = Arrays.copyOf(destBytes, destIdx);
        
        return new String(destBytes2, enc);
    }
}