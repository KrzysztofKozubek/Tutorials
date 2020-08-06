
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
