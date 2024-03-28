import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
/*        To make the largest number that can be made from a given number.
         For this, I collected the number in an array, sorted it in reverse,
         and converted it back into a number.          */

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int i = 0;
        String numberString = Integer.toString(number);
        int length = numberString.length();
        int[] array = new int[length];
        int digit = 0;
        if (length != 1) {
            while (number != 0) {
                digit = number % 10;
                number /= 10;
                array[i] = digit;
                i++;
            }
        } else {
            System.out.println(number);
        }
        int[] reverseArray = getReverseSelectionSort(array);
        printArray(reverseArray);

        int largestNumber = 0;
        for (int k=0;k< reverseArray.length;k++){
            largestNumber = largestNumber * 10 + reverseArray[k];
        }
        System.out.println(largestNumber);

    }

    public static int[] getReverseSelectionSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] > array[min]) {
                    min = j;
                }
            }

            int temp = array[min];
            array[min] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static void printArray(int array[]) {
        int n = array.length;
        for (int i = 0; i < n; ++i)
            System.out.print(array[i] + " ");
        System.out.println();
    }
}