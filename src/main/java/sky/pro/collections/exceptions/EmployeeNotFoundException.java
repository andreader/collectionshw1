package sky.pro.collections.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException() {
        super("This employee is not found.");
    }
}
