package com.example.java8Golovach.lesson5;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Example01 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alex", Speciality.Physics, 1),
                new Student("Rika", Speciality.Biology, 4),
                new Student("Julia", Speciality.Biology, 2),
                new Student("Steve", Speciality.History, 4),
                new Student("Mike", Speciality.Finance, 1),
                new Student("Hinata", Speciality.Biology, 2),
                new Student("Richard", Speciality.History, 1),
                new Student("Kate", Speciality.Psychology, 2),
                new Student("Sergey", Speciality.ComputerScience, 4),
                new Student("Maximilian", Speciality.ComputerScience, 3),
                new Student("Tim", Speciality.ComputerScience, 5),
                new Student("Ann", Speciality.Psychology, 1)
        );
//Нужно сгруппировать всех студентов по курсу.
        students.stream()
                .collect(Collectors.groupingBy(Student::getYear)).entrySet().forEach(System.out::println);



//Вывести в алфавитном порядке список специальностей, на которых учатся перечисленные в списке студенты.

        students.stream()
                .map(s -> s.getSpeciality())
                .distinct()
                .sorted(Comparator.comparing(Enum::name))
                .forEach(System.out::println);

//Вывести количество учащихся на каждой из специальностей.

        students.stream()
                .collect(Collectors.groupingBy(Student::getSpeciality, Collectors.counting()))
                .entrySet().forEach(System.out::println);

//Сгруппировать студентов по специальностям, сохраняя алфавитный порядок специальности, а затем сгруппировать по курсу.

        students.stream()
                .sorted(Comparator.comparing(Student::getSpeciality, Comparator.comparing(Enum::name)))
                .collect(Collectors.groupingBy(Student::getSpeciality,
                        LinkedHashMap::new,
                        Collectors.groupingBy(Student::getYear)))
        .entrySet().forEach(System.out::println);

        //Проверить, есть ли третьекурсники среди учащихся всех специальностей кроме физики и CS.
        boolean b = students.stream()
                .filter(s -> !EnumSet.of(Speciality.Physics, Speciality.ComputerScience).contains(s.getSpeciality()))
                .anyMatch(s -> s.getYear() == 3);

        System.out.println(b);


//
//        IntStream.range(5, 30).limit(12).skip(3).limit(6).skip(2).forEach(System.out::println);
//
//        IntStream.range(1,5).flatMap(i -> IntStream.generate(() -> i).limit(i)).forEach(System.out:: println);
//
//        // 1, 2, 2, 3, 3, 3, 4, 4, 4, 4

//        int x = IntStream.range(-2,2).map(i->i*5).reduce(10, Integer::sum);
//        System.out.println(x);
//        // x: 0

//        IntStream.range(0,10).boxed().collect(Collectors.partitioningBy(i -> i % 2 == 0))
//                .entrySet().forEach(System.out::println);

//        IntStream.range(-5,0).flatMap(i->IntStream.of(i, -i)).sorted().forEach(System.out::println);

//        IntStream.range(-5, 0).flatMap(i -> IntStream.of(i, -i)).boxed().sorted(Comparator.comparing(Math::abs))
//                .forEach(System.out::println);

        IntStream.range(1, 5).flatMap(i -> IntStream.generate(()->i).limit(i)).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().forEach(System.out::println);

    }
}

class Student{
    private String name;
    private Speciality speciality;
    private Integer year;

    public Student(String name, Speciality speciality, Integer year) {
        this.name = name;
        this.speciality = speciality;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (speciality != null ? !speciality.equals(student.speciality) : student.speciality != null) return false;
        return year != null ? year.equals(student.year) : student.year == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (speciality != null ? speciality.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name + ": " + speciality.name() + " " + year;
    }
}
enum Speciality{
    Biology, ComputerScience, Economics, Finance, History, Philosophy, Physics, Psychology;
}
