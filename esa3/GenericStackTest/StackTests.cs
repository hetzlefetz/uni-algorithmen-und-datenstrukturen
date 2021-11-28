

using GenericStack;
using NUnit.Framework;
using System;

namespace GenericStackTest
{
  class StackTests
  {
    [Test]
    public void CanPush()
    {
      var s = new VerketteterStapel<string>();

      s.Push("Foo");

      Assert.AreEqual("[Foo]",s.ToString());
    }
    [Test]
    public void CanPushMultiple()
    {
      var s = new VerketteterStapel<string>();

      s.Push("Foo");
      s.Push("Bar");

      Assert.AreEqual("[Bar,Foo]", s.ToString());

    }
    [Test]
    public void CanPop()
    {
      var val = "Foo";
      var s = new VerketteterStapel<string>();
      s.Push(val);

      var ret = s.Pop();

      Assert.AreEqual(val, ret);

    }
    [Test]
    public void CantPopEmpty()
    {
      var s = new VerketteterStapel<string>();

      Assert.Throws(typeof(InvalidOperationException), () => s.Pop());

    }
    [Test]
    public void CanTop()
    {
      var val = "Foo";
      var s = new VerketteterStapel<string>();
      s.Push(val);

      var ret = s.Top();

      Assert.AreEqual(val, ret);
      Assert.AreEqual("[Foo]", s.ToString());
    }
    [Test]
    public void CantTopEmpty()
    {
      var s = new VerketteterStapel<string>();

      Assert.Throws(typeof(InvalidOperationException), () => s.Top());

    }
    [Test]
    public void TestToStringWithEmpty()
    {
      var s = new VerketteterStapel<string>();
      Assert.AreEqual("[]", s.ToString());
    }
  }
}
