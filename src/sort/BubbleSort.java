package sort;

import util.Utils;

/**
 * Created by wesley on 2016/10/3.
 */
public class BubbleSort {
    private int[] arr = {31, 41, 59, 26, 41, 58};

    public void sort() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    Utils.swap(arr, j - 1, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort mySort = new BubbleSort();
        mySort.sort();
        Utils.printArray(mySort.arr);
    }

}
