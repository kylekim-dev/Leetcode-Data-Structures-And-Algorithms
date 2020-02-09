using System;
using System.Collections.Generic;
using System.Text;

namespace DataStructure.Algorithms.Sorting
{
    public class SelectionSort : ISort
    {
        public void Ascending(int[] arr)
        {
            int minimumIndex, temp;
            for (int i = 0; i < arr.Length; i++)
            {
                minimumIndex = i;
                for (int j = i + 1; j < arr.Length; j++)
                {
                    if (arr[j] < arr[minimumIndex])
                    {
                        minimumIndex = j;
                    }
                }

                temp = arr[minimumIndex];
                arr[minimumIndex] = arr[i];
                arr[i] = temp;
            }
        }

        public void Descending(int[] arr)
        {
            int maximumIndex, temp;
            for (int i = 0; i < arr.Length; i++)
            {
                maximumIndex = i;
                for (int j = i + 1; j < arr.Length; j++)
                {
                    if (arr[j] > arr[maximumIndex])
                    {
                        maximumIndex = j;
                    }
                }

                temp = arr[maximumIndex];
                arr[maximumIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
