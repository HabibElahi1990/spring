package springCore.annotationConfig;

import java.util.ArrayList;
import java.util.List;

public class DevDatabaseUtil implements DataSource {

    @Override
    public List<Employee> getEmployeeDetails(){
        List<Employee> empDetails = new ArrayList<>();
        Employee emp1 = new Employee(111,"Abc",11000);
        Employee emp2 = new Employee(222,"Xyz",22000);
        empDetails.add(emp1);
        empDetails.add(emp2);

        return empDetails;
    }
}
