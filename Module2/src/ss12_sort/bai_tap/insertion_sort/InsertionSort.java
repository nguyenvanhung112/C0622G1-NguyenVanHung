package ss12_sort.bai_tap.insertion_sort;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 9, 6, 7, 4, 8};
        insertionSort(arr);
        for (int item : arr) {
            System.out.println(item);
        }
    }

    public static void insertionSort(int[] list) {
        for (int i = 0; i < list.length; i++) {
            int key = list[i];
            int j;
            for (j = i - 1; j >= 0 && list[j] > key; j--) {
                list[j + 1] = list[j];
            }
            list[j + 1] = key;
        }
    }
}
