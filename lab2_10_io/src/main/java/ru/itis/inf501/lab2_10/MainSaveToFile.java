package ru.itis.inf501.lab2_10;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class MainSaveToFile {
    public static void main(String[] args) {
        try (OutputStream os = new FileOutputStream("тест.txt")) {
            //выходному потоку пофиг вообще
            //если прочитали байт, то перечитать мы его уже не можем
            String str1 = "Тестовая строка 1\n";
            os.write(str1.getBytes());
            String str2 = "Тестовая строка 2\n";
            os.write(str2.getBytes());
            String str3 = "Тестовая строка 3\n";
            os.write(str3.getBytes());
            String str4 = "Тестовая строка 4\n";
            os.write(str4.getBytes());

            //сбросим буферы записи на устройстве
            os.flush();

//1.составить json объект :
// не менее трех полей, 1 из них числовое
//записать в файл
// 2. прочитать из файла json обьект
// распарсить его и вывести в форме ключ : значение

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
