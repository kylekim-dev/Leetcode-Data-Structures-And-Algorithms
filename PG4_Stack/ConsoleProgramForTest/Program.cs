using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using DataStructureLibrary;
using DataStructureLibrary.Stack;

namespace ConsoleProgramForTest
{
    class Program
    {
        static void Main(string[] args)
        {
            RunAsArray();
            RunAsLinkedList();
        }

        static void RunAsArray()
        {
            try
            {
                var stackArray = new StackArray<int>();
                stackArray.CreateStack(10);
                for (int i = 0; i < 12; i++)
                {
                    stackArray.Push(new Node<int>(i * 10));
                }

                Console.WriteLine($"Get Size: {stackArray.GetSize()} // Get Capacity: {stackArray.GetCapacity()} // Top Value: {stackArray.GetTopValue()}");

                for (int i = 0; i < 13; i++)
                {
                    Console.Write("Pop: {0}, ", stackArray.Pop());
                    Console.WriteLine("Current Top: {0}, ", stackArray.GetSize());
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }

        static void RunAsLinkedList()
        {
            try
            {
                var stackLinkedList = new StackLinkedList<int>();
                for (int i = 0; i < 12; i++)
                {
                    stackLinkedList.Push(new Node<int>(i * 10));
                }

                Console.WriteLine($"Get Size: {stackLinkedList.GetSize()} // Top Value: {stackLinkedList.GetTopValue()}");

                for (int i = 0; i < 13; i++)
                {
                    Console.Write("Pop: {0}, ", stackLinkedList.Pop());
                    Console.WriteLine("Current Top: {0}, ", stackLinkedList.GetSize());
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }
    }
}
