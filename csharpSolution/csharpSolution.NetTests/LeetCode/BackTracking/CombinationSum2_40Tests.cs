using Microsoft.VisualStudio.TestTools.UnitTesting;
using csharpSolution.LeetCode.BackTracking;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace csharpSolution.LeetCode.BackTracking.Tests
{
    [TestClass()]
    public class CombinationSum2_40Tests
    {
        [TestMethod()]
        public void CombinationSum2Test()
        {
            int[] candidates = {1, 2 };
            int target = 4;
            var combination = new CombinationSum2_40();
            var results = combination.CombinationSum2(candidates, target);
            bool testResult = true;
            foreach (var list in results)
            {
                int sum = 0;
                foreach (var item in list)
                {
                    sum += item;
                }
                if (sum == target)
                {
                    testResult |= true;
                }
                else
                {
                    testResult |= false;
                }
            }
            Assert.IsTrue(testResult == true);
        }
    }
}