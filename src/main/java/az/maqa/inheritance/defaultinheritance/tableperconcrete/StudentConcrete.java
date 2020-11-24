package az.maqa.inheritance.defaultinheritance.tableperconcrete;

import javax.persistence.*;

@Entity
@Table(name = "student_concrete")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id")),
        @AttributeOverride(name = "name", column = @Column(name = "name")),
        @AttributeOverride(name = "surname", column = @Column(name = "surname"))
})
public class StudentConcrete extends PersonConcrete {

    @Column(name = "course")
    private int course;

    public StudentConcrete() {
    }

    public StudentConcrete(String name, String surname, int course) {
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
