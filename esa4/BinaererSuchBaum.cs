using System;

public class BinaererSuchBaum<T> : BinaererBaum<T> where T : IComparable<T>
{
    public void Insert(Knoten<T> knoten)
    {
        if (Root == null) { Root = knoten; return; }
        Root.Append(knoten, IComparableAppendStrategy);
    }

    public override bool Search(T needle)
    {
        return Search(needle, Root);
    }

    private bool Search(T needle, Knoten<T> hayStack)
    {
        if (hayStack == null) { return false; }
        if (hayStack.Key.CompareTo(needle) == 0)
        {
            return true;
        }
        if (hayStack.Key.CompareTo(needle) < 0)
        {
            return Search(needle, hayStack.Left);
        }
        return Search(needle, hayStack.Right);
    }

    public T MinElement()
    {
        if (Root == null)
        {
            throw new InvalidOperationException("Tree was empty!");
        }
        return MinElement(Root);
    }
    private T MinElement(Knoten<T> node)
    {
        if (node.Left == null) { return node.Key; }
        return MinElement(node.Left);
    }
    public T MaxElement()
    {
        if (Root == null)
        {
            throw new InvalidOperationException("Tree was empty!");
        }
        return MaxElement(Root);
    }
    private T MaxElement(Knoten<T> node)
    {
        if (node.Right == null) { return node.Key; }
        return MaxElement(node.Right);
    }
    private void IComparableAppendStrategy(Knoten<T> node, Knoten<T> newNode)
    {
        if (node.Key.CompareTo(newNode.Key) > 0)
        {
            if (node.Left == null)
            {
                node.Left = newNode;
                newNode.Previous = node;
                newNode.Right = null;
                newNode.Left = null;
            }
            else
            {
                node.Left.Append(newNode, IComparableAppendStrategy);
            }
        }
        else
        {
            if (node.Right == null)
            {
                node.Right = newNode;
                newNode.Previous = node;
                newNode.Right = null;
                newNode.Left = null;
            }
            else
            {
                node.Right.Append(newNode, IComparableAppendStrategy);
            }

        }
    }
}