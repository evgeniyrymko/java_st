package com.javarush.task.task03.task0307;

/* 
Привет StarCraft!
Привет StarCraft!
Создать 5 зергов, 3 протосса и 4 террана.
Дать им всем уникальные имена.


Требования:
1. Нельзя изменять классы Zerg, Protoss и Terran.
2. Нужно создать 5 объектов типа Zerg и каждому из них дать свое имя.
3. Нужно создать 3 объекта типа Protoss и каждому из них дать свое имя.
4. Нужно создать 4 объекта типа Terran и каждому из них дать свое имя.
*/

public class Solution {
    public static void main(String[] args) {
        Zerg zerg1=new Zerg();
        zerg1.name="A";
        Zerg zerg2=new Zerg();
        zerg2.name="B";
        Zerg zerg3=new Zerg();
        zerg3.name="C";
        Zerg zerg4=new Zerg();
        zerg4.name="D";
        Zerg zerg5=new Zerg();
        zerg5.name="E";

        Protoss pr1=new Protoss();
        pr1.name="F";
        Protoss pr2=new Protoss();
        pr2.name="G";
        Protoss pr3=new Protoss();
        pr3.name="H";

        Terran t1=new Terran();
        t1.name="I";
        Terran t2=new Terran();
        t2.name="J";
        Terran t3=new Terran();
        t3.name="K";
        Terran t4=new Terran();
        t4.name="L";


    }

    public static class Zerg {
        public String name;
    }

    public static class Protoss {
        public String name;
    }

    public static class Terran {
        public String name;
    }
}
