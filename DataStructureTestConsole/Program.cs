using DataStructure.Algorithms.Sorting;
using DataStructure.DataStructures.Linear;
using System;

namespace DataStructureTestConsole
{
    class Program
    {
        static void Main(string[] args)
        {
            //RunDynamicArray();
            //RunStackUsingArray();
            RunBubbleSort();
        }

        static void RunBubbleSort()
        {
            int[] arr = { 4, 5, 3, 2, 1 };
            Console.Write($"Origin Arr: ");
            foreach (var d in arr)
            {
                Console.Write($"{d} ");
            }
            Console.WriteLine();

            BubbleSort bubbleSort = new BubbleSort();

            bubbleSort.Ascending(arr);
            Console.Write($"After Ascending: ");
            foreach (var d in arr)
            {
                Console.Write($"{d} ");
            }
            Console.WriteLine();

            bubbleSort.Descending(arr);
            Console.Write($"After Descending: ");
            foreach (var d in arr)
            {
                Console.Write($"{d} ");
            }
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
