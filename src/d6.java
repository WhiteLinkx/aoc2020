import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class d6 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        try {
            File input = new File("input_6.txt");
            Scanner reader = new Scanner(input).useDelimiter("\n\n");
            while (reader.hasNext()) {
                String val = reader.next();
                list.add(val);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not foumd");
        }
        int total = 0;
        for(String str : list){

            /* PART ONE
            int count = 0;
            Set<Character> set = new HashSet<>();
            for(Character c : str.toCharArray()){
                if(set.add(c) && c != '\n')  count++;
            }
            total += count;
             */
            String[] temp = str.split("\n");
            Set<Character> setTwo = new HashSet<>();
            Set<Character> toRemove = new HashSet<>();
            for(Character c : temp[0].toCharArray()) setTwo.add(c);
            for(int i = 1; i < temp.length; i++){
                for (Character c : setTwo) {
                    if (temp[i].indexOf(c) == -1) toRemove.add(c);
                }
            }
            setTwo.removeAll(toRemove);
            total += setTwo.size(); // PART TWO
        }
        System.out.println(total);
    }
}
