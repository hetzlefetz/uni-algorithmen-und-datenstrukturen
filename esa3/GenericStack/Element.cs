namespace GenericStack
{
  public class Element<T>
  {
    private readonly T _key;
    private readonly Element<T> _next;

    public Element(T item)
    {
      _key = item;
    }
    public Element(T item, Element<T> next)
    {
      _key = item;
      _next = next;
    }

    public T Key => _key;
    public Element<T> Next => _next;

    public override string ToString()
    {
      if(_next == null)
      {
        return Key.ToString();
      }
      else
      {
        return $"{Key},{Next}";
      }

    }
  }
}
