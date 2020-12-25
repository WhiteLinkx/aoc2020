import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class d1p1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        try{
            File input = new File("input_1_1.txt");
            Scanner reader = new Scanner(input);
            while(reader.hasNextInt()){
                int val = reader.nextInt();
                list.add(val);
            }
        }catch(FileNotFoundException e){
            System.out.println("File not foumd");
        }
        for(int i = 0; i < list.size(); i++){
            for(int j = i + 1; j < list.size(); j++){
                if(list.get(i) + list.get(j) == 2020){
                    //System.out.println( list.get(i) * list.get(j)); PART 1

                }
            }
        }
        partTwo(list);
    }
    public static void partTwo(List<Integer> numbers){
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i+1; j < numbers.size(); j++) {
                for (int k = j+1; k < numbers.size(); k++) {
                    if(numbers.get(i)+numbers.get(j)+numbers.get(k) == 2020){
                        System.out.println(numbers.get(i) * numbers.get(k) * numbers.get(j));
                    }
                }
            }
        }
    }
}
