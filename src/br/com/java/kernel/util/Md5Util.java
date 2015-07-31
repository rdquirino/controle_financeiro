package br.com.java.kernel.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Util {

	private static String bytesToHex(byte[] b) {
        StringBuffer sb = new StringBuffer();
        for (byte aB : b) {
            sb.append((Integer.toHexString((aB & 0xFF) | 0x100)).substring(1, 3));
        }
        return sb.toString();
    }

    public static String hashMd5(String data) throws NoSuchAlgorithmException {
        byte[] mybytes = data.getBytes();
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] md5digest = md5.digest(mybytes);
        return bytesToHex(md5digest);
    }
}
