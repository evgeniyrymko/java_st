package algorithms_and_data_structures.technostrim_mail_ru.lesson_001_arrays.exercise_002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Проверить число на простоту
public class PrimeNumber {
    public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int number = Integer.parseInt(reader.readLine());
        System.out.println(isPrime(number));

    }

    private static boolean isPrime(int number) {
        if (number==1) {
            return false;
        }
        if (number==2) {
            return true;
        }

        for (int i = 2; i*i <=number ; i++) {
            if (number%i==0) return false;
        }
        return true;
    }
}
