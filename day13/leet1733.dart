// Neither Minimum nor Maximum
// Given an integer array nums containing distinct positive integers, find and return any number from the array that is neither the minimum nor the maximum value in the array, or -1 if there is no such number.

// Return the selected integer.

int findNonMinOrMax(List<int> nums) {
  if (nums.length <= 2) return -1;
  nums.sort();
  return nums[1];
}

void main(List<String> args) {
  print(findNonMinOrMax([3,2,1,4]));
  print(findNonMinOrMax([3,2]));
  print(findNonMinOrMax([3,2,1]));
}
