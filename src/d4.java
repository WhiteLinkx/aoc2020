import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class d4 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        try {
            File input = new File("input_4.txt");
            Scanner reader = new Scanner(input).useDelimiter("\n\n");
            while (reader.hasNext()) {
                String val = reader.next();
                list.add(val);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not foumd");
        }
        int count = 0;
        for(String str : list){
            if(str.contains("byr") && str.contains("iyr") && str.contains("eyr") && str.contains("hgt") && str.contains("hcl") && str.contains("ecl") && str.contains("pid")){
                String[] temp = str.split("( |\n)",0);
                boolean valid = true;
                for(String stri : temp){
                    String[] help = stri.split(":");
                    if(help[0].equals("byr") && !(Integer.parseInt(help[1]) >= 1920 && Integer.parseInt(help[1]) <= 2002)) valid = false;
                    if(help[0].equals("iyr") && !(Integer.parseInt(help[1]) >= 2010 && Integer.parseInt(help[1]) <= 2020)) valid = false;
                    if(help[0].equals("eyr") && !(Integer.parseInt(help[1]) >= 2020 && Integer.parseInt(help[1]) <= 2030)) valid = false;
                    if(help[0].equals("hgt")){
                        String unit = String.valueOf(help[1].charAt(help[1].length() - 2)) + String.valueOf(help[1].charAt(help[1].length() - 1));
                        int value = Integer.parseInt(help[1].replaceAll("[^0-9]", ""));
                        switch(unit){
                            case "cm":
                                if(!(value >= 150 && value <=193) )valid = false;
                                break;
                            case "in":
                                if(!(value >= 59 && value <=76) )valid = false;
                                break;
                            default:
                                valid = false;

                        }
                    }
                    if(help[0].equals("hcl")){
                        if(!(help[1].matches("#([0-9]|[a-f]){6}"))) valid = false;
                    }
                    if(help[0].equals("ecl")){
                        if(!help[1].matches("(amb|blu|brn|gry|grn|hzl|oth)")) valid = false;
                    }
                    if(help[0].equals("pid")){
                        if(!help[1].matches("[0-9]{9}")) valid = false;
                    }


                }
                if(valid) count++;
            }
        }
        System.out.println(count);
    }
}
