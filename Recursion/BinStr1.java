import java.util.ArrayList;

public class BinStr1 {
    static ArrayList<String> generateBinaryStrings(int n){
        if(n==0){
            ArrayList<String> empty=new ArrayList<>();
            return empty;
        }
        else if(n==1){
            ArrayList<String> binStr=new ArrayList<>();
            binStr.add("0");
            binStr.add("1");
            return binStr;
        }
        ArrayList<String> answer=new ArrayList<>();
        ArrayList<String> prevStr=generateBinaryStrings(n-1);
        for(String str:prevStr){
            answer.add(str+"0");
            if(str.charAt(str.length()-1)!=1){
                answer.add(str+"1");
            }
        }
        return answer;
    }
}
