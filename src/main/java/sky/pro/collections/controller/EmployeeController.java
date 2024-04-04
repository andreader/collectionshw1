package sky.pro.collections.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sky.pro.collections.domain.Employee;
import sky.pro.collections.service.EmployeeService;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<String> addEmployee(@RequestParam("firstName") String firstName,
                                              @RequestParam("lastName") String lastName) {
        try {
            Employee employee = employeeService.addEmployee(firstName, lastName);
            String message = "Employee added successfully: " + employee.toString();
            return ResponseEntity.ok(message);
        } catch (RuntimeException e) {
            String errorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    @GetMapping("/remove")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<String> removeEmployee(@RequestParam("firstName") String firstName,
                                                 @RequestParam("lastName") String lastName) {
        try {
            Employee employee = employeeService.removeEmployee(firstName, lastName);
            String message = "Employee removed successfully: " + employee.toString();
            return ResponseEntity.ok(message);
        } catch (RuntimeException e) {
            String errorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    @GetMapping("/find")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<String> findEmployee(@RequestParam("firstName") String firstName,
                                               @RequestParam("lastName") String lastName) {
        try {
            Employee employee = employeeService.findEmployee(firstName, lastName);
            String message = "Employee found successfully: " + employee.toString();
            return ResponseEntity.ok(message);
        } catch (RuntimeException e) {
            String errorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }


    @GetMapping("/print")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<?> printEmployeeList() {
        try {
            List<Employee> list = employeeService.printEmployeeList();
            return ResponseEntity.ok(list);
        } catch (RuntimeException e) {
            String errorMessage = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }
}