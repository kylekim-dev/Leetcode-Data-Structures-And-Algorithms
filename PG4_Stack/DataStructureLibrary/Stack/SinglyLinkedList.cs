using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataStructureLibrary.Stack
{
    public class SinglyLinkedList<T>
    {
        public Node<T> Head;

        public SinglyLinkedList()
        {
            Head = null;
        }

        public void Add(Node<T> newNode)
        {
            if (IsHeadEmpty())
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

        public void Delete(Node<T> deleteNode)
        {
            if (!IsHeadEmpty())
            {
                Node<T> Current = Head;

                while(Current.NextNode != null)
                {
                    if(Current.NextNode == deleteNode)
                    {
                        Current.NextNode = deleteNode.NextNode;
                    }
                    Current = Current.NextNode;
                }
            }
        }

        public void InsertAfter(Node<T> aheadNode, Node<T> newNode)
        {
            if (aheadNode != null)
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

        public Node<T> GetNodeAt(int n)
        {
            Node<T> Current = Head;
            int i = 0;
            while(Current == null)
            {
                if(i == n)
                {
                    return Current;
                }
                i++;
                Current = Current.NextNode;
            }
            return Current;
        }

        public bool IsHeadEmpty()
        {
            return Head == null;
        }
    }
}
