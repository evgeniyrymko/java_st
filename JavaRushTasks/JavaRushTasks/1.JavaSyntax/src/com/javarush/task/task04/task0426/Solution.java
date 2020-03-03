package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа

Ярлыки и числа
Ввести с клавиатуры целое число. Вывести на экран его строку-описание следующего вида:
"отрицательное четное число" - если число отрицательное и четное,
"отрицательное нечетное число" - если число отрицательное и нечетное,
"ноль" - если число равно 0,
"положительное четное число" - если число положительное и четное,
"положительное нечетное число" - если число положительное и нечетное.

Пример для числа 100:
положительное четное число

Пример для числа -51:
отрицательное нечетное число


Требования:
1. Программа должна считывать число c клавиатуры.
2. Программа должна использовать команду System.out.println() или System.out.print().
3. Если число отрицательное и четное, вывести "отрицательное четное число".
4. Если число отрицательное и нечетное, вывести "отрицательное нечетное число".
5. Если число равно 0, вывести "ноль".
6. Если число положительное и четное, вывести "положительное четное число".
7. Если число положительное и нечетное, вывести "положительное нечетное число".
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int number1 = Integer.parseInt(bf.readLine());
        if (number1<0 && (number1%2==0)) System.out.println("отрицательное четное число");
        if (number1<0 && (number1%2==-1)) System.out.println("отрицательное нечетное число");
        if (number1>0 && (number1%2==0)) System.out.println("положительное четное число");
        if (number1>0 && (number1%2==1)) System.out.println("положительное нечетное число");
        if (number1==0) System.out.println("ноль");

    }
}
