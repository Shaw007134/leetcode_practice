class trapping_rain_water {
    public static int trap(int[] height){
        int res = 0;
        int start = 0;
        int end = height.length - 1;
        while(start < end){
            if(height[start] < height[end]){
                int current = height[start++];
                while(height[start] < current){
                    res += current - height[start++];
                }
            }else{
                int current = height[end--];
                while (height[end] < current){
                    res += current - height[end--];
                }
            }
        }
        return res;
    }
}
