class MaxAreaSolution {
    public int maxArea(int h, int w, int[] hc, int[] vc) {
        // 3D search algorithm necessary
        // Solution -- sort arrays -- find max height and with of difference max for start comparison values
        // search through respective height and width arrays for maxes
        // return area of max hieght and width -- Error decimals needed -- Cast to long before returning to int
        Arrays.sort(hc);
        Arrays.sort(vc);
        int maxh = Math.max(hc[0], h - hc[hc.length-1]);
        int maxv = Math.max(vc[0], w - vc[vc.length-1]);
        for (int i = 1; i < hc.length; i++) {
            maxh = Math.max(maxh, hc[i] - hc[i-1]);
        }
        for (int i = 1; i < vc.length; i++) {
            maxv = Math.max(maxv, vc[i] - vc[i-1]);
        }
        return (int)((long)maxh * maxv % 1000000007);
    }
}
