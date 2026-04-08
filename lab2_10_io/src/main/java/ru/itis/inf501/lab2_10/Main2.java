package ru.itis.inf501.lab2_10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Main2 {
    public static void main(String[] args) {
        //потому что closable можно убрать finally
        //если прочитали байт, то перечитать мы его уже не можем
        try (InputStream is = new FileInputStream("bookings.json")) {
            byte[] buffer = new byte[4096];
            int count = 0;
            int r;
            while ((r = is.read())!= -1) {
                if ((char) r == '\n') {
                    String str = new String(buffer, 0, count, "UTF-8");
                    System.out.println(str);
                    count = 0;
                } else {
                    buffer[count++] = (byte) r;
                }
//                    System.out.print((char) r);
            }
            System.out.println();



        } catch (FileNotFoundException e) {
            System.out.println("Не смогли найти входной файл");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
