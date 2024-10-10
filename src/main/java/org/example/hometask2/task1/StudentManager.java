package org.example.hometask2.task1;

import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students;

    public StudentManager(ArrayList<Student> students) {
        this.students = students;
    }

    public StudentManager() {
        this.students = new ArrayList<>();
    };

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void removeStudent(String id) {
        // variant 1:
        // 1) найти студента по айди
        // 2) удалить студента по айди

        Student targetStudent = null;

        for (Student student : students) {
            // условные операторы если - то - иначе
            if (student.getId().equals(id)) {
                targetStudent = student;
            }
        }
        if (targetStudent != null) {
            students.remove(targetStudent);
        } else {
            System.out.println("Student with id " + id + " not found");
        }
    }
}
