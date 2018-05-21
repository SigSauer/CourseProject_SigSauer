package scenes.DataBase;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Hashing {
    public static String getHash(String pass) {

        /**
         Next code was written for another program by @anonymous@
         */

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(pass.getBytes());
        byte byteData[] = md.digest();
        StringBuffer hexString = new StringBuffer();
        for (int i=0;i<byteData.length;i++) {
            String hex=Integer.toHexString(0xff & byteData[i]);
            if(hex.length()==1) hexString.append('0');
            hexString.append(hex);
        }
        String hash = hexString.toString();
        return hash;
    }

    public String getPass(String hash) {
        return "Fuck You";
    }

    public static String getQuadrupleSlashURL(String url) {
        return doubling(url,"\\\\\\\\");
    }

    /**
         Next code was written for another program by SigSauer
     */

    private static String doubling(String value, String slash) {
        String newValue;
        char[] oldValue = value.toCharArray();
        System.out.println(value);
        int count = 0;
        for (int i = 0; i < oldValue.length; i++) {
            if (oldValue[i] == '\\') {
                oldValue[i] = '/';
            }
            if (oldValue[i] == '/') {
                count++;
            }
        }
        int[] pos = new int[count];
        int j = 0;
        for (int i = 0; i < oldValue.length; i++) {
            if (oldValue[i] == '/') {
                pos[j] = i;
                j++;
            }
        }
        value = String.valueOf(oldValue);
        System.out.println(value);
        String arrayZero = value.substring(0, value.indexOf((int) '/'));
        String arrayLast = value.substring(value.lastIndexOf((int) '/')+1);
        String[] strs = new String[pos.length - 1];
        for (int i = 0; i < strs.length; i++) {
            char[] temp = new char[pos[i + 1] - pos[i] - 1];
            System.arraycopy(oldValue, pos[i] + 1 , temp, 0, temp.length);
            strs[i] = String.valueOf(temp);
            System.out.println(strs[i]);
        }
        newValue = arrayZero;
        for (int i = 0; i < strs.length; i++) {
            newValue += (slash + strs[i]);
        }
        newValue+= (slash + arrayLast);
        return newValue;
    }
}
