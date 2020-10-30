using System;
using System.Collections.Generic;
using System.Text;

namespace Graph.HashTableGraph
{
    public class GraphUsingHashTable<T>
    {
        // Vertexes
        private Dictionary<T, List<Node<T>>> nodes = new Dictionary<T, List<Node<T>>>();

        public void AddVertex(T key, int weight = 1)
        {
            AddVertex(new Node<T>(key, weight));
        }

        public void AddVertex(Node<T> node)
        {
            if (!nodes.ContainsKey(node.Key))
            {
                var edgeList = new List<Node<T>>();

                nodes.Add(node.Key, edgeList);
            }
        }

        public void AddEdge(T from, T to, int weight = 1)
        {
            var fromNode = nodes[from];

            if (fromNode == null)
            {
                throw new ApplicationException("Not found");
            }

            fromNode.Add(new Node<T>(to, weight));
        }

        public void DFS()
        {
            var visitors = new HashSet<Node<T>>();

            foreach (var node in this.nodes)
            {
                if (visitors.Contains(node))
                {

                }
            }
        }
    }
}
