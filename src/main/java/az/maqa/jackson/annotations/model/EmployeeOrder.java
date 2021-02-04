package az.maqa.jackson.annotations.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

@JsonPropertyOrder(value = {"surname", "age", "name", "salary"}, alphabetic = true)
@JsonRootName("employee")
public class EmployeeOrder extends JacksonPerson {

    private int age;
    private Double salary;


    public EmployeeOrder() {
    }

    public EmployeeOrder(String name, String surname) {
        super(name, surname);
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeeOrder{" +
                "age=" + age +
                ", salary=" + salary +
                '}';
    }
}
