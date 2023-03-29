package pro.sky.homework18;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    final static int maxNumberOfEmployees = 10;
    public List<Employee> employees = new ArrayList<>(maxNumberOfEmployees);

    public Employee addEmployee(String firstName, String lastName) {
        if (findEmployeeByFullName(firstName, lastName) != null) {
            throw new EmployeeAlreadyAddedException("в массиве уже есть такой сотрудник");
        }
        if (employees.size() == maxNumberOfEmployees) {
            throw new EmployeeStorageIsFullException("массив сотрудников переполнен");
        }
        Employee employee = new Employee(firstName, lastName);
        employees.add(employee);
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName, lastName);
        employees.remove(employee);
        return employee;
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = findEmployeeByFullName(firstName, lastName);
        if (employee == null) {
            throw new EmployeeNotFoundException("искомый сотрудник не найден");
        }
        return employee;
    }

    private Employee findEmployeeByFullName(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.getFirstName().equals(firstName.trim()) && employee.getLastName().equals(lastName.trim())) {
                return employee;
            }
        }
        return null;
    }

    public boolean checkParameters(Object param1, Object param2) {
        return (param1 != null && param2 != null);
    }
}
