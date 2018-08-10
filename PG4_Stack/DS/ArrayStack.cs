using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DS
{
    public class ArrayStack<T>
    {
        public int Capacity;
        public int Top;
        public Node<T>[] Nodes;
        
        public ArrayStack()
        {
            Capacity = 0;
            Top = 0;
            Nodes = null;
        }
    }
}
