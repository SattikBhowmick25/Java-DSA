public class RotateString {
    static boolean rotateString(String s, String goal) {
        int n=s.length();
        int m=goal.length();

        if(n != m) return false;
        for(int i=0;i<n;i++){
            String sub1=s.substring(i+1);
            String sub2=s.substring(0,i+1);
            String temp=sub1+sub2;
            System.out.println(sub2+" "+sub1);
            if(temp.equals(goal))  return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String s="abcde";
        String goal="cdeab";
        boolean ans=rotateString(s,goal);
        System.out.println(ans);
    }
}
