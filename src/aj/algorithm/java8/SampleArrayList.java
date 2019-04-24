package aj.algorithm.java8;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SampleArrayList {
    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<Integer>(10);
//
//        IntStream.range(0,10).forEach(i -> list.add(i, Integer.MAX_VALUE));
//        list.stream().forEach(System.out::println);
//        list.stream().map(item -> item -1).forEach(System.out::println);
//        list.stream().forEach(System.out::println);
//
        IntStream.range(0,10).map(i -> Integer.MAX_VALUE).forEach(System.out::println);
    }
}
