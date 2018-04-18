import java.util.Collections;

/**
 * Inplace Quicksort (Desructive)
 * Space complexity: Theta(1)
 * Author: Benjamin Ulrich
 */

public class QuickSort<T> {

    public static <T extends Comparable> void sort(T[] lst) {
        sort(lst, 0, lst.length - 1);
    }

    private static <T extends Comparable> void sort(T[] lst, int startI, int endI) {
        final int startPos = startI;
        final int endPos = endI;

        if (startI >= endI) {
            return;
        }
        T pivot = lst[startI];
        int leftPointer = startI + 1;
        int rightPointer = endI;
        boolean flagLeft = true;
        boolean flagRight = true;

        while (rightPointer >= leftPointer) {
            //swap
            if (!flagLeft && !flagRight) {
                flagLeft = true;
                flagRight = true;
                swap(lst, rightPointer, leftPointer);
                rightPointer -= 1;
                leftPointer += 1;
            }
            //check left pointer
            if (flagLeft) {
                if (lst[leftPointer].compareTo(pivot) >= 0) {
                    flagLeft = false;
                } else {
                    leftPointer += 1;
                }
            }
            //check right pointer
            if (flagRight) {
                if (lst[rightPointer].compareTo(pivot) <= 0) {
                    flagRight = false;
                } else {
                    rightPointer -= 1;
                }
            }
        }
        swap(lst, startI, rightPointer);
        sort(lst, startI, rightPointer - 1);
        sort(lst, leftPointer, endI);
    }

    private static <T extends Comparable> void swap(T[]lst, int x, int y) {
        //destructively swaps two items in a list
        T a = lst[x];
        lst[x] = lst[y];
        lst[y] = a;
    }

}
