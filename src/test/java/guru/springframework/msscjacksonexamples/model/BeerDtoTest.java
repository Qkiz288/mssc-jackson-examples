package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@JsonTest
class BeerDtoTest extends BaseTest {

    @Test
    public void serializeDto() throws JsonProcessingException {
        // given
        BeerDto beerDto = getDto();

        // when
        String jsonString = objectMapper.writeValueAsString(beerDto);

        // then
        assertNotNull(jsonString);
    }

    @Test
    public void deserializeDto() throws IOException {
        // given
        String jsonString = "{\"id\":\"d05bc6d2-a337-424a-b4a6-87f2ed38f03d\"," +
                "\"beerName\":\"Test beer name\"," +
                "\"beerStyle\":\"Ale\"," +
                "\"upc\":5," +
                "\"price\":9.99," +
                "\"createdDate\":\"2020-07-10T11:11:32.970871+02:00\"," +
                "\"lastUpdatedDate\":\"2020-07-10T11:11:32.971879+02:00\"}";
        BeerDto expectedDeserializedDto = getDto();

        // when
        BeerDto dto = objectMapper.readValue(jsonString, BeerDto.class);

        // then
        assertEquals(expectedDeserializedDto.getBeerName(), dto.getBeerName());
        assertEquals(expectedDeserializedDto.getBeerStyle(), dto.getBeerStyle());
        assertEquals(expectedDeserializedDto.getUpc(), dto.getUpc());
        assertEquals(expectedDeserializedDto.getPrice(), dto.getPrice());
    }

}