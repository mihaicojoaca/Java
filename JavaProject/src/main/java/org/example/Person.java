package org.example;

import java.util.List;

public class Person {
    String name;
    Integer age;
    Boolean passedExam;
    List<Integer> grades;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Boolean getPassedExam() {
        return passedExam;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPassedExam(Boolean passedExam) {
        this.passedExam = passedExam;
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }

    public Person(String name, Integer age, Boolean passedExam, List<Integer> grades) {
        this.name = name;
        this.age = age;
        this.passedExam = passedExam;
        this.grades = grades;
    }
}