# PYTANIA
## SPRING
### SPRING CONTAINER
Kontener spring należy do modułu core spring.<BR>
Odpowiada za tworzenie obiektów, wiązanie ich, konfigurowanie, jak również zarządznie ich czasem życia.<BR>
Kontener używa dependency injection (DI) do zarządzania app.

spring ma 2 typy kontenerów:
- BeanFactory
- ApplicationContext

`BeanFactory` pozwala na czytanie definicji beanów z xml jak również wyciąganie ich z bean factory.

`BeanFactory` ma tylko 6 metod:
- boolean containsBean(String)
- Object getBean(String)
- Object getBean(String, Class)
- Class getType(String name)
- boolean isSingleton(String)
- String[] getAliases(String) all alias name bean

`ApplicationContext` zawiera wszystkie funkcjonalności co `BF` i jest zalecanym kontenerem.

Najbardziej popularnymi implementacjami sa:
- FileSystemXmlApplicationContext - def z xml (full path) 
- ClassPathXmlApplicationContext - def z xml 
- WebXmlApplicationContext - def z xml 
```java
ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
ApplicationContext context = new FileSystemXmlApplicationContext("bean.xml");
XmlWebApplicationContext
```

jest bardzo podobna na 1 rzut oka do BF ale zapewnie dodatkowo:
- tworzenie instancji/dowiazan
- automatyczne beanPostProcessor 
- automatyczne beanFactoryPostProcessor 
- wygodny MessageSource access (i18n)
- publikacja ApplicationEvent

`IoC`
Odwrócenie Sterowania to paradygmat programowania polegający na zamianie odpowiedzialności pewnych części aplikacji.
Mówiąc jaśniej, w klasycznie napisanej aplikacji to kod programisty wywołuje funkcje z zewnętrznych bibliotek. 
Natomiast gdy zastosowane jest IoC, to zewnętrzny framework wywołuje kod programisty w odpowiednich momentach. 

**Wady i zalety**

`IoC` ma kilka wad, które powinny być brane przed skorzystaniem z tego modelu.

- kod zaczyna być rozproszony co może prowadzić do jego znacznego rozdrobnienia.
- tracimy kontrolę nad wywoływanymi metodami - wywołujemy interfejsy. Może to doprowadzić do nieprzewidzianych sytuacji gdy chcemy np. rzutować obiekt (a korzystamy z obiektu Proxy).
- wszystkie wady związane ze wstrzykiwaniem zależności.

- Wymusza organizację kodu w małe klasy o dobrze określonych zadaniach.
- Ułatwia tworzenie luźno powiązanego kodu.
- Ułatwia tworzenie kodu łatwego w testowaniu. Promuje metodyki zwinne oparte o TDD.

`DI` Wstrzykiwanie Zależności
jest to wzorzec projektowy. 
`DI` jest formą `IoC`, w której implementacje są przekazywane do obiektu za pomocą konstruktorów / setterów / wyszukiwania usług, na których obiekt „zależy”, aby zachowywać się poprawnie.

Głównym założeniem jest przeniesienie tworzenia obiektów oraz wiązania ich między sobą poza kod aplikacji. 
Obiekty tworzy i wiąże osobna biblioteka nazywana kontener DI. 
Kontener w celu powiązania obiektów posługuje się konfiguracją, która określa jak obiekty powinny być powiązane.

1. definujemy tworzenia obiektu
2. tworznie obiektu za pomocą definicji, która została mu przedstawiona w xml (settery, konstruktor, interfejsy)

**zalety i wady**
pozwala na tworzenie kodu o luźniejszych powiązaniach, łatwiejszego w testowaniu i modyfikacji

### Tworzenie bean
- konstruktor (wymagane wszystkie obiekty sa podczas tworzenia beanu)
- factory-method (wywołanie statycznej metody zwracajacej obiekt)
- factory-bean (wskazuje z ktorego bean wywołac factory-method)
- settery / pola / interfasy 

### Scope bean
|Scope          |Wyjaśnienie                                            |
|---------------|-------------------------------------------------------|
|singleton      |1 instancja na kontener (default)                      |
|prototype      |nowa instancja za kazdym razem gdy bean jest potrzebny | 
|request        |pojedynczy bean na zapytanie HTTP                      |
|session        |pojedynczy bean na sesje HTTP                          |
|global-session |pojedynczy bean na globalna sesje HTTP                 |

### Cykl życia bean
spring bean factory jest odpowiedzialny za zarzadzaniem zycia beanow. 
zycie beanow sklada sie z call back metod ktore mozna podzielic na:

|Type               |Adnotation     |Method   |Interface                            |
|-------------------|---------------|---------|-------------------------------------|
|Post initialization|@PostConstruct |init()   |InitializingBean afterPropertiesSet()|
|pre destruction 	|@PreDestroy 	|destroy()|DisposableBean destroy()             |

- instanition 
- populate properties 
- BeanNameAware's setBeanName() 
- BeanFactoryAware's setBeanFactory() 
- Pre-initialization BeanPostProcessors 
- InitialzingBeans's afterPropertiesSet() 
- Call custiom init()
- Post-initialization BeanPostProcessors 
- ready to use

CONTAINER IS SHUTDOWN
- DisposableBean's destroy() 
- Call custom destroy-method

### BeanPostProcessor
implements BeanPostProcessor
postProcessBeforeInitialization(Object bean, String beanName)
postProcessAfterInitialization(Object bean, String beanName)

Typically spring’s DI container does following things to create a bean, you request for:
	Create the bean instance either by a constructor or by a factory method
	Set the values and bean references to the bean properties
	Call the setter methods defined in the all the aware interfaces
	Pass the bean instance to the postProcessBeforeInitialization() method of each bean post processor
	Call the initialization callback methods
	Pass the bean instance to the postProcessAfterInitialization() method of each bean post processor
	The bean is ready to be used
	When the container is shut down, call the destruction callback methods
	
### Autowiring
Jest to oddanie odpowiedzialności powiazań beanow springowi<BR>
Spring na podstawie beanow znajdujacych sie w beanFactory wiaże potrzebne ze saba beany 
domśynie ta opcja jest wyłaczona
inne tryby dzialania autoWiring:
- no
- byName (nazwa beanu powinna byc taka sama jak nazwa wlasnosci)
- byType (po typie)
- constructor (podobnie jak byType lecz uzywa konstruktora)
- autodetect (wybiera konstruktor lub typ)

### ResourceLoader
```java
implements ResourceLoaderAware
    .getResource("file:data.txt");
    .getResource("classpath:classpathdata.txt");
    .getResource("file:c:/temp/filesystemdata.txt");
    .getResource("//howtodoinjava.com/readme.txt");
```

### [Transakcje](https://bottega.com.pl/pdf/materialy/receptury/tx.pdf)
Transakcja to w ogólnym ujęciu zbiór operacji, które zmieniają stan systemu (np. dane przechowywane w tabelach w przypadku baz danych lub parametry aplikacji) w kilku krokach, i tylko wykonanie wszystkich tych kroków może być uznane za sukces. Jeśli któryś z kroków się nie powiedzie, należy wycofać wszystkie zmiany dokonane w ramach transakcji.
Zakończenie transakcji powodzeniem prowadzi do tzw. `commita` — zapisania wszystkich zmian w ‚głównym’ stanie i udostępnienie ich innym w przyszłości. Niepowodzenie transakcji wymaga tzw. `rollbacka` — przywrócenia stanu sprzed transakcji, czyli anulowania wszystkich wprowadzonych do tej pory zmian.

W springu transakcje oznacza się adnotacja `@Transactional`. [link to doc](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/transaction/annotation/Propagation.html#REQUIRED)
Interfejs posiada pola:
- propagation (metoda propagacji transakcji domysnie REQUIRED: wspiera istniejącą lub tworzy nową)
- isolation (sposób izolacji transakcji)
- timeout (czas kiedy transakcja ma być zabita jeśli się nie wykona w czasie)
- readOnly (informuje że transakcja tylko do odczytu - wpływa na wydajność)
- rollbackFor (klasy, powodujące wycofanie transakcji - muszą dziedziczyć po Throwable)
- noRollbackFor (klasy, które zostaną zignorowane i nie wycofają transakcji)

Transakcje są wycofywane tylko przez `RuntimeException`.

#### ACID 
to akronim od angielskich słów `atomicity` — `consistency` — `isolation` — `durability`. Są to cechy oczekiwane od każdego systemu transakcyjnego.

`Atomicity` — (pol. atomowość) wszystkie operacje w danej transakcji zostaną wykonane jako spójna jednostka zmiany lub nie zostaną wykonanie w ogóle.

`Consistency` — (pol. spójność) transakcja zmieni dane z jednego spójnego stanu w inny spójny stan (respektując constrains), nie naruszając integralności

`Isolation` — (pol. izolacja) współbieżne transakcje nie oddziaływają między sobą – w jakim stopniu, to zależy od poziomu izolacji

`Durability` — (pol. trwałość)  transakcja zatwierdzona pozostawia trwałe zmiany odporne na późniejsze usterki bazy danych

### Anomalie
W przypadku, gdy dwie transakcje T1 i T2 operują na wspólnych danych,
możemy spodziewać się różnych anomalii w spójności danych:
- `dirty read` – T1 odczytuje dane zmienione przez T2, nawet gdy w
późniejszym czasie T2 jest wycofana. W efekcie T1 „widzi” nieistniejące
dane
- `lost update` - T1 i T2 czyta dane, następnie T1 modyfikuje zmiany a 
kolejnie T2 modyfikuje te same dane. Modyfikacja T1 jest niewidoczna
- `unrepeatable read` – T1 wykonuje kilkukrotnie to samo zapytanie, ale
otrzymuje inne dane (w sensie taka sama ilość wierszy, ale inne wartości
w wierszach). Dzieje się to z powodu tego, że T2 modyfikuje te dane
- `phantoms` - T1 wykonuje kilkukrotnie to samo zapytanie, ale otrzymuje
inną ilość danych (w sensie innej ilości wierszy). Dzieje się to z powodu
tego, że T2 modyfikuje te dane.

### Poziomy izolacji
Z powodu powyższych anomalii chcemy sterować poziomami izolacji transakcji
T1 i T2, które wykonują się współbieżnie:
- `read_uncommited` – niezatwierdzone przez T1 zmiany są widoczne w T2,
występują wówczas anomalie: dirty-reads, non-repeatable-reads,
phantoms
- `read_commited` – zmiany poczynione przez T1 są widoczne dopiero po jej
zatwierdzeniu (commit), występują wówczas anomalie: non-repetablereads, phantoms
- `repeatable_read` – pobrane dane są blokowane, więc kolejne odczyty
zwracają te same dane, możliwe anomalie: phantoms
- `serializable` – transakcje serializowane, nie występują żadne anomalie.

Domyślny poziom izolacji zależy od konkretnej bazy danych. Oczywiście im
większy poziom izolacji, tym większy koszt.

| Poziom izolacji   |  dirty read   | unrepeatable read | phantoms  |   
| ----------------- | ------------- | ----------------- | --------- |
| READ UNCOMMITTED  |       ✓       |         ✓         |      ✓    | 
| READ COMMITED     |       x       |         ✓         |      ✓    | 
| REPEATABLE READ   |       x       |         x         |      ✓    | 
| SERIALIZABLE      |       x       |         x         |      x    | 
| SNAPSHOT          |       x       |         x         |      x    |


#### SERIALIZABLE vs SNAPSHOT
`SERIALIZABLE` - blokuje wiersze, aż do momentu zakończenia transakcji.<BR>
`SNAPSHOT` - wykorzystuje technologie wersjonowania wierszy

### Propagacja transakcji 
Jest to zachowanie transakcji w przypadku wywołania metody wewnątrz innej transakcji (np. Klasa A metoda a wywoluje bean klasy B metody b).
- `REQUIRED` Jest to domyślna polityka, która zakłada, że jeżeli metoda rozpoczyna transakcję, to musi również ją zakończyć (commit/rollback). Jeżeli transakcja nie istnieje, to wówczas jest tworzona. Baza danych posiada własną fizyczną transakcję a Spring logiczną.
- `REQUIRES_NEW` Polityka, która wymusza założenie osobnej transakcji fizycznej. Jeżeli transakcja istnieje, to jest zawieszana
```java
@Service
public class OuterService{
 @Autowired
 private MyDAO myDAO;
 @Autowired
 private InnerService innerService;
 @Transactional(propagation=Propagation.REQUIRED)
 public void testRequired(User user) {
 myDAO.insertUser(user);
 try{
     innerService.doRequiresNew();
 } catch(RuntimeException e){
 // handle exception
 }
 /*wyjątek unchecked wycofa transakcję wewnętrzną, ale ponieważ jest
przechwycony, to nie wpłynie na transakcję zewnętrzną.*/
 }
}

@Service
public class InnerService{
 @Transactional(propagation=Propagation.REQUIRES_NEW)
 public void doRequiresNew() {
     throw new RuntimeException("Rollback this transaction!");
 }
}

```
Wywołując metody z propagacją `REQUIRES_NEW`, zawsze stworzona zostanie
nowa transakcja.
Jeżeli używamy JPA, to pracujemy z nową instancją EntityManager, czyli mamy do
czynienia z nowym, osobnym cache pierwszego poziomu (L1 cache).

- `NESTED` Polityka wymusza jedną transakcję fizyczną i savepoints na poziomie bazy danych. Zatwierdzenie (commit) następuje na końcu metody rozpoczynającej transakcję. Wyjątek metody wewnętrznej wycofuje pod-transakcję do poprzedniego savepoint. Zewnętrzna metoda może kontynuować pomimo wycofania (rollback) wewnętrznej.
<br>Zastosowanie do długich procesów (np. import dużych sekcji danych), gdzie pewne ścieżki mogą się nie powieść i wówczas chcemy się z tej ścieżki wycofać, aby pójść inną.

- `SUPPORTS` Metoda o takiej polityce może działać bez kontekstu transakcji. Ale jeżeli kontekst istnieje, to jest do niego dołączana. Skutkuje to widocznością kontekstu persystencji (Session/Entitymanager) stworzonego wcześniej. 
<BR>Idealna propagacja do metod odczytujących dane. Taka metoda może być wołana bez transakcji, lub wewnątrz już istniejącej. W drugim przypadku metoda odczytująca „widzi” dane zapisane (jeszcze bez commit) przez metodę nadrzędną

- `NOT_SUPPORTED` Na czas wywołania metody o takiej polityce propagacji zawieszana jest istniejąca transakcja. Skutkuje to brakiem widoczności zasobów takich jak EntityManager.
<BR>Polityka ta jest odpowiednia w przypadku wywołania procedur bazodanowych, które same zarządzają transakcjami - a łącznie (chaining) nie jest wspierane przez bazę danych.

- `MANDATORY` Metoda o tej polityce propagacji dołącza się do istniejącego kontekstu transakcji, a jeżeli takowy nie istnieje, to dostajemy wyjątek.
<BR>Możemy przyjąć ziarniste API i strategię zarządzania transakcjami przez kod kliencki (patrz rozdział „Strategie transakcji”). Metoda nie wywoła się, jeżeli wcześniej kod kliencki nie rozpoczął transakcji.

- `NEVER` Wywołując metodę o tej polityce, dostaniemy wyjątek, gdy transakcja już istnieje.



### Dynamiczne proxy:
Porxy czyli pośrednik. Może on posiadać trzy role:
* filtrowanie (filtrowanie nieautoryzowanych rządań)
* zapamiętywanie odpowiedzi (zwracanie pliki wcześniej rządanego)
* load balancer (rozkładanie ruchu sieciowego na gr. serwerów)

Jest to przechwycenie wywołania metody na danym obiekcie i udekorowanie go.

Zastosowanie:
* logger (logowanie wywołanych metod)
* zmiana zachowania zamknietego kodu (zmiana działania metod w bibliotece)

```
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyApp {
    public static void main(String[] args) {
        System.out.println("Without proxy:");
        System.out.println("---------------------");
        Car car = new CarImpl();
        car.runEngine("Driver");
        System.out.println("---------------------");
        System.out.println("\nWith proxy:");
        System.out.println("---------------------");
        Car carProxy = (Car) Proxy.newProxyInstance(Car.class.getClassLoader(),
                new Class[]{Car.class},
                new CarInvocationHandler(new CarImpl()));
        carProxy.runEngine("Driver");
        System.out.println("---------------------");
    }
    interface Car {
        void runEngine(String message);
    }
    static class CarImpl implements Car {
        @Override
        public void runEngine(String who) {
            System.out.println(String.format("Engine is running. [%s] run it.", who));
        }
    }
    static class CarInvocationHandler implements InvocationHandler {
        private final Object original;
        CarInvocationHandler(Object original) {
            this.original = original;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            try {
                System.out.println(String.format(">> before method: [%s]", method.getName()));
                return method.invoke(original, args);
            } finally {
                System.out.println(String.format("<< after method: [%s]", method.getName()));
            }
        }
    }
}
```

### Programowanie aspektowe:
Programowanie zorientowane aspektowo to sposób programowania, który pozwala oddzielić pewne fragmenty kodu od siebie, poprawiając dzięki temu modularność tworzonego programu.</BR>
Można na to spojrzeć tak, że programowanie aspektowe pozwala wprowadzić dodatkową warstwę do kodu, który tworzymy i zwykle ta warstwa jest wyraźnie odseparowana od właściwego kodu.


#### Jak działają aspekty?

Aspekty działają poprzez dodanie klasy `proxy` do właściwego wywołania metody z danej klasy.

Normalne wywołanie metody z osobnej klasy wygląda mniej więcej tak:
```java 
klasa klienta -> klasa właściwa
```
Mechanizm AOP dodaje pomiędzy klasą klienta a klasą właściwą dodatkową klasę `proxy`. Tak wygląda to w uruchomionej aplikacji (runtime):
```java 
klasa klienta -> klasa proxy -> klasa właściwa
```
#### Jak uruchomić 

Dodać dependencje: `org.springframework.boot:spring-boot-starter-aop`

Do głównej klasy uruchomieniowej dodać: `@EnableAspectJAutoProxy(proxyTargetClass=true)`

Parametr `proxyTargetClass=true` odpowiada za to, że mechanizm AOP będzie mógł utworzyć klasę proxy dla klasy. Domyślnie AOP w Springu tworzy proxy korzystając z mechanizmu `JDK dynamic proxies`. Mechanizm ten tworzy proxy na podstawie interfejsu. Jeśli nie chcesz tworzyć dodatkowo interfejsu wystarczy, że ustawisz `proxyTargetClass=true`. Dzięki temu ustawieniu Spring AOP tworzy klasę proxy z użyciem biblioteki `CGLIB`.

#### Jak korzystać

Mamy jakiś dowolny komponent. Może to być klasa oznaczona adnotacją `@Component`, `@Service`, `@Controller`, `@Repository` (ogólnie bean springowy).

```java
package path.to.class; 

@Componet
class MyClass {
  public void do() {
    //impl
  }
}
```

```java
@Aspect
@Component
public class LoggingAspect {
 
  @Around("execution(* path.to.class..*(..))")
  public Object doSomethingAdice(ProceedingJoinPoint joinPoint) throws Throwable {
    System.out.println(":: start ::");
    Object proceed = joinPoint.proceed();
    System.out.println(":: end ::");
    return proceed;
  }
}
```
Nazewnictwo:
* Pointcut: `execution(* path.to.class..*(..))`
* Advice : `ProceedingJoinPoint joinPoint`


#### Kiedy użyć:
* wiciągniecie technicznego kodu (tranzakcje)
* logger

