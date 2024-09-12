class Solution {
public:
    int maxArea(vector<int>& height) {
        int maximum=0;
        int left=0;
        int right=height.size()-1;
        while(left<right){
            int width=right-left;
            int area=min(height[left],height[right])*width;
            maximum=max(maximum, area);
            if(height[left]<=height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maximum;
    }
};