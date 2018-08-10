using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DLL
{
    public class MyList<T>
    {
        public MyList()
        {

        }

        public void CreateNode(Node<T> newNode)
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
                newNode.PrevNode = Current;
            }
        }

        public void AppendAfter(Node<T> aheadNode, Node<T> newNode)
        {
            if (IsHeadEmpty())
            {
                Head = newNode;
            }
            else
            {
                Node<T> Current = Head;
                while (Current != null)
                {
                    if(Current == aheadNode)
                    {
                        if(Current.NextNode == null)
                        {
                            Current.NextNode = newNode;
                            newNode.PrevNode = Current;
                        }
                        else
                        {
                            Current.NextNode.PrevNode = newNode;
                            newNode.NextNode = Current.NextNode;
                            Current.NextNode = newNode;
                            newNode.PrevNode = Current;
                        }
                    }
                    Current = Current.NextNode;
                }
            }
        }

        public void RemoveNode(Node<T> deleteNode)
        {
            if (!IsHeadEmpty())
            {
                Node<T> Current = Head;
                if (Head == deleteNode)
                {
                    Head = Current.NextNode;
                }
                else
                {
                    while (Current != null)
                    {
                        if (Current == deleteNode)
                        {
                            if (Current.NextNode == null)
                            {
                                Current.PrevNode.NextNode = null;
                            }
                            else
                            {
                                Current.PrevNode.NextNode = deleteNode.NextNode;
                                Current.NextNode.PrevNode = deleteNode.PrevNode;
                            }
                        }

                        Current = Current.NextNode;
                    }
                }
            }

        }

        public Node<T> GetNodeAt(int location)
        {
            if (IsHeadEmpty())
            {
                return null;
            }

            Node<T> Current = Head;
            int index = 0;
            while (Current.NextNode != null)
            {
                if(index == location)
                {
                    return Current;
                }

                Current = Current.NextNode;
                index++;
            }

            return Current;
        }

        public int GetCount()
        {
            if (IsHeadEmpty())
            {
                return 0;
            }

            Node<T> Current = Head;
            int c = 0;

            while (Current != null)
            {
                Current = Current.NextNode;
                c++;
            }

            return c;
        }

        public void PrintAll()
        {
            if (IsHeadEmpty())
            {
                Console.WriteLine("N/A");
            }
            else
            {
                Node<T> Current = Head;
                int c = 1;
                while (Current != null)
                {
                    Console.WriteLine(string.Format("{0} current value = {1}", c, Current.Data));
                    Current = Current.NextNode;
                    c++;
                }
            }
        }

        private bool IsHeadEmpty()
        {
            if (Head == null)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        private Node<T> Head { get; set; }
    }
}
