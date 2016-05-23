public class Gnrc {
    private static boolean fileProcessed = false;


    public static class Process1Thread extends Thread {
        public void run() {
            System.out.println("1111111111启动");
            while (!fileProcessed) {
                try {
                    long start = System.currentTimeMillis();
                    Thread.sleep(1 * 10 * 1000);
                    long end = System.currentTimeMillis();
                    System.out.println("休息了多少秒" + (end - start) / 1000);
                } catch (InterruptedException e) {
                }
            }
            System.out.println("111111111111111的工作被终止");
        }
    }


    public static class Process2Thread extends Thread {
        public void run() {
            System.out.println("22222222222启动中,他可以终止111111的工作..现在拭目以待");
            fileProcessed = true;
        }
    }

    public static void main(String[] args) {
        new Process1Thread().start();
        new Process2Thread().start();
    }
}