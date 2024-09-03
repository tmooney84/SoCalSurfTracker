package com.surf.surftracker.service;

import com.surf.surftracker.model.Current;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.MockedStatic;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DeepSwell_ServiceTest {

    @Mock
    private Current testLowersCurrent;

    @InjectMocks
    private DeepSwell_Service deepSwellService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetDeepSwellCurrent() throws IOException {
        Document mockDocument = mock(Document.class);
        Elements mockElements = mock(Elements.class);

        // Setting up mocks
        when(mockElements.text()).thenReturn("3-4+ ft");
        when(mockDocument.getElementsByClass("panel-body")).thenReturn(mockElements);

        try (MockedStatic<Jsoup> mockedJsoup = mockStatic(Jsoup.class)) {
            // Stubbing the static method with matchers
            mockedJsoup.when(() -> Jsoup.connect(anyString()).userAgent(anyString()).get()).thenReturn(mockDocument);

            // Call the method to be tested
            deepSwellService.getDeepSwellCurrent();

            // Verify that the wave height was set correctly
            verify(testLowersCurrent).setDeepSwellWaveHeight("3-4+ ft");
        }
    }
}
