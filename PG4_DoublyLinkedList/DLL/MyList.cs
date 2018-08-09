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
                    while (Current.NextNode != null)
                    {
                        if (Current == deleteNode)
                        {
                            Current.PrevNode.NextNode = deleteNode.NextNode;
                            Current.NextNode.PrevNode = deleteNode.PrevNode;
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
