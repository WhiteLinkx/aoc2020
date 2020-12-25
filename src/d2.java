import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class d2 {
    public static void main(String[] args) {
        List<String[]> list = new ArrayList<>();
        try {
            File input = new File("input_2_1.txt");
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()) {
                String[] val = reader.nextLine().split(":");
                list.add(val);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not foumd");
        }
        int result = 0;
        for(String[] str : list){
            String temp = str[0];
            String[] bounds = temp.split("-");
            int min = Integer.parseInt(bounds[0]);
            String[] tempArr = bounds[1].split(" ");
            int max = Integer.parseInt(tempArr[0]);
            char c = tempArr[1].charAt(0);
            if(partTwo(min,max,c,str[1])) result++;
            int count = 0;
            for(int i = 0; i < str[1].length(); i++){
                if(str[1].charAt(i) == c) count++;
            }
            //if(count >= min && count <= max) result++; PART 1
        }
        System.out.println(result);
    }

    public static boolean partTwo(int min, int max, char c, String check ){
        if((check.charAt(min) == c && !(check.charAt(max) == c)) || (!(check.charAt(min) == c) && check.charAt(max) == c)) return true;
        else return false;
    }
}
