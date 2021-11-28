# ESA 3

## Vorraussetzungen

Um das Programm ausführen zu können wird das netcore3.1 sdk benötigt, welches hier gefunden werden kann:

- Win: https://dotnet.microsoft.com/download/dotnet/thank-you/sdk-3.1.415-linux-x64-binaries
- Linux: https://dotnet.microsoft.com/download/dotnet/thank-you/sdk-3.1.415-windows-x64-installer
- Mac: https://dotnet.microsoft.com/download/dotnet/thank-you/sdk-3.1.415-macos-x64-installer

## Programm ausführen

Um das demo Programm auszführen bitte folgendes Kommando im Basisordner ausführen:
`ddotnet test .\GenericStackTest\GenericStackTest.csproj`

Um die Testsuite auzuführen bitte folgendes Kommando ausführen:
`dotnet test .\GenericStackTest\GenericStackTest.csproj`

## Zeitkomplexität

### Pop()

Die Zeitkomplexität der Pop() Methode beträgt O(1), da sie einen einfaches umspeichern des Pointers im \_head Member auf den Next darstellt

### Push()

Die Zeitkomplexität der Push() Methode beträgt O(1), da sie einen einfachen Aufruf auf den \_head Member darstellt

### Top()

Die Zeitkomplexität der Top() Methode beträgt O(1), da sie einen einfachen Aufruf auf den \_head Member darstellt

### ToString()

Die Zeitkomplexität der ToString() Methode beträgt O(n), sie skaliert mit der "höhe" Stacks, da die Methode auf jedem Element einmal aufgerufen wird.
