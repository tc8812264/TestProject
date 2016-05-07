package practice;

public class ThreadDemo {
  public static void main(String[] args) {
    Thread th = new Thread() {
      public void run() {
        System.out.printf("lalala\n");
      }
    };
    th.start();
    try {
      th.join();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
