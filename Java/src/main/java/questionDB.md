## BAZY DANYCH
#### Co to jest tablica asocjacyjna? 
Przechowuje relacje wiele-do-wielu

#### Jak zsumować płace wg. działów. Masz tablicę z listą pracowników z wynagrodzeniami i przypisanym działem.
TL DR; Trzeba zrobić Group BY po kolumnie z działami.

#### [ORACLE DB] Jak policzyć ilość wierszy zwracanych przez zapytanie?
- Standardowo ```count(*)```, ale można szybciej: 
- ```count(1);``` działa zdecydowanie szybciej, bo nie wyciąga wiersza za każdym razem

#### Co to jest Primary key
Są to attrybyty identyfikace dany rekord w sposób jednoznaczny.
Taki klucz nie może przyjmować wartości null (wyjątek non clustered).
Taki klucz może być tylko 1 na tabele.
Może on być użyty na dowolną kolumnę lub wiele kolumn.
Często tworzy się nowa kolumnę która jest samouzupelniana przez bazę danych w celu zapewnienia unikalności.

#### Omów Unique index
Indeks można założyć na jedną lub więcej kolumn.
Unique informuje nas o tym że dane wartości się nie powtórzą w tabeli.

#### Czym się różnią Clustered Index i Non Clustered index
#### Kiedy używać indeksów w bazie danych a kiedy nie powinno się?
Używać gdy wyszukujemy, łączymy relacja daną kolumnę.

#### Kiedy indeksy przyspieszają działanie bazy, a kiedy spowalniają?
Przyspieszają jak dobrze się ich używa.

Spowalniają gdy zakładamy indeksy na wszystkich kolumnach a wyszukujemy zawsze po jednej.

#### Omów SQL: INNER JOIN, OUTER JOIN, HAVING, GROUP BY, ORDER BY
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