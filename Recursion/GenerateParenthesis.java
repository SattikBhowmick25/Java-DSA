import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis{
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        backtrack(result,"",0,0,n);
        return result;
    }
    static void backtrack(List<String> result,String current,int open,int close,int n){
        if(current.length()==2*n){
            result.add(current);
            return;
        }
        //If there's scope of adding opening parenthesis then add it
        if(open<n){
            backtrack(result,current+"(",open+1,close,n);
        }
        //If number of closing parenthesis is not equal to the number of openings
        if(close<open){
            backtrack(result,current+")",open,close+1,n);
        }
    }
}