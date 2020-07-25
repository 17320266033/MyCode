package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 归并排序
 *
 * 归并排序（MERGE-SORT）是利用归并的思想实现的排序方法，
 * 该算法采用经典的分治（divide-and-conquer）策略（分治法将问题分(divide)
 * 成一些小的问题然后递归求解，
 * 而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)。
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int[] temp = new int[arr.length];
        sort(arr, 0, arr.length - 1, temp);
    }
    public static void sort(int[] arr, int start, int last, int[] temp) {
        if (start < last) {
            int mid = (start + last) >> 1;
            sort(arr, start, mid, temp);
            sort(arr, mid + 1, last, temp);
            merge(arr, start, mid, last, temp);
        }
    }

    public static void merge(int[] arr, int start, int mid, int end, int[] temp) {
        int i = start;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            }
            if (arr[i] > arr[j]) {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        while (j <= end) {
            temp[t++] = arr[j++];
        }
    }
}
