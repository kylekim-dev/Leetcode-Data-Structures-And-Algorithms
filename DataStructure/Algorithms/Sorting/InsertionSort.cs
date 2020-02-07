using System;
using System.Collections.Generic;
using System.Text;

namespace DataStructure.Algorithms.Sorting
{
    public class InsertionSort : ISort
    {
        // Time Complexity: O(n ^ 2) - Worst
        public void Ascending(int[] arr)
        {
            for (int i = 1; i < arr.Length; i++)
            {
                int key = arr[i];
                for (int j = i; j > 0; j--)
                {
                    if (arr[j - 1] > key)
                    {
                        int temp = arr[j];
                        arr[j] = arr[j - 1];
                        arr[j - 1] = temp;
                    }
                }
            }
        }

        public void Descending(int[] arr)
        {
            for (int i = 1; i < arr.Length; i++)
            {
                int key = arr[i];
                for (int j = i; j > 0; j--)
                {
                    if (arr[j - 1] < key)
                    {
                        int temp = arr[j];
                        arr[j] = arr[j - 1];
                        arr[j - 1] = temp;
                    }
                }
            }
        }
    }
}
