public class SingleElement {
    public static void main(String[] args) {
        int[] arr={1,1,2,2,3,3,4,5,5,6,6};
        int single=singleElement1(arr);
        System.out.println(single);
    }
    static int singleElement(int arr[]){
        int low=0,high=arr.length-1;
        
        if(arr.length==1)   return arr[0];
        if(arr[0]!=arr[1])  return arr[0];
        if(arr[arr.length-2]!=arr[arr.length-1])    return arr[arr.length-1];

        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid-1]!=arr[mid] && arr[mid]!=arr[mid+1])    return arr[mid];
            
            if((low%2==0 && (low+1)%2==1) && ((mid-1)%2==0 && mid%2==1)){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -9999;
    }
    static int singleElement1(int arr[]){
        int low=1,high=arr.length-2;
        
        if(arr.length==1)   return arr[0];
        if(arr[0]!=arr[1])  return arr[0];
        if(arr[arr.length-2]!=arr[arr.length-1])    return arr[arr.length-1];

        while(low<=high){
            int mid=low+(high-low)/2;

            if(arr[mid-1]!=arr[mid] && arr[mid]!=arr[mid+1])    return arr[mid];
            
            if((mid%2==1 && arr[mid-1]==arr[mid]) || (mid%2)==0 && arr[mid]==arr[mid+1]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -9999;
    }
}
