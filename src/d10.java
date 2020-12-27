import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class d10 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        try{
            File input = new File("test.txt");
            Scanner reader = new Scanner(input);
            while(reader.hasNextInt()){
                int val = reader.nextInt();
                list.add(val);
            }
        }catch(FileNotFoundException e){
            System.out.println("File not foumd");
        }
        list.add(0);
        Collections.sort(list);
        int diffOne = 0;
        int diffThree = 0;
        for(int i = 0; i < list.size(); i++){
            int start = list.get(i);
            int end = i == list.size() - 1 ? list.get(i) + 3 : list.get(i+1);
            if(end - start == 1) diffOne++;
            else if(end - start == 3)diffThree++;
            else{
                System.out.println(start);
                System.out.println(end);
                System.out.println("Bad Joltage");
            }
        }
        System.out.println(diffOne * diffThree);
        long[] dp = new long[list.size()];
        System.out.println(partTwo(list, 0,dp));
    }
    public static long partTwo(List<Integer> list, int index, long[] dp) {
        if(index == list.size() - 1) return 1;
        long ans = 0;
        if(dp[index] != 0) return dp[index];
        for (int i = index+1; i < list.size(); i++) {
            if (list.get(i) - list.get(index) <= 3){
                ans += partTwo(list,i,dp);
            }
        }
        dp[index] = ans;
        return ans;
    }
 }
