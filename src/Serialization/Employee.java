package Serialization;

import java.io.Serializable;

/**
 * Created by NISHANT on 4/24/18.
 */
public class Employee implements Serializable{

    private static final long serialVersionUID = -299482035708790407L;

    private String name;
    private String gender;
    private int age;

    // private transient String role;
    // If we don’t want some object property to be converted to stream, we have to use transient keyword for that.
    private String role;

    public Employee(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", role='" + role + '\'' +
                '}';
    }
}
