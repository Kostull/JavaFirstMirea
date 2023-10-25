package ru.mirea.task9;

import java.util.Comparator;

class Student {
    private String name;
    private int gpa;

    public Student(String name, int gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public int getGpa() {
        return gpa;
    }
}

class SortingStudentsByGPA implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        if (student1.getGpa() < student2.getGpa()) {
            return 1;
        } else if (student1.getGpa() > student2.getGpa()) {
            return -1;
        } else {
            return 0;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Student[] students = {
                new Student("Алексей", 87),
                new Student("Ирина", 95),
                new Student("Дмитрий", 75),
                new Student("Елена", 99),
                new Student("Мария", 80)
        };

        java.util.Arrays.sort(students, new SortingStudentsByGPA());

        System.out.println("Список студентов, отсортированный по убыванию баллов:");
        for (Student student : students) {
            System.out.println("Имя: " + student.getName() + ", Итоговый балл: " + student.getGpa());
        }
    }
}
