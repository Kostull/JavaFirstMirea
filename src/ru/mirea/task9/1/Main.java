package ru.mirea.task9;

class Student implements Comparable<Student> {
    private int iDNumber;
    private String name;

    public Student(int iDNumber, String name) {
        this.iDNumber = iDNumber;
        this.name = name;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.iDNumber, other.iDNumber);
    }

    @Override
    public String toString() {
        return "Student{" +
                "iDNumber=" + iDNumber +
                ", name='" + name + '\'' +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Student[] students = {
                new Student(3, "Алиса"),
                new Student(1, "Александр"),
                new Student(5, "Мария"),
                new Student(2, "Евгений"),
                new Student(4, "Иван")
        };

        System.out.println("Неотсортированный массив:");
        printStudents(students);

        insertionSort(students);

        System.out.println("\nОтсортированный массив:");
        printStudents(students);
    }

    public static void insertionSort(Student[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Student currentStudent = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareTo(currentStudent) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = currentStudent;
        }
    }

    public static void printStudents(Student[] arr) {
        for (Student student : arr) {
            System.out.println(student);
        }
    }
}
