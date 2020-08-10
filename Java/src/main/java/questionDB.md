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

