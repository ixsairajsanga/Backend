import java.util.*;
import java.io.*;

public class prob2 {
    public static void main(String[] args) {
        String[] names = {"sairaj","nikhil","krish","sairaj"};

        ArrayList<String> All_names = new ArrayList<>();
        for(String i:names){    
            All_names.add(i);
        }
        

        System.out.println("Arraylist: with duplicates");
        System.out.println(All_names);
        
        HashSet<String> Hs_names = new HashSet<>();
        for(String i : names){
            Hs_names.add(i);
        }
        System.out.println("Hashset: no duplicates");
        System.out.println(Hs_names);
        
        HashMap <String, Integer> Hm_names = new HashMap<>();
        for(String i : names){
            Hm_names.put(i, Hm_names.getOrDefault(i,0)+1);
        }
        System.out.println("Hashmap:");
        System.out.println(Hm_names);

        //printing data using multiple iterators

        System.out.println("Hashmap using foreach:");
        Hm_names.forEach((k,v) -> System.out.println(k+ " - " +v));

        System.out.println("HashMap using keyset:");
        for(String key : Hm_names.keySet()){
            System.out.println(key + " - " +Hm_names.get(key));
        }

        System.out.println("Hashmap using entryset:");
        for(Map.Entry<String,Integer> entry : Hm_names.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }



        System.out.println("Arraylist using foreach:");
        for(String s : All_names){
            System.out.println(s);
        }




        System.out.println("Hashset using iterator:");
        Iterator<String> it = Hs_names.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}