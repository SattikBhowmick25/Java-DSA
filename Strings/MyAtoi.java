public class MyAtoi{
    static int myAtoi(String s) {
        String str=s.trim();
        int num=0;
        int sign=1;
        int start=0;
        if(str.length()==0) return 0;
        if(str.charAt(0)=='-' || str.charAt(0)=='+'){
            start++;
            if(str.charAt(0)=='-')
                sign=-1;
        }
        while(start<str.length() && str.charAt(start)-'0'>=0 && str.charAt(start)-'0'<=9){
            // to avoid integer overflow
            if (num > (Integer.MAX_VALUE / 10) || (num == (Integer.MAX_VALUE / 10) && start > 7)){
                return sign==-1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            num=num*10 + (str.charAt(start)-'0');
            start++;
        }
        return sign*num;
    }
    public static void main(String[] args) {
        String s="1337c0d3";
        int num=myAtoi(s);
        System.out.println(num);
    }
}