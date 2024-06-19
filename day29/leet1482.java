// Minimum Number of Days to Make m Bouquets
/*
You are given an integer array bloomDay, an integer m and an integer k.

You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.

Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.
*/
class leet1482 {

    public static void main(String[] args) {
          System.out.println(minDays(new int[] { 1,10,3,10,2 }, 3,1)) ;

  }
    private static boolean isOkayDays(int mid, int[] bloomDay, int m, int k){
        int consecCount = 0, numOfBouquet = 0;
        for(int i = 0; i < bloomDay.length; i++){
            if(bloomDay[i] <= mid) consecCount++;
            else consecCount = 0;

            if (consecCount == k){
                numOfBouquet++;
                consecCount = 0;
            }
        }
        return (numOfBouquet >= m);
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long)m*k > n) return -1;

        int l = 1, r = 0, ans = -1;
        for(int i: bloomDay)
            r = i > r ? i : r;
        while(l <= r){
            int mid = (l + r) / 2;
            if(isOkayDays(mid, bloomDay, m, k)){
                ans = mid;
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
}