// class Node {

//   int data;
//   Node next;

//   // Node() {}

//   Node(int data) {
//     this.data = data;
//     this.next = null;
//   }
// }

// class Stack {

//   Node top;
//   int size = 0;

//   void push(int val) {
//     Node temp = new Node(val);
//     temp.next = top;
//     top = temp;
//     size++;
//   }

//   int pop() {
//     if (size == 0) {
//       System.out.println("Stack Empty");
//       return -1;
//     }
//     size--;
//     int data = top.data;
//     top = top.next;
//     return data;
//   }

//   int top() {
//     if (top != null) return top.data;
//     return -1;
//   }

//   int size() {
//     return size;
//   }
// }

// public class LL {

//   private class Queue {

//     Node end;
//     Node start = end;
//     int size;

//     void push(int val) {
//       Node temp = new Node(val);
//       if (start == null && end == null) {
//         start = temp;
//         end = temp;
//       } else {
//         end.next = temp;
//         end = end.next;
//       }
//       size++;
//     }

//     int pop() {
//       if (size == 0) {
//         System.out.println("Empty Queue");
//         return -1;
//       } else {
//         size--;
//         int num = start.data;
//         start = start.next;
//         return num;
//       }
//     }
//   }

//   public static void main(String[] args) {
//     Stack st = new Stack();

//     st.push(10);
//     st.push(20);

//     System.out.println(st.top());
//     st.pop();
//     st.pop();
//     System.out.println(st.top());
//     System.out.println(st.size);
//     System.out.println(st.size());
//   }
// }
