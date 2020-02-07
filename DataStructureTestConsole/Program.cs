using DataStructure.Algorithms.Sorting;
using DataStructure.DataStructures.Linear;
using System;
using System.Diagnostics;

namespace DataStructureTestConsole
{
    class Program
    {
        static void Main(string[] args)
        {
            //RunDynamicArray();
            //RunStackUsingArray();
            RunSort(SortType.Insertion);
        }

        static void RunSort(SortType type)
        {
            ISort sort;
            switch (type)
            {
                case SortType.Bubble:
                    sort = new BubbleSort();
                    break;
                case SortType.Insertion:
                    sort = new InsertionSort();
                    break;
                default:
                    sort = new InsertionSort();
                    break;
            }
            int[] arr = new int[20000];
            Random random = new Random();
            for(int i = 0; i < arr.Length; i++)
            {
                arr[i] = random.Next(1, 20000);
            }
            
            Console.Write($"Original: ");
            foreach (var d in arr)
            {
                Console.Write($"{d} ");
            }
            Console.WriteLine();
            Console.WriteLine();

            Stopwatch stopwatch = new Stopwatch();
            Console.Write($"After Ascending: ");
            stopwatch.Start();
            sort.Ascending(arr);
            stopwatch.Stop();
            foreach (var d in arr)
            {
                Console.Write($"{d} ");
            }
            Console.WriteLine();
            Console.WriteLine($"Time elapsed: {stopwatch.Elapsed}");

            //Console.Write($"After Descending: ");
            //sort.Descending(arr);
            //foreach (var d in arr)
            //{
            //    Console.Write($"{d} ");
            //}
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

        public enum SortType
        {
            Bubble,
            Insertion
        }
    }
}
