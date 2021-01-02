package az.maqa.auditing.model;

import javax.persistence.*;
import java.util.List;

@Entity
@EntityListeners(AuditingEntity.class)
@Table(name = "family_members")
public class FamilyMembers{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpa_sequence")
    private Long id;

    private String name;

    private String surname;

    @ElementCollection
    @CollectionTable(name = "family_members_characters", joinColumns = @JoinColumn(name = "family_members_id", referencedColumnName = "id"))
    @Column(name = "characters")
    private List<String> characters;

    public FamilyMembers() {

    }

    public FamilyMembers(String name, String surname, List<String> characters) {
        this.name = name;
        this.surname = surname;
        this.characters = characters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    @Override
    public String toString() {
        return "FamilyMembers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", characters=" + characters +
                '}';
    }
}
