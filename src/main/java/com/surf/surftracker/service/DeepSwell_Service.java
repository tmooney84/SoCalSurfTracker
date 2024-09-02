package com.surf.surftracker.service;

import com.surf.surftracker.model.Current;
import com.surf.surftracker.util.SurfSpotURLList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeepSwell_Service {
    private Current testLowersCurrent;

    public DeepSwell_Service(Current testLowersCurrent)
    {
        this.testLowersCurrent = testLowersCurrent;
    }

    //Need to clean up the code so that it reflects

    String[] DSurl = {
            SurfSpotURLList.LowerTrestles.deepSwellURL()
    };
        public void getDeepSwellCurrent() {
            try {
                for (int i = 0; i < DSurl.length; i++) {
                    Document dsConnect = Jsoup.connect(DSurl[i])
                            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                                    "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36").get();

                    Elements div = dsConnect.getElementsByClass("panel-body");
                    if (div != null) {
                        String text = div.text();
                        Pattern pattern = Pattern.compile("(\\d+-\\d+\\+?|\\d+\\+?) ft");
                        Matcher matcher = pattern.matcher(text);

                        if (matcher.find()) {
                            String waveHeight = matcher.group(1);
                            testLowersCurrent.setDeepSwellWaveHeight(waveHeight+" ft");
                        } else {
                            System.out.println("Wave height not found at location #" + i);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}