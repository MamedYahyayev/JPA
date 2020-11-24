package az.maqa.inheritance.defaultinheritance.tableperconcrete;

import javax.persistence.*;

@Entity
@Table(name = "employee_concrete")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id")),
        @AttributeOverride(name = "name", column = @Column(name = "name")),
        @AttributeOverride(name = "surname", column = @Column(name = "surname"))
})
public class EmployeeConcrete extends PersonConcrete {
    @Column(name = "salary")
    private double salary;

    public EmployeeConcrete() {

    }

    public EmployeeConcrete(String name, String surname, double salary) {
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
