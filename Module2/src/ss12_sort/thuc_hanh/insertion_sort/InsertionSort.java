package ss12_sort.thuc_hanh.insertion_sort;

public class InsertionSort {
    static int[] list = {1, 9, 4, 6, 5, -4};

    public static void main(String[] args) {
        insectionSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
// Sắp xếp chèn
    public static void insectionSort(int[] list) {
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
