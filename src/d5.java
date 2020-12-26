import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class d5 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
       try {
            File input = new File("input_5.txt");
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()) {
                String val = reader.nextLine();
                list.add(val);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not foumd");
        }
        List<Integer> ids = new ArrayList<>();
        int max = Integer.MAX_VALUE; //MAX = 818 MIN = 48
        for(String str : list){
            int seatId = 0;
            int row = 0;
            int col = 0;
            int lower = 0;
            int upper = 127;
            int lowerCol = 0;
            int upperCol = 7;
            for(int i = 0; i < str.length(); i++){
                if (i == 6 && str.charAt(i) == 'F') {
                    row = lower;
                }else if (i == 6 && str.charAt(i) == 'B'){
                    row = upper;
                } else if (i == 9 && str.charAt(i) == 'R') {
                    col = upperCol;
                } else if (i == 9 && str.charAt(i) == 'L') {
                    col = lowerCol;
                }
                switch(str.charAt(i)){
                    case 'F':
                        upper = (lower+upper)/2;
                        break;
                    case 'B':
                        lower = lower + ((upper-lower) / 2) + 1;
                        break;
                    case 'R':
                        lowerCol = lowerCol + ((upperCol-lowerCol) / 2) + 1;
                        break;
                    case 'L':
                        upperCol = (lowerCol+upperCol)/2;
                        break;
                    default:

                        System.out.println("Wrong input read");
                }
            }
            int temp = (row * 8) + col;
            ids.add(temp);
            max = Math.min(temp, max);
        }
        //System.out.println(max); PART 1
        //PART 2
        for (int i = 48; i <= 818 ; i++) {
            if(!ids.contains(i)) System.out.println(i);
        }

    }
}
