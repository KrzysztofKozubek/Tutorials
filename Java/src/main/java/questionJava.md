# PYTANIA
## JAVA 
#### Co to jest JVM?
Java Virtual Machine. Środowisko uruchomieniowe dla języka JAVA. Interpretuje JAVA Bytecode - język pośredni będący wynikiem kompilacji kodu JAVA.

Więcej: https://bottega.com.pl/pdf/materialy/jvm/jvm1.pdf

### Jakie są różnice pomiędzy JDK, JRE oraz JVM
JDK (Java Development Kit) tłum. Pakiet Programisty Javy. JDK  zawiera Środowisko Uruchomieniowe Javy (tzn. JRE) oraz 
zestaw narzędzi niezbędnych do tworzenia oraz kompilowania oprogramowania tworzonego w języku JAVA. (Narzędzie dla developerów)

JRE (Java Runtime Environment), tłum. Środowisko Uruchomieniowe Javy. W skład JRE wchodzi Wirtualna Maszyna Javy (JVM) a także 
zbiór klas oraz narzędzi wymaganych do uruchomienia aplikacji tworzonych w języku JAVA. (Narzędzie dla klientów którzy chcą uruchomić APK)

JVM (Java Virtual Machine), tłum. Wirtualna Maszyna Javy. Jest to maszyna wirtualna oraz środowisko zdolne do 
wykonywania skompilowanego kodu aplikacji napisanej w języku Java (kod bajtowy Javy).

#### Co to jest Garbage Collector?
Wyróżniamy dwa typy algorytmów GC: 
- skalarne
- wektorowe

W Java, GC bierze 5/8 procka

**Skalarne**: (PHP, C++, Python)
prosty algo do zliczające ref
- patrzymy ile obiektów wskazuje na obiekt
- ref > 1, ktoś korzysta
- ref == 0, można usuniać

wady:
- podczas wystapienia cyklu (sytuacja gdy 1 obiekt wskazuje na 2 i wice wersa) pamieć nie zostanie zwolniona
- moga powstac wyspy obiektow

zalety:
- prostota

**Wektorowe**
obiekty w pamieci sa mapowane na graf encji

algo działania:
- znajduje ele rootowe (miejsce gdzie ma zacząć analize usuwania obiektów)
- markuje wszystkie obiekty które są widoczne bezpośrenio lub pośrednio od obiektu root (w tym ele root) jako żywe
- obiekty nieposiadające zamarkowania jako żywe zostają usunięte

Przez fakt że obiekty często są tworzone i uswane mogło by dojść do sytuacji gdzie mimo 10MB wolnego miejsca w pamięci nie jesteśmy w stanie stworzyć obiektu 3MB

![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#c5f015](https://placehold.it/15/c5f015/000000?text=+)

Z powodu takich jak: 
- większosć obiektów szybko staje się nieużyteczna z punktu widzenia aplikacji,
- odwołania starych obiektów do nowych są bardzo rzadkie.

pamięć (sterta = heap) została podzielona na: Young(Eden, Survivor0, Survivor1), Old. 
Pozwoloło to na trzy rodzaje metod sprzątania: 
- mino collection GC, young
- mijor collection GC, old
- full collection gc, all heap

alorytmy kolekcji:
- `Serial`, następuje stop the World a GC 1 wątkiem sprząta pamięć
- `Parallel`, następuje stop the World a GC wieloma wątkiem sprząta pamięć
- `Concurrnet`, GC sprząta w trakcie działania programu
- `Incremental`, GC wielowątkowy, sprząta częściej w mniejszym zakresie

algorytmy kolekcji:
- kopiujacy

|zachowanie |Young      |S0        |S1        |
|-----------|-----------|----------|----------|
|zapełniamy younga |![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) |![#1589F0](https://placehold.it/15/1589F0/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) | ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) |
|uruchamiamy GC (sprawdzamy które obiekty są nieużywane)|![#7d990c](https://placehold.it/15/7d990c/000000?text=+) ![#7d990c](https://placehold.it/15/7d990c/000000?text=+) ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#7d990c](https://placehold.it/15/7d990c/000000?text=+) ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#7d990c](https://placehold.it/15/7d990c/000000?text=+) | ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) | ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) |
|kopiujemy obiekty z Young do S0|![#1589F0](https://placehold.it/15/1589F0/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) | ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) | ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) |
|zapełniamy younga|![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) | ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) | ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) |
|uruchamiamy GC|![#7d990c](https://placehold.it/15/7d990c/000000?text=+) ![#7d990c](https://placehold.it/15/7d990c/000000?text=+) ![#7d990c](https://placehold.it/15/7d990c/000000?text=+) ![#7d990c](https://placehold.it/15/7d990c/000000?text=+) ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) | ![#7d990c](https://placehold.it/15/7d990c/000000?text=+) ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) | ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) |
|kopiujemy obiekty o pamięć z starszą generacją|![#1589F0](https://placehold.it/15/1589F0/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) | ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) | ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) |


- serial:
    w mlodej generacji dzialal przez kopiowanie obiektow (kopiowanie z young to s0, s1)
    w starej generacji MarkSweepCompact
- throughtput collection:
    young kopuijacy (na wielu watkach)
    old MarkSweepCompact (na wielu watkach)
- cms:
    mniej wydajny lecz minimalizuje pauzy GC
    young kopiujacy
    old praca rownolegla z apk
- g1:
    wspolbierznie
    young kopiujacy
    old kopiujacy (old zostal podzielony na male kawalki)
    1. stop apk  (znalezienie rootow | klas loader systemowy)
    
Więcej: https://bottega.com.pl/pdf/materialy/jvm/jvm2.pdf

#### Reprezentacja obiektu
Layout obiektu:
```text
Obiekt sklada sie z {
    naglowka (mark header)      = 4 bytes
    ref na klase (np. String)   = 8 bytes
}
```
Wielkosci obiektow:
- `shallow` (plytki rozmiar obiektu)
- `deep` (ile wazy obiekt + jego dzieci)
- `retained` (ile pamieci zwolnimy gdy usuniemy ten obiekt)

#### Layout Memory JVM:
HEAP | OFFHEAP (pamiec zarzadzana natywnie)
```text
HEAP {
    Young (mloda generacja) {
        eden
        0 przestrzen przetwarnikowa (survivor)
        1 przestrzen przetwarnikowa
    }
    Old (stara generacja)

    obiekty stworzone zostaja wrzucone do young a po jakims czasie
    (o ile nie zostana usuniete)
    wrzucane sa do old'a
}
OFFHEAP {
    zawiera obiekty potrzebne VM do dzialania

    Metaspace (nowe klasy laduja tutaj || np. wszystkie proxy do obiektow)
    CodeCache (JIT | przyspiesza 20x) 
    (przepełnienie może spowodować że nasz kod już nigdy nie zostanie skompilowany 
    po deoptymalizacji nasz kod zwalnia)
}
```

### Zaleta używania typów prostych
+ GC będzie miał mniej pracy (przejścia po referecjach = krótszy stop the World)
+ mniej pamieci potrzebuja

#### Jakie rzeczy są zapisywane na stercie, a jakie na stosie?
- STOS (Stack) - typy proste, wskaźniki do obiektów, wskaźniki powrotu z funkcji (jedna na wątek).
- STERTA (Heap) - Obiekty i typy złożone

#### Jakie znasz typy w JAVIE
**TYPY PROSTE**

| typ     | wielkość | opis                        |
| ------- | -------- | --------------------------- |
| boolean | 1 bit    | wartość logiczna            |
| byte    | 8 bit    | liczba całkowita ze znakiem |
| short   | 16 bit   | liczba całkowita ze znakiem |
| int     | 32 bit   | liczba całkowita ze znakiem |
| long    | 64 bit   | liczba całkowita ze znakiem |
| float   | 32 bit   | liczba zmiennoprzecinkowa   |
| double  | 64 bit   | liczba zmiennoprzecinkowa   |
| char    | 16 bit   | litera                      |

#### Operacje na bitach 
```java

/* Format write value */
String binaryNumber = "101001101";
Integer.parseInt(binaryNumber, 2));

10                  /* decimal */
0b00001010          /* binary */
012                 /* octal */
0xA                 /* hexadecimal */

/* Byte operation */
0b0101 & 0b0011     /* 0b0001 = 1 */
0b0101 | 0b0011     /* 0b0111 = 7 */
0b0101 ^ 0b0011     /* 0b0110 = 6 */
~0b0101             /* 0b1010 = -6 */
0b0101 << 2         /* 0b010100 = 20 */
0b0101 >> 2         /* 0b01 = 1 */
       
```

#### Omów typy BigDecimal / BigInteger. Po co się je stosuje?
- BigDecimal - liczby zmiennoprzecinkowe. 
- BigInteger - liczby całkowite

#### Czym są Unboxing i autoboxing w JAVIE?
Każdy typ prosty ma swój odpowiednik jako typ obiektowy w JAVIE, np. ```int => Integer```.

- **Boxing** - pakowanie obiektu do typu obiektowego
```java
int someInteger = 1234;
Integer boxedInteger = Integer.valueOf(someInteger);
```
- **Autoboxing** - Automatyczne opakowanie typu przez kompilator:
```java
int someInteger = 1234;
Integer boxedInteger = someInteger;
```
- **Unboxing** - Odpakowanie typu obiektowego
```java
Integer boxedInteger = Integer.valueOf(someInteger);
int integer = (int)boxedInteger;
```

### Metody klasy java.lang.Object
* clone (dostępny po implementacji Cloneable)
* equals (porównuje referencje)
```java
public boolean equals(Object obj) {
    return (this == obj);
}
```
* finalize (metoda wykonywana przed zabiciem obiektu)
* hashcode (wyliczenie hash kodu z referencji)
* notify (wybudzenie obiektu)
* notifyAll (wybudzenie wszystkich obiektów)
* wait (oczekiwanie)
* toString
```java
public String toString() {
    return getClass().getName() + "@" + Integer.toHexString(hashCode());
}
```

#### Co to jest serializacja
Serializacja to zamiana obiektów, np. w strumień bajtów z zachowaniem ich aktualnego stanu

#### Co to jest refleksja
Mechanizm refleksji polega na modyfikowaniu kodu aplikacji podczas jej działania.
Dzięki refleksji można zarządzać kodem programu prawie tak łatwo, jakby to były zwykłe dane.     	

#### Co to jest enum
Enum to typ wyliczeniowy, czyli pewna struktura danych zawierająca listę wszystkich wartości, jakie może przyjąć ten typ. 
Typy wyliczeniowe wykorzystywane są bardzo często jako swego rodzaju stałe.

#### Czy klasa może dziedziczyć po kilku interfejsach
Klasy nie dziedziczą po interfejsach, a je implementują. Jedna klasa może implementować wiele interfejsów
Jeden interfejs może dziedziczyć po kilku innych.

#### Jak wywołać metodę w klasie podrzędnej z klasy nadrzędnej
słowem kluczowym: `super`

#### Czym się różni lista (List) od zbioru (Set)
Lista `(java.util.List)` reprezentuje uporządkowaną listę elementów i może zawierać duplikaty.
Zbiór `(java.util.Set)` reprezentuje zbiór unikatowych elementów, natomiast przechowywana kolejność jest zależna od konkretnej implementacji zbioru.

#### Omów typy: String, StringBuilder, StringBuffer
String - łańcuch znaków. Jest obiektem **Immutable** (niezmienialnym). <br/>
java.lang.String został tak zaprojektowany z kilku powodów: 
- Bezpieczeństwem (nazwy użytkowników, hasła)
- Synchronizacja 
- Zarządzanie Pamięcią (dwa obiekty typu String posiadają tą samą wartość - optymalizacja)

Dodawanie łańcuchów podczas konkatenacji za każdym razem tworzy nowy obiekt.
Aby dodawać do siebie wiele String'ów używamy klasy:
- ```StringBuilder``` jest szybszy.
- ```StringBuffer``` ma wszystkie metody **synchronized**, jest thread safe

#### Czym charakteryzują się obiekty Immutable? 
Nie zmieniają swojego stanu po utworzeniu. W celu zmienienia go, tworzy się nowy na jego podstawie.
Przykład: klasa String, DataTime

**ZALETY**: 
- Po utworzeniu obiektu możemy być pewni, że nie zmieni on swojego stanu. Możemy np. przekazać go innej metodzie bez obaw. 
- Każda zmiana obiektu Immutable powoduje utworzenie nowego obiektu. 
- Dzięki tym cechom są bezpieczniejsze w programowaniu wielowątkowym, kiedy wiele wątków może na raz utworzonym obiekcie pracować jednocześnie. 

#### Jak pobrać pojedynczy znak z obiektu String
uzywajac metody `charAt` | `substring` | `toCharArray()[]`

#### Jak działa metoda Substring() w klasie String?
````java
public String substring(int beginIndex, int endIndex) {
     if (beginIndex < 0) {
         throw new StringIndexOutOfBoundsException(beginIndex);
     }
     if (endIndex > value.length) {
         throw new StringIndexOutOfBoundsException(endIndex);
     }
     int subLen = endIndex - beginIndex;
     if (subLen < 0) {
         throw new StringIndexOutOfBoundsException(subLen);
     }
     return ((beginIndex == 0) && (endIndex == value.length)) ? this
             : new String(value, beginIndex, subLen);
}
````

#### Omów jakie znasz klasyfikatory dostępu w JAVIE (są 4)
Dotyczą **pól / klas / metod**:

| klasyfikator             | opis                                       |
| ------------------------ | ------------------------------------------ |
| public                   | dostęp publiczny                           |
| protected                | dostęp tylko z poziomu klas dziedziczących |
| default = private package| dostęp z obrębu pakietu                    |
| private                  | dostęp tylko z tej samej klasy             |

## PORÓWNYWANIE OBIEKTÓW
#### Jak porównywane są obiekty w JAVIE, z jakich metod korzystają. 
- ```obj1 == obj2``` - porównuje referencje
- ```boolean result = obj1.equals(obj2)``` porównuje zawartość obiektów

Metodę ```.equals()``` należy zaimplementować (albo użyć do tego biblioteki). 

#### Do czego służy metoda hashCode() ?
Metodę ```int hashCode()``` można zaimplementować.

Zwraca ona liczbę ```int``` specyficzną dla każdego obiektu. 

### Kontrakt między equals i hashCode
Konrakt mówi, że:
Kolejne wywołania hashCode muszą zwracać ten sam wynik.
- Jeżeli obiekty są ```równe```, wg metody ```equals```, ich ```hashCode``` również musi być ```równy```.
- Jeżeli obiekty są ```różne```, to ich hashCode może być ```równy```.
- Relacja wyznaczona metodą equals musi być ```zwrotna``` | ```x!=null x.equals(x) = true```.
- Relacja wyznaczona metodą equals musi być ```symetryczna``` | ```x.equals(y) = y.equals(x)```.
- Relacja wyznaczona metodą equals musi być ```przechodnia``` | ```x.equals(y) & y.equals(z) => z.equals(x)```.
- Relacja wyznaczona metodą equals musi być ```spójna``` | ```x.equals(x) = true```.

Każdy obiekt jest różny od null, czyli wywołanie ```x.equals(null)``` dla obiektu x różnego od null, zawsze musi zwrócić false.
	
#### Omów interfejsy Comparable i Comparator.
| Comparable                        | Comparator                        |
|-----------------------------------|-----------------------------------|
|java.lang                          |java.util                          |
|compareTo & equals                 |compareTo                          |
|sortuje obiekty tego samego typu   |może sortować obiekty różnego typu |

Obie metody pozwalają porównywać obiekty. 
Metody zwracają typ ```int``` o wartościach: 
- ```-1```: mniejszy 
- ```0```: równy 
- ```1```: większy

PRZYKŁADY:
- Interfejs ```Comparable```:  ```obj1.compareTo(obj2)```
- Interfejs ```Comparator```:  ```comparatorInstance.compare(obj1, obj2)```

#### Co oznacza słowo kluczowe final
```java
final class A { nie można dzinedziczyć (extends)
    final void method(){} nie mozna nadpisać (override)
    final Object a; nie można modyfikować 
} 
```

## KOLEKCJE
#### Jakie znasz kolekcje w JAVA. Podstawowy podział
<img src="https://fresh2refresh.com/wp-content/uploads/2013/08/Java-Framework.png"/>

#### Iterator
Iterator jest to interfejs który udostępnia metody potrzebne do iterowania poprzez każdą z kolekcji. 
Dzięki Iteratorowi możemy przeprowadzać takie operacje jak odczyt oraz usunięcie.

#### Czym różni się ArrayList od LinkedList?
Sposobem implementacji. 
- **ArayList** - przechowuje elementy w tablicy
    - zaletą jest dostęp O(1)
    - wadą jest zmiana rozmiaru (ponosimy koszty zmiany rozmiaru tablicy + przepisywanie elementów)
- **LinkedList** w każdym elemencie posiada wskaźnik do następnego elementu
    - zaletą jest tanie dodawanie elementu w dowolnym miejscu
    - wadą jest przeszukiwanie elementów

#### Czym różni się HashSet od TreeSet? 
- HashSet 
  - nie gwarantuje kolejności wstawiania
  - może przechowywać obiekty o wartości ```null```
  - gwarantuje szybkość działania ```O(1)```, gdzie ```TreeSet```, tylko ```log(n)```
  
#### Wyjaśnij jak działa HashMap.
```HashMap``` przechowuje dane w postaciach: klucz-wartość. 
Podczas zapisu ```map.put(key, value)``` implementacja HashMap wywołuje ```.hashCode()``` na kluczu ```key``` i wykorzystując ten hashcode znajduje indeks pod którym zapisany będzie obiekt(```Entry<key, value>```) w wewnętrznym Array'u. Każdy wpis (Entry) przechowuje zarówno klucz jak i wartość. 

Wiele kluczy może zwrócić ten sam **hashcode** - stąd pod danym indeksem może być wiele zapisanych obiektów. Dana sytuacja nazywa się kolizją. A obiekty w tej sytuacji zapisywane są w strukturze ```LinkedList<Entry>``` w danym *buckecie*.

Podczas pobierania zasobu z ```map.get(key)```, znowu liczony jest hashcode, wybierany bucket. Jeśli nie ma kolizji - zwracany jest obiekt. Jeśli jest kolizja, wyszukiwany jest odpowiedni wpis na liście (korzystając z metody ```.equals()```).
Zapewnia to osiągnięcie złożoności obliczeniowej przy pobieraniu obiektu: ```O(1)```.

Parametry: 
```java
DEFAULT_INITIAL_CAPACITY = 16 <- ilość bucketów
DEFAULT_LOAD_FACTOR = 0.75f   <- zapełnienie powodujące dodanie bucketów (* 2)

```

### Różnica pomiędzy interfejsami Iterator oraz ListIterator
- ListIterator pozwala na przeszukiwanie listy w obie strony
- ListIterator może być używany tylko do List. 
- Ponadto ListIterator pozwala również na dodawanie elementów, oraz zmianę ich wartości

### Różnica pomiędzy HashMap i Hashtable?
- Hashtable jest zsynchronizowane
- Hashtable nie zezwala na używanie wartości null jako klucza i wartości
- HashMap do Iteracji poprzez wartości obiektów wykorzystuje Iterator, natomiast Hashtable enumerator
- HashMap jest dużo szybszy niż Hashtable

<B>Warto zwrócić uwagę że Hashtable może być również zastąpiony przy pomocy ```ConcurrentHashMap```<B>

## WYJĄTKI
#### Omów podstawowe klasy wyjątków i ich hierarchię
Podstawowy podział:
<img src="https://www.tutorialspoint.com/java/images/exceptions1.jpg">

#### Czym różni się **Exception** od **Error**? 
- Error zwykle nie zależy od programisty. Sygnalizuje awarię, której programista nie może / nie powinien obsługiwać w kodzie jak: **StackOverflowError**, czy **OutOfMemoryError**. 
- Exception'y - mogą / powinny być obsługiwane przez programistę.

#### Co to są wyjątki "checked" i "unchecked" ?
- **checked** - wyjątki sprawdzane w trakcie kompilacji. Program się nie skompiluje bez ich obsłużenia lub zadeklarowania.
- **unchecked** - nie są sprawdzane w trakcie kompilacji.

#### Czym różni się **RuntimeException** od **IOException**? 
1. Źródłem 2. pierwsze jest unchecked, drugie checked.

## TYPY GENERYCZNE
#### Co to są typy generyczne? Omów je
dodane do Javy 1.5, umożliwiające parametryzowanie klasy metody oraz interfejsu
Przykład:
```java
class LinkedList<E> {
    Node<E> first;

    public LinkedList(){}

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
```
`T` może reprezentować wszystko, co nie jest prymitywem. 
Możemy dowolnie wybrać nazwę parametru. 
Warto jednak pamiętać, że istnieje pewna konwencja nazewnictwa i tak: 
`E — Element`, `K — Key`, `N — Number`, `T — Type`, `V — Value`, `S`,`U`,`V` etc. — drugi, trzeci, czwarty parametr).

```java
class Foo {
    static <T> T foo1 (T a, Class<T> s) {
        return a;
    }
    static <T extends Number> T foo2 (T a, Class<T> s) {
        return a;
    }
    public static void main(String[] args) {
        Foo.<String>foo1("Test", String.class);
        Foo.<Integer>foo2(123, Integer.class);
    }
}

```

Ograniczenie typu generycznego:
```java
interface A {}
interface B extends A {}
interface C {}
interface Y extends B, C {}
class D<T extends B & C> {} 
//correct: new D<Y>()
//incorrect: new D<A>()
```
Generyki podczas kompilacji są usuwane i zmienieane na typ `Object`, spodowowane to było koniecznością kompatybilności z poprzednimi wersjami.

https://docs.oracle.com/javase/tutorial/extra/generics/morefun.html

#### Wyrażenie lambda
Dla uproszczenia można powiedzieć, że wyrażenie lambda jest metodą1. Metodą, którą możesz przypisać do zmiennej. Możesz ją także wywołać czy przekazać jako argument do innej metody.
Na przykład wyrażenie lambda, które podnosi do kwadratu przekazaną liczbę wygląda następująco:

```java
x -> x * x
```
Wyrażenie lambda ma następującą składnię
```java
<lista parametrów> -> <ciało wyrażenia>
```
Jest to instancja dowolnego interfejsu funkcyjnego.

## Functional interfaces
to interfejs posiadający 1 abstrakcyjną metodę. Oznacza się interfejsem `@FunctionalInterface`.
Wiekszość tych interfejsów znajduje się w pakiecie `java.util.function`:
- `Function<T, R>` przyjmuje `T` i zwraca `R` metodą `apply()`
- `Consumer<T>` 
- `Predicate<T>` przyjmuje `T` i zwraca flagę metodą `test()`
- `Supplier<T>` nie przymuje i zwraca `T` metodą `get()`
- `UnaryOperatot<T>` przyjmuje i zwraca `T`

#### Stream
wprowadzenie przez java do programowania funkcyjnego. Służą do przetwarzania danych. Zawierają dane i pozwalają na opisanie co chcesz zrobić tymi danymi.
Strumienie wykorzystują wzorzec łączenie metod (method chaining), zwanym także płynnym interfejsce, (fluent interface)
Strumienie możemy podzielić na trzy typy:
- tworzenia strumienia
- przetwarzania danych wew strumienia
- zakończenie strumienia

## WĄTKI
#### Co to są wątki? Co to są procesy?
PROCESY:
- System operacyjny udostępnia aplikacjom procesy, które "opakowują" zasoby dostępne dla danej aplikacji, te zasoby to: 
  - Wątki (ciąg instrukcji procesora)
  - Pamięć operacyjna
  - Uchwyty do plików
  - połączenia HTTP (port), urządzenia wejścia/wyjścia, itp.
- Proces zawsze posiada conajmniej jeden wątek.
- Każdy proces może mieć podprocesy
  - **proces-rodzic** ma dostęp do wszystkich zasobów swoich podprocesów
  - **podproces** ma dostęp tylko do swoich zasobów

WĄTKI:
- Jeden wątek -> Jeden ciąg instrukcji procesora
- Są Najmniejszą sekwencją instrukcji możliwą do zarządzania przez ```Scheduler``` systemu operacyjnego.
- Jednocześnie jeden rdzeń procesora może obsługiwać wiele wątków, lecz nie w tym samym czasie (sytem operacyjny przydziela ułamek czasu
procesora na każdy z nich).
- Wszystkie wątki dzielą jedną pamięć w ramach tego samego procesu. Dlatego są łatwiejsze/szybsze
do utworzenia / zamknięcia, niż procesy.

#### Programowanie współbieżne
Pozwala na podzielenie programu na oddzielne, wykonywane niezależnie zadania. 
W modelu wielowątkowości każde z tych niezależnych zadań posiada własny wątek wykonywania.

#### słowo kluczowe volatile
volatile sprawia iż dana wartość będzie zapisana w danej pamięci tak szybko jak to, możliwe.
jest to informacja dla Java żeby danej zmiennej nie optymalizować.

#### Jak utworzyć wątek? Jak go zatrzymać? 
https://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/
https://winterbe.com/posts/2015/04/30/java8-concurrency-tutorial-synchronized-locks-examples/
```java
Example 1:
Runnable task = () -> {
    String threadName = Thread.currentThread().getName();
};
task.run(); // nie tworzy nowego wątku
new Thread(task).start();

Example 2:
ExecutorService executor = Executors.newSingleThreadExecutor(); // newFixedThreadPool(int)
executor.submit(() -> {
    String threadName = Thread.currentThread().getName();
});

Example 3:
// task impl interface Callable
Future<Integer> future = executor.submit(task);
Integer result = future.get();

Remember about shutdown executor
```

#### Jak synchronizować wątki? Omów słowo kluczowe **synchronized**

```java
Runnable r = () -> {
    Thread.currentThread().setPriority(Thread.MAX_PRIORITY); <- ustawienie priorytetu wątka
    // ... complicated operation
    Thread.yield(); <- sugestia do wykonywania przez wątek innego zadania
    thread2.join(); <- oczekiwanie na zakończenie pracy wątku thread2
}
```

#### Jak złapać wyjątek w innym wątku
```java
final AtomicReference<Exception> exception = new AtomicReference<Exception>();
Thread thread = library.someMethod(new Runnable() {
   public void run() {
      try {
         throw new NullPointerException();
      } catch (Exception e) {
         exception.set(e);
      }
   }
});

thread.join();
if (exception.get() != null) {
   throw exception.get();
}
```

#### Jak działają metody **wait()**, **notify()**, **notifyAll()**
Metody możliwe do wykonania na obiekcie
- wait() - zatrzymuje wątek w danym miejscu (celem synchronizacji)
- notify() - uruchamia zatrzymany wątek.
- notifyAll() - uruchamia wszystkie zatrzymane wątki

Metody statyczne klasy Thread
- sleep(int) - usypia wątek
- interrupt() - wybudza

````java
synchronized (o) {
    Thread.sleep(1000); <- wstrzymuje wykonywanie bloku
    o.wait(millis); <- oczekuje na synchronizacje
}
````

#### Jak działa parallel() na stream
Działa na pool ForkJoinPool (dziel i zwyciężaj)
```java
// Simple version 
IntStream.range(1, 1_000)
        .parallel()
        .boxed()
        .collect(Collectors.toList())

// Version with set number of thread pool
final int parallelism = 50;
ForkJoinPool forkJoinPool = null;
try {
    forkJoinPool = new ForkJoinPool(parallelism);
    final List<Integer> primes = forkJoinPool.submit(() ->
            IntStream.range(1, 1_000)
                    .parallel()
                    .boxed()
                    .collect(Collectors.toList())
    ).get();
    
    
    System.out.println(primes);
} catch (InterruptedException | ExecutionException e) {
    throw new RuntimeException(e);
} finally {
    if (forkJoinPool != null) {
        forkJoinPool.shutdown();
    }
}
```

#### ForkJoinPool
Pula ta służy do realizacji zadań, które da się podzielić. Do podziału problemów stosuje ona algorytm dziel i zwyciężaj, a te podzielone zadania przydzielane są dzięki wykorzystaniu algorytmu Work-Stealing.
Jeśli mamy podzielone zadania, trafiają one na kolejkę. Teraz obsługą tych zadań zajmuje się algorytm Work-Stealing, który przydziela zadania wątkom aktualnie bezrobotnym. Kradną więc one pracę innym wątkom:

Pulę tę możemy tworzyć sami poprzez:
```java
ForkJoinPool pool = new ForkJoinPool(parallelism);

// Task which return result
class Task extends RecursiveTask<Integer> {
    protected Integer compute() {
        return null;
    }
}

// Task which do not return result
class Task extends RecursiveAction {
    protected void compute() {
    }
}

//Example:
class Sum extends RecursiveTask<Long> {

    private final int[] numbersToSum;
    private int low;
    private int high;

    Sum(int[] numbersToSum) {
        this.numbersToSum = numbersToSum;
        this.high = numbersToSum.length;
    }

    private Sum(int[] numbersToSum, int low, int high) {
        this.numbersToSum = numbersToSum;
        this.low = low;
        this.high = high;
    }

    private boolean isSimple() {
        return (high - low) <= 1;
    }

    protected Long compute() {
        if (isSimple()) {
            return (long) numbersToSum[high] + numbersToSum[low];
        }

        int mid = low + (high - low) / 2;
        Sum left = new Sum(numbersToSum, low, mid);
        Sum right = new Sum(numbersToSum, mid, high);

        left.fork();
        System.out.println(Thread.currentThread().getName());
        return right.compute() + left.join();
    }
}

```
## OOP
#### Co to jest polimorfizm?
Jest koncepcją gdzie zachowanie obiektu jest różne w zależności od danej sytuacji.
Dzielimy go na: 
- w czasie rzeczywistym (runtime) | wybieranie metody miedzy klasami (przy dziedziczeniu)
- podczas kompilacji (compile time) | wybór miedzy metodami przeładowanymi

```java
void main () {}
void main (String s) {}
void main (String[] args) {}
polymorphism compile time occurs when we overloading method
(multiple implementation with different argument)
    
    
private List<String> list;
void init() {
    if (new Random().nextBoolean()) {
        list = new ArrayList<>();
    } else {
        list = new LinkedList<>();
    }
}
during compilation we don't know what we used
```

#### Co to jest dziedziczenie?
Dodanie funkcjonalności do klasy poprzez jej **rozszerzanie / nadpisanie**.<BR>
Zalety:
- używanie napisanego kodu
- rozszerzenie klasy z nowa funkcjonalnością
- łatwe dodawanie nowych funkcjonalności

Wady
- utrudnia pisanie testów jednostkowych
- trudniejsze debagowanie

#### Po co stosować enkapsulację?
Aby ograniczyć powiązania w aplikacji do minimum. Ułatwia to późniejsze utrzymanie kodu.

Access Levels

|Modifier    |Class	 |Package  |Subclass   |World|
|------------|-------|---------|-----------|-----|
|public	     |Y	     |Y        |Y          |Y    |
|protected	 |Y	     |Y        |Y          |N    |
|no modifier |Y	     |Y        |N          |N    |
|private	 |Y	     |N        |N          |N    |

#### Jakie są różnice pomiędzy throw oraz throws
- `throw` sluzy do wyrzucania wyjatkow ```new throw(new RunTimeException)```
- `trowhs` informuje ze dana metoda moze wyrzucic wyjatki ```void method() throws Exception```

#### Jakie są różnice pomiędzy final, finally oraz finalize?
- `final` - zabrania dziedziczenia, nadpisania, modyfikacji
- `finally` - blok, wykonywany zawsze przy try catch
- `finalize` - metoda wywolywana przed usunieciem obiektu

#### Omów znane Tobie wzorce projektowe i omów je
Tu jest wszystko: https://refactoring.guru/design-patterns/catalog

**PRZYKŁADY:**
- KREACYJNE (creational)
  - Fabryka abstrakcyjna (używamy tam gdzie chcemy odciąć się od tworzenia instancji klasy konkretnego typu)
  - Budowniczy (pozwala na budowanie obiektu w kilku etapach)
  - Metoda wytwórcza (Udostępnia interfejs do tworzenia obiektów w klasie bazowej, ale pozwala podklasom zmieniać typ tworzonych obiektów)
  - Prototyp (Umożliwia kopiowanie istniejących obiektów bez tworzenia zależności pomiędzy twoim kodem, a ich klasami)
  - Singleton (jedna instancja danego obiektu w apk)
- STRUKTURALNE (structural)
  - Adapter (Zachowanie kompatybilności z starszym/nowym interfejsem)
  - Most (Rozdziela abstrakcje od implementacji)
  - Kompozyt (Utworzenie obiektów w tzw struktury drzewiaste)
  - Dekorator (dodania istniejącej klasie, nowe zachowanie, ale nie zmienia działania klasy podstawowej)
  - Fasada (ułatwia dostęp do różnych obiektów i ukrywa szczegóły implementacji)
  - Pyłek (ograniczenie zajmowanej pamięci przez wiele obiektów)
  - Pełnomocnik (kontrolowanego tworzenia na żądanie kosztownych obiektów oraz kontroli dostępu do nich)
- CZYNNOŚCIOWE (behavioral)
  - Łańcuch zobowiązań (Pozwala przekazywać żądania według łańcucha obiektów obsługujących)
  - Iterator (Pozwala przechodzić sekwencyjnie po elementach zbioru bez konieczności eksponowania jego formy (lista, stos, drzewo))
  - Mediator (Wzorzec ogranicza bezpośrednią komunikację pomiędzy obiektami i zmusza je do współpracy wyłącznie za pośrednictwem obiektu mediatora)
  - Obserwator (Pozwala zdefiniować mechanizm subskrypcji by powiadamiać wiele obiektów o zdarzeniach odbywających się w obserwowanym obiekcie)
  - Stan (obiekt zmiena swoje zachowanie gdy zmieni się jego wewnętrzny stan)
  - Strategia (Pozwala zdefiniować rodzinę algorytmów, umieścić je w osobnych klasach i uczynić obiekty tych klas wymienialnymi)
  - Metoda szablonowa (Definiuje szkielet algorytmu w klasie bazowej, ale umożliwia podklasom nadpisanie poszczególnych etapów algorytmu bez konieczności zmiany jego struktury)
  - Odwiedzający (Pozwala oddzielić algorytmy od obiektów na których pracują)
- Inne 
  - API Gateway
    - security – decyduje, czy zapytanie może być “wpuszczone” do systemu
    - zarządzanie ruchem – routing na podstawie URI
    - testowanie – możemy kierować ruchem na nowe usługi w celu przetestowania (na przykład canary release)
    - eksperymenty – daje nam możliwość eskperymetowania z przekierowywaniem ruchu
    - wstrzykiwanie danych – możemy dodawać dane do żądań (na przykład do nagłówków)
    - monitoring – na podstawie tego serwisu mamy wgląd do tego jak ruch jest rozdzielany oraz co dzieję się w systemie
    - wstrzykiwanie błędów – możemy na przykład wstrzykiwać złe nagłówki i obserwować jak odpowie na to system
    - odporność – jeśli któryś z serwisów będzie niedostępny, gateway może przekierować ruch na działające instancje.
  - Circuit breakers
    - ma na celu zminimalizowanie efektu, gdy część usług nie odpowiada, a wiele klientów chce do nich uzyskać dostęp.
    - W przypadku, gdy mamy setki wywołań, wtedy lepiej, gdy np. pierwszy klient ostrzeże innych o tym, że i tak nie ma sensu łączyć się z daną usługą, ponieważ ona nie odpowiada.
    - Obwód zamknięty – normalny tryb pracy. 
    - Obwód otwarty – jeśli proxy jest w tym stanie, to znaczy, że dopuszczalna liczba nieudanych połączeń została przekroczona
    - Półotwarty -  dopuszczanie ograniczonej liczby zapytań, które będą stanowić tak naprawdę test usług
  - Load balancing
    - jest urządzeniem lub oprogramowaniem, przekierowującym żądania TCP/IP do odpowiednich serwerów, które tworzą klaster webowy lub tzw. farmę
    - celem jest rozdzielenie ruchu siecowego równomiernie na wszystkie serwery
  - Service discovery 
    - to serwis, który umożliwia rejestrowanie się nowych serwisów, jak i udostępnianie informacji o zarejestrowanych użytkownikach. Często są to implementacje wzorca klucz-wartosc, od którego wymagana jest duża niezawodność i szybkość
    
#### Co daje użycie Buildera vs settery w obiekcie? 
Niemutowalność, co za tym idzie obiekt jest thread safe. Dodatkowo przy dużej liczbie podobnych obiektów poprawia wydajność.

#### Dziedziczenie vs Kompozycja - czym się różni, kiedy się jakie stosuje? 
- Kompozycja - dodanie funkcjonalności do klasy wstawiając do niej pole innej klasy.
- Dziedziczenie - dodanie funkcjonalności do klasy poprzez skopiowanie i nadpisanie jej metod/pól
Np. 
```java
class BaseClass {
    void someMethod() {
        //do something
    }
}
// Dziedziczenie
class ExtendingClass extends BaseClass {
    void myMethod() {
        this.someMethod(); // funkcjonalność z BaseClass poprzez dziedziczenie
    }
}
// Kompozycja
class CompositionClass {
    BaseClass base = new BaseClass();
    void myMethod() {
        base.someMethod(); // funkcjonalność z BaseClass poprzez kompozycje
    }
}
```

#### Interfejs vs klasa abstrakcyjna czym się różnią? 
- Interfejs nie jest klasą więc:
  - interfejs nie może enkapsulować zmiennych i funkcji ```(public static final)```
  - interfejs może być rozszerzony przez więcej niż 1 interfejs
  - klasa może implementować interfejsy
  - klasa może rozszerzać klasę
  

#### Omów zasady SOLID
https://hackernoon.com/solid-principles-made-easy-67b1246bcdf
- **S**ingle Responsibility Principle - Każda klasa powinna posiadać dokładnie jedną odpowiedzialność i robić tę jedną rzecz najlepiej jak się da. Nigdy nie powinien istnieć więcej niż jeden powód do modyfikacji klasy.

- **O**pen-Closed Principle - Projekt powinien być otwarty na rozszerzanie i zamknięty na modyfikacje. Zamiast modyfikować klasę raczej powinniśmy ją rozszerzać, jednocześnie bazując na abstrakcji aniżeli konkretnych implementacjach.

- **L**iskov Substitution Principle - Jeśli w danym miejscu programu oczekujemy jakiegośkonkretnego typu obiektu (np. Animal), to powinniśmy mieć możliwość użycia tam dowolnego jego podtypu np. Cat, Mouse itp.

- **I**nterface Segregation Principle - Krótko: Użytkownik nie powinien być zmuszony do implementowania metod których nie używa. Lepiej więcej małych Interfejsów niż jeden duży. Celem są proste i krótkie interfejsy przeznaczone do jednego celu (SRP). Ograniczy to powstawanie niepotrzebnych zależności w projekcie.

- **D**ependency Inversion Principle - Opieraj się na abstrakcjach, zamiast konkretnych implementacjach. Moduły wysokopoziomowe NIE POWINNY zależeć od modułów niskopoziomowych. 

Interfejsy powinny stać wyżej w hierarchii niż ich konkretne implementacje, które mogą się zmieniać. Ten wzorzec jest powszechnie implementowany przez kontenery ```Dependency Injection```, gdzie w kodzie używa się nazw interfejsów, a za dostarczenie konkretnych instancji obiektów odpowiada centralnie kontener **DI**.

#### Omów KISS
**Keep It Simple, Stupid!**
KOD POWINIEN BYĆ:
- czytelny i zrozumiały (nie buduj hack'ów)
- możliwie najkrótszy (wszystkie nieużywane funkcje - do wyrzucenia )
- Jak coś nie jest konieczne w kodzie to tego ma tam nie być! 80% czasu przy programowaniu to czytanie (nie pisanie) kodu. Zadbaj, by było go jak najmniej.

#### YAGNI
**You aren't gonna need it**<BR>
Nie twórz na przyszłość.

#### Parsowanie XML
* `DOM`: jest wczytywane w całości do pamięci i odpowiednimi metodami możemy wyciągać z niego informacje nas interesujące
* `SAX`: nieudany projekt (sekwencyjne wykonywanie operacji na pliku)
* `JAXB`: standard, odpowiada za mapowanie xml na klasy i vice versa (wprowadzony w 1.6) 

#### XSD - XML Schema Definition
opracowany przez W3C standard służący do definiowania struktury dokumentu XML. XML Schema stanowi alternatywę dla DTD

## ZASOBY ZEWNĘTRZNE:
- http://toolsqa.com - Baza wiedzy o selenium
- https://learncodethehardway.org/unix/bash_cheat_sheet.pdf - BASH Cheatsheet
- https://www.geeksforgeeks.org/functional-interfaces-java/ - JAVA Functional interfaces
- https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/ - JAVA Streams
