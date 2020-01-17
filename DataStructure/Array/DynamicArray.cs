using System;
using System.Collections.Generic;
using System.Text;

namespace DataStructure.Array
{
    public class DynamicArray
    {
        private object[] arr;
        private const int GROWTH_FACTOR = 2;

        public int Count { get; private set; }
        public int Capacity { get { return arr.Length; } }
        public DynamicArray(int capacity = 16)
        {
            arr = new object[capacity];
            Count = 0;
        }

        public object this[int i]
        {
            get
            {
                return Get(i);
            }
        }

        public void Add(object element)
        {
            if (Count >= Capacity)
            {
                int nextSize = Capacity * GROWTH_FACTOR;
                Console.WriteLine($"Size Up {Capacity} -> {nextSize}"); // for testing
                var tempArr = new object[nextSize];
                for (int i = 0; i < arr.Length; i++)
                {
                    tempArr[i] = arr[i];
                }
                arr = tempArr;
            }

            arr[Count++] = element;
        }

        public object Get(int index)
        {
            if (index > Capacity - 1)
            {
                throw new IndexOutOfRangeException("Element not found");
            }
            return arr[index];
        }

        // Other methods...
    }
}
