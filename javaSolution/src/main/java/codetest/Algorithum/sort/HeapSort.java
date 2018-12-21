package codetest.Algorithum.sort;
import java.util.*;

public class HeapSort
{
    private int[] heap;
    private boolean isMaxHeap;

    public HeapSort(int[] nums, boolean isMaxHeap)
    {
        this.isMaxHeap = isMaxHeap;
        heap = Arrays.copyOf(nums, nums.length);
        buildHeap();
    }

    private void buildHeap()
    {
        for(int i = (int)Math.floor(this.heap.length/2); i >= 0; i--)
        {
            heapify(i, this.heap.length);
        }
    }

    private void heapify(int rootIndex, int len)
    {
        int left = rootIndex * 2 + 1;
        int right = rootIndex * 2 + 2;
        int swapIndex = rootIndex;
        if (this.isMaxHeap)
        {
            if (left < len && heap[left] > heap[swapIndex])
            {
                swapIndex = left;
            }

            if (right < len && heap[right] > heap[swapIndex])
            {
                swapIndex = right;
            }
        }
        else
        {
            if (left < len && heap[left] < heap[swapIndex])
            {
                swapIndex = left;
            }

            if (right < len && heap[right] < heap[swapIndex])
            {
                swapIndex = right;
            }
        }

        if (rootIndex != swapIndex)
        {
            swap(rootIndex, swapIndex);
            heapify(swapIndex, len);
        }
    }

    private void swap(int a, int b)
    {
        int tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }

    public void sort()
    {
        for(int i = heap.length - 1; i >= 0; i--)
        {
            swap(i, 0);
            heapify(0, i - 1);
        }
    }

    public int[] getHeapArray()
    {
        return this.heap;
    }

}
