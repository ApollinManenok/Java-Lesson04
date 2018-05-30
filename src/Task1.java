import java.util.Scanner;

public class Task1 {

    public static void manualFill(int[] array) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter " + array.length + " numbers separated by space: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = scan.nextInt();
        }
        scan.close();
    }

    public static void myQuickSort(int[] array, int begin, int end) {
        if (begin >= end)
            return;
        int lessIndex = begin - 1, supportElement = array[end];
        for (int j = begin; j <= end - 1; j++) {
            if (array[j] < supportElement) {
                lessIndex++;
                int temp = array[j];
                array[j] = array[lessIndex];
                array[lessIndex] = temp;
            }
        }
        while (array[lessIndex + 1] == array[end] && lessIndex + 1 < end) {
            lessIndex++;
        }
        int temp = array[lessIndex + 1];
        array[lessIndex + 1] = array[end];
        array[end] = temp;
        myQuickSort(array, begin, lessIndex);
        myQuickSort(array, lessIndex + 2, end);
    }

    public static void printArray(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            System.out.printf("%d | ", array[i]);
        }
        System.out.println(array[array.length - 1]);
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        manualFill(arr);
        printArray(arr);
        myQuickSort(arr, 0, arr.length - 1);
        printArray(arr);
    }
}
