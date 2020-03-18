package com.javarush.task.task04.task0428;

/* 
Положительное число

Положительное число
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных чисел среди этих трех.

Примеры:
а) при вводе чисел
-4
6
6
получим вывод
2

б) при вводе чисел
-6
-6
-3
получим вывод
0
в) при вводе чисел
0
1
2
получим вывод
2

Требования:
1. Программа должна считывать числа c клавиатуры.
2. Программа должна выводить число на экран.
3. Программа должна выводить количество положительных чисел в исходном наборе.
4. Если положительных чисел нет, программа должна вывести "0".
5. Учти, что "0" не относится ни к положительным, ни к отрицательным числам.
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(bf.readLine());
        int n2 = Integer.parseInt(bf.readLine());
        int n3 = Integer.parseInt(bf.readLine());
        if (n1>0 && n2>0 && n3>0) System.out.println(3);
        else if ((n1>0 && n2>0) ||(n1>0 && n3>0)||(n2>0 && n3>0)) System.out.println(2);
        else if(n1>0 || n2>0 || n3>0) System.out.println(1);
        else System.out.println(0);

    }
}
