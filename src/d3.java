import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class d3 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        try {
            File input = new File("input_3.txt");
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()) {
                String val = reader.nextLine();
                list.add(val);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not foumd");
        }
        int col = 0;
        int count1 = 0; /* Solution for Part one */
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int size = list.get(0).length();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).charAt(col) == '#') count1++;
            col = (col + 3) % size;
        }
        col = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).charAt(col) == '#') count2++;
            col = (col + 1) % size;
        }
        col = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).charAt(col) == '#') count3++;
            col = (col + 5) % size;
        }
        col = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).charAt(col) == '#') count4++;
            col = (col + 7) % size;
        }
        col = 0;
        for(int i = 0; i < list.size(); i+=2){
            if(list.get(i).charAt(col) == '#') count5++;
            col = (col + 1) % size;
        }
        long res = count1*count2*count3*count4*count5;
        System.out.println(res );
    }
}
