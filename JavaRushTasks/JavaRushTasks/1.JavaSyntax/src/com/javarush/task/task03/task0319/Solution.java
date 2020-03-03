package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее

Предсказание на будущее
Ввести с клавиатуры отдельно Имя, число1, число2.
Вывести надпись:
"Имя" получает "число1" через "число2" лет.

Пример:
Коля получает 3000 через 5 лет.


Требования:
1. Программа должна выводить текст.
2. Программа должна считывать данные с клавиатуры.
3. Выведенный текст должен содержать введенное имя.
4. Выведенный текст должен содержать введенное число1.
5. Выведенный текст должен содержать введенное число2.
6. Выведенный тест должен полностью соответствовать заданию.
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String name=bf.readLine();
        String amount = bf.readLine();
        String years = bf.readLine();
        int amountInt=Integer.parseInt(amount);
        int yearsInt=Integer.parseInt(years);
        System.out.println(name+" получает "+amountInt+" через "+yearsInt+" лет.");

    }
}
