package az.maqa.jackson.annotations.model;

import com.fasterxml.jackson.annotation.*;

import java.util.Date;

@JsonIgnoreProperties({"name", "surname"})
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class JacksonPerson {

    public String university;
    public String gender;

    @JsonIgnore
    private Long id;
    private String name;
    private String surname;
    private Double salary;

    private Address address;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date date;


    public JacksonPerson() {
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

    public Double getSalary() {
        return salary;
    }

    @JsonSetter("personSalary")
    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "JacksonPerson{" +
                "university='" + university + '\'' +
                ", gender='" + gender + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                ", address=" + address +
                '}';
    }

    @JsonIgnoreType
    public static class Address {
        private String city;
        private String address;

        public Address() {
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
