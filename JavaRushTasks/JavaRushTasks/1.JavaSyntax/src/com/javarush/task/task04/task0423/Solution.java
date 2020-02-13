package com.javarush.task.task04.task0423;

/* 
Фейс-контроль

Фейс-контроль
Ввести с клавиатуры имя и возраст. Если возраст больше 20 вывести надпись "И 18-ти достаточно".


Требования:
1. Программа должна считывать строки c клавиатуры.
2. Программа должна использовать команду System.out.println() или System.out.print().
3. Если возраст больше 20 вывести только сообщение "И 18-ти достаточно".
4. Если возраст меньше либо равно 20 ничего не выводить.
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String name = bf.readLine();
        int age=Integer.parseInt(bf.readLine());
        if (age>20) {
            System.out.println("И 18-ти достаточно");
        }
    }
}
