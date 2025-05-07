public class testJni2 {
    static {
        System.loadLibrary("native");
    }

    public static void main(String[] args) {
        int number1 = 5;
        int number2 = 4;
        System.out.println("Multiplication of " + number1 + " and " + number2 + " is: " + new testJni2().multiply(number1, number2));
    }

    private native int multiply(int n1, int n2);
}
