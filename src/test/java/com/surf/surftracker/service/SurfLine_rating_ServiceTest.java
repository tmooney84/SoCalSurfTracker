/*package com.surf.surftracker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.surf.surftracker.dto.SurfLine_rating_DTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class SurfLine_rating_ServiceTest {

    @Mock
    private WebClient webClient;

    @Mock
    private WebClient.RequestHeadersSpec<?> requestHeadersSpec;

    @Mock
    private ResponseSpec responseSpec;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private SurfLine_rating_Service surfLine_rating_service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetSurfLineRating() throws Exception {
        // Sample JSON response
        String jsonResponse = "{\"someField\":\"someValue\"}";

        // Mocking WebClient behavior
        when(webClient.get()).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.uri(eq("https://services.surfline.com/kbyg/spots/forecasts/rating?spotId=5842041f4e65fad6a770888a&days=5&intervalHours=1&cacheEnabled=trued"))).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(String.class)).thenReturn(Mono.just(jsonResponse));

        // Mocking ObjectMapper behavior
        SurfLine_rating_DTO mockDTO = new SurfLine_rating_DTO();
        when(objectMapper.readValue(jsonResponse, SurfLine_rating_DTO.class)).thenReturn(mockDTO);

        // Call the method to test
        SurfLine_rating_DTO result = surfLine_rating_service.getSurfLineRating();

        // Validate the result
        assertEquals(mockDTO, result);
    }
}
*/