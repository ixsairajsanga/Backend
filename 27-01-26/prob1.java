import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class prob1 {

    public static void main(String[] args) {

        String text = "";

        try (BufferedReader read = new BufferedReader(new FileReader("javafiles.txt"))) {
            String line;
            while ((line = read.readLine()) != null) {
                text +=line+"\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("The original text is:");
        System.out.println(text);


        System.out.println("------------------------------------------------------------");

        int c=text.replaceAll("\\s+","").length(); 
        System.out.println("charcater count is:"+c);

        String[] words=text.split(" ");
        System.out.println("Words count:"+words.length);

        String[] sentences=text.split("[.!?]");
        System.out.println("Sentences count :"+sentences.length);

        System.out.println("-------------------------------------------------------------");
        String txt1=text.replaceAll("\\s+"," ").trim();
        System.out.println("Cleared text after removal of multiple white spaces:"); 
        System.out.println(txt1);


        System.out.println("-------------------------------------------------------------");

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
       
        System.out.println("Top 5 most frequent words:");
        for (int i = 0; i < 5; i++) {
            Map.Entry<String, Integer> entry = list.get(i);
            System.out.println(entry.getKey() + " - " + entry.getValue());
        } 

        System.out.println("-------------------------------------------------------------");
        
        System.out.println("After Reversing each sentence ");
        for(String sentence : sentences){
            StringBuilder s = new StringBuilder(sentence);
            System.out.println(s.reverse());
        }


        System.out.println("-------------------------------------------------------------");
        String str1="Hello";
        String str2="Hello";
        String str3=new String("Hello");
        System.out.println(str1==str2);
        System.out.println(str1.equals(str2));
        System.out.println(str1==str3);
        System.out.println(str1.equals(str3));
    }
}