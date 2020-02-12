package company;

public class Main {

    public static void main(String[] args) {
        Base base = new Child();
        Child child1 = (Child) base;
        child1.fun1();
        child1.fun2();
        child1.fun3();

    }
}
