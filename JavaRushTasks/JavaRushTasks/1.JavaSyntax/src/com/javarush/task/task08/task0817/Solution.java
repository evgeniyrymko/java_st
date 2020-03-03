package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны

Нам повторы не нужны
Создать словарь (Map<String, String>) занести в него десять записей по принципу "фамилия" - "имя".
Удалить людей, имеющих одинаковые имена.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь Map с типом элементов String, String состоящих из 10 записей.
4. Метод removeTheFirstNameDuplicates() должен удалять из словаря всех людей, имеющие одинаковые имена.
5. Метод removeTheFirstNameDuplicates() должен вызывать метод removeItemFromMapByValue().

*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<>();
        map.put("A", "A12345");
        map.put("B", "B12345");
        map.put("C", "B12345");
        map.put("D", "D12345");
        map.put("E", "E12345");
        map.put("F", "F12345");
        map.put("G", "F12345");
        map.put("H", "F12345");
        map.put("J", "J12345");
        map.put("K", "K12345");
        return map;
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        Iterator<Map.Entry<String, String>> entryIterator = map.entrySet().iterator();
        Map<String, String> copy1 = new HashMap<>(map);
        Set<String> set = new HashSet<>();
        for (String name :
                copy1.values()) {
            if (!set.add(name)) {
                removeItemFromMapByValue(map, name);
            }
        }

    }



    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }

    public static void main(String[] args) {
//        Map<String,String> example = createMap();
//        removeTheFirstNameDuplicates(example);
//        System.out.println(example);
    }
}
