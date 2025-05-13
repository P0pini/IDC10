package org.example;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class DeathCauseStatistic {
    private String ICD10;
    private int[] Age;
    private DeathCauseStatistic(String ICD10, int[] Age){
        this.ICD10=ICD10;
        this.Age=Age;
    }
    public static DeathCauseStatistic fromCsvLine(String line){
        String[] parts= line.split(",",-1);
        String ICD10 = parts[0].trim();
        int[] deaths = new int[parts.length -1];

        for(int i=1; i< parts.length; i++){
            String values = parts[i].trim();
            if(values.equals("-")){
                deaths[i-1]=0;
            }else{
                try{
                    deaths[i-1]=Integer.parseInt(values);
                }catch (NumberFormatException e){
                    throw new IllegalArgumentException("Nieprawidłowa liczba w kolumnie"+i);
                }
            }
        }
        return new DeathCauseStatistic(ICD10,deaths);
    }
    public String getICD10(){
        return ICD10;
    }

    public class AgeBracketDeaths{
        public final int young;
        public final int old;
        public final int deathCount;
        public AgeBracketDeaths(int young, int old,int deathCount){
            this.young = young;
            this.old = old;
            this.deathCount = deathCount;
        }
    }
    public AgeBracketDeaths getDeathCount(int wiek){
        int indeks = wiek/5 ;
        if(indeks>19){
            throw new IllegalArgumentException("19");
        }
        int deathCount = Age[indeks];
        int young = indeks *5;
        int old = young+4;
        return new AgeBracketDeaths(young,old, deathCount);
    }

    public class DeathCauseStatisticList{
        private List<DeathCauseStatistic> statistics;
        public DeathCauseStatisticList(){
            this.statistics=new ArrayList<>();
        }
        public void repopulate(String csvFile){
            statistics.clear();
            try(BufferedReader){

            }
        }

    }


}
