import az.maqa.jackson.annotations.model.AuthorJacksonCreator;
import az.maqa.jackson.annotations.model.EmployeeJsonValue;
import az.maqa.jackson.annotations.model.EmployeeOrder;
import az.maqa.jackson.annotations.model.JacksonPerson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class JacksonAnnotationsTest {

    JacksonPerson person;
    ObjectMapper mapper;
    String personJson;
    EmployeeOrder employee;
    String employeeJson;

    /*
        1. JsonIgnore
        2. JsonIgnoreProperties
        3. JsonIgnoreType
        4. JsonAutoDetect
        5. JsonSetter
        6. JsonFormat
        7. JsonGetter
        8. JsonPropertyOrder
        9. JsonRootName
        10. JsonValue
        11. Jackson Creator
    */


    @BeforeEach
    void setUp() throws JsonProcessingException {
        mapper = new ObjectMapper();

        JacksonPerson.Address address = new JacksonPerson.Address();
        address.setAddress("Frankfurt");
        address.setCity("Berlin");

        List<String> items = Arrays.asList("Book", "Chair", "Pen");

        person = new JacksonPerson();
        person.setId(1L);
        person.setName("Samir");
        person.setSurname("Samirov");
        person.setSalary(2300D);
        person.setDate(new Date());
        person.setAddress(address);
        person.university = "AZI";
        person.gender = "Male";
        person.setItems(items);


        employee = new EmployeeOrder();
        employee.setName("Qasim");
        employee.setSurname("Qasimov");
        employee.setAge(22);
        employee.setSalary((double) 2300);

        employeeJson = mapper.writeValueAsString(employee);
        personJson = mapper.writeValueAsString(person);
    }

    @DisplayName("Json Ignore Annotations")
    @Test
    void testJsonIgnoreAnnotations() throws IOException {
        JacksonPerson jacksonPerson = mapper.readValue(personJson, JacksonPerson.class);

        assertNull(jacksonPerson.getId());
    }

    @DisplayName("Json Ignore Properties Annotations")
    @Test
    void testJsonIgnorePropertiesAnnotations() throws IOException {
        // This annotations ignores a bunch of properties on the class level , it was written on top of the class
        JacksonPerson jacksonPerson = mapper.readValue(personJson, JacksonPerson.class);

        assertNull(jacksonPerson.getId());
        assertNull(jacksonPerson.getName());
        assertNull(jacksonPerson.getSurname());
    }

    @DisplayName("Json Ignore Type Annotations")
    @Test
    void testJsonIgnoreTypeAnnotations() throws IOException {
        // This annotations ignores inner class type and it was written on top of the inner class
        JacksonPerson jacksonPerson = mapper.readValue(personJson, JacksonPerson.class);

        assertNull(jacksonPerson.getAddress());
    }

    @DisplayName("Json Auto Detect Annotations")
    @Test
    void testJsonAutoDetectAnnotations() throws IOException {
        JacksonPerson jacksonPerson = mapper.readValue(personJson, JacksonPerson.class);

        assertNotNull(jacksonPerson.university);
    }

    @DisplayName("Json Setter Annotations")
    @Test
    void testJsonSetterAnnotations() throws IOException {
        // The Jackson annotation @JsonSetter is used to tell Jackson that is should match the name of this setter method to a property name in the JSON data,
        // when reading JSON into objects. This is useful if the property names used internally in your Java class is not the same as the property name used in the JSON file.
        JacksonPerson jacksonPerson = mapper.readValue(personJson, JacksonPerson.class);

        System.out.println(personJson);
    }


    @DisplayName("Json Format Annotations")
    @Test
    void testJsonFormatAnnotations() throws IOException {
        JacksonPerson jacksonPerson = mapper.readValue(personJson, JacksonPerson.class);
        System.out.println(personJson);
    }

    @DisplayName("Json Getter Annotations")
    @Test
    void testJsonGetterAnnotations() {
        System.out.println(personJson);
        assertNotNull(JsonPath.from(personJson).getList("person_items"));
    }

    @DisplayName("Json Property Annotations")
    @Test
    void testJsonPropertyOrder() throws IOException {
        EmployeeOrder employee = mapper.readValue(employeeJson, EmployeeOrder.class);

        System.out.println(employeeJson);
        assertNotNull(employee);
    }

    @DisplayName("Json Root Name Annotations")
    @Test
    void testJsonRootName() throws IOException {
        EmployeeOrder employee = mapper.readValue(employeeJson, EmployeeOrder.class);
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        System.out.println(employeeJson);
        assertNotNull(employee);
    }

    @DisplayName("Json Value Annotations")
    @Test
    void testJsonValue() throws IOException {
        EmployeeJsonValue employeeJsonValue = new EmployeeJsonValue("Cabbar", "Cabbarli");

        String result = mapper.writeValueAsString(employeeJsonValue);

        String expected = "{\"fullname\":\"Cabbar Cabbarli\"}";

        assertEquals(expected, result);
    }

    @DisplayName("Json Creator Annotations")
    @Test
    void testJsonCreator() throws IOException {
        String json = "{\"name\":\"Samir\",\"surname\":\"Hesenli\"}";

        AuthorJacksonCreator authorJacksonCreator = mapper.readValue(json, AuthorJacksonCreator.class);

        assertNotNull(authorJacksonCreator);
    }
}
