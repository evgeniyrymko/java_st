package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких

Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.


Требования:
1. Программа должна создавать большой массив на 20 целых чисел.
2. Программа должна считывать с клавиатуры 20 чисел для большого массива.
3. Программа должна создавать два маленьких массива на 10 чисел каждый.
4. Программа должна скопировать одну половину большого массива в первый маленький, а вторую - во второй и вывести второй маленький массив на экран.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int smallArr1[] = new int[10];
        int smallArr2[] = new int[10];
        int bigArr[] = new int[20];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < bigArr.length; i++) {
            bigArr[i] = Integer.parseInt(reader.readLine());
            if (i < 10) smallArr1[i] = bigArr[i];
            if (i >= 10) smallArr2[i - 10] = bigArr[i];
        }
        for (int i = 0; i < smallArr2.length; i++) {
            System.out.println(smallArr2[i]);
        }

    }
}
