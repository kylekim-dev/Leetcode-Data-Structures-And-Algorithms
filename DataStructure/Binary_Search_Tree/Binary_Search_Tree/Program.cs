using System;

namespace Binary_Search_Tree
{
    class Program
    {
        static void Main(string[] args)
        {
            BST<int> bst = new BST<int>();
            Random random = new Random();
            for (int i = 0; i < 10; i++)
            {
                //int val = random.Next(0, 100);
                if (!bst.Search(i))
                {
                    bst.Add(i);
                }
            }

            bst.InorderTraversal();

            bst.Remove(1);
            bst.Remove(2);
            bst.Remove(3);
            bst.Remove(4);
            bst.Remove(5);
            Console.WriteLine();
            bst.InorderTraversal();
        }
    }
}
