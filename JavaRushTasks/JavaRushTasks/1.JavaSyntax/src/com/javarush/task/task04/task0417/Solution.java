package com.javarush.task.task04.task0417;

/* 
Существует ли пара?

Существует ли пара?
Ввести с клавиатуры три целых числа. Определить, имеется ли среди них хотя бы одна пара равных между собой чисел.
Если такая пара существует, вывести на экран числа через пробел.
Если все три числа равны между собой, то вывести все три.

Примеры:
а) при вводе чисел
1
2
2
получим вывод
2 2

б) при вводе чисел
2
2
2
получим вывод
2 2 2

Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна содержать System.out.println() или System.out.print()
3. Если два числа равны между собой, необходимо вывести числа на экран.
4. Если все три числа равны между собой, необходимо вывести все три.
5. Если нет равных чисел, ничего не выводить.
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
        if (number1 == number2 && number1 == number3) {
            System.out.println(number1 + " " + number2 + " " + number3);
        } else if (number1 == number2) {
            System.out.println(number1 + " " + number2);
        } else if (number1 == number3) {
            System.out.println(number1 + " " + number3);
        } else if (number3 == number2) {
            System.out.println(number3 + " " + number2);
        }


    }
}