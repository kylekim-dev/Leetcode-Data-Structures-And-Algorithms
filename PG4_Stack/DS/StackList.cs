using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DS
{
    public class StackList<T>
    {
        public StackList()
        {

        }

        public void AS_CreateStack(ArrayStack<T> Stack, int Capacity)
        {
            Stack.Capacity = Capacity;
            Stack.Top = 0;
            Stack.Nodes = new Node<T>[Capacity];
        }

        public void AS_DestroyStack(ArrayStack<T> Stack)
        {
            Stack = null;
        }

        public void AS_Push(ArrayStack<T> Stack, Node<T> Data)
        {
            if(!As_IsOverflow(Stack))
            {
                Stack.Nodes[Stack.Top++] = Data;
            }
        }

        public T As_Pop(ArrayStack<T> Stack)
        {
            return Stack.Nodes[--Stack.Top].Data;
        }

        public T As_Top(ArrayStack<T> Stack)
        {
            return Stack.Nodes[Stack.Top-1].Data;
        }

        public int As_GetSize(ArrayStack<T> Stack)
        {
            return Stack.Top;
        }

        public bool As_IsEmpty(ArrayStack<T> Stack)
        {
            return Stack.Top == 0;
        }

        private bool As_IsOverflow(ArrayStack<T> Stack)
        {
            return Stack.Top == Stack.Capacity;
        }
    }
}
