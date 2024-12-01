class Solution {
    int bs(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public boolean checkIfExist(int[] arr) {
        int check = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            check = bs(arr, 2 * arr[i]);
            if (check != -1 && check != i) {
                return true;
            }
        }
        return false;
    }
}