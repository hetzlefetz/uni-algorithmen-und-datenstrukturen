using System;

namespace esa4
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello Tree World!");
            var k1 = new Knoten<int>(1);
            var k2 = new Knoten<int>(2, null, null, k1);
            var k3 = new Knoten<int>(3, null, null, k2);
            var k4 = new Knoten<int>(13, null, null, k1);
            k1.Left = k2;
            k1.Right = k4;
            k2.Left = k3;


            var b1 = new BinaererBaum<int>(k1);

            b1.Inorder();

            Console.WriteLine("Tree size: " + b1.Size());
            Console.WriteLine("search 1" + b1.Search(1));
            Console.WriteLine("search 2" + b1.Search(2));
            Console.WriteLine("search 3" + b1.Search(3));
            Console.WriteLine("search 13" + b1.Search(13));
            Console.WriteLine("search 14" + b1.Search(14));

            var b2 = new BinaererSuchBaum<int>();
            b2.Insert(new Knoten<int>(4));
            b2.Insert(new Knoten<int>(3));
            b2.Insert(new Knoten<int>(2));
            b2.Insert(new Knoten<int>(3));
            b2.Insert(new Knoten<int>(5));
            b2.Insert(new Knoten<int>(7));

            b2.Inorder();
            Console.WriteLine("Tree size: " + b2.Size());
            Console.WriteLine("search 4" + b2.Search(4));
            Console.WriteLine("search 3" + b2.Search(3));
            Console.WriteLine("search 2" + b2.Search(2));
            Console.WriteLine("search 5" + b2.Search(5));
            Console.WriteLine("search 7" + b2.Search(7));
            Console.WriteLine("search 17" + b2.Search(17));

            Console.WriteLine("Min Value:" + b2.MinElement());
            Console.WriteLine("Max Value:" + b2.MaxElement());

        }
    }
}
