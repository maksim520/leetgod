package com.jiaqi.leetgod;

import java.util.*;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

/**
 * stream对对象某一属性去重
 */
public class StreamDeduplicationTest {
    public static void main(String[] args) {
        Person p1 = new Person(1,22,19);
        Person p2 = new Person(2,22,20);
        Person p3 = new Person(3,22,28);
        Person p4 = new Person(4,34,15);
        Person p5 = new Person(5,45,5);
        Person p6 = new Person(6,3,3);

        List<Person> personList = Arrays.asList(p1,p2,p3,p4,p5,p6);
        ArrayList<Person> collect1 = personList.stream().collect(
                // 将集合先放到 treeSet 集合然后将他们转换成数组
                collectingAndThen(
                        toCollection(() -> new TreeSet<>(Comparator.comparing(o -> o.getAge())))
                        , ArrayList::new));
        collect1.forEach(System.out::println);
    }
}
