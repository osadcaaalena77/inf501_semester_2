package ru.itis.inf501.lab2_11;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.SimpleTimeZone;

//реализовать работу с бинарным файлом, хранящим информацию в следующей форме
//Person
//  name - ФИО: String
//  birthday: String(yyyyMMdd)  mm - для минут
//  gender: byte {0 - M, 1 - F}
//ФОРМАТ:  заголовок(HEADER)
//          данные(DATA)
//          lenName(1)
//          name(lenName)
//          birthday: y(2)M(1)d(1)
//          gender: (1)
public class DataFileTest {
    public static void main(String[] args) throws IOException {
        Person p = new Person();
        p.setName("Абрамский М. М.");
        p.setBirthDate("1988-08-31");
        p.setGender((byte) 0);

        DataFileTest converter = new DataFileTest();
        converter.saveToFile(p);
        DataFileTest input = new DataFileTest();
        Person person = input.readFromFile();
        System.out.println(person);

    }

    private static final String FILE_NAME = "person.dat";

    public void saveToFile(Person p) throws IOException {
        try (DataOutputStream os = new DataOutputStream(new FileOutputStream(FILE_NAME))) {
            //пишем в файл длину имени lenName(1)

//            byte[] n = p.getName().getBytes("UTF-8");
//            os.writeByte(n.length);
//            os.write(n);
            os.writeByte(p.getName().length());
            //пишем name в UTF-8 кодировке
            os.writeUTF(p.getName());
            //пишем год рождения
            os.writeShort(Short.parseShort(p.getBirthDate().substring(0, 4)));
            //пишем месяц рождения
            os.writeByte(Byte.parseByte(p.getBirthDate().substring(5, 7)));
            //пишем день рождения
            os.writeByte(Byte.parseByte(p.getBirthDate().substring(8, 10)));
            //пишем пол
            os.write(p.getGender());
            os.flush();
        }
    }

    public Person readFromFile() throws IOException {
        try (DataInputStream is = new DataInputStream(new FileInputStream(FILE_NAME))) {
            byte lenName = is.readByte();
//            byte[] buffer = new byte[lenName];
//            for (int i = 0; i < lenName; i++) {
//                buffer[i] = is.readByte();
//            }
//            String name = new String(buffer);
            String name = is.readUTF();
            Short year = is.readShort();
            Byte month = is.readByte();
            Byte day = is.readByte();
            Byte gender = is.readByte();
            Person p = new Person();
            p.setName(name);
            p.setBirthDate(year,month,day);
            p.setGender(gender);
            return p;
        }
    }
}
