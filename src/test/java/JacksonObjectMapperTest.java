import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class JacksonObjectMapperTest {

    public static final String CAR_WRITER_JSON = "src/test/resources/carWriter.json";
    public static final String CAR_JSON = "src/test/resources/car.json";
    private ObjectMapper objectMapper;
    private String carJson;
    private String carArrayJson;
    private String unknownJsonProperty;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        carJson = "{\"brand\":\"Mercedes\", \"doors\": 4}";
        carArrayJson = "[{\"brand\":\"Mercedes\", \"doors\": 4}]";
        unknownJsonProperty = "{\"brand\":\"Mercedes\", \"doors\": null}";
    }

    @Test
    void testReadObjects() throws IOException {
        Car car = objectMapper.readValue(carJson, Car.class);

        assertEquals("Mercedes", car.getBrand());
        assertEquals(4, car.getDoors());
    }

    @Test
    void testReadObjectsWithJsonReader() throws IOException {
        Reader reader = new StringReader(carJson);

        Car car = objectMapper.readValue(reader, Car.class);

        assertEquals("Mercedes", car.getBrand());
    }

    @Test
    void testReadObjectsFromJsonFile() throws IOException {
        File file = new File(CAR_JSON);

        Car car = objectMapper.readValue(file, Car.class);

        assertEquals(4, car.getDoors());
    }

    @Test
    void testReadObjectsFromByteArray() throws IOException {
        byte[] bytes = carJson.getBytes(StandardCharsets.UTF_8);

        Car car = objectMapper.readValue(bytes, Car.class);

        assertEquals(4, car.getDoors());
    }

    @Test
    void testReadObjectsFromJsonArray() throws IOException {
        Car[] cars = objectMapper.readValue(carArrayJson, Car[].class);

        assertEquals(1, cars.length);
    }

    @Test
    void testReadObjectsFromJsonArrayConvertToList() throws IOException {
        List<Car> carList = objectMapper.readValue(carArrayJson, new TypeReference<List<Car>>() {
        });
        assertEquals("Mercedes", carList.get(0).getBrand());
    }

    @Test
    void testReadMapFromJson() throws IOException {
        Map<String, Object> map = objectMapper.readValue(carJson, new TypeReference<Map<String, Object>>() {
        });

        assertEquals(4, map.get("doors"));
    }

    @Test
    void testReadUnknownJsonPropertyAndIgnoreNullValues() {
        // this method fails because we ignore the null values for primitives.
        assertThrows(MismatchedInputException.class, () -> {
            objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true);

            Car car = objectMapper.readValue(unknownJsonProperty, Car.class);

            System.out.println(car.getDoors());
        });
    }

    @Test
    void testWriteObjectsToJsonFile() throws IOException {
        // write value
        Car car = new Car();
        car.setBrand("Bmw M5");
        car.setDoors(4);

        objectMapper.writeValue(new FileOutputStream(CAR_WRITER_JSON), car);

        // read value
        Car readCar = objectMapper.readValue(new File(CAR_WRITER_JSON), Car.class);
        assertEquals("Bmw M5", readCar.getBrand());
    }

    @Test
    void testWriteObjectsAsString() throws JsonProcessingException {
        Car car = new Car();
        car.setBrand("Bmw M5");
        car.setDoors(4);
        String wroteValue = objectMapper.writeValueAsString(car);
        System.out.println(wroteValue);
        assertNotNull(wroteValue);
    }

    @Test
    void testWriteValueAsByte() throws JsonProcessingException {
        Car car = new Car();
        car.setBrand("Bmw M5");
        car.setDoors(4);
        byte[] bytes = objectMapper.writeValueAsBytes(car);
        assertNotNull(bytes);
    }


    @Test
    void testWriteDateValueToJsonString() throws JsonProcessingException {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        objectMapper.setDateFormat(format);

        Transaction transaction = new Transaction("transfer", new Date());

        String transactionJson = objectMapper.writeValueAsString(transaction);

        System.out.println(transactionJson);
        assertNotNull(transactionJson);
    }

    @Test
    void testReadObjectsFromJsonNode() throws IOException {
        JsonNode jsonNode = objectMapper.readValue(carJson, JsonNode.class);

        String brand = jsonNode.get("brand").asText();
        int doors = jsonNode.get("doors").asInt();

        assertEquals("Mercedes", brand);
        assertEquals(4, doors);
    }


    @Test
    void testConvertObjectToJsonNode() {
        Car car = new Car();
        car.brand = "Cadillac";
        car.doors = 4;

        JsonNode carJsonNode = objectMapper.valueToTree(car);

        assertEquals("Cadillac", carJsonNode.get("brand").asText());
    }

    @Test
    void testConvertJsonNodeToObject() throws IOException {
        JsonNode jsonNode = objectMapper.readTree(carJson);
        Car car = objectMapper.treeToValue(jsonNode, Car.class);
        assertEquals("Mercedes", car.getBrand());
    }

    private static class Car {
        private String brand;
        private int doors;

        public Car() {

        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public int getDoors() {
            return doors;
        }

        public void setDoors(int doors) {
            this.doors = doors;
        }
    }


    private static class Transaction {
        private final String type;
        private final Date date;

        public Transaction(String type, Date date) {
            this.type = type;
            this.date = date;
        }

        public String getType() {
            return type;
        }

        public Date getDate() {
            return date;
        }

    }
}
