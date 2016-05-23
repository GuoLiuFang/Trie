import java.util.Random;

public class Main {
    private static Random random = new Random();
    private static int seed;

    public static void main(String[] args) {
        int[] codes = {2, 3, 5};
        int mount = 100;
        System.out.println(getSeed(codes, mount));
        System.out.println(getResult(codes, mount));
    }

    public static int getSeed(int[] codes, int mount) {
        int minUpLimit = Integer.MIN_VALUE;
        for (int i = 0; i < codes.length; i++) {
            if (codes[i] > minUpLimit) {
                minUpLimit = codes[i];
            }
        }
        return seed = (mount / minUpLimit) + 1;
    }

    public static String getResult(int[] codes, int mount) {
        int no_perfect = 0;
        int i = 0;
        int[] result = new int[codes.length];
        do {
            no_perfect = 0;
            i = 0;
            //给前n-1个随机分配系数..留下最后一个做判断..
            for (; i < codes.length - 1; i++) {
                result[i] = random.nextInt(seed);
                no_perfect += codes[i] * result[i];
            }
        } while ((mount - no_perfect) % codes[codes.length - 1] != 0);
        System.out.println("前两个一共" + no_perfect);
        //得到最后一个的系数
        result[codes.length - 1] = (mount - no_perfect) / codes[codes.length - 1];
        StringBuffer stringBuffer = new StringBuffer();
        for (int k = 0; k < result.length; k++) {
            stringBuffer.append(codes[k]).append("*").append(result[k]).append("+");
        }
        return stringBuffer.substring(0, stringBuffer.length() - 1);
    }
}
