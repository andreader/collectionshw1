package sky.pro.collections.service;
import org.springframework.stereotype.Service;
import sky.pro.collections.domain.Employee;
import sky.pro.collections.exceptions.EmployeeAlreadyAddedException;
import sky.pro.collections.exceptions.EmployeeNotFoundException;
import sky.pro.collections.exceptions.EmployeeStorageIsFullException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employeeList;
    private static final int EMPLOYEE_AMOUNT = 2;

    {
        employeeList = new ArrayList<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (employeeList.size() >= EMPLOYEE_AMOUNT) {
            throw new EmployeeStorageIsFullException();
        } else {
            for (Employee employee : employeeList) {
                if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                    throw new EmployeeAlreadyAddedException();
                }
            }
            Employee employee = new Employee(firstName, lastName);
            employeeList.add(employee);
            return employee;
        }
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        for (Employee employee : employeeList) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                employeeList.remove(employee);
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        for (Employee employee : employeeList) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public List<Employee> printEmployeeList() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
        return new ArrayList<>(employeeList);
    }
}

