package sky.pro.collections.exceptions;

public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException() {
        super("This employee is already added.");
    }
}
