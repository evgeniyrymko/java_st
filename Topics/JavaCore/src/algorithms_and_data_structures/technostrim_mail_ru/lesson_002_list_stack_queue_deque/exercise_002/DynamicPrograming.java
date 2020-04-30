package algorithms_and_data_structures.technostrim_mail_ru.lesson_002_list_stack_queue_deque.exercise_002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Применить динамическое программирование для вычисления значений рекуррентной формулы
// F(x,y) = 3*F(x-1,y)-2F(x,y-1)*F(x,y-1), F(x,0) = x, F(0,y)=0
// Для этого необходимо создать двумерный массив и проинициализировать его краевые условия
// Затем для вычисления рекуррентной формулы необходимо создать вложенный цикл
public class DynamicPrograming {
    public static void main(String[] args) throws IOException {
        int[][] array = new int[11][11];
        for (int i = 1; i < 11; i++) {
            array[i][0] = i;
        }
        for (int j = 0; j < 11; j++) {
            array[0][j] = 0;
        }
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                array[i][j] = 3 * array[i - 1][j] - 2 * array[i][j - 1] * array[i][j - 1];
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(reader.readLine());
        int y = Integer.parseInt(reader.readLine());
        System.out.println("F(x,y)= " + array[x][y]);
    }

}
