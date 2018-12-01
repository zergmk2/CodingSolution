package codetest.Algorithum.sort;
import java.util.*;

public class MergeSort {
    public void sort(int[] array)
    {
        if (array == null || array.length == 0)
        {
            return;
        }

        sort(array, 0, array.length-1);
    }

    private void sort(int[] array, int l, int r)
    {
        if (l < r)
        {
            int m = (r + l) / 2;
            sort(array, l, m);
            sort(array, m + 1, r);
            merge(array, l, m, r);
        }
    }

    private void merge(int [] array, int l, int m, int r)
    {
        int subArraySize1 = m - l + 1;
        int subArraySize2 = r - m;

        int[] subArray1 = Arrays.copyOfRange(array, l, l + subArraySize1);
        int[] subArray2 = Arrays.copyOfRange(array, m + 1, m + 1 + subArraySize2);

        int i = 0, j = 0;
        int mergeIndex = l;
        while(i < subArraySize1 && j < subArraySize2)
        {
            int left = subArray1[i];
            int right = subArray2[j];
            if (left <= right)
            {
                array[mergeIndex] = left;
                i++;
            }
            else
            {
                array[mergeIndex] = right;
                j++;
            }

            mergeIndex++;
        }

        while (i < subArraySize1)
        {
            array[mergeIndex] = subArray1[i];
            mergeIndex++;
            i++;
        }

        while (j < subArraySize2)
        {
            array[mergeIndex] = subArray2[j];
            mergeIndex++;
            j++;
        }
    }
}
