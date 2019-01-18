using Microsoft.VisualStudio.TestTools.UnitTesting;
using csharpSolution.Algorithum;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace csharpSolution.Algorithum.Tests
{
    [TestClass()]
    public class HeapSortTests
    {
        [TestMethod()]
        public void sortTest()
        {
            int[] nums = {1,10,8,4,5,6,2 };
            Stack<int> stack = new Stack<int>();
            stack.Push(1);
            stack.Push(2);
            stack.Push(3);
            stack.Push(4);
            stack.Push(5);
            var tmp = stack.ToArray();
            var heapSorter = new HeapSort(nums, true);
            heapSorter.sort();
            Assert.IsTrue(heapSorter.Heap[0] < heapSorter.Heap[2]);
        }
    }
}