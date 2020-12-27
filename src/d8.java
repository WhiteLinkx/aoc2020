import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class d8 {
    static int acc = 0;
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
        acc = 0;
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
        //System.out.println(acc); PART ONE
        //PART TWO
        for(String str : list ){
            String[] temp = str.split("\\s");
            int i = list.indexOf(str);
            List<String> help = new ArrayList<>(list);
            if(temp[0].equals("nop")){
                help.set(i,"jmp" + " " + temp[1]);
            }else if(temp[0].equals("jmp")){
                help.set(i,"nop" + " " +temp[1]);
            }
            if(!isStuck(help)){
                System.out.println(acc);
                break;
            }
        }

    }

    public static boolean isStuck(List<String> list){
        acc = 0;
        int loc = 0;
        boolean[] run = new boolean[list.size()];
        while(true){
            String str = list.get(loc);
            if(loc >= list.size() - 1 ) break;
            if(run[loc]) return true;
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
        return false;
    }
}
