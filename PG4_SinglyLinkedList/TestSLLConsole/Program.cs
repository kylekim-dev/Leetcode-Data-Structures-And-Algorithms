using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using SinglyLinkedList;

namespace TestSLLConsole
{
    class Program
    {
        static void Main(string[] args)
        {
            LList<int> list = new LList<int>();
            list.Create(new Node<int>(10));
            list.Create(new Node<int>(20));
            list.Create(new Node<int>(30));
            list.Create(new Node<int>(40));
            list.Create(new Node<int>(50));

            list.InsertNode(list.GetNodeAt(2), new Node<int>(60));

            list.Remove(list.GetNodeAt(1));

            list.PrintAll();

            while (true)
            {

            }
        }
    }
}
