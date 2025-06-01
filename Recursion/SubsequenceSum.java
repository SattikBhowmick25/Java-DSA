import java.util.ArrayList;

public class SubsequenceSum {
    static boolean subsSum(int ind,int arr[],ArrayList<Integer> sub,int n,int k,int sum){
        if(ind>=n){
            if(sum==k){
                System.out.print("[");
                for(Integer a:sub){
                    System.out.print(a+" ");
                }
                System.out.println("]");
                return true;
            }
            else{
                return false;
            }
        }
        sub.addLast(arr[ind]);
        sum+=arr[ind];
        if(subsSum(ind+1,arr,sub,n,k,sum)==true)    return true;
        sub.remove(sub.size() - 1);
        sum-=arr[ind];
        if(subsSum(ind+1,arr,sub,n,k,sum)==true)    return true;
        return false;
    }
    static void subsequenceSum(int ind, int arr[], ArrayList<Integer> sub, int n, int k, int sum) {
        if (ind >= n) {
            if (sum == k) {
                System.out.print("[");
                for (int i = 0; i < sub.size(); i++) {
                    System.out.print(sub.get(i) + (i == sub.size() - 1 ? "" : " "));
                }
                System.out.println("]");
            }
            return;
        }

        // Include the current element
        sub.add(arr[ind]);
        sum += arr[ind];
        subsequenceSum(ind + 1, arr, sub, n, k, sum);

        // Exclude the current element
        sub.remove(sub.size() - 1);
        sum -= arr[ind];
        subsequenceSum(ind + 1, arr, sub, n, k, sum);
    }
    static int countSubs(int ind,int[] arr,ArrayList<Integer> sub,int n,int k,int sum){
        if(ind>=n){
            if(sum==k){
                return 1;
            }
            else return 0;
        }
        sub.add(arr[ind]);
        sum+=arr[ind];
        int left=countSubs(ind+1, arr, sub, n, k, sum);
        sub.remove(sub.size()-1);
        sum-=arr[ind];
        int right=countSubs(ind+1, arr, sub, n, k, sum);
        return left+right;
    }

    public static void main(String[] args) {
        int[] arr={1,1,1,2};
        ArrayList<Integer> sub=new ArrayList<>();
        subsequenceSum(0, arr, sub, 4, 3, 0);
        System.err.println();
        subsSum(0, arr, sub, 4, 3, 0);
        System.out.println(countSubs(0, arr, sub, 4, 3, 0));
    }
}
