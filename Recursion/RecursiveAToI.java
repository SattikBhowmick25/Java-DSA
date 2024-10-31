public class RecursiveAToI {
    static int myAtoi(String s) {
        if(s=="" || !s.matches("^\\d*$")){
            return 0;
        }
        if(s.length()==1){
            return s.charAt(0)-'0';
        }
        String str=s.substring(0, s.length()-1);
        return (10*myAtoi(str)+s.charAt(s.length()-1)-'0');
    }
}
