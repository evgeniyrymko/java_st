package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел

Минимум двух чисел
Ввести с клавиатуры два целых числа, и вывести на экран минимальное из них.
Если два числа равны между собой, необходимо вывести любое.


Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна выводить число на экран.
3. Программа должна выводить на экран минимальное из двух целых чисел.
4. Если два числа равны между собой, необходимо вывести любое.
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s1 = bf.readLine();
        String s2 = bf.readLine();
        int number1=Integer.parseInt(s1);
        int number2=Integer.parseInt(s2);
        if (number1<=number2) {
            System.out.println(number1);
        } else {
            System.out.println(number2);
        }

    }
}