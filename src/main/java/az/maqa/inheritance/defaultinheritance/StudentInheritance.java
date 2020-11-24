package az.maqa.inheritance.defaultinheritance;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "student")
public class StudentInheritance extends Person {

    @Column(name = "course")
    private int course;

    public StudentInheritance() {
    }

    public StudentInheritance(String name, String surname, int course) {
        super(name, surname);
        this.course = course;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}
