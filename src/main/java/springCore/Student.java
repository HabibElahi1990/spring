package springCore;

public class Student {
    private static Book book=new Book();
    private Integer nationalCode;

    public Integer getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(Integer nationalCode) {
        this.nationalCode = nationalCode;
    }

    public Book createBookInstance(){
        return book;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nationalCode=" + nationalCode + "   \n"+
                 book.toString() +
                '}';
    }
}
