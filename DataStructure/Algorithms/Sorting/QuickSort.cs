using System;
using System.Collections.Generic;
using System.Text;

namespace DataStructure.Algorithms.Sorting
{
    public class QuickSort : ISort
    {
        public void Ascending(int[] arr)
        {
            _QuickSort(arr, 0, arr.Length - 1);
        }

        public void Descending(int[] arr)
        {
            _QuickSortReverse(arr, 0, arr.Length - 1);
        }

        // Time Complexity: O(n^2) // average O(N*logN)
        private void _QuickSort(int[] arr, int left, int right)
        {
            int low = left;
            int high = right;
            int pivot = arr[(left + right) / 2]; // Pivot the element in the middle of the array.

            // Repeat until low and high intersect.
            do
            {
                // Select an element larger than from the left.
                while (pivot > arr[low])
                {
                    low++;
                }

                // Select an element lower than from the right.
                while (pivot < arr[high])
                {
                    high--;
                }

                // Swap
                if (low <= high)
                {
                    int temp = arr[low];
                    arr[low] = arr[high];
                    arr[high] = temp;
                    low++;
                    high--;
                }
            } while (low <= high);

            // recursion
            if (left < high)
            {
                _QuickSort(arr, left, high);
            }

            if (low < right)
            {
                _QuickSort(arr, low, right);
            }
        }

        private void _QuickSortReverse(int[] arr, int left, int right)
        {
            int low = left;
            int high = right;
            int pivot = arr[(left + right) / 2]; // Pivot the element in the middle of the array.

            // Repeat until low and high intersect.
            do
            {
                // Select an element larger than from the left.
                while (pivot < arr[low])
                {
                    low++;
                }

                // Select an element lower than from the right.
                while (pivot > arr[high])
                {
                    high--;
                }

                // Swap
                if (low <= high)
                {
                    int temp = arr[low];
                    arr[low] = arr[high];
                    arr[high] = temp;
                    low++;
                    high--;
                }
            } while (low <= high);

            // recursion
            if (left < high)
            {
                _QuickSortReverse(arr, left, high);
            }

            if (low < right)
            {
                _QuickSortReverse(arr, low, right);
            }
        }
    }
}
