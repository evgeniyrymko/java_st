package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел

Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
Если числа равны между собой, необходимо вывести любое.


Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна выводить число на экран.
3. Программа должна выводить на экран максимальное из четырёх чисел.
4. Если максимальных чисел несколько, необходимо вывести любое из них.
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s1 = bf.readLine();
        String s2 = bf.readLine();
        String s3 = bf.readLine();
        String s4 = bf.readLine();
        int number1 = Integer.parseInt(s1);
        int number2 = Integer.parseInt(s2);
        int number3 = Integer.parseInt(s3);
        int number4 = Integer.parseInt(s4);
        int numbers[] = {number1, number2, number3, number4};
        int max = number1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        System.out.println(max);
    }
}
