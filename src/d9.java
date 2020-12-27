import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class d9 {
    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();
        try {
            File input = new File("input_9.txt");
            Scanner reader = new Scanner(input);
            while (reader.hasNextLong()) {
                Long val = reader.nextLong();
                list.add(val);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not foumd");
        }
        int start = 0;
        Long[] vals = new Long[25];
        Long corrupted = 0L;
        for(int i = 25; i < list.size(); i++){
            for(int j = 0; j < vals.length; j++){
                vals[j] = list.get(start+j);
            }
            if(isCorrupted(vals,list.get(i))){
                //System.out.println(list.get(i)); PART ONE
                corrupted = list.get(i);
                break;
            }
            start++;
        }
        //PART TWO
        start = 0;
        Long curr = 0L;
        List<Long> nums = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            curr+=(Long) list.get(i);
            nums.add(list.get(i));
            if(curr > corrupted) {
                start++;
                i = start - 1;
                curr = 0L;
                nums = new ArrayList<>();
            }else if(curr.equals(corrupted)){
                System.out.println(Collections.max(nums,null) + Collections.min(nums,null));
                break;
            }
        }
    }

    public static boolean isCorrupted(Long[] vals, Long val){
        for (int i = 0; i < vals.length; i++) {
            for (int j = i+1; j < vals.length; j++) {
                if(vals[i] + vals[j] == val) return false;
            }
        }
        return true;
    }
}
