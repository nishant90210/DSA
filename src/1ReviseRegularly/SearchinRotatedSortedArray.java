package Programs;

public class SearchinRotatedSortedArray {

    public static void main(String[] args) {

        int[] nums = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int target = 3;
        int start = 0;
        int end = nums.length-1;
        while (start < end){
            int mid = (end + start) / 2;
            if(nums[mid] > nums[end]) {//in Sorted array elements are in increasing order, so if this is not the case increase ur
                start = mid + 1;       //start else meaning array is in sorted order till mid we need to find out the smallest value for
            } else {                   //we need to decrease the end till mid
                end = mid;
            }
        }
        int newStart = start;
        start = 0;
        end = nums.length-1;
        if (target >= nums[newStart] && target <= nums[end]){
            start = newStart;
        }else {
            end = newStart;
        }
        while (start <= end){
            int mid = (end + start) / 2;
            if (target == nums[mid]){
                System.out.println(mid);
                return;
            }else if (target > nums[mid]){
                start = mid + 1;
            }else if (target < nums[mid]){
                end = mid - 1;
            }
        }
        System.out.println(-1);
    }
}
