using System;

namespace GenericStack
{
  public class VerketteterStapel<T> : IStapel<T>
  {
    private Element<T> _head;
    public T Pop()
    {
      var ret = _head ?? throw new InvalidOperationException("Stack is empty"); ;
      _head = ret.Next;
      return ret.Key;
    }

    public void Push(T item)
    {
      if (_head == null)
      {
        _head = new Element<T>(item);
      }
      else
      {
        _head = new Element<T>(item, _head);
      }

    }

    public T Top()
    {
      if (_head == null)
      {
        throw new InvalidOperationException("Stack is empty");
      }
      return _head.Key;
    }
    public override string ToString()
    {
      if (_head == null)
      {
        return "[]";
      }
      return $"[{_head}]";
    }
  }
}
