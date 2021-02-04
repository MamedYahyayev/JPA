package az.maqa.jackson.annotations.model;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public class EmployeeJsonValue {

    private String name;
    private String surname;

    public EmployeeJsonValue(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @JsonValue
    public Map<String, String> toJson() {
        Map<String, String> values = new HashMap<>();
        values.put("fullname", name + " " + surname);
        return values;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
