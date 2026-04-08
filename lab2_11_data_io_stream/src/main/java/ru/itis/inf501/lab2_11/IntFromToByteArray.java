package ru.itis.inf501.lab2_11;

public class IntFromToByteArray {
    public static byte[] int2byteArray(int i) {
        byte[] a = new byte[4];
        a[3] = (byte) (i & 0xFF);
        a[2] = (byte) ((i >> 8) & 0xFF);
        a[1] = (byte) ((i >> 16) & 0xFF);
        a[0] = (byte) ((i >> 24) & 0xFF);
        return a;
    }

    public static int intFromByteArray(byte[] a) {
        return (a[3] & 0xFF) | ((a[2] & 0xFF) << 8) | ((a[1] & 0xFF) << 16) | ((a[0] & 0xFF) << 24);

    }
}
