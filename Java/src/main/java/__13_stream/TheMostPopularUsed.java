package __13_stream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.regex.Pattern;
import java.util.stream.*;
import java.util.function.Supplier;

public class TheMostPopularUsed {

    private void createStream() {
        // collection
        Stream<Integer> stream1 = new LinkedList<Integer>().stream();
        // array
        Stream<Integer> stream2 = Arrays.stream(new Integer[]{});
        // regular expression
        Stream<String> stream3 = Pattern.compile(".").splitAsStream("some longer sentence");
        // primitive
        DoubleStream doubles = DoubleStream.of(1, 2, 3);
        IntStream ints = IntStream.range(0, 123);
        LongStream longs = LongStream.generate(() -> 1L);
        // random data
        DoubleStream randomDoubles = new Random().doubles();
        IntStream randomInts = new Random().ints();
        LongStream randomLongs = new Random().longs();
        // empty stream
        Stream.empty();
        // file stream
        try (Stream<String> lines = new BufferedReader(new FileReader("file.txt")).lines()) {
            // do something
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /* Operation on stream
    *
    * filter - return stream with objects where filter return true
    * map - return stream with medicated objects in this function
    * peek - return stream with the same objects what accepted
    * limit - return stream with limited objects
    *
    * */

    /* End stream
    *
    * forEach - do operation for each one object
    * count - return number of objects in stream
    * allMatch - return information that all objects fulfills the conditions
    * collect - return object in new type of collection
    *
    * */

    /* Stream are:
    *
    * - lazy
    * - can process sequential and parallel (parallelStream)
    *
    * */

    private void createObject() {
        /* create primitive variable */
        int[] ints = IntStream.of(1, 2, 3).toArray();
        IntStream.range(1, 3).toArray();
        IntStream.rangeClosed(1, 3).toArray();

        IntStream.iterate(1, i -> i + 1).limit(3).toArray();
        IntStream.generate(() -> ThreadLocalRandom.current().nextInt(3) + 1).limit(3).toArray();

        /* create object */
        Supplier<Object> supplier = () -> new Object();
        Stream<Integer> stream = Arrays.stream(new Integer[]{1, 2});

        stream.collect(Collectors.toCollection(LinkedHashSet::new));
        stream.collect(Collectors.groupingBy(Object::getClass));
    }

    private void medicateObject() {
        Stream<POJO> stream = Stream.of(new POJO("A", 1L), new POJO("B", 2L), new POJO("C", 3L));

        stream.map(POJO::getType)
                .peek(System.out::print) //nothing change
                .map((p) -> p.split(" "))
                .filter(p -> p.length > 0)
                .map(p -> p[0])
                .peek(System.out::print) //nothing change
                .collect(Collectors.toList());

    }

    public static void main(String[] args) {
        new TheMostPopularUsed().createObject();
        new TheMostPopularUsed().medicateObject();
    }
}

class POJO {
    private String type;
    private Long age;

    POJO(String type, Long age) {
        this.type = type;
        this.age = age;
    }

    String getType() {
        return type;
    }

    public Long getAge() {
        return age;
    }
}
