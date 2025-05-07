public class testJni2 {
    static {
        System.loadLibrary("native");
    }

    public static void main(String[] args) {
        System.out.println("Subtraction is: " + new testJni2().subtract(20, 10));
    }

    private native int subtract(int n1, int n2);
}
