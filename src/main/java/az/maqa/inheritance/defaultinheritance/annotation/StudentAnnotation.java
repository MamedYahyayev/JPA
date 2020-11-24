package az.maqa.inheritance.defaultinheritance.annotation;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "student")
public class StudentAnnotation extends PersonAnnotation {

    @Column(name = "student_course", columnDefinition = "TINYINT CHECK (student_course > 1 AND student_course < 6)")
    private int course;

    public StudentAnnotation() {

    }

    public StudentAnnotation(String name, String surname, int course) {
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
