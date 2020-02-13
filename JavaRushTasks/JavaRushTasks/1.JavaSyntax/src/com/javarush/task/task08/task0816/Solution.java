package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы

Добрая Зинаида и летние каникулы
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: "фамилия" - "дата рождения".
Удалить из словаря всех людей, родившихся летом.


Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, Date состоящий из 10 записей.
4. Метод removeAllSummerPeople() должен удалять из словаря всех людей, родившихся летом.
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне1", dateFormat.parse("JUNE 1 2012"));
        map.put("Сталлоне2", dateFormat.parse("JULY 1 2012"));
        map.put("Сталлоне3", dateFormat.parse("AUGUST 1 2012"));
        map.put("Сталлоне4", dateFormat.parse("SEPTEMBER 1 2012"));
        map.put("Сталлоне5", dateFormat.parse("OCTOBER 1 2012"));
        map.put("Сталлоне6", dateFormat.parse("NOVEMBER 1 2012"));
        map.put("Сталлоне7", dateFormat.parse("DECEMBER 1 2012"));
        map.put("Сталлоне8", dateFormat.parse("JANUARY 1 2012"));
        map.put("Сталлоне9", dateFormat.parse("FEBRUARY 1 2012"));
//        System.out.println(map);
//        System.out.println("+++++++++++++++++++++++++++++++++++");
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        Iterator<Map.Entry<String, Date>> entrySet = map.entrySet().iterator();
        while (entrySet.hasNext()) {
            int month = entrySet.next().getValue().getMonth();
            if (month >= 5 && month <= 7) {
                entrySet.remove();
            }
        }
//        System.out.println(map);
    }

    public static void main(String[] args) throws ParseException {
//        Map<String, Date> example;
//        example = createMap();
//        removeAllSummerPeople(example);
    }
}
