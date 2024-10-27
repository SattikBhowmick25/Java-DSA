public class SubarraySum{
    //returns the number of subarrays with sum <= goal
    static int findSubsLE(int[] arr,int goal){
        int left = 0,right = 0;
        int sum = 0,count = 0;
        if(goal < 0)    return 0;
        while(right < arr.length){
            sum += arr[right];
            while(sum > goal){
                sum -= arr[left];
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
    static int findSubsEq(int[] arr,int goal){
        return (findSubsLE(arr, goal) - findSubsLE(arr, goal-1));
    }
    public static void main(String[] args) {
        int[] arr = {1,0,1,0,1};
        int count = findSubsEq(arr, 2);
        System.out.println(count);
    }
}