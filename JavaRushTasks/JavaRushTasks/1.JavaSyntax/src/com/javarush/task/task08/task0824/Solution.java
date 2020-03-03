package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.List;

/* 
Собираем семейство

Собираем семейство
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Выведи все объекты Human на экран (Подсказка: используй метод toString() класса Human).


Требования:
1. Программа должна выводить текст на экран.
2. Класс Human должен содержать четыре поля.
3. Класс Human должен содержать один метод.
4. Класс Solution должен содержать один метод.
5. Программа должна создавать объекты и заполнять их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей и выводить все объекты Human на экран.
*/

public class Solution {
    public static void main(String[] args) {
        Human child1 = new Human("Child1", true, 5);
        Human child2 = new Human("Child2", true, 6);
        Human child3 = new Human("Child3", true, 7);
        Human dad = new Human("Dad", true, 40, child1, child2, child3);
        Human mom = new Human("Mom", false, 35, child1, child2, child3);
        Human daddy1 = new Human("Daddy1", true, 70, dad);
        Human granny1 = new Human("Granny1", false, 70, dad);
        Human daddy2 = new Human("Daddy2", true, 70, mom);
        Human granny2 = new Human("Granny2", false, 70, mom);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
        System.out.println(dad);
        System.out.println(mom);
        System.out.println(daddy1);
        System.out.println(granny1);
        System.out.println(daddy2);
        System.out.println(granny2);
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        List<Human> children=new ArrayList<>();

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human... children123) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            for (Human child :
                    children123) {
                this.children.add(child);
            }


        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }
}
