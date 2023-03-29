package pro.sky.homework18;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Object addEmployee(@RequestParam String firstName, String lastName) {
        if (!employeeService.checkParameters(firstName, lastName)) {
            //return "неверно указаны параметры в запросе!";
            throw new EmployeeBadParameters();
        }
        try {
            return employeeService.addEmployee(firstName, lastName);
        } catch (IllegalArgumentException e) {
            return "неверно указаны имя фамилия сотрудника!";
        } catch (EmployeeStorageIsFullException e) {
            return "превышено максимальное количество сотрудников!";
        } catch (EmployeeAlreadyAddedException e) {
            return "такой сотрудник уже есть!";
        }
    }

    @GetMapping("/remove")
    public Object removeEmployee(@RequestParam String firstName, String lastName) {
        if (!employeeService.checkParameters(firstName, lastName)) {
            //return "неверно указаны параметры в запросе!";
            throw new EmployeeBadParameters();
        }
        try {
            return employeeService.removeEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            return "удаляемый сотрудник не найден!";
        }
    }

    @GetMapping("/find")
    public Object findEmployee(@RequestParam String firstName, String lastName) {
        if (!employeeService.checkParameters(firstName, lastName)) {
            //return "неверно указаны параметры в запросе!";
            throw new EmployeeBadParameters();
        }
        try {
            return employeeService.findEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            return "искомый сотрудник не найден!";
        }
    }

    @GetMapping("/listEmployees")
    public Object getListEmployees() {
            return employeeService.employees;
    }
}
