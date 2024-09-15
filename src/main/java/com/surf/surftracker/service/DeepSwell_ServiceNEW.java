package com.surf.surftracker.service;

import com.surf.surftracker.model.Current;
import com.surf.surftracker.util.SurfSpotURLList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DeepSwell_ServiceNEW {
    //private Current testLowersCurrent;


   // public DeepSwell_ServiceNEW(Current testLowersCurrent)
   // {
    //    this.testLowersCurrent = testLowersCurrent;
  //  }

    //Need to clean up the code so that it reflects

//    String[] DSurl = {
//            SurfSpotURLList.LowerTrestles.deepSwellURL()
//    };
    private String deepSwellWaveHeight = "";

        public String getDeepSwellCurrent(String dSurl) {
            try {
                    Document dsConnect = Jsoup.connect(dSurl)
                            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                                    "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/126.0.0.0 Safari/537.36").get();

                    Elements div = dsConnect.getElementsByClass("panel-body");
                    if (div != null) {
                        String text = div.text();
                        Pattern pattern = Pattern.compile("(\\d+-\\d+\\+?|\\d+\\+?) ft");
                        Matcher matcher = pattern.matcher(text);

                        if (matcher.find()) {
                            String waveHeight = matcher.group(1);
                            deepSwellWaveHeight = waveHeight +" ft";
                        } else {
                          deepSwellWaveHeight = "N/A";
                        }
                    }
            } catch (IOException e) {
                e.printStackTrace();
            }
       return deepSwellWaveHeight;
        }
}