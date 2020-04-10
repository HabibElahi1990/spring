package springCore;

import java.util.Map;

public class Person{
    private static Person person=new Person();
    private Person(){}

    public static Person setPerson(){
        person.setFirstName("Ali");
        person.setLastName("Elahi");
        return person;
    }

    private String firstName;
    private String lastName;
    private Map<Integer,String> personType;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static Person getPerson() {
        return person;
    }

    public static void setPerson(Person person) {
        Person.person = person;
    }

    public Map<Integer, String> getPersonType() {
        return personType;
    }

    public void setPersonType(Map<Integer, String> personType) {
        this.personType = personType;
    }

    static class NestedClass{

        private int id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
