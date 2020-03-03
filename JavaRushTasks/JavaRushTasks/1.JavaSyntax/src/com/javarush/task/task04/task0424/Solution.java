package com.javarush.task.task04.task0424;

/* 
Три числа

Три числа
Ввести с клавиатуры три целых числа. Одно из чисел отлично от двух других, равных между собой. Вывести на экран порядковый номер числа, отличного от остальных.

Пример для чисел 4 6 6:
1

Пример для чисел 6 6 3:
3


Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна использовать команды System.out.println() или System.out.print().
3. Программа должна выводить на экран порядковый номер числа, отличного от остальных.
4. Если все числа разные, ничего не выводить.
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(bf.readLine());
        int number2 = Integer.parseInt(bf.readLine());
        int number3 = Integer.parseInt(bf.readLine());
        if (number1 == number2) System.out.println(3);
        if (number2 == number3) System.out.println(1);
        if (number1 == number3) System.out.println(2);

    }
}
