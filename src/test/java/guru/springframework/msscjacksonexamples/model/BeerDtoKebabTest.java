package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ActiveProfiles("kebab")
@JsonTest
public class BeerDtoKebabTest extends BaseTest {

    @Test
    public void serializeKebabCase() throws JsonProcessingException {
        // given
        BeerDto beerDto = getDto();

        // when
        String jsonString = objectMapper.writeValueAsString(beerDto);

        // then
        assertNotNull(jsonString);
    }

    @Test
    public void deserializeKebabCase() throws IOException {
        // given
        String jsonString = "{\"beerId\":\"35a3d909-0dd8-4dc3-8a8d-16faf6404245\"," +
                "\"beer-name\":\"Test beer name\"," +
                "\"beer-style\":\"Ale\",\"upc\":5," +
                "\"price\":9.99," +
                "\"created-date\":\"2020-07-10T11:41:57.211064+02:00\"," +
                "\"last-updated-date\":\"2020-07-10T11:41:57.211716+02:00\"}";
        BeerDto expectedDeserializedDto = getDto();

        // when
        BeerDto dto = objectMapper.readValue(jsonString, BeerDto.class);

        // then
        assertNotNull(dto.getId());
        assertEquals(expectedDeserializedDto.getBeerName(), dto.getBeerName());
        assertEquals(expectedDeserializedDto.getBeerStyle(), dto.getBeerStyle());
        assertEquals(expectedDeserializedDto.getUpc(), dto.getUpc());
        assertEquals(expectedDeserializedDto.getPrice(), dto.getPrice());
    }

}
