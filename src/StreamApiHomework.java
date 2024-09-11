import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second){
        int min;

        List<T> firstList = new ArrayList<>();
        List<T> secondList = new ArrayList<>();

        first.forEach(firstList::add);
        second.forEach(secondList::add);

        if(first.count()<second.count()) min = (int) first.count();
        else min =(int) second.count();


        return IntStream.range(0, min)
                .mapToObj(i -> Stream.of(firstList.get(i), secondList.get(i)))
                .flatMap(s -> s);
    }

}
