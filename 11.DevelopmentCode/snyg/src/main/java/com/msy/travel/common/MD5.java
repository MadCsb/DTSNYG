package com.msy.travel.common;



import java.security.MessageDigest;

public class MD5
{

    private static final String hexDigits[] =
        {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
            "e", "f"};

    public MD5()
    {
    }

    public static void main(String args[])
    {
        System.out.print(encode("2"));
    }

    public static String byteArrayToHexString(byte b[])
    {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++)
            resultSb.append(byteToHexString(b[i]));

        return resultSb.toString();
    }

    private static String byteToHexString(byte b)
    {
        int n = b;
        if (n < 0)
            n += 256;
        int d1 = n / 16;
        int d2 = n % 16;
        return (new StringBuilder(String.valueOf(hexDigits[d1]))).append(hexDigits[d2])
            .toString();
    }

    public static String encode(String origin)
    {
        String resultString = null;
        try
        {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString =
                byteArrayToHexString(md.digest(resultString.getBytes("utf-8")));
        }
        catch (Exception exception)
        {
        }
        return resultString;
    }

    public static String encode(String origin,String charsetname)
    {
        String resultString = null;
        try
        {
            resultString = origin;
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (charsetname == null || "".equals(charsetname))
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes()));
            else{
                resultString = byteArrayToHexString(md.digest(resultString
                        .getBytes(charsetname)));
            }
           
        }
        catch (Exception exception)
        {
        }
        return resultString;
    }
    
    public static String encode(byte origin[])
    {
        String resultString = null;
        try
        {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(origin));
        }
        catch (Exception exception)
        {
        }
        return resultString;
    }
}
