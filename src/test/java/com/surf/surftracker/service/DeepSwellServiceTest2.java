//package com.surf.surftracker.service;
//
//import com.surf.surftracker.model.Current;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.select.Elements;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockedStatic;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.io.IOException;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class DeepSwellServiceTest2 {
//
//    @Mock
//    private Current testLowersCurrent;
//
//    @Mock
//    private Document mockDocument;
//
//    @InjectMocks
//    private DeepSwell_ServiceNEW deepSwellService;
//
//    @Test
//    public void testGetDeepSwellCurrent_ParsesWaveHeight() throws IOException {
//        // Mock static Jsoup.connect method
//        try (MockedStatic<Jsoup> jsoupMock = mockStatic(Jsoup.class)) {
//            // Set up mock behavior for Jsoup.connect
//            jsoupMock.when(() -> Jsoup.connect(anyString()).userAgent(anyString()).get()).thenReturn(mockDocument);
//
//            // Set up mock document elements
//            Elements mockElements = mock(Elements.class);
//            when(mockDocument.getElementsByClass("panel-body")).thenReturn(mockElements);
//            when(mockElements.text()).thenReturn("3-4+ ft"); // Example text with wave height
//
//            // Call the method to test
//            deepSwellService.getDeepSwellCurrent();
//
//            // Verification
//            verify(testLowersCurrent).setDeepSwellWaveHeight("3-4+ ft");
//        }
//    }
//}
