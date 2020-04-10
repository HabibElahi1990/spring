package springCore;

public class BeanOne {

    private BeanTwo beanTwo=new BeanTwo();
    public BeanOne() {
        System.out.println("BeanOne Initialized");
    }

    public void doSomthing() {
        System.out.println("Inside doSomthing() method of BeanOne");
        beanTwo.doSomthing();
    }
}
