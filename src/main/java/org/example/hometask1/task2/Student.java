package org.example.hometask1.task2;

public class Student implements Printable{
    private String name;
    private int gradeBookNumber;
    private double averageScore;

    public void setName(String name) {
        this.name = name;
    }

    public void setGradeBookNumber(int gradeBookNumber) {
        this.gradeBookNumber = gradeBookNumber;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public String getName() {
        return this.name;
    }

    public int getGradeBookNumber() {
        return this.gradeBookNumber;
    }

    public double getAverageScore() {
        return this.averageScore;
    }

    @Override
    public void print() {
        System.out.println(this.name + ", " + this.gradeBookNumber + ", " + this.averageScore);
    }

}
