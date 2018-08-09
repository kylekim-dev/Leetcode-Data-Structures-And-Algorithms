using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DLL
{
    public class Node<T>
    {
        public Node(T data)
        {
            Data = data;
            PrevNode = null;
            NextNode = null;
        }

        public T Data { get; set; }
        public Node<T> PrevNode { get; set; }
        public Node<T> NextNode { get; set; }
    }
}
