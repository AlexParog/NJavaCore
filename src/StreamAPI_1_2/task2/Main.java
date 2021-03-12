package StreamAPI_1_2.task2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

//        System.out.println("Количество несовершеннолетних: " + printMinors(persons));
        System.out.println();
//        System.out.println(printMilitary(persons));
        System.out.println();
//        System.out.println(printWorkable(persons));


    }

    public static long printMinors(Collection<Person> persons) {
        long count = persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        return count;
    }

    public static List<String> printMilitary(Collection<Person> persons) {
        List<String> military = persons.stream()
                .filter(person -> person.getSex() == Sex.MAN)
                .filter(person -> person.getAge() >= 18 && person.getAge() <= 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        return military;
    }

    public static List<Person> printWorkable(Collection<Person> persons) {
        List<Person> worker = persons.stream()
                .filter(person -> person.getEducation() == Education.HIGHER)
                .filter(person -> (person.getSex() == Sex.WOMEN && person.getAge() >= 18 &&
                        person.getAge() <= 60) || (person.getSex() == Sex.MAN && person.getAge() >= 18 &&
                        person.getAge() <= 65))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        return worker;
    }
}
