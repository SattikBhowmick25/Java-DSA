public class ReverseWords {
    static String reverseWords(String s){
        String reverse="";
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)==' '){
                i++;
            }
            else{
                String word="";
                while(i<s.length() && s.charAt(i)!=' '){
                    word += s.charAt(i);
                    i++;
                }
                int j=i;
                boolean flag=false;
                while(j<s.length()){
                    if(s.charAt(j)!=' '){
                        flag=true;
                        break;
                    }
                    j++;
                }
                if(flag)
                    word = " " + word;
                reverse = word + reverse;
                i++;
            }
            
        }
        return reverse;
    }
    static String reverseWords1(String s){
        String reverse="";
        int i=0;
        s=s.trim();
        while(i<s.length()){
            if(s.charAt(i)==' '){
                i++;
            }
            else{
                String word="";
                while(i<s.length() && s.charAt(i)!=' '){
                    word += s.charAt(i);
                    i++;
                }
                if(i<s.length())
                    word = " " + word;
                reverse = word + reverse;
                i++;
            }
            
        }
        return reverse;
    }
    public static void main(String[] args) {
        String s="          The sky     is blue            ";
        String revString=reverseWords1(s);
        System.out.println(revString);
    }
}
