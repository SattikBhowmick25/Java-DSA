import java.util.HashMap;
import java.util.Map;

public class RomanInteger {
    static int romanToInt(String s) {
        int intVal=0;
        Map<Character,Integer> map= new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int i=0;
        while(i<s.length()){
            if(i!=s.length()-1){
                if(map.get(s.charAt(i))<map.get(s.charAt(i+1)) && map.get(s.charAt(i+1))/map.get(s.charAt(i))<=10){
                    intVal=intVal+(map.get(s.charAt(i+1)) - map.get(s.charAt(i)));
                    i+=2;
                }
                else{
                    intVal+=map.get(s.charAt(i));
                    i+=1;
                }
            }
            else{
                intVal+=map.get(s.charAt(i));
                    i+=1;
            }
            System.out.println(intVal);
        }
        return intVal;
    }
    public static void main(String[] args) {
        String s="MCMXCIV";
        int intVal=romanToInt(s);
        System.out.println(intVal);
    }
}
