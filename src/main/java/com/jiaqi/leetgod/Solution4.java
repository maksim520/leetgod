package com.jiaqi.leetgod;

import java.util.*;

public class Solution4 {
    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(2, 10, 170));
        list.add(new Person(1, 12, 180));
        list.add(new Person(1, 10, 170));
        list.add(new Person(6, 12, 180));
        list.add(new Person(2, 12, 175));
        System.out.println(list);

        System.out.println("-----------------");
        List<Person> returnValue = filter(list);
        returnValue.forEach(x -> System.out.println(x));
    }

    public static List<Person> filter(List<Person> list) {
        Map<Integer, PriorityQueue<Person>> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            Person person = list.get(i);
            PriorityQueue<Person> temp = map.get(person.getAge());
            if (temp == null) {
                temp = new PriorityQueue<>((o1, o2) -> {
                    if (o1.getHeight() - o2.getHeight() < 0) {
                        return 1;
                    } else if (o1.getHeight() - o2.getHeight() == 0) {
                        return -(o1.getId() - o2.getId());
                    } else {
                        return -1;
                    }
                });
            }
            temp.add(person);
            map.put(person.getAge(), temp);
        }
        List<Person> returnList = new ArrayList<>();
        map.entrySet().forEach(x -> returnList.add(x.getValue().poll()));

        return returnList;
    }
}
