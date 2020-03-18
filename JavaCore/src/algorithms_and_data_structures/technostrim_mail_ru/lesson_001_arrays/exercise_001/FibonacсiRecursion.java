package algorithms_and_data_structures.technostrim_mail_ru.lesson_001_arrays.exercise_001;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

//Написать рекурсивный метод для определения числа Фибоначчи
public class FibonacсiRecursion {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        Date date1 = new Date();
        System.out.println(date1.getTime());
        long fibonacci = fibonacciRecursionMethod(number);
        Date date2 = new Date();
        System.out.println(date2.getTime());
        System.out.println("Time is " + (date2.getTime() - date1.getTime()));
        System.out.println("Result is " + fibonacci);

    }

    private static long fibonacciRecursionMethod(int i) {
        if (i == 0 || i == 1) {
            return 1;
        }
        return fibonacciRecursionMethod(i - 1) + fibonacciRecursionMethod(i - 2);
    }
}
