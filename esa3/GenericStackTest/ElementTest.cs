using GenericStack;
using NUnit.Framework;

namespace GenericStackTest
{
  public class Tests
  {
    

    [Test]
    public void EnsureToStringReturnsWithoutNext()
    {
      var x = new Element<string>("foo");

      Assert.AreEqual("foo", x.ToString());
    }
    [Test]
    public void EnsureToStringReturnsWithNext()
    {
      var x = new Element<string>("foo");
      var y = new Element<string>("bar", x);
      Assert.AreEqual("bar,foo", y.ToString());
    }
    [Test]
    public void EnsureToStringReturnsWithNextAndNext()
    {
      var x = new Element<string>("foo");
      var y = new Element<string>("bar", x);
      var z = new Element<string>("baz", y);
      Assert.AreEqual("baz,bar,foo", z.ToString());
    }
  }
}