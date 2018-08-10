using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataStructureLibrary
{
    public class Node<T>
    {
        public T Data;
        public Node<T> NextNode;

        public Node(T data)
        {
            Data = data;
            NextNode = null;
        }
    }
}
