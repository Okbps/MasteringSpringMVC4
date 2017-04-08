package masterSpringMvc;

/**
 * Created by Aspire on 06.04.2017.
 */
public class TestClass {
    private String s;

    public static void main(String[] args) {
        TestClass t1, t2, t3, t4;
        t1 = t2 = new TestClass("a");
        t3 = new TestClass("b");

        System.out.println(t1.getS());
        System.out.println(t2.getS());
        System.out.println(t3.getS());

        t2.setS("c");
        System.out.println(t1.getS());
        System.out.println(t2.getS());

        t1.setS("d");
        System.out.println(t1.getS());
        System.out.println(t2.getS());
    }

    public TestClass(String s) {
        this.s = s;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }
}
