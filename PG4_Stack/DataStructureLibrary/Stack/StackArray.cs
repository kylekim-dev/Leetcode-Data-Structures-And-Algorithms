using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataStructureLibrary.Stack
{
    public class StackArray<T> : IStack<T>
    {
        private int Capacity;
        private int Top;
        private Node<T>[] Nodes;

        public StackArray()
        {
            Capacity = 0;
            Top = -1;
            Nodes = null;
        }

        public void CreateStack(int capacity)
        {
            this.Capacity = capacity;
            this.Top = -1;
            Nodes = new Node<T>[capacity];
        }

        public int GetSize()
        {
            return Top;
        }

        public int GetCapacity()
        {
            return Capacity;
        }

        public bool IsEmpty()
        {
            return Top == -1;
        }

        public void IsOverFlowCheck()
        {
            if(Capacity == Top+1)
            {
                Capacity = (int)Math.Pow(2, (int)Math.Log(Capacity, 2) + 1);
                Node<T>[] newNode = new Node<T>[Capacity];
                for (int i = 0; i < Nodes.Length; i++)
                {
                    newNode[i] = Nodes[i];
                }
                Nodes = newNode;
            }
        }

        public void Push(Node<T> data)
        {
            IsOverFlowCheck();
            Nodes[++Top] = data;
        }

        public T Pop()
        {
            if (IsEmpty())
            {
                throw new IndexOutOfRangeException();
            }
            return Nodes[Top--].Data;
        }

        public T GetTopValue()
        {
            return Nodes[Top].Data;
        }
    }
}
