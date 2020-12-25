import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class d5 {
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
        int max = Integer.MAX_VALUE;
        for(String str : list){
            int seatId = 0;
            int row = 0;
            int col = 0;
            int lower = 0;
            int upper = 127;
            for(int i = 0; i < str.length(); i++){
                if (i == 6 && str.charAt(i) == 'F') {
                    row = upper/2;
                }else if (i == 6 && str.charAt(i) == 'B'){

                }
                switch(str.charAt(i)){
                    case 'F':
                        upper = upper/2;
                    case 'B':
                        lower = upper/2;
                }
            }
        }
    }
}
