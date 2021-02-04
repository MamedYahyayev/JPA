package az.maqa.jackson.annotations.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorJacksonCreator {

    private String firstname;
    private String lastname;

    @JsonCreator
    public AuthorJacksonCreator(
            @JsonProperty("name") String firstname,
            @JsonProperty("surname") String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return "AuthorJacksonCreator{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
