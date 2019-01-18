using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace csharpSolution.DataStructure
{
    public class Trie
    {
        private TrieNode _root;
        private int _count;
        public Trie()
        {
            _root = new TrieNode(' ');
            _count = 0;
        }

        public int Count { get => _count; }

        public bool IsEmpty { get => _count == 0; }

        public void Add(string word)
        {
            var current = _root;

            foreach (var ch in word)
            {
                if (!current.Children.ContainsKey(ch))
                {
                    current.Children[ch] = new TrieNode(ch);
                    current.Children[ch].Parent = current;
                }
                current = current.Children[ch];
            }

            ++_count;
            current.IsTerminal = true;
        }

        public void Remove(string word)
        {
            var current = _root;

            foreach (var ch in word)
            {
                if (!current.Children.ContainsKey(ch))
                {
                    break;
                }

                current = current.Children[ch];
            }

            current.IsTerminal = false;
            if (current.Children.Count == 0 && current.Parent != null)
            {
                current.Parent.Children.Remove(current.Key);
            }

        }
    }
}
