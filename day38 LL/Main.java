public class Main {

  public static void main(String args[]) {
    LL list = new LL();
    list.insertFirst(10);
    list.insertFirst(0);
    list.insertLast(1);
    list.insertFirst(110);
    list.insertLast(89);
    list.insert(890, 0);

    list.display();
    System.out.println(list.deleteFirst());
    list.display();
    System.out.println(list.deleteLast());
    list.display();
    System.out.println(list.delete(2));
    list.display();
  }
}
