import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {

    public static void divideArray(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        int[] greaterArray = Arrays.stream(array).filter(num -> num > max).toArray();
        int[] othersArray = Arrays.stream(array).filter(num -> num <= max).toArray();

        System.out.println("Array of numbers greater than max element:");
        System.out.println(Arrays.toString(greaterArray));
        System.out.println("Remaining array:");
        System.out.println(Arrays.toString(othersArray));
    }

    public static int[] insertAtBeginning(int[] array, int element) {
        int[] newArray = new int[array.length + 1];
        newArray[0] = element;
        System.arraycopy(array, 0, newArray, 1, array.length);
        return newArray;
    }

    public static int[] deleteAtLast(int[] array) {
        if (array.length == 0) {
            System.out.println("Array is empty, cannot delete last element.");
            return array;
        }
        return Arrays.copyOf(array, array.length - 1);
    }

    public static void sortArray(int[] array) {
        if (array.length % 2 == 0) {
            Arrays.sort(array);
            System.out.println("Sorted in ascending order:");
        } else {
            Arrays.sort(array);
            for (int i = 0; i < array.length / 2; i++) {
                int temp = array[i];
                array[i] = array[array.length - 1 - i];
                array[array.length - 1 - i] = temp;
            }
            System.out.println("Sorted in descending order:");
        }
        System.out.println(Arrays.toString(array));
    }

    public static void printArray(int[] array) {
        System.out.println("Array elements:");
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {};

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Divide array into two arrays");
            System.out.println("2. Insert an element at the beginning");
            System.out.println("3. Delete the element at last");
            System.out.println("4. Sort the elements");
            System.out.println("5. Print the array");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    divideArray(array);
                    break;
                case 2:
                    System.out.print("Enter element to insert at the beginning: ");
                    int element = scanner.nextInt();
                    array = insertAtBeginning(array, element);
                    break;
                case 3:
                    array = deleteAtLast(array);
                    break;
                case 4:
                    sortArray(array);
                    break;
                case 5:
                    printArray(array);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}
