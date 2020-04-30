package algorithms_and_data_structures.technostrim_mail_ru.lesson_001_arrays.exercise_001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;

//Написать нерекурсивный метод для определения числа Фибоначчи с использованием мемоизации (т.е. добавления вычисленных ранее чисел Фибоначчи в массив)
public class FibonacciRecursionMemoization {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        long array[]=new long[number+1];
        Arrays.fill(array,-1);
        Date date1 = new Date();
        System.out.println(date1.getTime());
        long fibonacci = fibonacciRecursionMemoizationMethod(number,array);
        Date date2 = new Date();
        System.out.println(date2.getTime());
        System.out.println("Time is " + (date2.getTime() - date1.getTime()));
        System.out.println("Result is " + fibonacci);
    }

    private static long fibonacciRecursionMemoizationMethod(int number, long[] array) {
        if (number==0 || number==1) {
            return 1;
        }
        if (array[number]!=-1) {
            return array[number];
        }
        long result = fibonacciRecursionMemoizationMethod(number-1,array)+fibonacciRecursionMemoizationMethod(number-2,array);
        array[number]=result;
        return result;
    }
}
