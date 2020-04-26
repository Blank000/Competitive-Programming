public class knapsackProblem_0_1 {
    //This Algo is used to find out how can we maxmize the value of some items. Lets say there are few weights of some values and you want to choose items out of it such that the calue is maximised. So we use this.

    //  Imagine the weights are 1,2,3  and the values are 2,4,1. How can we choose two items such that total value is maximum
    //  We will make an arraylist of weights vs number of different weights. Here we will make 
    // and then we can see that holding weight 2 and 3 will be a wise option.

    //Method

    public static int knapSack(int[] weightArr, int[] valuesArr, int totalWeight) {
        int[][] res = new int[weightArr.length+1][totalWeight+1];
        for (int i=0;i<= weightArr.length; i++) {
            for (int k=0; k<= totalWeight; k++) {
                if (i == 0 || k == 0) {
                    res[i][k] = 0;
                }else if (weightArr[i-1] <= k) {
                    res[i][k] = Math.max(valuesArr[i-1]+res[i-1][k-weightArr[i-1]], res[i-1][k]);
                } else {
                    res[i][k] = res[i-1][k];
                }
            }
        }
        return res[weightArr.length][totalWeight];
    }

    public static void main(String[] args) {
        System.out.println(knapSack(new int[]{2, 3, 5, 4}, new int[]{4,2,6,2}, 7));
    }
}
