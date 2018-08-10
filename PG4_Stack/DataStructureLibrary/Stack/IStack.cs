using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DataStructureLibrary.Stack
{
    public interface IStack<T>
    {
        void CreateStack(int capacity);
        void Push(Node<T> data);
        T Pop();
        T GetTopValue();
        int GetSize();
        bool IsEmpty();
        void IsOverFlowCheck();


    }
}
