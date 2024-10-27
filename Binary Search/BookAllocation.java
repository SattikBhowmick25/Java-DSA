public class BookAllocation{
    public static void main(String[] args) {
        int[] arr={12, 34, 67, 90};
        int m=2;
        int ans1=bookAllocationBrute(arr, m);
        int ans2=bookAllocationBrute(arr, m);
        System.out.println(ans1);
        System.out.println(ans2);
    }

    static int sum(int[] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
        }
        return sum;
    }
    static int max(int[] arr){
        int max=-1;
        for(int i=0;i<arr.length;i++){
            if(max<arr[i])      max=arr[i];
        }
        return max;
    }
    
    static int countStudents(int[] arr,int pages){
        int student=1,pageCount=0;
        for(int i=0;i<arr.length;i++){
            if((pageCount+arr[i])<=pages){
                pageCount += arr[i];
            }
            else{
                student++;
                pageCount=arr[i];
            }
        }
        return student;
    }
    static int bookAllocationBrute(int[] arr,int m){
        int n=arr.length;
        
        if (m > n)
            return -1;
        
        for(int i=max(arr);i<=sum(arr);i++){
            if(countStudents(arr, i)==m)    return i;
        }
        return max(arr);
    }

    static int bookAllocationOptimal(int[] arr,int m){
        int low=max(arr),high=sum(arr);
        int n=arr.length;
        
        if(m>n)     return -1;

        if(m==n)    return low;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(countStudents(arr, mid)==m){
                return mid;
            }
            else if(countStudents(arr, mid)>m){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}