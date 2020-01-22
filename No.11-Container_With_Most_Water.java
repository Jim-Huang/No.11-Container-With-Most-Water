/*採取雙指標的方式，逐一計算可以組成的面積來找到最大值*/
class Solution {
    public int maxArea(int[] height) {
        
        int left_index = 0;
        int right_index = height.length - 1; 
        int area = 0;                           //area = return的答案 = 能組成的最大面積
        while(left_index < right_index){
            
            //求可達到的高度(由於水不能溢出，容器高度將求較小邊長的值)
            int h = height[left_index]<height[right_index]?  height[left_index] : height[right_index];
            
            //計算面積(找最大值)
            area = area > h * (right_index - left_index)?  area : h * (right_index - left_index);
            
            //由於越大的邊長可以得到較大的面積的機會越高，因此將較小一邊的邊長篩選掉
            if(height[left_index] < height[right_index]){ 
                left_index++;
            }
            else{
                right_index--;
            }  
        }
        return area;
    }
}
