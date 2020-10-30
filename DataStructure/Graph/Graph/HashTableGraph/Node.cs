using System;
using System.Collections.Generic;
using System.Text;

namespace Graph.HashTableGraph
{
    public class Node<T>
    {
        public T Key { get; private set; }
        public int Weight { get; private set; }

        public Node(T key, int weight = 1)
        {
            this.Key = key;
            this.Weight = weight;
        }
    }
}
