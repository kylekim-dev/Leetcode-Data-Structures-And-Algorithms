using System;
using System.Collections.Generic;
using System.Text;

namespace DataStructure.DataStructures.Linear
{
    public class StackArray
    {
        private object[] arr;
        private int _top;

        public StackArray(int capacity = 16)
        {
            arr = new object[capacity];
            _top = -1;
        }

        public void Push(object data)
        {
            if (_top == arr.Length - 1)
            {
                throw new OverflowException();
            }

            arr[++_top] = data;
        }

        public object Pop()
        {
            if (this.IsEmpty)
            {
                throw new ApplicationException("Empty");
            }

            return arr[_top--];
        }

        public object Peek()
        {
            if (this.IsEmpty)
            {
                throw new ApplicationException("Empty");
            }

            return arr[_top];
        }

        public bool IsEmpty
        {
            get => _top == -1;
        }

        public int Capacity
        {
            get => arr.Length;
        }
    }
}
