package ru.itis.inf501.lab2_10_json;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class OutputClass {
    public static void main(String[] args) {
        try (OutputStream os = new FileOutputStream("jsonObject.json")) {

            String json1 = "{\n\t\"name\" : \"Алёна\",\n\t\"age\" : 18,\n\t\"gender\" : \"female\"\n}\n";


            os.write(json1.getBytes(StandardCharsets.UTF_8));



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //1.составить json объект :
// не менее трех полей, 1 из них числовое
//записать в файл
// 2. прочитать из файла json обьект
// распарсить его и вывести в форме ключ : значение
    }
}
