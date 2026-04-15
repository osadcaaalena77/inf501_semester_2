package ru.itis.inf501.lab2_12;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Many many1 = new Many(1,-1,"Купила кофе", new Date(2026,8,4),"хватит тратить деньги на кофе!!!");
        Many many2 = new Many(2,1,"папа скинул", new Date(2026,8,4),"спасибо папе!");
        Many many3 = new Many(3,-1,"чипсы", new Date(2026,8,4),"вкуснотища");

        Map<Integer,Long> indexes = new HashMap<>();
        try (FileOutputStream fos = new FileOutputStream("many.tbl",true); DataOutputStream dos = new DataOutputStream(fos)) {
            ByteArrayOutputStream bos1 = new ByteArrayOutputStream();
            ObjectOutputStream os1 = new ObjectOutputStream(bos1);
            os1.writeObject(many1);
            os1.flush();

            byte[] buf1 = bos1.toByteArray();
            dos.writeInt(many1.getId());
            dos.writeByte(1);
            dos.writeInt(buf1.length);
            dos.write(buf1);
            System.out.println(buf1.length);
            indexes.put(many1.getId(), (long)0);

            ByteArrayOutputStream bos2 = new ByteArrayOutputStream();
            ObjectOutputStream os2 = new ObjectOutputStream(bos2);
            os2.writeObject(many2);
            os2.flush();

            byte[] buf2 = bos2.toByteArray();
            long positionMany2 = 4 + 1 + 4 + buf1.length;
            System.out.println(positionMany2);
            dos.writeInt(many2.getId());
            dos.writeByte(1);
            dos.writeInt(buf2.length);
            dos.write(buf2);
            System.out.println(buf2.length);
            indexes.put(many2.getId(), positionMany2);

            ByteArrayOutputStream bos3 = new ByteArrayOutputStream();
            ObjectOutputStream os3 = new ObjectOutputStream(bos3);
            os3.writeObject(many3);
            os3.flush();
            byte[] buf3 = bos3.toByteArray();
            long positionMany3 = 4 + 1 + 4 + positionMany2 + buf2.length;
            System.out.println(positionMany3);
            dos.writeInt(many3.getId());
            dos.writeByte(1);
            dos.writeInt(buf3.length);
            dos.write(buf3);
            indexes.put(many3.getId(),positionMany3);

            for (Map.Entry<Integer,Long> x : indexes.entrySet()) {
                System.out.println(x);
            }
            System.out.println(readId(3,indexes));
//            changeType(2,indexes,-1);
//            System.out.println(many1);
//            System.out.println(many2);
//            System.out.println(many3);




        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream("many.tbl"))) {
//            System.out.println( readId(3,indexes));
//            int indexChoose = 2;

//            String s = new String(buff);
//            System.out.println(s);
            changeType(1);
            int id = dis.readInt();
//            System.out.println(id);
            byte type = dis.readByte();
//            System.out.println(type);
            int size = dis.readInt();
//            System.out.println(size);
            byte[] buff = new byte[size];
            for (int i = 0; i < size; i++) {
                buff[i] = dis.readByte();
            }
            int id2 = dis.readInt();
            byte type2 = dis.readByte();
            int size2 = dis.readInt();
            byte[] buff2 = new byte[size2];
            for (int i = 0; i < size2; i++) {
                buff2[i] = dis.readByte();
            }
            ObjectInputStream ois1 = new ObjectInputStream(new ByteArrayInputStream(buff));
            Many many = (Many) ois1.readObject();
            System.out.println(many);
            ObjectInputStream ois2 = new ObjectInputStream(new ByteArrayInputStream(buff2));
            Many mn = (Many) ois2.readObject();
            System.out.println(mn);
//             String str = new String(buff);
//            System.out.println(str);

            //System.out.println(ois.readObject());









            //Many many = (Many) is.readObject();
            //is.skip(indexes.get(1));

            //System.out.println(many);
            //System.out.println("Введите id");
//            Scanner scanner = new Scanner(System.in);
            int i = 2;
            //dis.skipBytes(Math.toIntExact(indexes.get(i - 1)));
//            System.out.println(dis.readObject());
//            System.out.println(dis.readObject());

            //Many many21 = (Many) is.readObject();
            //System.out.println(many21);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }
    public static Many readId(int id,Map<Integer,Long> indexes) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("many.tbl"))) {
            dis.skipBytes(indexes.get(id).intValue());
            int id1 = dis.readInt();
            byte type = dis.readByte();
            int size = dis.readInt();
            byte[] b = new byte[size];
            for (int i = 0; i < size; i++) {
                b[i] = dis.readByte();
            }
            ByteArrayInputStream bis = new ByteArrayInputStream(b);
            ObjectInputStream os = new ObjectInputStream(bis);
            Many many = (Many) os.readObject();
            return many;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void changeType(int id) {
            try {
                File file = new File("many.tbl");
                long fileSize = file.length();

                FileInputStream fis = new FileInputStream(file);
                DataInputStream dis = new DataInputStream(fis);

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                DataOutputStream dos = new DataOutputStream(baos);

                long pos = 0;
                while (pos < fileSize) {
                    int currentId = dis.readInt();
                    byte currentType = dis.readByte();
                    int size = dis.readInt();

                    byte[] buf = new byte[size];
                    dis.readFully(buf);

                    if (currentId == id) {
                        ByteArrayInputStream bis = new ByteArrayInputStream(buf);
                        ObjectInputStream ois = new ObjectInputStream(bis);
                        Many many = (Many) ois.readObject();

                        many.setType(0);

                        ByteArrayOutputStream bos = new ByteArrayOutputStream();
                        ObjectOutputStream oos = new ObjectOutputStream(bos);
                        oos.writeObject(many);
                        oos.flush();
                        byte[] newBuf = bos.toByteArray();

                        dos.writeInt(currentId);
                        dos.writeByte(0);
                        dos.writeInt(newBuf.length);
                        dos.write(newBuf);
                    } else {
                        dos.writeInt(currentId);
                        dos.writeByte(currentType);
                        dos.writeInt(size);
                        dos.write(buf);
                    }

                    pos += 4 + 1 + 4 + size;
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
    //index.put(1,0)
    //index.put(2,посчитать все байты)
