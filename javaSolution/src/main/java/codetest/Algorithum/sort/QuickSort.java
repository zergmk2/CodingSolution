package codetest.Algorithum.sort;

import java.util.ArrayList;

public class QuickSort {
    public void sort(int[] array)
    {
        if (array == null || array.length == 0)
        {
            return;
        }
        sort(array, 0, array.length - 1);
    }

    private void sort(int[] array, int l, int r) {
        if (l < r)
        {
            int pivot = partition(array, l, r);
            sort(array, l, pivot - 1);
            sort(array, pivot + 1, r);
        }
    }

    private int partition(int[] array, int l, int r) {
        int pivot = array[r];

        int index = l;

        for (int i = l; i < r; i++)
        {
            if (array[i] <= pivot)
            {
                swap(array, index, i);
                index++;
            }
        }
        swap(array, index, r);
        return index;
    }

    private void swap(int[] array, int a, int b)
    {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
