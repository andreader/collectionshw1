package sky.pro.collections.exceptions;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException() {
        super("Employee storage is full!");
    }
}
