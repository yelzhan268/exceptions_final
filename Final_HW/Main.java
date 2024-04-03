package Final_HW;

import java.io.*;
import java.nio.file.FileSystemException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        try {
            makeRecord();
            System.out.println("success");
        } catch (FileSystemException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    public static void makeRecord() throws Exception {
        System.out.println("Введите фамилию, имя, отчество, дату рождения (в формате dd.mm.yyyy), номер телефона (число без разделителей) и пол(символ латиницей f или m), разделенные пробелом");
        String data;
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            data = bf.readLine();
        }catch (IOException e){
            throw new Exception("Произошла ошибка при работе с консолью");
        }
        String[] arr = data.split(" ");
        if (arr.length != 6){
            throw new Exception("Введено неверное количество параметров");
        }

        String secondName = arr[0];
        String firstName = arr[1];
        String surName = arr[2];
        String birthDay = arr[3];

        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        Date birthDate;
        try {
            birthDate = format.parse(arr[3]);
        }catch (ParseException e){
            throw new ParseException("Неверный формат даты рождения", e.getErrorOffset());
        }

        int phone;
        try {
            phone = Integer.parseInt(arr[4]);
        }catch (NumberFormatException e){
            throw new NumberFormatException("Неверный формат телефона");
        }

        String gender = arr[5];
        if (!gender.equals("m") && !gender.equals("f")) {
            throw new RuntimeException("Неверно введен пол");
        } 

        Person p = new Person(secondName, firstName, surName, birthDay, phone, gender);
        System.out.println(p.toString());


        String fn = secondName.toLowerCase() + ".txt";
        try(FileWriter fr = new FileWriter(fn, true);) {
            fr.write(String.format("<%s><%s><%s><%s><%s><%s>", secondName, firstName, surName, birthDate, phone, gender) + '\n');
            fr.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
