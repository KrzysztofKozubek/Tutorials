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
- STOS (Stack)- typy proste, wskaźniki do obiektów, wskaźniki powrotu z funkcji.
- STERTA (Heap)- Obiekty i typy złożone

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
clone, equals, finalize, hashcode, notify, notifyAll, wait

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

https://docs.oracle.com/javase/tutorial/extra/generics/morefun.html

## Functional interfaces
to interfejs posiadający 1 abstrakcyjną metodę

#### Wyrażenie lambda
wyrażenie instancji wyrażeń lmbda 

#### Stream
wprowadzenie przez java do programowania funkcyjnego. Służą do przetwarzania danych. Zawierają dane i pozwalają na opisanie co chcesz zrobić tymi danymi.


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

#### słowo kluczowe volatile
volatile sprawia iż dana wartość będzie zapisana w danej pamięci tak szybko jak to, możliwe

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
Future<Integer> future = executor.submit(task);
Integer result = future.get();

Remember about shutdown executor
```

#### Jak synchronizować wątki? Omów słowo kluczowe **synchronized**

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
  - Singleton
  - Factory method
  - Abstract factory
  - Builder
- STRUKTURALNE (structural)
  - Facade
  - Proxy
  - Decorator
  - Composite
- CZYNNOŚCIOWE (behavioral)
  - Observer
  - Visitor
  - Iterator
  - Strategy

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

  
## ALGORYTMY
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

## SELENIUM i AUTOMATYZACJA
#### Omów jakie znasz rodzaje selektorów. 
Selenium udostępnia 8 rodzai, przy czym wszystkie można zastąpić albo CSS lub XPATH.

#### Czym się różni XPATH od CSS?
Dwa zupełnie odmienne rodzaje języka służącego do określenia elementów w drzewie DOM / XML.
- CSS - Selektory bardziej zwięzłe, bardziej zrozumiałe dla frontendowców. Natywna obsługa klas CSS.
- XPATH - daje największe możliwości. Umożliwia wyszukiwanie po zawartości tekstowej, poruszanie się po drzewie, itp. 

#### Który jest szybszy i dlaczego? 
Szybszy jest CSS, ponieważ nie wczytuje całego drzewa DOM podczas działania.

#### Kiedy używać jakich selektorów?
Generalnie - jak nie potrzebujemy ficzerów XPATH to CSS będzie szybszy i bardziej przejrzysty

#### Co znajdą poniższe selektory CSS: 
- div#content
- .img
- .img.first
- .img .first
- .img:first-child
- .img > div
- .img[lol='xd']


#### Co znajdą poniższe selektory XPATH: 
- //*[@type='hidden']
- //div[0]
- //div[3]
- //div[div]
- //div//a
- //div/a
- //div/a[contains(text(), 'lol')]
- //div/a[contains(., 'lol')]
- //div/a/../..//div[name='lol']
- //div/a[contains(.,'loltext')]/..
- //div[@name='lol'][@id='lolId']
- //div[a[@id='lolId']]

#### [ZADANIE] Masz slider w postaci licznika samochodowego w kształcie półokręgu. Możesz przesuwać wskazówkę za pomocą "wajchy" po tym półokręgu myszką. Pod spodem jest licznik 0-100%, który wskazuje jak ustawiłeś wskazówkę(0% wskazówka z lewej, 50% wskazówka do góry, 100% wskazówka z prawej).
- Jak sprawdzić czy to działa używając Selenium ? 
- Napisz komponent, który enkapsuluje działania na tym sliderze.
- Masz do dyspozycji funkcję **dragAndDrop(x, y)**, gdzie x i y to współrzędne z układu zaczynającego się w lewym górnym rogu strony. 

## JavaScript / TypeScript ES6+
#### Co to jest Event Loop?
#### Czy w JS są klasy
**Nie*** (z jednym zastrzeżeniem)
Są przede wszystkim obiekty. Dziedziczenie odbywa się przez prototypy.
W ES6 doszła składnia definicji ```class```, która pod spodem niczym się nie różni od opierania się na prototypach.

#### Omów dziedziczenie przez prototypy w JS

#### na co wskazuje **this** ?
this -> Aktualny kontekst wykonania. This jest przypisywany np. podczas tworzenia nowego obiektu poprzez operator new.

#### Co pojawi się na konsoli po wykonaniu poniższego kodu: 
```javascript
setTimeout(0, () => console.log("First"));
console.log("Second");
```
#### I dlaczego?
ODPOWIEDŹ: 
```
> Second
>
> First
```
W pierwszej linii wywołujemy funkcję setTimeout, która triggeruje dodanie do Event Loop funkcji ```() => console.log("First")``` po czasie 0 (od razu) na koniec event loop'a.
Jednak Zostanie ona wykonana, dopiero po zakończeniu wszystkich instrukcji z aktualnego kontekstu wykonania (tj. wklejonego kodu - drugiej linijki: ```console.log("Second")```).

#### Jak zmienić this dla obiektu w JavaScript?
Można użyć funkcji ```bind()```

#### Co to Promise's w JavaScript? Po co je stosować (zamiast callbacków)?
API ułatwiające zarządzanie asynchronicznym kodem. Zmniejsza poziom skomplikowania kodu w porównaniu do używania callback'ów. 

#### Co zwraca funkcja ze słowem kluczowym **async**? 
Zwraca Promise'a - obietnicę zwrócenia wyniku. 
Np. 
```javascript
async function abc() {
    return "abc"; // return Promise<String>
}
```
#### Co robi operator **await** wewnątrz funkcji asynchronicznej?
Czeka na rozwiązanie ```Promise``` i: 
- Gdy się powiedzie (```resolved```) zwraca jej wynik
- Gdy się nie powiedzie (```rejected```) wyrzuca Wyjątek

#### Czy znasz TypeScript?

#### Jakie korzyści przynosi stosowanie TypeScript'u w projekcie?
Typowanie, a dzięki temu:
- podpowiadanie składni
-mniejsze prawdopodobieństwo błędów dzięki kompilacji
- zwiększa czystość kodu
- wymusza stosowanie typów i dzięki temu zmniejsza prawdopodobieństwo rzutowania / konwersji typów tam gdzie o nie jest pożądane / zamierzone.


#### Czy JavaScript jest asynchroniczny?
Tak

#### Czy JavaScript jest jednowątkowy?
Tak, z zastrzeżeniem, że 
  - korzysta z API środowiska(np. przeglądarki), które działają w innych wątkach i procesach np WEB API's timing API, fetch API itp.
  - można w przeglądarce uruchomić service worker, który działa na innym wątku. 
  - można w Node.JS uruchomić podprocesy (**child_process**), każdy ma swój wątek. 

#### [ZADANIE] Napisz funkcję ```hello(name)``` zwracającą obietnicę (Promise), która po 1 sekundzie rozwiązuje się do wartości ```name```.
```javascript
function hello(name) {
    return new Promise((resolve, reject) => {
        return setTimeout(() => resolve(name), 1000);
    });
}
```

Lub korzystając ze składni async: 
```javascript
async function hello(name) {
  await sleep(1000);
  return name;
}

//funkcja pomocnicza
function sleep(ms) {
  return new Promise(res => setTimeout(res, ms))  
}
```


#### [ZADANIE] Za pomocą konsoli przeglądarki mając otwartą stronę wyników wyszukiwania z Google wypisz wszystkie znalezione linki.
Jedno z rozwiązań:
```javascript
const links = document.querySelectorAll(".r > a:first-child");
links.forEach(link => console.log(link.href));
```

#### [ZADANIE] Masz dwie wieże naprzeciw siebie, każda ma 3 okna po 1 na każdym piętrze - czyli razem 6 okien naprzeciw siebie. Można między dowolnymi oknami przerzucić 2 liny - w zależności od kombinacji mogą się przecinać albo nie.
Napisz logikę / zamodeluj problem odpowiadające na pytanie kiedy liny się przetną, a kiedy nie. 
- Na wejściu masz informacje o tym, jak są zawieszone liny, na wyjściu odpowiedz czy się przecinają. 
- Zamodeluj to używając klasy / klas.
- zaimplementuj metodę mówiącą czy liny się przecinają zwracającą `true` lub `false`.


# ISTQB - Teoria testowania
#### [ZADANIE] Proszę tutaj jest termometr zaokienny, zastanawiamy się czy zamawiać 1000000 sztuk. Jak byś go przetestował/a ?
#### [ZADANIE] Przetestuj windę

Syllabus: https://sjsi.org/ist-qb/do-pobrania/

#### Pomyłka, defekt, awaria - czym się różnią? 
- **pomyłka (błąd)** - ktoś popełnia błąd podczas kodzenia, w wyniku tego powstaje...
- **defekt**! - jakiś kawałek kodu, który nie działa jak trzeba i może spowodować: 
- **awarię!** - do tego staramy się nie dopuścić i wykryć defekt wcześniej

#### Siedem zasad testowania
1. Testowanie ujawawnia usterki, ale nie dowodzi ich braku
2. Testowanie gruntowne jest niemożliwe
3. Wczesne testowanie oszczędza czas i pieniądze
4. Kumulowanie się defektów
5. Paradoks pestycydów
6. Testowanie zależy od kontekstu
7. Przekonanie o braku błędów jest błędem

#### Cykl życia błędu
Mniej więcej tak:

Nowy -> Przydzielony -> Otwarty -> "Naprawiony" -> Retest -> Ponownie otwarty -> Naprawiony -> Retest -> Zamknięty

#### Poziomy testów
Każdy z poziomów ma swoje, cele szczegółowe, rodzaje błędów, typowe defekty i awarie oraz środowisko. 
Np. Testy modułowe izolują moduły od innych, a akceptacyjne wymagają środowiska zbliżonego do produkcyjnego. 

- **testowanie modułowe** - Unit testy. Testowanie zachowania pojedynczych modułów w izolacji od ich powiązań z innymi (stosowane są tutaj zaślepki / mocki)
- **testowanie integracyjne** - Testowanie integracji pomiędzy różnymi modułami. Badanie zgodności działania z interfejsami. Można testować integrację pomiędzy modułami w danej aplikacji, lub na wyższym poziomie - Pomiędzy różnymi systemami. 
- **testowanie systemowe** - Testowanie zachowania całego systemu lub produktu z uwzględnieniem wymagań funkcjonalnych i niefunkcjonalnych. 
- **testowanie akceptacyjne** - Testownie całego systemu z perspektywy użytkownika końcowego. Wykrywają kompletność działania całego systemu. Zwiększają poziom zaufania. Testowanie zgodności z umową. Testy AB. 



#### Typy testów
Każdy z typów testów można wykonać na każdym poziomie testów.
- **testy funkcjonalne**
- **testy niefunkcjonalne**
- **testy czarnoskrzynkowe**
- **testy białoskrzynkowe**
- **testy wydajnościowe**
- **testy obciążeniowe**


#### Wymień rodzaje dokumentacji w projekcie
#### Co powinien zawierać Test plan? 
#### Co powinien zawierać przypadek testowy? 
#### Jak tworzyć przypadki testowe?
#### Jak tworzyć przypadki testowe, kiedy nie ma zdefiniowanych wymagań? 
#### Omów cykl życia błędu
#### Co to są wymagania funkcjonalne? 
#### Co to są wymagania niefunkcjonelne (podaj przykłady)? 
#### Wymień rodzaje testów: 
#### Co to są testy jednostkowe, funkcjonalne, systemowe, akceptacyjne? 
#### Co to są testy regresyjne?
#### Omów metodologię TDD
#### Omów podejście BDD
#### Omów różnice pomiędzy testami czarnoskrzynkowymi, a białoskrzynkowymi
#### Omów cykl życia błędu
#### Czym się różni się defekt od błędu?
#### Co powinno zawierać zgłoszenie błędu? 
#### Po co stosować mock'owanie podczas testów? 
#### Dostajesz błąd zgłoszony na produkcji od użytkownika co z tym robisz? 
- próbujesz powtórzyć błąd używając scenariuszy testowych
- sprawdzasz logi
- kontaktujesz się że zgłaszającym o jeśli jest potrzeba i możliwość
- sprawdzasz czy błąd występuje na poprzedniej wersji aplikacji
- No i oczywiście zgłaszasz błąd do deweloperów


# Zarządzanie projektami
#### Co to jest SCRUM? Omów jego założenia.
#### Omów role w SCRUM'ie (Scrum master, Product owner, zespół, klient)
#### Wymień i omów zdarzenia w SCRUM'ie
#### Wyjaśnij proces tworzenia oprogramowania w SCRUMIE
#### Omów metodologię Waterfall

# SIECI
#### Omów protokół HTTPS: 
#### Po co się go stosuje?
#### Na czym polega komunikacja? Krok po kroku.
#### Klucze publiczne i prywatne
#### Szyfrowanie asymetryczne i symetryczne
#### Z czego się składa adres IP?
#### Co to jest maska podsieci
#### Jak znając maskę podsieci i IP wyliczyć ilość dostępnych adresów w sieci?
#### Ile jest dostępnych adresów przy masce 0.0.0.0
#### Omów ogólnie czego dotyczy model OSI

# HTTP / REST
#### Czym jest SOAP?
#### Czym jest REST?
Styl architektury dla Usług webowych (Web Services) opierający się na wykorzystaniu protokołu HTTP do przesyłania wiadomości.
Metoda HTTP definiuje akcję, a kody odpowiedzi rezultat. 
Cechy systemu **RESTfull**
- Architektura klient-serwer
- Bezstanowość
- Cacheability
- Layered system - Ustanowienie warstwy proxy pomiędzy klientem, a serwerem nie niesie za sobą konieczności ich modyfikacji (jest transparentne). Można np. użyć Load balancera.
- Jednolity interfejs:
  - Resource identification in requests - każdy zasób ma swój unikalny URI
  - Resource manipulation through representations - jeśli klient ma informacje o obiekcie, są one wystarczające do jego usunięcia / modyfikacji
  - Self-descriptive messages - wiadomości powinny zawierać wystarczającą ilość metadanych i danych do ich poprawnego zrozumienia np. MIME type. Wiadomości zawierają informacje o ich *"cacheowalności"*
  - Hypermedia as the engine of application state (HATEOAS) - ustandaryzowane linki do zasobów https://restfulapi.net/hateoas/ 

#### Jakie znasz metody HTTP? Do czego służy każda z nich?
- `GET` - pobiera zasób
- `HEAD` - sprawdza, czy zasób istnieje (zwraca to samo co GET, tylko bez response body)
- `POST` - tworzy nowy zasób
- `PUT` - Edytuje cały zasób
- `PATCH` - Modyfikuje część zasobu
- `DELETE` - Usuwa zasób
- `OPTIONS` - Zwraca listę dostępnych metod HTTP dla danego zasobu 
- `CONNECT`
- `TRACE`

#### Jak wygląda request i response HTTP?
#### Jaki jest główny podział statusów odpowiedzi HTTP?
#### Co oznaczają kody odpowiedzi 1xx, 2xx, 3xx, 4xx, 5xx
https://www.restapitutorial.com/httpstatuscodes.html
- 1xx - informacyjne
- 2xx - sukces (203 no auth | 204 no content)
- 3xx - przekierowanie (305 use proxy | 310 too many redirects)
- 4xx - błąd klienta (400 bad request | 401 anauth | 403 forbiden(zabroniony) | 404 not found | 408 timeout)
- 5xx - błąd serwera (500 serv error | 502 bad gatewat)
#### Czym chararakteryzują się metody idempotentne? Które są idempotentne, a które nie?
#### Czym charakteryzują się metody bezpieczne
| Method  | Safe | Idempotent | Cacheable | Allowed in HTML forms | Request has body | Response has body |
|---------|------|------------|-----------|-----------------------|------------------|-------------------|
| GET     | ✅    | ✅          | ✅         | ✅                     | ❌                | ✅                 |
| HEAD    | ✅    | ✅          | ✅         | ❌                     | ❌                | ❌                 |
| POST    | ❌    | ❌          | ✅*        | ✅                     | ✅                | ✅                 |
| PUT     | ❌    | ✅          | ❌         | ❌                     | ✅                | ❌                 |
| PATCH   | ❌    | ❌          | ❌         | ❌                     | ✅                | ✅                 |
| DELETE  | ❌    | ✅          | ❌         | ❌                     | May               | May               |
| OPTIONS | ✅    | ✅          | ❌         | ❌                     | ❌                | ✅                 |
| TRACE   | ❌    | ✅          | ❌         | ❌                     | ❌                | ❌                 |
| CONNECT | ❌    | ❌          | ❌         | ❌                     | ❌                | ✅                 |
* - Only if freshness information is included

#### Czym są Headery i do czego się je stosuje?
- Zawierają metadane, np. info o stanie ssji (ciastka), cacheowalność, Content type, autentykacja, 
#### Jakie znasz Headery? Podaj przykłady.
#### Co to są ciasteczka? Do czego się je stosuje?


# BEZPIECZEŃSTWO

#### Czy znasz OWASP? Co to jest?
#### Jakie znasz rodzaje ataków na serwisy WWW?
SQL Injection, XSS, XSRF, SSRF, XXE
  - **XSS (Cross-site Scripting)** wykonanie złośliwego kodu wstrzykując go do ofierze np. tak: ```alert('to jest atak! Powinno wyświetlić alert w Twojej przeglądarce, ale github jakieś tam zabezpieczenia przed XSS ma');```
  - **XSRF (Cross-site Request Forgery)** Akcja wywołująca u ofiary wykonanie jakiegoś żądania w systemie w którym jest zalogowana. Np. wysłanie ofierze takiego linku na czacie i skłonienie do kliknięcia w niego: ```http://fb.com/usuń_konto```. Atakujący nie widzi odpowiedzi, więc atak nie służy do wykradania danych, a bardziej do skłonienia ofiary do wykonania jakiejś (autoryzowanej) akcji. Jeśli ofiara ma uprawnienia administratora, atak może wyrządzić wiele szkód: np. ```fb.com/usuń_serwer```n
  - **SSRF (Server-Side Request Forgery)** - Skłonienie serwera, do wykonania żądania, niezgodnie z zamysłem programistów. Np. Po wklejeniu linku do Messengera. Serwery wykonują żądania na ten adres i po chwili pojawia się migawka ze strony internetowej. Tutaj atak SSRF mógłby wyglądać tak, że atakujący wkleiłby link: ```/etc/passwd```, a serwer posłusznie wyświetliłby zawartość swoich własnych plików. Albo lokalny port ```0.0.0.0:12345```, oznaczający (skanowanie portów w sieci wewnętrznej). Itp. 
  - **XXE (XML External Entity)** - atak polegający na tym, że standard XML umożliwia definiowanie zmiennych (encji). 
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE myxml [ 
  <!ENTITY shp SYSTEM "/etc/passwd <tu można wstawić url, lokalizację pliku itp.>">
] >
```
Te encje można zaimportować z oddzielnego pliku i/lub adresu URL. Jeśli prześlemy takiego XML'a, gdzie w encji wprowadzimy zewnętrzny adres, udaje się w ten sposób wywołać atak **SSRF**, albo czytać pliki z serwera.

#### Czy Kod JS na stronie może wywołać zapytanie do innej domeny?
Nie, bo **Same Origin Policy**

#### Co to jest Same Origin policy?
Reguła bezpieczeństwa nowoczesnych przeglądarek, uniemożliwiająca kodowi JS wysyłania żądań do adresów z poza 'origin', czyli kombinacji aktualnych: **domeny, portu, protokołu**. Blokuje wiele wektorów ataku typu np. XSS.

#### Co oznacza skrót CORS?
**CORS (Cross-Origin Resource Sharing)** - zestaw mechanizmów pozwalający ominąć CORS dla niektórych wybranych domen w celu umożliwienia działania naszej aplikacji. Robi się to za pomocą headerów: ```Access-Control```, więcej tu: 

#### Czym się różni autoryzacja od autentykacji?
- Autoryzacja - Stwierdzenie że użytkownike ma dostęp do zasobu.
- Autentykacja - stwierdzenie kim jest użytkownik (jest krokiem autoryzacji)
#### Co to jest OAuth2
Standard delegacji autoryzacji. 

# Kontrola wersji
#### Czym różni się merge od rebase? 
#### Zasada działania GIT'a i czym różni się od SVN? 

# Bash
Podstawy tutaj: https://github.com/qarmin/PodstawowePoleceniaLinux/blob/master/README.md#podstawowe-polecenia-stosowane-w-systemie-gnulinux
#### Jakie znasz skróty klawiszowe w IDE z którym pracujesz?
#### Omów działanie komend pod linuxem: 
- ls
- touch xd.dd
- cd ..
- cd .
- cat
- head
- tail
- ps aux | grep node
#### Jak wypisać 10 ostatnich linijek z pliku testowego?
#### Jak wypisać pierwszych 10 linijek z pliku?
#### Jak wyszukać w pierwszych 100 linijkach pliku xd.dd linii zawierających słowo ```lol``` ?
```bash
head -100 xd.dd | grep lol
```


## BAZY DANYCH
#### Co to jest tablica asocjacyjna? 
Przechowuje relacje wiele-do-wielu

#### Jak zsumować płace wg. działów. Masz tablicę z listą pracowników z wynagrodzeniami i przypisanym działem.
TL DR; Trzeba zrobić Group BY po kolumnie z działami.

#### [ORACLE DB] Jak policzyć ilość wierszy zwracanych przez zapytanie?
- Standardowo ```count(*)```, ale można szybciej: 
- ```count(1);``` działa zdecydowanie szybciej, bo nie wyciąga wiersza za każdym razem

#### Co to jest Primary key
#### Omów Unique index
#### Czym się różnią Clustered Index i Non Clustered index
#### Kiedy używać indeksów w bazie danych a kiedy nie powinno się?
#### Kiedy indeksy przyspieszają działanie bazy, a kiedy spowalniają?
#### Omów SQL: INNER JOIN, OUTER JOIN, HAVING, GROUP BY, ORDER BY
#### Jakie znasz funkcje agregujące? 
#### Omów co to (i po co) jest ACID?
#### Omów poziomy izolacji


## ZASOBY ZEWNĘTRZNE:
- http://toolsqa.com - Baza wiedzy o selenium
- https://learncodethehardway.org/unix/bash_cheat_sheet.pdf - BASH Cheatsheet
- https://www.geeksforgeeks.org/functional-interfaces-java/ - JAVA Functional interfaces
- https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/ - JAVA Streams