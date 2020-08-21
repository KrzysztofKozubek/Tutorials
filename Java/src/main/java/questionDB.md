## BAZY DANYCH
#### Co to jest tablica asocjacyjna? 
Przechowuje relacje wiele-do-wielu

#### Jak zsumować płace wg. działów. Masz tablicę z listą pracowników z wynagrodzeniami i przypisanym działem.
TL DR; Trzeba zrobić Group BY po kolumnie z działami.

#### [ORACLE DB] Jak policzyć ilość wierszy zwracanych przez zapytanie?
- Standardowo ```count(*)```, ale można szybciej: 
- ```count(1);``` działa zdecydowanie szybciej, bo nie wyciąga wiersza za każdym razem

#### Blokady na bazie:
* Blokowanie `pesymistyczne` 
    * Zablokuj dane 
    * Odczytaj dane 
    * Zmień dane 
    * Wyślij zmianę 
    * Odblokuj dane 
    
* Blokowanie `optymistyczne` 
    * Odczytaj dane 
    * Zmień dane 
    * Wyślij zmianę 
    * sprawdzając czy ktoś nie zmienił obiektu 
    * Jeśli dane zostały zmienione w międzyczasie - wyjąte

#### Co to jest Primary key
Są to attrybyty identyfikace dany rekord w sposób jednoznaczny.
Taki klucz nie może przyjmować wartości null (wyjątek non clustered).
Taki klucz może być tylko 1 na tabele.
Może on być użyty na dowolną kolumnę lub wiele kolumn.
Często tworzy się nowa kolumnę która jest samouzupelniana przez bazę danych w celu zapewnienia unikalności.

#### Omów Unique index
Indeks można założyć na jedną lub więcej kolumn.
Unique informuje nas o tym że dane wartości się nie powtórzą w tabeli.

```sql
CREATE UNIQUE INDEX __index__
ON __table__ (__column__);
```

#### Czym się różnią Clustered Index i Non Clustered index
#### Kiedy używać indeksów w bazie danych a kiedy nie powinno się?
Używać gdy wyszukujemy, łączymy relacja daną kolumnę.

#### Kiedy indeksy przyspieszają działanie bazy, a kiedy spowalniają?
Przyspieszają jak dobrze się ich używa.

Spowalniają gdy zakładamy indeksy na wszystkich kolumnach a wyszukujemy zawsze po jednej.

#### Omów SQL: INNER JOIN, OUTER JOIN, HAVING, GROUP BY, ORDER BY
* Inner join
```sql
select *
from __table1__
join __table2__ on __column1__ = __column2__;
```
PRODUCTS

|id |product |price  |
|---|--------|-------|
|1  |Potatoes|  3$   |
|2  |Avocados|  4$   |
|3  |Kiwis   |  2$   |
|4  |Onions  |  1$   |
|5  |Melons  |  5$   |
|6  |Oranges |  5$   |
|7  |Tomatoes|  6$   |

QUANTITY

|id |product_id|quantity|
|---|----------|--------|
|1  |1         |   45   |
|2  |2         |   62   |
|3  |3         |   19   |
|4  |4         |   20   |
|5  |5         |   66   |
|6  |10        |   27   |
|7  |1         |   92   |




```sql
SELECT *
FROM Quantity
JOIN PRICE ON QUANTITY.product_id = PRODUCTS.id;
```
|QUANTITY.id|QUANTITY.product_id|QUANTITY.quantity|PRODUCTS.id|PRODUCTS.price|PRODUCTS.product|
|-----------|-------------------|-----------------|-----------|--------------|-------------|
|1          |1                  |45               |1          |3             |Potatoes|
|2          |2                  |62               |2          |4             |Avocados|
|3          |3                  |19               |3          |2             |Kiwis|
|4          |4                  |20               |4          |1             |Onions|
|5          |5                  |66               |5          |5             |Melons|

```sql
SELECT *
FROM Quantity
LEFT JOIN PRICE ON QUANTITY.product_id = PRODUCTS.id;
```

|QUANTITY.id|QUANTITY.product_id|QUANTITY.quantity|PRODUCTS.id|PRODUCTS.price|PRODUCTS.product|
|-----------|-------------------|-----------------|--------|-----------|-------------|
|1    |1    |45    |1    |3    |Potatoes|
|2    |2    |62    |2    |4    |Avocados|
|3    |3    |19    |3    |2    |Kiwis|
|4    |4    |20    |4    |1    |Onions|
|5    |5    |66    |5    |5    |Melons|
|6    |6    |27    |null|null|null|
|7    |7    |92    |null|null|null|

```sql
SELECT *
FROM Quantity
RIGHT JOIN PRICE ON QUANTITY.product_id = PRODUCTS.id;
```
|QUANTITY.id|QUANTITY.product_id|QUANTITY.quantity|PRODUCTS.id|PRODUCTS.price|PRODUCTS.product|
|-----------|-------------------|-----------------|--------|-----------|-------------|
|1    |1    |45    |1    |3    |Potatoes|
|2    |2    |62    |2    |4    |Avocados|
|3    |3    |19    |3    |2    |Kiwis|
|4    |4    |20    |4    |1    |Onions|
|5    |5    |66    |5    |5    |Melons|
|null|null|null|6    |5    |Oranges|
|null|null|null|7    |6    |Tomatoes|

```sql
SELECT *
FROM Quantity
FULL OUTER JOIN PRICE ON QUANTITY.product_id = PRODUCTS.id;
```
|QUANTITY.id|QUANTITY.product_id|QUANTITY.quantity|PRODUCTS.id|PRODUCTS.price|PRODUCTS.product|
|-----------|-------------------|-----------------|--------|-----------|-------------|
|1    |1    |45    |1    |3    |Potatoes|
|2    |2    |62    |2    |4    |Avocados|
|3    |3    |19    |3    |2    |Kiwis|
|4    |4    |20    |4    |1    |Onions|
|5    |5    |66    |5    |5    |Melons|
|6    |6    |27    |null|null|null|
|7    |7    |92    |null|null|null|
|null|null|null|6    |5    |Oranges|
|null|null|null|7    |6    |Tomatoes|
#### Jakie znasz funkcje agregujące? 
- AVG
- SUM
- MIN
- COUNT
- MAX
- SUM

#### Omów co to (i po co) jest ACID?
#### Omów poziomy izolacji



## SQL podstawowe komendy

* SELECT 

SQL SELECT Statement
```sql 
SELECT __column1__, __column2__....__columnN__
FROM   __table__;
```
SQL DISTINCT Clause
```sql 
SELECT DISTINCT __column1__, __column2__....__columnN__
FROM   __table__;
```
SQL WHERE Clause
```sql 
SELECT __column1__, __column2__....__columnN__
FROM   __table__
WHERE  CONDITION;
```
SQL AND/OR Clause
```sql 
SELECT __column1__, __column2__....__columnN__
FROM   __table__
WHERE  CONDITION-1 {AND|OR} CONDITION-2;
```
SQL IN Clause
```sql 
SELECT __column1__, __column2__....__columnN__
FROM   __table__
WHERE  __column__ IN (_val1__, _val2__,...val-N);
```
SQL BETWEEN Clause
```sql 
SELECT __column1__, __column2__....__columnN__
FROM   __table__
WHERE  __column__ BETWEEN _val1__ AND _val2__;
```
SQL LIKE Clause
```sql 
SELECT __column1__, __column2__....__columnN__
FROM   __table__
WHERE  __column__ LIKE { PATTERN };
```
SQL ORDER BY Clause
```sql 
SELECT __column1__, __column2__....__columnN__
FROM   __table__
WHERE  CONDITION
ORDER BY __column__ {ASC|DESC};
```
SQL GROUP BY Clause
```sql 
SELECT SUM(__column__)
FROM   __table__
WHERE  CONDITION
GROUP BY __column__;
```
SQL COUNT Clause
```sql 
SELECT COUNT(__column__)
FROM   __table__
WHERE  CONDITION;
```
SQL HAVING Clause
```sql 
SELECT SUM(__column__)
FROM   __table__
WHERE  CONDITION
GROUP BY __column__
HAVING (arithematic function condition);
```

SQL WITH
```sql
WITH __template__ (__val1__, __val2__, ..., __valN__) AS
({QUERY}),

SELECT __column__
FROM __table__
WHERE __column__ = __val1__;

WITH __template__ (averageValue) AS
(SELECT AVG(salary) FROM Employee), 

SELECT empoyer_id, salary 
FROM Employee
WHERE salary > averageValue;

```

* INSERT 
```sql
INSERT INTO __table__ (__column1__, __column2__, ..., __columnN__)
VALUES (__val1__, __val2__, ..., __valN__);
```

* UPDATE
```sql
UPDATE __table__
SET __column1__ = __val1__,
    __column2__ = __val2__,
    ...,
    __columnN__ = __valN__,
[WHERE {CONDITION}];
```

* DELETE
```sql
DELETE FROM __table__
WHERE {CONDITION};
```




# JPA / Hibernate

JPA to standard z grupy tzw. ORM (ang. Object-Relational Mapping).

Aby korzystać z JPA będziemy potrzebowali tzw. providera — biblioteki, która dostarcza implementację standardu JPA (JPA to tylko zbiór kontraktów, tzn. opisów, jakie funkcje mają być realizowane i w jaki sposób — sami możemy wybrać lub stworzyć implementację, która będzie się tym zajmowała).


## Adnotacje

```java
@Entity
@Table(name="PRODUCTS")
@Getter
@Setter
public class Product {

    @Id // PK
    @GeneratedValue 
    /*
    strategy:
    TABLE - przechowywane w osobnej tabeli (przed włożeniem dokonywany jest odczyt) 
    IDENTITY – AUTO-INCREMENT przez baze
    SEQUENCE – systemowy sekwenser
    AUTO – automatycznie jedno z powyższych

    generator: name of primary key
    */
    private Long id;

    @Size(min = 1, max = 10)
    @Pattern("^{0-9}{9}$")
    @Column(name = "__column__")
    private String column;


    @Transient
    private String noSaved;
}
```

Relacje:
Movie

| id | name | movie_details_id |
|----|------|------------------|
| 1  | Dark |        1         |

Movie Details

| id | genre  | lenght |
|----|--------|--------|
| 1  | Horror |  152   |

* `OneToOne`:
  * jednokierunkowa:
```java
// Movie.class
@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
private MovieDetails MovieDetails;
```
  * dwukierunkowa:
```java
// MovieDetails.class
@OneToOne(fetch = FetchType.LAZY)
private Movie movie;

// Movie.class
public void setMovieDetails(MovieDetails movieDetails) {
  movieDetails.setMovie(this);
  this.movieDetails = movieDetails;
}
```

* `OneToMany` / `ManyToOne`:
  * jednokierunkowa:
```java
// Movie.class
@OneToMany(cascade = CascadeType.ALL)
private final List<Showing> showings = new ArrayList<>();

public void addShowing(Showing showing) {
  showings.add(showing);
}
 
public void removeShowing(Showing showing) {
  showings.remove(showing);
}

// Showing.class
@ManyToOne(fetch = FetchType.LAZY)
private Movie movie;
```
  * dwukierunkowa:
 ```java
 // Movie.class
 public void addShowing(Showing showing) {
  showings.add(showing);
  showing.setMovie(this);
}
 
public void removeShowing(Showing showing) {
  showings.remove(showing);
  showing.setMovie(null);
}
```
* `ManyToMany`:
  * jednokierunkowa:
```java
// Movie.class
@ManyToMany
private final List<Category> categories = new ArrayList<>();

public void addCategory(Category category) {
  this.categories.add(category);
}
 
public void removeCategory(Category category) {
  this.categories.remove(category);
}
```
  * dwukierunkowa:
```java
// Category.class
@ManyToMany
private final List<Movie> movies =  new ArrayList<>();
 
public void addMovie(Movie movie) {
  movies.add(movie);
}
 
public void removeMovie(Movie movie) {
  movies.remove(movie);
}

// Movie.class
public void addCategory(Category category) {
  this.categories.add(category);
  category.addMovie(this);
}
 
public void removeCategory(Category category) {
  this.categories.remove(category);
  category.removeMovie(this);
}
```

## Fetch
Argument fetch określa sposób, w jaki powiązane obiekty są pobierane z bazy. Przyjmuje enum FetchType, który ma dwie wartości:
* `EAGER` – obiekty powiązane z użyciem tego FetchType będą automatycznie wyciągane z bazy przez Hibernate, przy wczytaniu obiektu bazowego
* `LAZY` – obiekty z FetchType.LAZY nie będą pobierane od razu razem z obiektem bazowym, a dopiero wtedy, gdy ich zażądamy.

Generalnie rzecz biorąc, `FetchType.EAGER` powinien być używany jak najrzadziej, tylko jeśli jesteśmy pewni, że zawsze będziemy pobierać zależności dla obiektu, na przykład gdy przesyłamy do klienta agregaty złożone z obiektu i jego zależności. Niepotrzebne użycie `EAGER` znacznie zwiększy obciążenie bazy danych, która będzie zwracać dodatkowo aplikacji niepotrzebne obiekty.

Warto pamiętać, że o ile `@OneToMany` i `@ManyToMany` mają domyślnie `FetchType.LAZY`, to jednak `@OneToOne` i `@ManyToOne` mają domyślnie zdefiniowany `FetchType.EAGER`, co nie zawsze jest optymalne.

## Cascade
Kaskadowanie operacji na encjach oznacza, że jeśli wykonamy konkretną operację na obiekcie to obiekty powiązane relacją też zostaną poddane tej operacji. Jeśli chcemy je włączyć, podajemy do argumentu cascade enum CascadeType, który przyjmuje wartości:

* `PERSIST` (INSERT) – `persist()`, czyli zapisywaniu nowego obiektu w bazie
* `MERGE`   (UPDATE) – `merge()`, czyli modyfikowaniu obiektu już istniejącego w bazie
* `REMOVE`  (DELETE) – `remove()`, czyli usuwaniu obiektu z bazy
* `DETACH`  – `detach()`, która wyrzuca dany obiekt z puli obiektów oczekujących na zapisanie w bazie
* `REFRESH` – `refresh()`, służącej do ponownego załadowywania obiektów z bazy
* `ALL` – kaskada dla wszystkich powyższych operacji

Wszystkie wytłuszczone metody należą do klasy EntityManager – interfejsu JPA służącego do komunikacji z bazą danych. Jeśli używamy JpaRepository z frameworka Spring, używa on wszystkich powyższych metod, oprócz `detach()` i `refresh()`, jednak tych również używa się w miarę potrzeby, dopisując własne metody do implementacji interfejsu. Domyślnie we wszystkich typach relacji kaskadowanie jest wyłączone

## Problemy

* Problem nieskończonej rekursji:
```java
// Movie.class
@ManyToMany
private final List<Category> categories = new ArrayList<>();
// Category.class
@ManyToMany
private final List<Movie> movies =  new ArrayList<>();
```
Rozwiązanie, dodać adnotacje `@JsonIgnore` do jednego z pól.



## Cache

Level 1 and Level 2 cache
```
       L1
-----------------     ------------------      |----|
| transaction 1 | ->  | entity manager |  ->  |    |
-----------------     ------------------      |    |
                                              | L2 |
-----------------     ------------------      |    |
| transaction 2 | ->  | entity manager |  ->  |    |
-----------------     ------------------      |----|
```
* `L1`: cache transakcji/sesji, który nie jest dzielona miedzy wątkami
* `L2`: cache ogóla, dzielona miedzy transakcjami

Cache'owanie obiektów odbywa się za pomocą adnotacji `@Cacheable / @Cache`

Strategie buforowania: 
* `ALL` : wszystkie encje niezależnie od konfiguracji (adnotacji @Cacheable) będą umieszczone w Cache L2. 
* `NONE` : żadna z encji nie trafi do bufora L2. 
* `ENABLE_SELECTIVE`: w buforze zostaną umieszczone tylko te encje które są oznaczone @Cacheable(true) lub @Cacheable 
* `DISABLE_SELECTIVE`: Buforuj wszystkie z wyjątkiem encji oznaczonych @Cacheable(false) 
* `UNSPECIFIED`: ustawienie nie określa polityki buforowania. Zostanie użyta domyślna strategia 



## Dziedziczenie

```java
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) // JOINED | TABLE_PER_CLASS
@DiscriminatorColumn(name="WEAPON_TYPE",discriminatorType=DiscriminatorType.STRING)
public abstract class Weapon  {
 
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private Long id;
         
    private String name;   
     
    // Getterki i setterki ominiete 
}
 
@Entity
@DiscriminatorValue("StingWeaponDiscValue")
public class StingWeapon extends Weapon {
 
      private int stingAttack;
 
      // Getterki i setterki ominiete
}
 
@Entity
@DiscriminatorValue("RangeWeaponDiscValue")
public class RangeWeapon extends Weapon {
 
      private int rangeAttack;
 
      // Getterki i setterki ominiete
}
```
* `SINGLE_TABLE`: 
Zostanie stworzona tylko 1 tabela łącząca wszystkie trzy klasy

| id | name  | sting_attack | range_attack |
|----|-------|--------------|--------------|
| 10 | sword |     120      |      0       |

* `JOINED`:
Zostanią stworzone trzy tabele połączone relacją

Weapon

| id | name  |
|----|-------|
| 10 | sword |

StingWeapon

| id | sting_attack |
|----|--------------|
| 10 |     120      |

RangeWeapon

| id | range_attack |
|----|--------------|
| 10 |      0       |

* `TABLE_PER_CLASS`:
Zostaną stworzone dwie tabele, odzorujące klasy

StingWeapon

| id | sting_attack | name  |
|----|--------------|-------|
| 10 |     120      | sword |

RangeWeapon

| id | range_attack | name  |
|----|--------------|-------|
| 10 |      0       | sword |

















