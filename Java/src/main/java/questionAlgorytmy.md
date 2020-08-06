## ALGORYTMY
#### Złożoność obliczeniowa algorytmu
ilość zasobów komputerowych potrzebnych do jego wykonania:
- Złożoność czasowa – to ilość czasu potrzebnego do wykonania zadania, wyrażona jako funkcja ilości danych.
- Złożoność pamięciowa – to ilość pamięci potrzebnej do wykonania zadania, wyrażona jako funkcja ilości danych.
Można wyróżnić:
- złożoność pesymistyczną O() - ilość zasobów potrzebnych do wykonania algorytmu przy założeniu najbardziej "złośliwych/najgorszych" danych,
- złożoność oczekiwaną Θ() - ilość zasobów potrzebnych do wykonania algorytmu przy założeniu "typowych" (statystycznie oczekiwanych) danych wejściowych,
- złożoność optymistyczną - ilość zasobów potrzebnych do wykonania algorytmu przy założeniu "najlepszych" danych. 


#### Problem diamentowy w JAVIE
Problem powstał w JAVA 8 i dotyczy wielodziedziczenia. Interfejsy w JAVA8 mogą posiadać domyślne implementacje. Jednocześnie można zaimplementować kilka interfejsów i przypadkowo podziedziczyć kilka implementacji funkcji o tej samej nazwie i parametrach np. boo(). Którą zatem wybrać? Można się odnieść bezpośrednio do konkretnej implementacji: ```Interface1.boo()```
```java
interface A {
    default void a() {
        System.out.println("A");
    }
}

interface B {
    default void a() {
        System.out.println("B");
    }
}
interface C extends A, B {

    @Override
    default void a() {
        A.super.a();
        B.super.a();
        System.out.println("C");
    }
}
```
#### Omów problem pięciu filozofów
#### Omów problem producenta i konsumenta
#### [ZADANIE] Napisz algorytm liczący silnię (bez rekurencji)
```java
int silnia(int level) {
    if (level < 0) {
        throw new RuntimeException("Level should not be negative.")
    }
    
    if (level == 0) {
        return 1;
    }
    
    int currentValue = 1;
    for (i = 2; i <= level; i++) {
        currentValue = currentValue * i;
    }
    
    return currentValue;
}
```

#### [ZADANIE] Napisz algorytm liczący n-ty element ciągu fibonacciego (bez rekurencji). (wartość elementu to suma dwóch poprzednich, gdzie: fib(0) = 1, fib(1) = 1, fib(2) = 1, fib(3) = 2, fib(4) = 3, ...
```javaScript
function fib(n) {
    if (n < 0) throw "argument should be 0 or higher, actual is " + n
    if (n == 0) return 0;
    if (n == 1) return 1;

    let prevPrevValue = 0, prevValue = 1, currentValue
    for (let i = 2; i <= n; i++) {
        currentValue = prevPrevValue + prevValue

        prevPrevValue = prevValue
        prevValue = currentValue
    }
    
    return currentValue
}
```

#### Sprawdź czy liczba jest potęgą 2
```javascript
function isPowerOf2(n) {
    for (i = 1; i<=n; i *=2) {
        if (n === i) return true
    }

	return false
}
```