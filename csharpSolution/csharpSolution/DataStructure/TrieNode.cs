using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace csharpSolution.DataStructure
{
    public class TrieNode
    {
        public virtual char Key { get; set; }
        public virtual bool IsTerminal { get; set; }
        public TrieNode Parent { get; set; }
        public Dictionary<char, TrieNode> Children { get; set; }

        public TrieNode(char key) : this(key, false)
        {
        }

        public TrieNode(char key, bool isTerminal)
        {
            Key = key;
            IsTerminal = isTerminal;
            Children = new Dictionary<char, TrieNode>();
        }

        public string Word
        {
            get {
                if (IsTerminal)
                {
                    Stack<char> stack = new Stack<char>();
                    var cur = this;
                    while (cur.Parent != null)
                    {
                        stack.Push(cur.Key);
                        cur = cur.Parent;
                    }
                    return new string(stack.ToArray());
                }
                else
                {
                    return null;
                }
            }
        }

        public void Remove()
        {
            IsTerminal = false;
            if (Children.Count == 0 && Parent != null)
            {
                Parent.Children.Remove(Key);

                if (!Parent.IsTerminal)
                {
                    Parent.Remove();
                }
            }
        }

        public void GetTerminalChildren(List<TrieNode> list)
        {
            foreach (var child in Children.Values)
            {
                if (child.IsTerminal)
                {
                    list.Add(child);
                }

                child.GetTerminalChildren(list);
            }
        }
    }
}
