using Microsoft.VisualStudio.TestTools.UnitTesting;
using csharpSolution;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace csharpSolution.Tests
{
    [TestClass()]
    public class SerializeAndDeserializeBstTests
    {
        [TestMethod()]
        public void serializeTest()
        {
            var unitUnderTest = new SerializeAndDeserializeBst();
            TreeNode root = new TreeNode(3);
            root.left = new TreeNode(1);
            root.right = new TreeNode(4);
            root.left.left = null;
            root.left.right = new TreeNode(2);
            //root.right.left = new TreeNode(9);
            //root.right.right = new TreeNode(10);

            // Act
            string serializedString = unitUnderTest.serialize(root);

            TreeNode root1 = unitUnderTest.deserialize(serializedString);
            // Assert
            Assert.IsTrue(serializedString.Length > 0);
        }
    }
}