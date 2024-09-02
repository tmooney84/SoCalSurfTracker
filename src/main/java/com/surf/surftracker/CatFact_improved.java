package com.surf.surftracker;

public class CatFact_improved {

    String fact;
    int length;

    //first spring is going to create an empty cat object
    public CatFact_improved(){

    }

    public String getFact() {
        return fact;
    }

    //then it will set the fact from the json
    public void setFact(String fact) {
        this.fact = fact;
    }

    public int getLength() {
        return length;
    }

    //and then it will set the length from the json
    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "CatFact_improved{" +
                "fact='" + fact + '\'' +
                ", length=" + length +
                '}';
    }
}
