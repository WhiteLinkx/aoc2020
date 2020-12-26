import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class d8 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        try {
            File input = new File("input_8.txt");
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()) {
                String val = reader.nextLine();
                list.add(val);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not foumd");
        }
        int acc = 0;
        int loc = 0;
        boolean[] run = new boolean[list.size()];
        while(true){
                String str = list.get(loc);
                if(run[loc]) break;
                run[loc] = true;
                String[] temp = str.split("\\s");
                switch(temp[0]){
                    case "acc":
                        acc += Integer.parseInt(temp[1]);
                        loc++;
                        break;
                    case "jmp":
                        loc += Integer.parseInt(temp[1]);
                        break;
                    case "nop":
                        loc++;
                        break;
                }

        }
        System.out.println(acc);
    }
}
