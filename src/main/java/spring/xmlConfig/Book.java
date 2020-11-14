package spring.xmlConfig;

public class Book {
    private String name;
    private Integer unit;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", unit=" + unit +
                '}';
    }
}
