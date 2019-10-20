public class SolutionToWater {
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int mm = 0;//用于存遍历过程中得到的存水最大值
        while(true){
            int m = (j-i)*(height[i] <= height[j]?height[i++]:height[j--]);
            if(m > mm) mm = m;
            if(i == j) break;
        }
        return mm;
    }
}
