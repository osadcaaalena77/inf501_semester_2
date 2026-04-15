package ru.itis.inf501.database;

import ru.itis.inf501.lab2_12.Many;

import javax.crypto.spec.PSource;
import java.io.*;
import java.util.*;

public class DatabaseUtils {

    private static final String FILE_NAME = "db.tbl";
    private static long fileSize;
    private static Map<Integer, Long> indexes;

    public DatabaseUtils() throws  IOException{
        init();
    }

    public void save(Wastes wastes) throws IOException{
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             FileOutputStream fos = new FileOutputStream(FILE_NAME, true);
             ObjectOutputStream os = new ObjectOutputStream(bos);
             DataOutputStream dos = new DataOutputStream(fos)) {
            os.writeObject(wastes);
            byte[] buff = bos.toByteArray();
            dos.writeInt(wastes.getId());
            dos.writeByte(1);
            dos.writeInt(buff.length);
            dos.write(buff);
            fos.flush();

            indexes.put(wastes.getId(), fileSize);
            fileSize += 4 + 1 + 4 + buff.length;
        }
    }

    public void init() throws IOException{
        indexes = new HashMap<>();
        fileSize = 0;
        long position = 0L;
        try (FileInputStream fis = new FileInputStream(FILE_NAME);
             DataInputStream dis = new DataInputStream(fis)) {
            while (dis.available() > 0) {
                int id = dis.readInt();
                byte flag = dis.readByte();
                int size = dis.readInt();
                dis.skip(size);
                if (flag == 1) {
                    indexes.put(id, position);
                }
                position += 9 + size;
                fileSize = position;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Зафиксировали первый старт");
        }
    }

    public Wastes findByteId(int id) throws IOException, ClassNotFoundException {
        Wastes result;
        Long position = indexes.get(id);
        if (position == null) {
            throw new NoSuchElementException();
        }
        try (FileInputStream fis = new FileInputStream(FILE_NAME);
             DataInputStream dis = new DataInputStream(fis)) {
            //здесь должен быть цикл
            dis.skipBytes(position.intValue());
            dis.readInt();
            dis.readByte();
            int size = dis.readInt();
            byte[] buff = new byte[size];
            dis.read(buff);
            //по сюда
            ByteArrayInputStream bis = new ByteArrayInputStream(buff);
            ObjectInputStream ois = new ObjectInputStream(bis);
            result = (Wastes) ois.readObject();
        }
        return result;

    }

    public void delete(int id) throws IOException,ClassNotFoundException {
        Long position = indexes.get(id);
        if (position == null) throw new NoSuchElementException();
        try(FileInputStream fis = new FileInputStream(FILE_NAME);
        DataInputStream dis = new DataInputStream(fis)) {
            byte[] buff = new byte[(int) fileSize];
            dis.read(buff);
            buff[(int)(position + 4)] = 0;
            indexes.remove(id);

            try (FileOutputStream fos = new FileOutputStream(FILE_NAME)) {
                fos.write(buff);
                fos.flush();
            }
        }
    }

    public void updateData(int id) throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream(FILE_NAME);
        DataInputStream dis = new DataInputStream(fis)) {
            dis.skip(indexes.get(id));
            dis.readInt();
            byte flag = dis.readByte();
            int size = dis.readInt();
            byte[] buff = new byte[size];
            dis.read(buff);
            ByteArrayInputStream bis = new ByteArrayInputStream(buff);
            ObjectInputStream ois = new ObjectInputStream(bis);
            Wastes wastes = (Wastes) ois.readObject();

            byte type;
            float sum;


            Scanner scanner = new Scanner(System.in);
            String type2 = scanner.nextLine();
            String name = scanner.nextLine();
            String comment = scanner.nextLine();
            String sum2 = scanner.nextLine();

            if (!type2.isEmpty()) {
                type = Byte.parseByte(type2);
                wastes.setType(type);
            }
            if (!name.isEmpty()) wastes.setName(name);
            if (!comment.isEmpty()) wastes.setComment(comment);
            if (!sum2.isEmpty()) {
                sum = Float.parseFloat(sum2);
                wastes.setSum(sum);
            }
            delete(id);
            save(wastes);
        }

    }

    public List<Wastes> giveAllWastes() throws IOException, ClassNotFoundException {
        List<Wastes> allWastes = new ArrayList<>();
        long position = 0;
        try (FileInputStream fis = new FileInputStream(FILE_NAME);
             DataInputStream dis = new DataInputStream(fis)) {
            while (position < fileSize) {
                int id = dis.readInt();
                byte flag = dis.readByte();
                int size = dis.readInt();
                if (flag == 1) {
                    byte[] buff = new byte[size];
                    dis.read(buff);
                    ByteArrayInputStream bis = new ByteArrayInputStream(buff);
                    ObjectInputStream ois = new ObjectInputStream(bis);
                    Wastes wastes = (Wastes) ois.readObject();
                    allWastes.add(wastes);
                } else {
                    dis.skip(size);
                }
                position += 9 + size;
            }
            return allWastes;
        }
    }

    public void createHTMLFile() throws IOException, ClassNotFoundException {
        String NEW_FILE_NAME = "students.html";
        String fileData = "";
        fileData += "<!DOCTYPE html>\n";
        fileData += "<html>\n";
        fileData += "<head>\n";
        fileData += "    <meta charset=\"utf-8\"/>\n";
        fileData += "</head>\n";
        fileData += "<body>\n";
        fileData += "<h1>Доходы/Расходы</h1>\n";
        fileData += "<table>\n";
        List<Wastes> allWastes = giveAllWastes();
        for (Wastes wastes : allWastes) {
            fileData += "   <tr>\n";
            String wast = "";
            String type = wastes.getType() == 1 ?  "Доход" : "Расход";
            fileData += "       <th>" + wastes.getId() + "</th><th>" + type + "</th><th>" + wastes.getName() + "</th><th>" + wastes.getSum() + "</th><th>" + wastes.getDate() + "</th><th>" + wastes.getComment() + "</th>\n";
            fileData += "   </tr>\n";
        }
        fileData += "</table>\n";
        fileData += "</body>\n";
        fileData += "</html>\n";

        try (PrintWriter pw = new PrintWriter(NEW_FILE_NAME)) {
            pw.write(fileData);
            pw.flush();
        }

    }

    public void concolInterface() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.println("Если хотите совершить операцию, то напишите цифру, которая соответствует данной операции");
            System.out.println("Ваши возможности:");
            System.out.println("1.добавление в БД");
            System.out.println("2.поиск по ID");
            System.out.println("3.удаление по ID");
            System.out.println("4.изменение данных");
            System.out.println("5.вывод всех данных в файл `students.html`");
            System.out.println("0.выход из программы");
            number = scanner.nextInt();
            switch (number) {
                case 1:
                    System.out.println("Введите(через пробел) тип(доход - 1 или расход - (-1)), название, комментарий, сумму");
                    int id;
                    if (indexes.isEmpty()) {
                        id = 1;
                    } else id = (int) indexes.keySet().stream().sorted((a, b) -> b - a).toArray()[0] + 1;
                    Scanner scanner1 = new Scanner(System.in);
                    byte type = scanner1.nextByte();
                    Scanner scanner2 = new Scanner(System.in);
                    String name = scanner2.nextLine();
                    Date date = new Date();
                    Scanner scanner3 = new Scanner(System.in);
                    String comment = scanner3.nextLine();
                    Scanner scanner4 = new Scanner(System.in);
                    float sum = scanner4.nextFloat();

                    Wastes wastes = new Wastes(id, type, name, date, comment, sum);
                    save(wastes);
                    break;
                case 2:
                    System.out.println("Введите id");
                    Scanner scanner5 = new Scanner(System.in);
                    int id1 = scanner5.nextInt();
                    System.out.println(findByteId(id1));
                    break;
                case 3:
                    System.out.println("Введите id");
                    Scanner scanner6 = new Scanner(System.in);
                    int id2 = scanner6.nextInt();
                    delete(id2);
                    break;
                case 4:
                    System.out.println("Введите id");
                    Scanner scanner7 = new Scanner(System.in);
                    int id3 = scanner7.nextInt();
                    System.out.println("Введите новые данные(кроме id),(через пробел), если хотите отставить что-то без изменений, то нажмите пробел");
                    updateData(id3);
                    break;
                case 5:
                    createHTMLFile();
                    break;
                case 0:
                    break;

            }
        } while (number != 0);
    }



}
