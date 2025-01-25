public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len=intervals.length;
        int count=0;
        int[][] ans=new int[len+1][2];
        int i=0;
        while(i<len && newInterval[0]>intervals[i][1]){
            ans[count][0]=intervals[i][0];
            ans[count][1]=intervals[i][1];
            count++;
            i++;
        }
        while(i<len && newInterval[1]>=intervals[i][0]){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        ans[count][0]=newInterval[0];
        ans[count][1]=newInterval[1];
        count++;

        while(i<len){
            ans[count][0]=intervals[i][0];
            ans[count][1]=intervals[i][1];
            count++;
            i++;
        }
        int[][] result=new int[count][2];
        for(int j=0;j<count;j++){
            result[j][0]=ans[j][0];
            result[j][1]=ans[j][1];
        }
        return result;
    }
}
