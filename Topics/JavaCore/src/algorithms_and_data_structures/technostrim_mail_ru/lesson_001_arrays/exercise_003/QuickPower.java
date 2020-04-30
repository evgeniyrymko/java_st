package algorithms_and_data_structures.technostrim_mail_ru.lesson_001_arrays.exercise_003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Быстрое возведение числа a в степень n. Для этого необходимо n представить как сумму чисел-степеней числа 2, например 18=16+2=2^4+2^1;
public class QuickPower {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());
        long result = quickPowerMethod(a, n);
        System.out.println(result);
    }

    private static long quickPowerMethod(long a, int n) {
        long result = 1;
        long aInPowerOf2 = a;
        while (n > 0) {
            if ((n & 1) == 1) {
                result *= aInPowerOf2;
            }
            aInPowerOf2 *= aInPowerOf2;
            n = n >> 1;
        }
        return result;
    }
}
