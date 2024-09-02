package com.surf.surftracker.service;

import com.surf.surftracker.model.Current;
import com.surf.surftracker.util.SurfSpotURLList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Surf_Captain_Service {
    private Current scCurrentLowers;

    public Surf_Captain_Service(Current scCurrentLowers)
    {
        this.scCurrentLowers = scCurrentLowers;
    }
    String[] SCurl = {
            SurfSpotURLList.LowerTrestles.surfCaptainURL(),
    };

    public void getSurfCaptainCurrent(){
        try {
            for (int i = 0; i < SCurl.length; i++) {
                Document scConnect = Jsoup.connect(SCurl[i])
                        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36").get();
                Element div = scConnect.getElementById("fcst-current-title");
                if (div != null) {
                    String text = div.text();
                    Pattern pattern = Pattern.compile("(\\d+-\\d+\\+?|\\d+\\+?) ft");
                    Matcher matcher = pattern.matcher(text);

                    if (matcher.find()) {
                        String waveHeight = matcher.group(1);

                        scCurrentLowers.setSurfCaptainWaveHeight(waveHeight + " ft");

                        //setter to spot object for SurfForecast wave height
              //          System.out.println("Current Wave height at location #" + i + ": " + waveHeight);
                    } else {
                        System.out.println("Wave height not found at location #" + i);
                    }
                } else {
                    System.out.println("Element not found at location #" + i);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}