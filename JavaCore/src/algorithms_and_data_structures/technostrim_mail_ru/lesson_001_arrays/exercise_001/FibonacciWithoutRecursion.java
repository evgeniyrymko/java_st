package algorithms_and_data_structures.technostrim_mail_ru.lesson_001_arrays.exercise_001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

//Написать нерекурсивный метод для определения числа Фибоначчи
public class FibonacciWithoutRecursion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        Date date1 = new Date();
        System.out.println(date1.getTime());
        long fibonacci = fibonacciWithoutRecursionMethod(number);
        Date date2 = new Date();
        System.out.println(date2.getTime());
        System.out.println("Time is " + (date2.getTime() - date1.getTime()));
        System.out.println("Result is " + fibonacci);
    }

    private static long fibonacciWithoutRecursionMethod(int number) {
        if (number==0 || number==1) {
            return 1;
        }
        long previous=1;
        long current=1;
        for (int i = 2; i <=number; i++) {
            long temp=current;
            current+=previous;
            previous=temp;
        }
        return current;
    }
}
