package algorithms_and_data_structures.technostrim_mail_ru.lesson_003_sort_methods_01.exercise_001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class SimpleSortMethods {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите количество элементов массива");
        int length = Integer.parseInt(reader.readLine());
        int array[] = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
//        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        long selectionSortTimeStart = System.nanoTime();
        selectionSort(array);
        long selectionSortTimeEnd = System.nanoTime();
        System.out.println(selectionSortTimeEnd - selectionSortTimeStart);

        long insertionSortTimeStart = System.nanoTime();
        insertionSort(array);
        long insertionSortTimeEnd = System.nanoTime();
        System.out.println(insertionSortTimeEnd - insertionSortTimeStart);

        long bubbleSortTimeStart = System.nanoTime();
        bubbleSort(array);
        long bubbleSortTimeEnd = System.nanoTime();
        System.out.println(bubbleSortTimeEnd - bubbleSortTimeStart);

        System.out.println("Вне методе");
        System.out.println(Arrays.toString(array));
    }


    // Сортировка выбором
// На очередной итерации будем находить минимум в массиве после текущего элемента и менять его с ним, если надо.
// Таким образом, после i-ой итерации первые i элементов будут стоять на своих местах.
// Асимптотика: O(n2) в лучшем, среднем и худшем случае.
// Нужно отметить, что эту сортировку можно реализовать двумя способами – сохраняя минимум и его индекс или просто
// переставляя текущий элемент с рассматриваемым, если они стоят в неправильном порядке.
// Первый способ оказался немного быстрее, поэтому он и реализован.
    private static void selectionSort(int[] array) {
        int arrayToModify[] = new int[array.length];
        System.arraycopy(array, 0, arrayToModify, 0, array.length);
        for (int i = 0; i < arrayToModify.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arrayToModify.length; j++) {
                if (arrayToModify[j] < arrayToModify[minIndex]) {
                    int tmp = arrayToModify[j];
                    arrayToModify[j] = arrayToModify[minIndex];
                    arrayToModify[minIndex] = tmp;
                }
            }
        }
        System.out.println("Сортировка выбором");
        System.out.println(Arrays.toString(arrayToModify));
    }

    // Сортировка вставками
// Создадим массив, в котором после завершения алгоритма будет лежать ответ.
// Будем поочередно вставлять элементы из исходного массива так, чтобы элементы в массиве-ответе всегда были отсортированы.
// Асимптотика в среднем и худшем случае – O(n2), в лучшем – O(n).
// Реализовывать алгоритм удобнее по-другому (создавать новый массив и реально что-то вставлять в него относительно сложно):
// просто сделаем так, чтобы отсортирован был некоторый префикс исходного массива,
// вместо вставки будем менять текущий элемент с предыдущим, пока они стоят в неправильном порядке.
    private static void insertionSort(int[] array) {
        int arrayToModify[] = new int[array.length];
        System.arraycopy(array, 0, arrayToModify, 0, array.length);
        for (int i = 1; i < arrayToModify.length; i++) {
            int tmp = arrayToModify[i];
            int j = i - 1;
            while (j >= 0 && tmp < arrayToModify[j]) {
                arrayToModify[j + 1] = arrayToModify[j];
                j--;
            }
            arrayToModify[j + 1] = tmp;
        }
        System.out.println("Сортировка вставками");
        System.out.println(Arrays.toString(arrayToModify));
    }


    // Сортировка пузырьком
// Будем идти по массиву слева направо.
// Если текущий элемент больше следующего, меняем их местами.
// Делаем так, пока массив не будет отсортирован.
// Заметим, что после первой итерации самый большой элемент будет находиться в конце массива, на правильном месте.
// После двух итераций на правильном месте будут стоять два наибольших элемента, и так далее.
// Очевидно, не более чем после n итераций массив будет отсортирован.
// Таким образом, асимптотика в худшем и среднем случае – O(n2), в лучшем случае – O(n).
    private static void bubbleSort(int[] array) {
        int arrayToModify[] = new int[array.length];
        System.arraycopy(array, 0, arrayToModify, 0, array.length);
        for (int i = arrayToModify.length-1; i > 0; i--) {
            int rotations=0;
            for (int j = 0; j < i; j++) {
                if (arrayToModify[j] > arrayToModify[j + 1]) {
                    int tmp = arrayToModify[j];
                    arrayToModify[j] = arrayToModify[j + 1];
                    arrayToModify[j + 1] = tmp;
                    rotations++;
                }
            }
            if (rotations==0) {
                break;
            }
        }
        System.out.println("Сортировка пузырьком");
        System.out.println(Arrays.toString(arrayToModify));

    }

}
