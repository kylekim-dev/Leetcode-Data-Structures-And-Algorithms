using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using DS;

namespace PG4_Stack
{
    class Program
    {
        static void Main(string[] args)
        {
            Run();
        }

        static void Run()
        {
            StackList<int> sl = new StackList<int>();
            ArrayStack<int> stack1 = new ArrayStack<int>();
            sl.AS_CreateStack(stack1, 10);
            sl.AS_Push(stack1, new Node<int>(3));
            sl.AS_Push(stack1, new Node<int>(37));
            sl.AS_Push(stack1, new Node<int>(11));
            sl.AS_Push(stack1, new Node<int>(12));

            Console.WriteLine("Capacity: {0} // Size: {1} // Top: {2}", stack1.Capacity, sl.As_GetSize(stack1), sl.As_Top(stack1));

            for (int i = 0; i < 4; i++)
            {
                if (sl.As_IsEmpty(stack1))
                {
                    break;
                }
                Console.Write("Popped: {0}, ", sl.As_Pop(stack1));
                if (!sl.As_IsEmpty(stack1))
                {
                    Console.WriteLine("Current Top: {0}, ", sl.As_GetSize(stack1));
                }
                else
                {
                    Console.WriteLine("Stack Is Empty!");
                }
            }

            sl.AS_DestroyStack(stack1);
        }
    }
}
