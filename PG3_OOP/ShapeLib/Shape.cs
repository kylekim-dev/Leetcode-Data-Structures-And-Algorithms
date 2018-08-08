using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ShapeLib
{
    public class Shape
    {
        private int X;
        private int Y;

        public Shape(int x, int y)
        {
            this.X = x;
            this.Y = y;
        }

        public virtual void Draw() { }
        public virtual double Area() { return 0; }
    }
}
