import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        var ints1 = new Random()
                .ints()
                .filter(x -> Math.abs(x) < 500)
                .limit(10)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(ints1);
        var countEvent = new Random()
                .ints()
                .limit(100)
                .filter(x -> x % 2 == 0)
                .count();
        System.out.println(countEvent);

        var randSum = new Random()
                .ints()
                .limit(100)
                .reduce((sum, x) -> sum + x);
        randSum.ifPresent(System.out::println);

        new Random()
                .ints()
                .filter(x -> Math.abs(x) < 100)
                .limit(10)
                .sorted()
                .forEach(System.out::println);

        var intsMap = new Random()
                .ints()
                .filter(x -> x > 0 && x < 100)
                .distinct()
                .limit(10)
                .boxed()
                .collect(Collectors.toMap(Object::toString, x -> x * x));
        System.out.println(intsMap);


// Последнее задание


        var strings = List.of("asd", "fgjsda", "asdasdasd", "qwe", "hkerty",
                                         "zxcvbn", "zxcvbn", "bhkjawd", "piohyugb");

        var strMap = strings.stream()
                .filter(x -> x.length() > 3)
                .sorted(Comparator.reverseOrder())
                .distinct()
                .limit(3)
                .collect(Collectors.toMap(x->x.toUpperCase(Locale.ROOT), String::length));

        System.out.println(strMap);
    }
}
