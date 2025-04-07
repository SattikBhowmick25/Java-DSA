import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {
    public List<List<String>> partition(String s) {
        List<String> path=new ArrayList<>();
        List<List<String>> res=new ArrayList<>();
        partitionHelper(0, s, path, res);
        return res;
    }
    private void partitionHelper(int index,String str,List<String> path,List<List<String>> res){
        if(index==str.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<str.length();i++){
            if(isPalindrome(str, index, i)){
                path.add(str.substring(index, i+1));
                partitionHelper(i+1, str, path, res);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String str,int start,int end){
        if(str.length()==1) return true;
        while(start<=end){
            if(str.charAt(start++)!=str.charAt(end--))
                return false;
        } 
        return true;
    }
}
