using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataStructureLibrary.Stack
{
    public class StackLinkedList<T> : IStack<T>
    {
        public Node<T> Top;
        public Node<T> Nodes;

        public StackLinkedList()
        {
            Top = null;
            Nodes = null;
        }

        public int GetSize()
        {
            if (IsEmpty())
            {
                return 0;
            }
            else
            {
                int c = 0;
                Node<T> Current = Nodes;
                while (Current != null)
                {
                    c++;
                    Current = Current.NextNode;
                }

                return c;
            }
        }

        public T GetTopValue()
        {
            return Top.Data;
        }

        public bool IsEmpty()
        {
            return Top == null;
        }

        public T Pop()
        {
            if (IsEmpty())
            {
                throw new IndexOutOfRangeException();
            }
            Node<T> Current = Nodes;

            if(Nodes.NextNode == null)
            {
                Nodes = null;
                Top = Nodes;
            }
            else
            {
                while (Current.NextNode != Top)
                {
                    Current = Current.NextNode;
                }
                Current.NextNode = null;
                Top = Current;
            }

            return Current.Data;
        }

        public void Push(Node<T> data)
        {
            if (IsEmpty())
            {
                Top = data;
                Nodes = data;
            }
            else
            {
                Node<T> Current = Nodes;
                
                while (Current.NextNode != null)
                {
                    Current = Current.NextNode;
                }
                Top = data;
                Current.NextNode = Top;
            }
        }

        void IStack<T>.CreateStack(int capacity)
        {
            throw new NotImplementedException();
        }

        void IStack<T>.IsOverFlowCheck()
        {
            throw new NotImplementedException();
        }
    }
}
