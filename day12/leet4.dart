// Median of Two Sorted Arrays
// Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

// The overall run time complexity should be O(log (m+n)).

void main() {
  double findMedianSortedArrays(List<int> nums1, List<int> nums2) {
    nums1.addAll(nums2);
    nums1.sort();
    int n = nums1.length;
    int mid = n ~/ 2;
    if (n % 2 != 0) {
      return nums1[mid].toDouble();
    }
    return (nums1[mid] + nums1[mid - 1]) / 2;
  }

  List<int> nums1 = [1, 2];
  List<int> nums2 = [3, 4];
  print(findMedianSortedArrays(nums1, nums2));
}
