package az.maqa.inheritance.defaultinheritance.annotation;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "employee")
public class EmployeeAnnotation extends PersonAnnotation {

    @Column(columnDefinition = "DECIMAL(7,2)")
    private double salary;

    public EmployeeAnnotation() {
    }

    public EmployeeAnnotation(String name, String surname, double salary) {
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
