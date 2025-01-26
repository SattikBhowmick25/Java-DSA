import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LRU {
    static int pageFaults(int N, int C, int pages[]){
        Set<Integer> memory=new HashSet<>();
        Map<Integer,Integer> lruPages=new HashMap<>();
        int pageFault=0;
        for(int i=0;i<N;i++){
            int page=pages[i];
            if(!memory.contains(page)){
                if(memory.size()==C){
                    int lru=Integer.MAX_VALUE;
                    int lruPage=-1;
                    for(int p:memory){
                        if(lruPages.getOrDefault(p,0)<lru){
                            lru=lruPages.getOrDefault(p,0);
                            lruPage=p;
                        }
                    }
                    memory.remove(lruPage);
                }
                memory.add(page);
                pageFault++;
            }
            lruPages.put(page,i);
        }
        return pageFault;
    }
}
