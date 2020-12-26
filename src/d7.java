import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class d7 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        try {
            File input = new File("input_7.txt");
            Scanner reader = new Scanner(input);
            while (reader.hasNextLine()) {
                String val = reader.nextLine();
                list.add(val);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not foumd");
        }
        Set<String> result = new HashSet<>();
        Set<String> help = new HashSet<>();
        int count = 0;
        int c = -1;
        result.add("shiny gold");
        while(true) {
            for (String str : list) {
                for (String stri : result) {
                    if (str.contains(stri)) {
                        String[] tenp = str.split("\\s+");
                        String res = tenp[0] + " " + tenp[1];
                        if(help.add(res )) count++;

                    }
                }
                result.addAll(help);
            }
            if(c == count) break;
            else c = count;

        }
        //System.out.println(count - 1);//-1 for shiny gold rule PART ONE
        // PART TWO
        Map<String,Integer> map = new HashMap<>();
        for(String str : list){
            List<String> nums = new ArrayList<>();
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(str);
            while(matcher.find()) nums.add(matcher.group());
            int sum = 0;
            for(String stri : nums) sum += Integer.parseInt(stri);
            String[] helper = str.split("\\s");
            map.put(helper[0] + " " + helper[1],sum == 0 ? 1 : sum);
        }
        int curr = map.get("shiny gold");
        int current = -1;

        while(true) {
            curr = map.get("shiny gold");
            for (String str : list) {
                Pattern pattern = Pattern.compile("((bags?(,|.)?|contains?|no other))");
                str = str.replaceAll(String.valueOf(pattern), "");
                String[] vals = str.split("\\s+");
                int sum = 1;
                for (int i = 2; i < vals.length; i += 3) {
                    sum += Integer.parseInt(vals[i]) * map.get(vals[i + 1] + " " + vals[i + 2]);
                }
                if(sum == 0) sum = 1;
                map.replace(vals[0] + " " + vals[1], sum);
            }
            if(curr == current) break;
            current = curr;
        }
        System.out.println(curr-1); //-1 for shiny gold
    }
}
