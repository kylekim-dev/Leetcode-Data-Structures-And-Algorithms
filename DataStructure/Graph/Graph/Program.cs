using System;

namespace Graph
{
    class Program
    {
        static void Main(string[] args)
        {
            var gr = new MyGraph<string>();
            var california = gr.AddVertex("CA");
            var massachusetts = gr.AddVertex("MA");
            var washington = gr.AddVertex("WA");
            var michigan = gr.AddVertex("MI");
            var arizona = gr.AddVertex("AZ"); 
            gr.AddEdge(california, massachusetts, 6);
            gr.AddEdge(california, washington, 7);
            gr.AddEdge(california, michigan, 10);
            gr.AddEdge(massachusetts, arizona, 7);
            gr.AddEdge(washington, arizona, 3);
            gr.AddEdge(michigan, washington, 4);
            gr.DebugPrintGraph();
        }
    }
}
