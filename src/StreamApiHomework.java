import java.util.*;
import java.util.stream.*;

public class StreamApiHomework {
    private long seed =0;
/*Метод приймає на вхід список імен.
 Необхідно повернути рядок вигляду 1. Ivan, 3. Peter...
 лише з тими іменами, що стоять під непарним індексом (1, 3 тощо)*/
    public String exercise1(List<String> names){
        return IntStream.range(0, names.size())
                .filter(i->i%2==0)
                .mapToObj(i-> (i+1) + ". " + names.get(i))
                .collect(Collectors.joining(", "));
    }

    /*Метод приймає на вхід список рядків (можна взяти список із Завдання 1).
    Повертає список цих рядків у верхньому регістрі, і відсортованих за спаданням (від Z до A).
     */
    public List<String> exercise2(List<String> names) {
        return names.stream()
                .map(name -> name.toUpperCase())
                .sorted()
                .collect(Collectors.toList());

    }


    /*Є масив:

    ["1, 2, 0", "4, 5"]

    Необхідно отримати з масиву всі числа, і вивести їх у відсортованому вигляді через кому ,, наприклад:

    "0, 1, 2, 4, 5"*/
    public String exercise3(String[] array) {
        return Arrays.stream(array)
                .flatMap(s -> Arrays.stream(s.split(", ")))
                .map(Integer::parseInt)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

    }

    public Stream<Long> exercise4(){

        long a = 25214903917L;
        int c =11;
        long m = (long) Math.pow(2,48);
        Stream<Long> iterate = Stream.iterate(seed, x -> ((a * x + c) % m))
                .limit(100);//необхідно закоментувати щоб був безкінечний потік
        return iterate;
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> iterator1 = first.iterator();
        Iterator<T> iterator2 = second.iterator();

        Iterator<T> zippedIterator = new Iterator<>() {
            private boolean toggle = false;

            @Override
            public boolean hasNext() {
                return iterator1.hasNext() && iterator2.hasNext();
            }

            @Override
            public T next() {
                toggle = !toggle;
                return toggle ? iterator1.next() : iterator2.next();
            }
        };

        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(zippedIterator, Spliterator.ORDERED),
                false
        );
    }
}
