package com.example.asd;

import java.util.Scanner;

public class MyClass {

    static String MyFirstMethod(){
        return "damn i got it correct";
    }

    public static void main(String[] args) {
        System.out.println("Hello world");

        String Name = "John";
        int intNum = 360;
        System.out.println(Name + " " + intNum);

        String First_Name = "Denvar";
        String Last_name = "Yuen";
        String Full_name  = Last_name + " " + First_Name;
        System.out.println(Full_name);

        int y = 8, x = 5, z = 3;
        int total = y + x * z;
        System.out.println(total);

        int[] numbers ={1,5,23,8,34,2,35,2,1234,232,32};

        for (int i : numbers){
            System.out.println(i);
        }

        int[][] Double_numbers = {{123,456,789},{321,654,987}};
        System.out.println(Double_numbers[0][2]);

        for (int[] double_number : Double_numbers) {
            for (int i : double_number) {
                System.out.println(i);
            }
        }
        System.out.println(MyFirstMethod());
        first_class Object = new first_class();
        System.out.println(Object.x + Object.z);
        System.out.println(Object.y);
        secondsd seconal = new secondsd();
        System.out.println(seconal);
        name the_fck = new name();
        System.out.println(the_fck.namesed);
        System.out.println(the_fck.x);
    }
    public static class first_class {
        int x = 5;
        String y = "ssssssss";
        int z = 20;
    }
    static class name extends first_class{
        private String namesed = "can this work";
    }

}
class secondsd{
    public static void main(String[] args){
        MyClass.first_class MySecondObject = new MyClass.first_class();
        String xy = MySecondObject.x + MySecondObject.y + MySecondObject.z;
    }
}
class Mains {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a number: ");
        int n = reader.nextInt();
        reader.close();
    }
}