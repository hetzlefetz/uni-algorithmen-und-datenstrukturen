using System;

public class Knoten<T>
{
    public Knoten<T> Left { get; set; }
    public Knoten<T> Right { get; set; }
    public Knoten<T> Previous { get; set; }
    public T Key { get; set; }

    public Knoten(T key)
    {
        Key = key;
    }

    public Knoten(T key, Knoten<T> right, Knoten<T> left, Knoten<T> previous)
    {
        Key = key;
        Right = right;
        Left = left;
        Previous = previous;
    }

    internal int Count()
    {
        return 1 + (Left?.Count() ?? 0) + (Right?.Count() ?? 0);
    }

    /// <summary>
    /// Appends a node to this node. The how can be configured using the append strategy
    /// </summary>
    /// <param name="knoten">The node to insert</param>
    /// <param name="appendStrategy">Optional: How to append a new node to the node. Default: The given node will be inserted left or right whichever is empty. If none the node will be appended to the left: Two parameters are passed to the function: The node itself and the node to add (in this order)</param>
    internal void Append(Knoten<T> knoten, Action<Knoten<T>, Knoten<T>> appendStrategy = null)
    {
        if (appendStrategy == null)
        {
            if (Left == null)
            {
                Left = knoten; return;
            }
            if (Right == null)
            {
                Right = knoten; return;
            }
            Left.Append(knoten, null);
        }
        appendStrategy(this, knoten);
    }
}