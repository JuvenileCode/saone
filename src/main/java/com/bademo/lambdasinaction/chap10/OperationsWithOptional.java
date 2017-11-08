package com.bademo.lambdasinaction.chap10;

import java.util.*;

import static java.util.Optional.of;
import static java.util.Optional.empty;

public class OperationsWithOptional {

    public static void main(String... args) {
        System.out.println(max(of(3), of(5)));
        System.out.println(max(empty(), of(5)));

        System.out.println(maxLength(of("java"),of("python")));
        System.out.println(maxLength(of("java"),empty()));

        Optional<Integer> opt1 = of(5);
//        Optional<Integer> opt2 = opt1.or(() -> of(4));

        /*System.out.println(
                of(5).or(() -> of(4))
        );*/
    }

    public static final Optional<Integer> max(Optional<Integer> i, Optional<Integer> j) {
         return i.flatMap(a -> j.map(b -> Math.max(a, b)));
    }

    public static Optional<String> maxLength(Optional<String> sa, Optional<String> sb) {
        return sa.flatMap(a -> sb.map(b -> a.length() > b.length() ? a : b));
    }
}
