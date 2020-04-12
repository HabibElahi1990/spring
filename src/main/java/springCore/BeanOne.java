package springCore;

public class BeanOne {


    private BeanTwo beanTwo=new BeanTwo();
    public BeanOne() {
        System.out.println("BeanOne constructor");
    }

    public void doSomthing() {
        System.out.println("Inside doSomthing() method of BeanOne");
        beanTwo.doSomthing();
    }

    public  void init(){
        System.out.println(" BeanOne init");
    }

    public void destroy(){
        System.out.println(" BeanOne destroy");
    }
}
