class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length3 = length1 + length2;
        int[] mergedArray = new int[length3];
        int left = 0;
        int right = 0;
        int count = 0;

        // Merge the two arrays
        while (left < length1 || right < length2) {
            if (left < length1 && (right >= length2 || nums1[left] <= nums2[right])) {
                mergedArray[count++] = nums1[left++];
            } else {
                mergedArray[count++] = nums2[right++];
            }
        }

        // Calculate the median
        if (length3 % 2 == 0) { // length of merged array is even
            int a = mergedArray[length3 / 2 - 1];
            int b = mergedArray[length3 / 2];
            return (a + b) / 2.0;
        } else { // length of merged array is odd
            return mergedArray[length3 / 2];
        }
    }
}
