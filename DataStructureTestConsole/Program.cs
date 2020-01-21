using DataStructure.DataStructures.Linear;
using System;

namespace DataStructureTestConsole
{
    class Program
    {
        static void Main(string[] args)
        {
            //RunDynamicArray();
            RunStackUsingArray();
        }

        static void RunDynamicArray()
        {
            DynamicArray dynamicArray = new DynamicArray();
            for (int i = 0; i < 20; i++)
            {
                dynamicArray.Add($"element{i + 1}");
            }

            for (int i = 0; i < dynamicArray.Count; i++)
            {
                Console.WriteLine(dynamicArray[i].ToString());
            }
        }

        static void RunStackUsingArray() 
        {
            StackArray stack = new StackArray(8);
            // Push data
            for (int i = 0; i < 7; i++)
            {
                stack.Push(i);
                Console.WriteLine($"Push data: {i}");
            }

            while (!stack.IsEmpty)
            {
                Console.WriteLine($"Pop data: {stack.Pop()}");
            }
        }
    }
}
