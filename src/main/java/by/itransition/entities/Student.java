package by.itransition.entities;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    private Job job;

    public Student() {

    }

    public Student (String name, String lastName) {
        this.firstName = name;
        this.lastName = lastName;
    }

    public Student (String name, String lastName, int age) {
        this.firstName = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Student (int id, String name, String lastName) {
        this.id = id;
        this.firstName = name;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", job=" + job +
                '}';
    }
}
