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

@ActiveProfiles("snake")
@JsonTest
public class BeerDtoSnakeTest extends BaseTest {

    @Test
    public void serializeSnakeCase() throws JsonProcessingException {
        // given
        BeerDto beerDto = getDto();

        // when
        String jsonString = objectMapper.writeValueAsString(beerDto);

        // then
        assertNotNull(jsonString);
    }

    @Test
    public void deserializeSnakeCase() throws IOException {
        // given
        String jsonString = "{\"id\":\"0dd193de-8768-4895-a5e4-ee136fc1e954\"," +
                "\"beer_name\":\"Test beer name\"," +
                "\"beer_style\":\"Ale\"," +
                "\"upc\":5,\"price\":9.99," +
                "\"created_date\":\"2020-07-10T11:29:47.65126+02:00\"," +
                "\"last_updated_date\":\"2020-07-10T11:29:47.652003+02:00\"}";
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
