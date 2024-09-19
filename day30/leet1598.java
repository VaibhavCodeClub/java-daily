// Crawler Log Folder
/*
The Leetcode file system keeps a log each time some user performs a change folder operation.

The operations are described below:

    "../" : Move to the parent folder of the current folder. (If you are already in the main folder, remain in the same folder).
    "./" : Remain in the same folder.
    "x/" : Move to the child folder named x (This folder is guaranteed to always exist).

You are given a list of strings logs where logs[i] is the operation performed by the user at the ith step.

The file system starts in the main folder, then the operations in logs are performed.

Return the minimum number of operations needed to go back to the main folder after the change folder operations.
 */

import java.util.Stack;

public class leet1598 {
  public static void main(String[] args) {
    System.out.println(minOperations(new String[] { "d1/", "../", "../", "../" }));
    System.out.println(minOperations1(new String[] { "d1/", "d2/", "./", "d3/", "../", "d31/" }));
  }

  public static int minOperations(String[] logs) {
    Stack<String> folderStack = new Stack<>();
    for (String log : logs) {
      if (log.charAt(0) == '.') {
        if (log.charAt(1) == '/')
          ;
        else if (log.charAt(1) == '.' && !folderStack.isEmpty())
          folderStack.pop();
      } else {
        folderStack.add(log);
      }
    }
    return folderStack.size();
  }

  public static int minOperations1(String[] logs) {
    int ans = 0;
    for (String log : logs) {
      if (log.charAt(0) == '.' && log.charAt(1) == '.' && ans != 0) {
        ans--;
      } else if (log.charAt(0) != '.') {
        ans++;
      }
    }
    return ans;
  }
}
