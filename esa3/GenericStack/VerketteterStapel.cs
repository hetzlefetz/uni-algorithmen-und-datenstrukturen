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
        public Element<T> Head => _head;
        public override string ToString()
        {
            if (_head == null)
            {
                //Fall leerer stapel
                return "[]";
            }
            //Stapel wirdd geprinted in dem er sein oberstes element printet
            return $"[{_head}]";
        }
        public override int GetHashCode()
        {
            return HashCode.Combine(_head);
        }

        public override bool Equals(object obj)
        {
            if (obj == null) return false;    //Das andere Objekt war null

            // Besonderheit von C#: der as Operator ist eine sichere Typumwandlung, und gibt wenn nicht umwandelbar null zurück
            var tmp = obj as VerketteterStapel<T>;
            if (tmp == null) return false;
            if (_head == null && tmp.Head != null || _head != null && tmp.Head == null)
            {
                // Die stapel unterscheiden sich im Head Element
                return false;
            }
            if (_head == null && tmp.Head == null)
            {
                // Die Stapel haben kein head element ... Hier falle ich auf referenzielle gleichheit zurück 
                return ReferenceEquals(this, obj);
            }
            // Vergleiche das head element (welches auch Equals überlädt)
            return _head.Equals(tmp.Head);
        }
    }
}
