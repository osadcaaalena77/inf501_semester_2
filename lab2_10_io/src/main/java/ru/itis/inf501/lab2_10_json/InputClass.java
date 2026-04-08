package ru.itis.inf501.lab2_10_json;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class InputClass {
    public static void main(String[] args) {
        try (InputStream is = new FileInputStream("jsonObject.json")) {
            byte[] buffer = new byte[4096];
            int count = 0;
            int r;
            String str2 = "";
            while ((r = is.read())!= -1) {
                if ((char) r == '\n') {
                    String str = new String(buffer, 0, count, "UTF-8");
                    str2 += str.trim();
                    count = 0;
                } else {
                    buffer[count++] = (byte) r;
                }
            }
            str2 = str2.replace("{","").replace("\""," ").replace("}","");
            //System.out.println(str2);
            String[] strings = str2.split(",");
            Map<String, Object> res = new HashMap<>();
            for (String x : strings) {
                String[] help = x.split(":");
                res.put(help[0],help[1]);
            }
            for (Map.Entry<String,Object> x : res.entrySet()) {
                System.out.println(x);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
