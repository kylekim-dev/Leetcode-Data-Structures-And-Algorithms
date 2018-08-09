using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using DLL;

namespace DoublyLinkedList
{
    class Program
    {
        static void Main(string[] args)
        {
            Run();
        }

        static void Run()
        {
            MyList<int> myList = new MyList<int>();
            myList.CreateNode(new Node<int>(10));
            myList.CreateNode(new Node<int>(20));
            myList.CreateNode(new Node<int>(30));
            myList.CreateNode(new Node<int>(40));

            myList.PrintAll();
            Console.WriteLine("------------------------");

            var Temp = myList.GetNodeAt(0);

            myList.RemoveNode(myList.GetNodeAt(0));
            myList.PrintAll();

        }
    }
}
