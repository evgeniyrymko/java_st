package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения

Перепись населения
Создать словарь (Map<String, String>) занести в него десять записей по принципу "Фамилия" - "Имя".
Проверить сколько людей имеют совпадающие с заданным именем или фамилией.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь Map с типом элементов String, String состоящих из 10 записей по принципу «Фамилия» - «Имя».
4. Метод getCountTheSameFirstName() должен возвращать число людей у которых совпадает имя.
5. Метод getCountTheSameLastName() должен возвращать число людей у которых совпадает фамилия.
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("A", "A123");
        map.put("B", "B123");
        map.put("C", "A123");
        map.put("D", "D123");
        map.put("E", "E123");
        map.put("F", "F123");
        map.put("G", "A123");
        map.put("H", "H123");
        map.put("I", "I123");
        map.put("J", "J123");
        return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int sameFirstName = 0;
        for (Map.Entry<String, String> pair :
                map.entrySet()) {
            if (pair.getValue().equals(name)) {
                sameFirstName++;
            }
        }
        return sameFirstName;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int sameLastName = 0;
        for (Map.Entry<String, String> pair :
                map.entrySet()) {
            if (pair.getKey().equals(lastName)) {
                sameLastName++;
            }
        }
        return sameLastName;

    }

    public static void main(String[] args) {
//        Map<String,String> example;
//        example=createMap();
//        System.out.println(getCountTheSameFirstName(example,"D"));
//        System.out.println(getCountTheSameLastName(example,"A123"));


    }
}
