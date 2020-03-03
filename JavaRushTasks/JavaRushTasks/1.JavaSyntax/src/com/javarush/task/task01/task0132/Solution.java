package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа

Сумма цифр трехзначного числа
Напиши код метода sumDigitsInNumber(int number). Метод на вход принимает целое трехзначное число. Нужно посчитать сумму цифр этого числа, и вернуть эту сумму.

Пример:
Метод sumDigitsInNumber вызывается с параметром 546.

Пример вывода:
15


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. Метод sumDigitsInNumber(int) должен быть публичным и статическим.
3. Метод sumDigitsInNumber должен возвращать значение типа int.
4. Метод sumDigitsInNumber не должен ничего выводить на экран.
5. Метод sumDigitsInNumber должен правильно возвращать сумму всех цифр в числе number.
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        String numberStr = Integer.toString(number);
        int value1=Integer.parseInt(numberStr.valueOf(numberStr.charAt(0)));
        int value2=Integer.parseInt(numberStr.valueOf(numberStr.charAt(1)));
        int value3=Integer.parseInt(numberStr.valueOf(numberStr.charAt(2)));
        return (value1+value2+value3);
    }
}