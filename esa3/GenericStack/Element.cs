using System;

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
            if (_next == null)
            {
                return Key.ToString();
            }
            else
            {
                return $"{Key},{Next}";
            }
        }
        public override int GetHashCode()
        {
            return HashCode.Combine(Key, Next);
        }
        public override bool Equals(object obj)
        {
            if (obj == null) return false;
            var tmp = obj as Element<T>;
            if (tmp == null) return false;
            if (Next == null && tmp.Next != null || Next != null && tmp.Next == null)
            {
                return false;
            }
            if (Next != null && tmp.Next != null)
            {
                return Key.Equals(tmp.Key) && Next.Equals(tmp);
            }
            else
            {
                return Key.Equals(tmp.Key);
            }
        }
    }
}
