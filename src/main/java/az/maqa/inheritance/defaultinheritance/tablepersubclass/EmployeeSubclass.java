package az.maqa.inheritance.defaultinheritance.tablepersubclass;

import javax.persistence.*;

@Entity
@Table(name = "employee_subclass")
@PrimaryKeyJoinColumn(name = "person_id")
public class EmployeeSubclass extends PersonSubclass {
    @Column(name = "salary")
    private double salary;

    public EmployeeSubclass() {

    }

    public EmployeeSubclass(String name, String surname, double salary) {
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
