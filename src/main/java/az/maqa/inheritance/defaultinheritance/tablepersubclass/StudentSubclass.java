package az.maqa.inheritance.defaultinheritance.tablepersubclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "stundent_subclass")
@PrimaryKeyJoinColumn(name = "person_id")
public class StudentSubclass extends PersonSubclass {

    @Column(name = "course")
    private int course;

    public StudentSubclass() {
    }

    public StudentSubclass(String name, String surname, int course) {
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
