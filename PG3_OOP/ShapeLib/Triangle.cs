using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ShapeLib
{
    public class Triangle : Shape
    {
        private int Side1;
        private int Side2;
        private int Side3;

        public Triangle(int side1, int side2, int side3, int x, int y) : base(x, y)
        {
            this.Side1 = side1;
            this.Side2 = side2;
            this.Side3 = side3;
        }

        public override void Draw()
        {
            Console.WriteLine("Draw Triangle ({0},{1},{2})", Side1, Side2, Side3);
        }

        public override double Area()
        {
            double s = (this.Side1 + this.Side2 + this.Side3)/2;
            double area = Math.Sqrt(s * (s - this.Side1) * (s - this.Side2) * (s - this.Side3));

            return area;
        }

        public bool IsEquilateral {
            get {
                return (this.Side1 == this.Side2) && (this.Side2 == this.Side3);
            }
        }
    }
}
