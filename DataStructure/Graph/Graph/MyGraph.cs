using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Text;

namespace Graph
{
    public class MyGraph<T>
    {
        public List<GraphNode<T>> nodes;
        private bool _directedGraph;

        public MyGraph(bool directedGraph = false)
        {
            this.nodes = new List<GraphNode<T>>();
            this._directedGraph = directedGraph;
        }

        public GraphNode<T> AddVertex(T data)
        {
            return AddVertex(new GraphNode<T>(data));
        }

        public GraphNode<T> AddVertex(GraphNode<T> node)
        {
            nodes.Add(node);
            return node;
        }

        public void AddEdge(GraphNode<T> from, GraphNode<T> to, int weight = 1)
        {
            from.Neighbors.Add(to);
            from.Weights.Add(weight);

            if (!this._directedGraph)
            {
                to.Neighbors.Add(from);
                to.Weights.Add(weight);
            }
        }

        internal void DebugPrintGraph()
        {
            foreach (var vertex in nodes)
            {
                int cnt = vertex.Neighbors.Count;
                for (int i = 0; i < cnt; i++)
                {
                    Console.WriteLine("{0}-- ({1}) --{2}",
                    vertex.Data,
                    vertex.Weights[i],
                    vertex.Neighbors[i].Data);
                }
            }
        }
    }
}
