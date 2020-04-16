package springCore.xmlConfig;

public class Student {
    private Person person;
    private static Book book = new Book();
    private Integer nationalCode;

    public Student(Person person, Integer nationalCode) {
        this.person = person;
        this.nationalCode = nationalCode;
    }

    public Integer getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(Integer nationalCode) {
        this.nationalCode = nationalCode;
    }

    public Book createBookInstance() {
        return book;
    }

    @Override
    public String toString() {
        return "Student{" +
                "person=" + person +
                "book=" + book +
                ", nationalCode=" + nationalCode +
                '}';
    }
}
