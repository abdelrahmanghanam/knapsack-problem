package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Item[] items={(new Item(1,7,42)),(new Item(2,3,12)),(new Item(3,4,40)),(new Item(4,5,25))};
        ArrayList<Set<Item>> subsets=printSubsets(items);
        printSubsets(items);
        System.out.println(subsets.size());
        System.out.println("-----------------------------------------------\n" +
                           "-------------- printing subsets----------------\n" +
                           "-----------------------------------------------");
        for (Set<Item> myset: subsets){
            for (Item item:myset){
                System.out.println(item.toString());
            }
            System.out.println("-----------------------------");
        }
        System.out.println("-----------------------------------------------\n" +
                "-------------- ending printing subsets---------\n" +
                "-----------------------------------------------");

        PrintMaxValueMinWeightElements(10,subsets);

    }



    public static ArrayList<Set<Item>> printSubsets(Item set[]) {
            int n = set.length;
            ArrayList<Set<Item>> subsets= new ArrayList<>();

            for (int i = 0; i < (1<<n); i++){
                Set<Item> myset= new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) > 0) {
                        myset.add(set[j]);
                    }
                }
                subsets.add(myset);
            }
            return subsets;
    }
    public static void PrintMaxValueMinWeightElements(int maxWeight, ArrayList<Set<Item>> subsets){
        int bestValue=0;
        Set<Item> bestItems=new HashSet<>();
        for (Set<Item> myset: subsets){
            int weight=0,value=0;
            for (Item item:myset){
                weight=weight+item.weight;
                value=value+item.value;
            }
            if (weight<=maxWeight){
                if (value>=bestValue){
                    bestValue=value;
                    bestItems=myset;
                }
            }
        }
        System.out.println("best value found with weight <= "+maxWeight+" is equal to "+bestValue+" and the items are: - ");
        for (Item item:bestItems){
            System.out.println(item.toString());
        }


    }

}
class Item{
    public int weight, value,id;
    public Item(int id,int w, int v){
        this.id=id;
        this.weight=w;
        this.value=v;
    }
    public String toString(){
        return "ID: "+this.id+" weight: "+this.weight+" value: "+this.value;
    }
}
