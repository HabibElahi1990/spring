package springCore.annotationConfig;

public class Employee {
    private int id;
    private String name;
    private double sal;

    public Employee(int id,String name,double sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSal() {
        return sal;
    }
}
