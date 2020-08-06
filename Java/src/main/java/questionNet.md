
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
