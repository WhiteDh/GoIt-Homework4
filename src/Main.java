import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StreamApiHomework streamApiHomework = new StreamApiHomework();


        List<String> names = List.of("Dima", "Andriy", "Vitaliy", "Bogdan", "Gleb", "Yan");


        System.out.println(streamApiHomework.exercise1(names));


        System.out.println(streamApiHomework.exercise2(names));


        System.out.println(streamApiHomework.exercise3(new String[] {"1, 2, 3", "11, 15, 8, 22"}));


        streamApiHomework.exercise4().forEach(System.out::println);


        //ех 5
        Stream<String> first = Stream.of("1", "2", "3");
        Stream<String> second = Stream.of("1", "2", "3", "4");

        Stream<String> zippedStream = streamApiHomework.zip(first, second);
        zippedStream.forEach(System.out::println);


    }
}