using System;
using System.Linq;

namespace GenericStack
{
  class Program
  {
    private static IStapel<string> stapel;
    static void Main(string[] args)
    {
      stapel = new VerketteterStapel<string>();
      start();
    }
    static void start()
    {
      Console.WriteLine("Aktueller Stapel: " + stapel.ToString());
      Console.WriteLine("Was soll getan werden:");
      Console.WriteLine("(P)ush: Ein element hinzufügen");
      Console.WriteLine("(T)op: Das oberste element ausgeben");
      Console.WriteLine("P(o)p: Das oberste element vom stapel entnehmen ");
      switch (readChar(new[] { "p", "t", "o" }).ToLower())
      {
        case "p": push(); break;
        case "t": top(); break;
        case "o": pop(); break;
      }
    }

    static void push()
    {
      Console.WriteLine("Neues element eingeben:");
      stapel.Push(Console.ReadLine());
      start();
    }
    static void top()
    {
      try
      {
        Console.WriteLine("Das oberste element war: " + stapel.Top());
      }
      catch (InvalidOperationException e)
      {
        Console.WriteLine("Fehler beim holen des obersten elements: "+e.Message);
      }
      start();
    }
    static void pop()
    {
      try
      {
        Console.WriteLine("Das oberste element war: " + stapel.Pop());
      }
      catch (InvalidOperationException e)
      {
        Console.WriteLine("Fehler beim holen des obersten elements: " + e.Message);
      }
      start();
      start();
    }

    static string readChar(string[] validChars)
    {
      string c = "";
      while (!validChars.Contains(c))
      {
        Console.WriteLine($"Warte auf eingabe ({string.Join("/", validChars)}):");
        c = Console.ReadLine().ToLower().First().ToString();
      }
      return c;
    }
  }
}
