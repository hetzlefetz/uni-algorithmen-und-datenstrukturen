namespace GenericStack
{
  interface IStapel<T>
  {
    T Top();
    T Pop();
    void Push(T item);
  }
}
