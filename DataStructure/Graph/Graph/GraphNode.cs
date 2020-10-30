using System;
using System.Collections.Generic;
using System.Text;

namespace Graph
{
    public class GraphNode<T>
    {
        public T Data { get; set; }
        public List<GraphNode<T>> Neighbors { get; private set; }
        public List<int> Weights { get; private set; }

        public GraphNode()
        {
            this.Neighbors = new List<GraphNode<T>>();
            this.Weights = new List<int>();
        }

        public GraphNode(T data) : this()
        {
            this.Data = data;
        }
    }
}
