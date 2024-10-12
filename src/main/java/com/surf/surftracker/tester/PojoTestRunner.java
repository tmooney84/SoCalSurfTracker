package com.surf.surftracker.tester;

import com.surf.surftracker.model.Current;

public class PojoTestRunner {
    public static void main(String[] args){
        Current siteA = new Current();
        String ATest = siteA.getSurfLineWaveHeight();
        System.out.println(siteA);
        System.out.println(ATest);
    }
}
