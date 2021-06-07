class MinCostClimbingStairsSolution {
    public int minCostClimbingStairs(int[] cost) {
        //No special condition b/c 2 <= cost.length <= 1000
        //Search first 2 array positions
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i-1], cost[i-2]);            
        }
        //Recursively call function until end and pass array of min value
        return Math.min(cost[cost.length-1], cost[cost.length-2]);
    }
}
