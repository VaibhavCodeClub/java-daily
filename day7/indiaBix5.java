class indiaBix5 extends Thread {
    public static void main(String[] args) {
        indiaBix5 t = new indiaBix5(); /* Line 5 */
        t.run(); /* Line 6 */
    }

    public void run() {
        for (int i = 1; i < 3; ++i) {
            System.out.print(i + "..");
        }
    }
}
