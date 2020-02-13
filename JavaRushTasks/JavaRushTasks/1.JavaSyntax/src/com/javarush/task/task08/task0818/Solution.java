package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей

Только для богачей
Создать словарь (Map<String, Integer>) и занести в него десять записей по принципу: "фамилия" - "зарплата".
Удалить из словаря всех людей, у которых зарплата ниже 500.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь Map с типом элементов String, Integer состоящих из 10 записей по принципу «фамилия» - «зарплата».
4. Метод removeItemFromMap() должен удалять из словаря всех людей, у которых зарплата ниже 500.
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 100);
        map.put("B", 200);
        map.put("C", 300);
        map.put("D", 400);
        map.put("E", 500);
        map.put("F", 600);
        map.put("G", 700);
        map.put("H", 800);
        map.put("I", 900);
        map.put("J", 1000);
        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {
//        System.out.println(map);
//        System.out.println("===================");
        Iterator<Map.Entry<String,Integer>> mapIterator=map.entrySet().iterator();
        while (mapIterator.hasNext()) {
            if (mapIterator.next().getValue()<500) {
                mapIterator.remove();
            }
        }
//        System.out.println(map);
    }

    public static void main(String[] args) {
//        Map<String, Integer> example = createMap();
//        removeItemFromMap(example);
    }
}