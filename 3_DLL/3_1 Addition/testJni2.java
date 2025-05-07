testJni2.java
public class testJni2
{
static{
System.loadLibrary("native");
}
public static void main(String args[])
{
System.out.println("Addition is "+ new testJni2().add(10,20));
}
private native int add(int n1,int n2);
}
