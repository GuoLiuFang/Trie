public class TestWaite {
    private static Object monitor = new Object();
    private static boolean fileProcessed = false;

    public static class Process1Thread extends Thread {
        public void run() {
            System.out.println("111111111启动");
            while (!fileProcessed) {
                synchronized (monitor) {
                    try {
                        System.out.println("遇见waite等待中");
                        monitor.wait();
                        Thread.yield();

                    } catch (InterruptedException e) {
                    }
                }
            }
//            System.out.println("File Processed, now upload file...");
            System.out.println("前置依赖已经完成.在这里可以开始工作啦..");
        }
    }

    public static class Process2Thread extends Thread {
        public void run() {
//            System.out.println("Start Processing File...");
            //do some processing on the files here...
            System.out.println("开始干活,完成后,通知后置依赖,//这里面Boolean的作用是控制检测..控制检测状态...");
            fileProcessed = true;
            synchronized (monitor) {
                monitor.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        new Process2Thread().start();
        new Process1Thread().start();
    }
}