using System;
using System.Collections.Generic;
using System.Net;
using System.Text;

namespace Binary_Search_Tree
{
    public class BST<T> where T : IComparable<T>
    {
        public class BSTNode
        {
            public BSTNode(T data)
            {
                this.Data = data;
            }
            public T Data { get; set; }
            public BSTNode Left { get; set; }
            public BSTNode Right { get; set; }
        }

        private BSTNode root { get; set; }
        // Time Complexity: O(log n)
        // Space complexity: O(n)
        public void Add(T data) 
        {
            if (root == null)
            {
                root = new BSTNode(data);
                return;
            }

            BSTNode node = root;

            while (node != null)
            {
                int cmp = node.Data.CompareTo(data);

                if (cmp == 0)
                {
                    throw new ApplicationException("Duplicate data");
                }
                else if (cmp > 0)
                {
                    if (node.Left == null)
                    {
                        node.Left = new BSTNode(data);
                        break;
                    }
                    else
                    {
                        node = node.Left;
                    }
                }
                else
                {
                    if (node.Right == null)
                    {
                        node.Right = new BSTNode(data);
                        break;
                    }
                    else
                    {
                        node = node.Right;
                    }
                }
            }
        }

        // Time Complexity: O(n)
        // Space complexity: O(n)
        public bool Remove(T data) 
        {
            BSTNode node = this.root;
            BSTNode prev = null;

            // Search data
            while (node != null)
            {
                int cmp = data.CompareTo(node.Data);

                if (cmp == 0)
                {
                    break;
                }
                else if (cmp < 0)
                {
                    prev = node;
                    node = node.Left;
                }
                else
                {
                    prev = node;
                    node = node.Right;
                }
            }

            if (node == null) return false; // data does not exist.

            if (node.Left == null && node.Right == null)
            {
                if (prev.Left == node)
                {
                    prev.Left = null;
                }
                else
                {
                    prev.Right = null;
                }

                node = null;
            }
            else if (node.Left == null || node.Right == null)
            {
                BSTNode child = (node.Left != null) ? node.Left : node.Right;
                if (prev.Left != null)
                {
                    prev.Left = child;
                }
                else
                {
                    prev.Right = child;
                }

                node = null;
            }
            else
            {
                var pre = node;
                var min = node.Right;
                while (min.Left != null)
                {
                    pre = min;
                    min = pre.Left;
                }

                node.Data = min.Data;

                if (pre.Left == min)
                {
                    pre.Left = min.Right;
                }
                else
                {
                    pre.Right = min.Right;
                }
            }

            return true;
        }

        // Time Complexity: O(log n)
        // Space complexity: O(n)
        public bool Search(T data) 
        {
            return SearchRecursive(root, data);
        }

        private bool SearchRecursive(BSTNode node, T data)
        {
            if (node == null) return false;
            int cmp = data.CompareTo(node.Data);
            if (cmp == 0)
            {
                return true;
            }
            return(cmp < 0) ? SearchRecursive(node.Left, data) : SearchRecursive(node.Right, data);
        }

        public void InorderTraversal()
        {
            if (this.root == null)
            {
                Console.WriteLine("Tree is empty");
            }

            BSTNode node = this.root;
            InorderTraversal(node);
        }
        // Time Complexity: O(n)
        // Space complexity: O(n)
        private void InorderTraversal(BSTNode node)
        {
            if (node.Left != null)
            {
                InorderTraversal(node.Left);
            }

            Console.Write("{0} ", node.Data);

            if (node.Right != null)
            {
                InorderTraversal(node.Right);
            }
        }
    }
}
