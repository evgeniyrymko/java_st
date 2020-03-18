package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human

Конструкторы класса Human
Напиши класс Human с 6 полями.
Придумай и реализуй 10 различных конструкторов для него.
Каждый конструктор должен иметь смысл.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. В классе Human должно быть 6 полей.
3. Все поля класса Human должны быть private.
4. В классе Human должно быть 10 конструкторов.
5. Все конструкторы класса Human должны быть public.
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        private int age;
        private int height;
        private int weight;
        private String name1;
        private String name2;
        private String name3;

        public Human() {
        }

        public Human(int age) {
            this.age = age;
        }

        public Human(String name1) {
            this.name1 = name1;
        }

        public Human(int age, String name1) {
            this.age = age;
            this.name1 = name1;
        }
        public Human(String name1, int age) {
            this.age = age;
            this.name1 = name1;
        }

        public Human(int age, int height) {
            this.age = age;
            this.height = height;
        }

        public Human(int age, int height, int weight) {
            this.age = age;
            this.height = height;
            this.weight = weight;
        }

        public Human(String name1, String name2) {
            this.name1 = name1;
            this.name2 = name2;
        }

        public Human(String name1, String name2, String name3) {
            this.name1 = name1;
            this.name2 = name2;
            this.name3 = name3;
        }

        public Human(int age, int height, int weight, String name1, String name2, String name3) {
            this.age = age;
            this.height = height;
            this.weight = weight;
            this.name1 = name1;
            this.name2 = name2;
            this.name3 = name3;
        }
    }
}
