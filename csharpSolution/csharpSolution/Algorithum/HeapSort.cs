using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace csharpSolution.Algorithum
{
    public class HeapSort
    {
        private int[] heap;
        private bool isMaxHeap;

        public int[] Heap { get => heap; set => heap = value; }

        public HeapSort(int[] nums, bool isMaxHeap)
        {
            this.isMaxHeap = isMaxHeap;
            heap = nums;
            buildheap();
        }

        private void buildheap()
        {
            for(int i = this.heap.Length / 2 - 1; i >= 0; i--)
            {
                heapify(i, this.heap.Length);
            }
        }

        private void heapify(int rootIndex, int length)
        {

            int left = rootIndex * 2 + 1;
            int right = rootIndex * 2 + 2;

            int swapIndex = rootIndex;
            if (this.isMaxHeap)
            {
                if (left < length && heap[left] > heap[swapIndex])
                {
                    swapIndex = left;
                }

                if (right < length && heap[right] > heap[swapIndex])
                {
                    swapIndex = right;
                }
            }
            else
            {
                if (left < length && heap[left] < heap[swapIndex])
                {
                    swapIndex = left;
                }
                else if (right < length && heap[right] < heap[swapIndex])
                {
                    swapIndex = right;
                }
            }

            if (swapIndex != rootIndex)
            {
                swap(swapIndex, rootIndex);
                heapify(swapIndex, length);
            }

        }

        private void swap(int a, int b)
        {
            if (a < heap.Length && b < heap.Length)
            {
                int tmp = heap[a];
                heap[a] = heap[b];
                heap[b] = tmp;
            }
        }

        public void sort()
        {
            buildheap();
            for (int i = heap.Length - 1; i >= 0; i--)
            {
                swap(i, 0);
                heapify(0, i - 1);
            }
        }
    }
}
