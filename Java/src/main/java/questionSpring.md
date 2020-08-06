# PYTANIA
## SPRING
#### SPRING CONTAINER
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

#### Tworzenie bean
- konstruktor (wymagane wszystkie obiekty sa podczas tworzenia beanu)
- factory-method (wywołanie statycznej metody zwracajacej obiekt)
- factory-bean (wskazuje z ktorego bean wywołac factory-method)
- settery / pola / interfasy 

#### Scope bean
|Scope          |Wyjaśnienie                                            |
|---------------|-------------------------------------------------------|
|singleton      |1 instancja na kontener (default)                      |
|prototype      |nowa instancja za kazdym razem gdy bean jest potrzebny | 
|request        |pojedynczy bean na zapytanie HTTP                      |
|session        |pojedynczy bean na sesje HTTP                          |
|global-session |pojedynczy bean na globalna sesje HTTP                 |

#### Cykl życia bean
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

#### BeanPostProcessor
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
	
#### Autowiring
Jest to oddanie odpowiedzialności powiazań beanow springowi<BR>
Spring na podstawie beanow znajdujacych sie w beanFactory wiaże potrzebne ze saba beany 
domśynie ta opcja jest wyłaczona
inne tryby dzialania autoWiring:
- no
- byName (nazwa beanu powinna byc taka sama jak nazwa wlasnosci)
- byType (po typie)
- constructor (podobnie jak byType lecz uzywa konstruktora)
- autodetect (wybiera konstruktor lub typ)

#### ResourceLoader
```java
implements ResourceLoaderAware
    .getResource("file:data.txt");
    .getResource("classpath:classpathdata.txt");
    .getResource("file:c:/temp/filesystemdata.txt");
    .getResource("//howtodoinjava.com/readme.txt");
```

### Transakcje
Transakcja to w ogólnym ujęciu zbiór operacji, które zmieniają stan systemu (np. dane przechowywane w tabelach w przypadku baz danych lub parametry aplikacji) w kilku krokach, i tylko wykonanie wszystkich tych kroków może być uznane za sukces. Jeśli któryś z kroków się nie powiedzie, należy wycofać wszystkie zmiany dokonane w ramach transakcji.
Zakończenie transakcji powodzeniem prowadzi do tzw. commita — zapisania wszystkich zmian w ‚głównym’ stanie i udostępnienie ich innym w przyszłości. Niepowodzenie transakcji wymaga tzw. rollbacka — przywrócenia stanu sprzed transakcji, czyli anulowania wszystkich wprowadzonych do tej pory zmian.


***ACID*** to akronim od angielskich słów atomicity — consistency — isolation — durability. Są to cechy oczekiwane od każdego systemu transakcyjnego, w szczególności od baz danych.

`Atomicity` — (pol. atomowość) niepodzielność transakcji, transakcja może albo zakończyć się w całości powodzeniem albo nie. Dzięki temu mamy gwarancje, że albo wykonane zostaną wszystkie operacje, albo żadna z nich.

`Consistency` — (pol. spójność)  utrzymanie spójności w całym kontekście, jakiego dotyczy transakcja. Innymi słowy wszystkie operacje wykonywane w ramach transakcji muszą prowadzić do spójnego stanu, tzn. takiego, który można scalić z innymi zmianami i który jest zgodny z zasadami systemu.

`Isolation` — (pol. izolacja)  rozdzielenie pomiędzy transakcjami — zmiany i operacje wykonywane w jednej transakcji domyślnie nie mogą wpływać na dane i stan przetwarzany w drugiej transakcji.

`Durability` — (pol. trwałość) o ile transakcja zakończy się sukcesem, zmiana stanu, która w niej zaszła, powinna być przechowywana i stała.







