using System;

public class BinaererBaum<T>
{
    /// <summary>
    /// The root of the tree
    /// </summary>
    public Knoten<T> Root { get; set; }

    /// <summary>
    /// Create an empty binary tree
    /// </summary>
    public BinaererBaum()
    {

    }

    /// <summary>
    /// Create a binary with a given root node
    /// </summary>
    /// <param name="root">The root node</param>
    public BinaererBaum(Knoten<T> root)
    {
        Root = root;
    }

    /// <summary>
    /// Perform an inorder tree traversal starting from the root node
    /// </summary>
    public void Inorder()
    {
        Console.Write("Traversing tree from root: ");

        Inorder(Root);

        Console.WriteLine();
    }

    /// <summary>
    /// Perform an inorder tree traversal starting from a given node
    /// </summary>
    /// <param name="knoten">The node to start from</param>
    private void Inorder(Knoten<T> knoten)
    {
        if (knoten != null)
        {
            Inorder(knoten.Left);
            Console.Write(knoten.Key.ToString() + ",");
            Inorder(knoten.Right);

        }
    }

    public int Size()
    {
        if (Root == null) return 0;
        return 1 + (Root.Left?.Count() ?? 0) + (Root.Right?.Count() ?? 0);
    }
    public virtual bool Search(T needle)
    {
        return Search(needle, Root);
    }

    private bool Search(T needle, Knoten<T> hayStack)
    {
        if (hayStack == null) { return false; }
        if (hayStack.Key.Equals(needle))
        {
            return true;
        }
        return Search(needle, hayStack.Left) || Search(needle, hayStack.Right);
    }
}