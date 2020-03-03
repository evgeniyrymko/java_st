package com.javarush.task.task09.task0901;

/* 
Возвращаем StackTrace

Возвращаем StackTrace
Написать пять методов, которые вызывают друг друга.
Каждый метод должен возвращать свой StackTrace.


Требования:
1. В классе должно быть 5 методов (метод main не учитывать).
2. Каждый метод должен вызывать следующий: main вызывать method1, method1 вызывать method2 и т.д.
3. Каждый метод должен возвращать свой StackTrace.
4. Для получения StackTrace воспользуйся Thread.currentThread().getStackTrace().
*/

public class Solution {
    public static void main(String[] args) {
        method1();
    }

    public static StackTraceElement[] method1() {
        method2();
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
//        for (StackTraceElement element :
//                stackTraceElement) {
//            System.out.println(element);
//        }
        return stackTraceElement;
    }

    public static StackTraceElement[] method2() {
        method3();
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
//        for (StackTraceElement element :
//                stackTraceElement) {
//            System.out.println(element);
//        }
        return stackTraceElement;
    }

    public static StackTraceElement[] method3() {
        method4();
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
//        for (StackTraceElement element :
//                stackTraceElement) {
//            System.out.println(element);
//        }
        return stackTraceElement;
    }

    public static StackTraceElement[] method4() {
        method5();
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
//        for (StackTraceElement element :
//                stackTraceElement) {
//            System.out.println(element);
//        }
        return stackTraceElement;
    }

    public static StackTraceElement[] method5() {
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
//        for (StackTraceElement element :
//                stackTraceElement) {
//            System.out.println(element);
//        }
        return stackTraceElement;
    }
}
