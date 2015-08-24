package rest.api;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * Created by root on 24/08/15.
 */
public class APISignature {

    public String getSignature(String apiKey, String secret) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        String timeWithMilliseconds = String.format("%s", new Date().getTime());
        String time = timeWithMilliseconds.substring(0, timeWithMilliseconds.length() - 3);

        String str = apiKey + secret + time;
        byte[] hashedBytes = md.digest(str.getBytes("UTF-8"));
        return convertByteArrayToHexString(hashedBytes);
    }

    private String convertByteArrayToHexString(byte[] arrayBytes) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < arrayBytes.length; i++) {
            stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return stringBuffer.toString();
    }

}
