package org.example;

public class Main {
    public static void main(String[] args) {
        String line = "I21          ,12345,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40";
        DeathCauseStatistic stat = DeathCauseStatistic.fromCsvLine(line);

        DeathCauseStatistic.AgeBracketDeaths bracket = stat.getDeathCount(42);
        System.out.println("ICD-10: " + stat.getICD10());
        System.out.println("Wiek: " + bracket.young + "-" + bracket.old);
        System.out.println("Zgony: " + bracket.deathCount);
    }
}
