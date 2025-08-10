abstract class A  {
  private final String a;
  public A() {a = ("1");}

   public String method() {
     return "was in class A";
   }
   public String getA() {return a;}

   public  String t() {return "a";}
}

class B extends A {
  private final String b;

  public B() {
    super();
    b = "A";
  }

  public String method() {
    return "was in class B";
  }
  public String getB() {return b;}

  public String t() {return "b";}

  public String toString() {return b;}

}

class C extends B {
  private final String c;
  public C() {c = "1";}

  public String method() {return super.method();}
  public String getC() {return c;}

  // public String t() {return "c";}
}

public class Test {
  public static void main(String[] args) {
    C c = new C();
    B b = new B();
    System.out.println(b);
    System.out.println(c.method());
    // System.out.println(a.getA() == b.getB());
    System.out.println(c.t());
    System.out.println(c instanceof A);
  }
}
