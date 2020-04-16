package springCore.xmlConfig;

public class University {
    private Student student;
    private String universityName;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    @Override
    public String toString() {
        return "University{" +
                "student=" + student +
                ", universityName='" + universityName + '\'' +
                '}';
    }
}
