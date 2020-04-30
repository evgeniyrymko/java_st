package algorithms_and_data_structures.technostrim_mail_ru.lesson_001_arrays.exercise_004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
// Бинарный поиск элемента в массиве, нерекурсивный метод; в данном алгоритме элемент сравнивается с элементом в середине массива, затем массив уменьшается вдвое,
//и итерация повторяется;
// Эту задачу также можно решить рекурсивно, для этого при каждом вызове метода необходимо передавать новый массив;
public class BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите длину массива");
        int lengthArray=Integer.parseInt(reader.readLine());
        int array[]=new int[lengthArray];
        System.out.println("Введите элементы массива");
        for (int i = 0; i < lengthArray; i++) {
            array[i]=Integer.parseInt(reader.readLine());
        }
        Arrays.sort(array);
        System.out.println("Введите элемент, который необходимо найти в массиве");
        int elementToSearch=Integer.parseInt(reader.readLine());
        System.out.println(binarySearchMethod(array, elementToSearch));

    }

    private static boolean binarySearchMethod(int[] array, int elementToSearch) {
        int startPosition=0;
        int endPosition=array.length-1;
        while ((endPosition-startPosition)>0) {
            int midPosition=(endPosition-startPosition)/2;
            if (array[midPosition] >= elementToSearch) {
                endPosition = midPosition;
            } else {
                startPosition=midPosition+1;
            }
        }

        return array[startPosition]==elementToSearch ? true: false;
    }
}
