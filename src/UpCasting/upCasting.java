package UpCasting;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class upCasting {
    interface Person { // 슈퍼클래스

        String calculator();
    }

    static class Student implements Person { // 서브클래스
        String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        @Override
        public String calculator() {
            return "Student";
        }
    }

    static class Teacher implements Person {
        String name;

        public Teacher(String name) {
            this.name = name;
        }

        @Override
        public String calculator() {
            return "Teacher";
        }
    }

    static List<Person> find(Predicate<Person> predicate, List<Person> list) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Person> b = new ArrayList<>();

        b.add(new Student("짱구"));
        b.add(new Student("철수"));
        b.add(new Teacher("맹구"));
        b.add(new Teacher("유리"));

        Predicate<Person> predicate = tp -> tp.calculator().equals("Student");

        List<Person> a = find(predicate, b);

        System.out.println(a.size());
    }
}
