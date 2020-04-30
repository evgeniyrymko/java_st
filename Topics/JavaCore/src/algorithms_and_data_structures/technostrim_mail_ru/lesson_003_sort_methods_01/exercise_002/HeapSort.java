package algorithms_and_data_structures.technostrim_mail_ru.lesson_003_sort_methods_01.exercise_002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//Пирамидальная сортировка
public class HeapSort {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите количество элементов массива");
        int length = Integer.parseInt(reader.readLine());
        int array[] = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }

        System.out.println(Arrays.toString(array));
        int buffer[] = new int[0];
        System.out.println("\nInsert Heap");
        for (int i = 0; i < array.length; i++) {
            buffer = heapInsert(buffer, array[i]);
            System.out.println(Arrays.toString(buffer));
        }
        System.out.println("\nSort Heap");
        for (int i = 0; i < array.length; i++) {
            array[array.length - 1 - i] = buffer[0];
            buffer = heapPop(buffer);
            System.out.println("------");
            System.out.println(Arrays.toString(array));
            System.out.println(Arrays.toString(buffer));
        }


    }

    private static void checkHeap(int[] buffer) {

        for (int i = 0; i < buffer.length; i++) {
            System.out.print(buffer[i]);
            if (2 * i + 1 < buffer.length) {
                System.out.print(" - " + buffer[2 * i + 1]);
            }
            if (2 * i + 2 < buffer.length) {
                System.out.print(" - " + buffer[2 * i + 2]);
            }
            System.out.print(" | ");
        }

    }

    public static int[] heapInsert(int[] array, int x) {
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[newArray.length - 1] = x;
        for (int i = newArray.length - 1; i > 0; ) {
            if (newArray[i] > newArray[(i - 1) / 2]) {
                int tmp = newArray[i];
                newArray[i] = newArray[(i - 1) / 2];
                newArray[(i - 1) / 2] = tmp;
                i = (i - 1) / 2;
            } else {
                break;
            }
        }
        return newArray;
    }


    public static int[] heapPop(int[] array) {
        int tmp = array[0];
        array[0] = array[array.length - 1];
        array[array.length - 1] = tmp;
        int newArray[] = new int[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, newArray.length);
        for (int i = 0; (2 * i + 1) < newArray.length; ) {
            i = 2 * i + 1;
            if ((i + 1) < newArray.length && newArray[i + 1] > newArray[i]) {
                i = i + 1;
            }
            if (newArray[(i - 1) / 2] < newArray[i]) {
                int tmp2 = newArray[(i - 1) / 2];
                newArray[(i - 1) / 2] = newArray[i];
                newArray[i] = tmp2;
            }
        }
        return newArray;
    }

}
