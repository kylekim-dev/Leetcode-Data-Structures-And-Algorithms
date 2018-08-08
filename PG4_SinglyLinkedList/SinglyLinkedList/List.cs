using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SinglyLinkedList
{
    public class LList<T>
    {
        public LList()
        {
            Head = null;
        }

        public Node<T> Head { get; private set; }

        public void Create(Node<T> newNode)
        {
            if(IsHeadEmpty())
            {
                Head = newNode;
            }
            else
            {
                Node<T> Current = Head;

                while (Current.NextNode != null)
                {
                    Current = Current.NextNode;
                }

                Current.NextNode = newNode;
            }
        }

        public Node<T> GetNodeAt(int index)
        {
            Node<T> Current = Head;
            while (Current != null && --index >= 0)
            {
                Current = Current.NextNode;
            }

            return Current;
        }

        public void InsertNode(Node<T> aheadNode, Node<T> newNode)
        {
            if(aheadNode != null)
            {
                Node<T> Current = Head;

                while (Current != null)
                {
                    if (Current == aheadNode)
                    {
                        newNode.NextNode = Current.NextNode;
                        Current.NextNode = newNode;
                        break;
                    }
                    Current = Current.NextNode;
                }
            }
        }

        public void Remove(Node<T> deleteNode)
        {
            if(!IsHeadEmpty() && !(deleteNode == null))
            {
                if(Head == deleteNode)
                {
                    Head = deleteNode.NextNode;
                }
                else
                {
                    Node<T> Current = Head;
                    while (Current != null)
                    {
                        if(Current.NextNode == deleteNode)
                        {
                            Current.NextNode = deleteNode.NextNode;
                        }
                        Current = Current.NextNode;
                    }
                }
            }
        }

        public void PrintAll()
        {
            Node<T> Current = Head;
            int c = 1;
            while (Current != null)
            {
                Console.WriteLine(string.Format("{0} Node has Value = {1}", c++, Current.Data ));
                Current = Current.NextNode;
            }
        }

        public int GetCount()
        {
            int c = 1;
            Node<T> Current = Head;
            if (IsHeadEmpty())
            {
                return 0;
            }
            else
            {
                while (Current.NextNode != null)
                {
                    Current = Current.NextNode;
                    c++;
                }
                return c;
            }
        }

        private bool IsHeadEmpty()
        {
            bool result = false;
            if (Head == null)
            {
                result = true;
            }
            else
            {
                result = false;
            }
            return result;
        }
    }
}
