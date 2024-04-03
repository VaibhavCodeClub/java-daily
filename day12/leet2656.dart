// Maximum Sum With Exactly K Elements
/*
You are given a 0-indexed integer array nums and an integer k. Your task is to perform the following operation exactly k times in order to maximize your score:

    Select an element m from nums.
    Remove the selected element m from the array.
    Add a new element with a value of m + 1 to the array.
    Increase your score by m.

Return the maximum score you can achieve after performing the operation exactly k times.
*/


void main(List<String> args) {
  int maximizeSum(List<int> nums, int k) {
    nums.sort();
    int s = nums.length - 1;
    int sum = 0;
    for (var i = 0; i < k; i++) {
      sum += nums[s];
      nums[s] = nums[s] + 1;
    }
    return sum;
  }

// Better approach
  int maximizeSum0(List<int> nums, int k) {
    nums.sort();
    int max = 0;
    for (int i = 0; i < k; i++) {
      max += nums[nums.length - 1] + i;
    }
    return max;
  }

  List<int> a = [
    4,
    4,
    9,
    10,
    10,
    9,
    3,
    8,
    4,
    2,
    5,
    3,
    8,
    6,
    1,
    10,
    4,
    5,
    3,
    2,
    3,
    9,
    5,
    7,
    10,
    4,
    9,
    10,
    1,
    10,
  ];
  List<int> ab = [1, 2, 3, 4, 5];
  print(maximizeSum(a, 6));
  print(maximizeSum0(ab, 3));
}
