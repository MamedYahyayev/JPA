package az.maqa.inheritance.defaultinheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "employee")
public class EmployeeInheritance extends Person {
    @Column(name = "salary")
    private double salary;

    public EmployeeInheritance() {

    }

    public EmployeeInheritance(String name, String surname, double salary) {
        super(name, surname);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
