using DataStructure.Array;
using System;

namespace DataStructureTestConsole
{
    class Program
    {
        static void Main(string[] args)
        {
            RunDynamicArray();
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
    }
}
