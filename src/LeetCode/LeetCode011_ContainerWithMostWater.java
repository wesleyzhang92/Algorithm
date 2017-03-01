package LeetCode;

/**
 * Container With Most Water
 * <p>
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 * <p>
 * KeyWords: Array, Two pointers
 * Difficulty: Medium
 */
public class LeetCode011_ContainerWithMostWater {
    //超时
    public int maxAre1a(int[] height) {
        int max = 0;
        int he_min = height[0];
        for (int i = 0; i < height.length; i++) {
            if (height[i] < he_min) {
                continue;
            } else {
                he_min = height[i];
            }
            for (int j = 1; i + j < height.length; j++) {
                int hei = Math.min(height[i], height[i + j]);
                max = hei * j > max ? hei * j : max;
            }
        }
        return max;
    }

    public int maxArea2(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right])
                    * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }
}
