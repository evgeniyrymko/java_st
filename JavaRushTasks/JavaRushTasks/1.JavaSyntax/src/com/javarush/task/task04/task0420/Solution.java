package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел

Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
Выведенные числа должны быть разделены пробелом.


Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна выводить числа на экран.
3. Программа должна выводить три числа разделенных пробелами.
4. Программа должна выводить числа в порядке убывания.
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s1 = bf.readLine();
        String s2 = bf.readLine();
        String s3 = bf.readLine();
        int number1 = Integer.parseInt(s1);
        int number2 = Integer.parseInt(s2);
        int number3 = Integer.parseInt(s3);
        int numbers[] = {number1, number2, number3};
        Arrays.sort(numbers);
        System.out.println(numbers[2] + " " + numbers[1] + " " + numbers[0]);
    }
}
