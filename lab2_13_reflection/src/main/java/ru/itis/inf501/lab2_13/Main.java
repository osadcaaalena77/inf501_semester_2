package ru.itis.inf501.lab2_13;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IllegalAccessException,
            NoSuchMethodException, InvocationTargetException {
        Group group = new Group();
        group.setName("11-501");

        Student student = new Student("Первый",18,group);

        //---------------------------------------------------------

        //Определим тип (класс) объекта
        System.out.println(student.getClass().getName());
        System.out.println("//------------------------------");

        //Определение публичных членов
        Field[] fields = student.getClass().getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("//------------------------------");

        //Определение всех членов
        Field[] allFields = student.getClass().getDeclaredFields();
        for (Field field : allFields) {
            System.out.println(field.getClass().getName() + " : " + field.getName() );
        }
        System.out.println("//------------------------------");

        //Определение публичных методов(вышли все методы класса Object)
        Method[] methods = student.getClass().getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("//------------------------------");

        //Определение private методов(только методы класса(к родителю не лезет))
        Method[] allMethods = student.getClass().getDeclaredMethods();
        for (Method method : allMethods) {
            System.out.println(method);
        }
        System.out.println("//------------------------------");

        //----------------------------------------------------
        //Вытаскиваем значения членов класса
        //1 способ(нехороший способ)
        for (Field field : allFields) {
            //Даем разрешение на получение данных из закрытых типов данных
            field.setAccessible(true);
            System.out.println(field.get(student));
        }

        //2 способ(хороший)
        for (Field field : allFields) {
            //конструируем имя геттера
            String getterName = "get"
                    + field.getName().substring(0,1).toUpperCase()
                    + field.getName().substring(1);
            //можно запросить список аргументов в методах
            Method getter = student.getClass().getMethod(getterName);
            if (getter != null) {
                //вызываем метод
                //тип Object
                Object value = getter.invoke(student);
                System.out.println(value);
            }


            //System.out.println(field.get(student));
        }


    }
}
