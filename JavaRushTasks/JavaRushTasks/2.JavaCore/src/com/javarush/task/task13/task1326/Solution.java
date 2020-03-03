package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла

Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.

Пример ввода:
5
8
-2
11
3
-5
2
10

Пример вывода:
-2
2
8
10


Требования:
1. Программа должна считывать данные с консоли.
2. Программа должна создавать FileInputStream для введенной с консоли строки.
3. Программа должна выводить данные на экран.
4. Программа должна вывести на экран все четные числа считанные из файла отсортированные по возрастанию.
5. Программа должна закрывать поток чтения из файла(FileInputStream).
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String source = reader.readLine();
//        String source = "D:\\Java Course\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\" +
//                "src\\com\\javarush\\task\\task13\\task1326\\1326text.txt";
        List<Integer> list = new ArrayList<>();

        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(source)))) {
            while (fileReader.ready()) {
                int i = Integer.parseInt(fileReader.readLine());
                if (i % 2 == 0) {
                    list.add(i);
                }

            }

        }
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.println(integer);

        }


    }
}
