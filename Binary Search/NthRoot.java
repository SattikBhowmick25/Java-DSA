public class NthRoot {
    public static void main(String[] args) {
        int num=64,n=3;
        int nRoot=nth_root(num, n);
        System.out.println("Number : "+num+"\t Nth Root : "+nRoot);
    }
    static int myPow(int base,int exp){
        int ans=1;
        if(base==0 || base==1)      return base;
        if(exp<0){
            base=1/base;
            exp=-(exp+1);
            ans=ans*base;
        }
        while(exp>0){
            if(exp%2==1){
                ans=ans*base;
                exp--;
            }
            else{
                exp=exp/2;
                base=base*base;
            }
        }
        return ans;
    }
    
    static int nthRoot(int num,int n){
        int low=1,high=num;
        int ans=1;
        while(low<=high){
            int mid=low+(high-low)/2;
            long val=myPow(mid,n);
            if(val<=num){
                ans=mid;
                low=mid+1;
            }
            else    
                high=mid-1;
        }
        return ans;
    }

    // return 0 if <num
    // return 1 if =num
    // return 2 if >num
    static int func(int mid,int n,int num){
        long ans=1;
        for(int i=1;i<=n;i++){
            ans=ans*mid;
            if(ans>num)
                return 2;           
        }
        if(ans==num)    return 1; 
        return 0;
    }

    static int nth_root(int num,int n){
        int low=1,high=num;
        int ans=1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int check=func(mid, n, num);
            if(check<=1){
                ans=mid;
                low=mid+1;
            }
            else
                high=mid-1;
        }
        return ans;
    }
}
