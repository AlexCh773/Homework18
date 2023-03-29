package pro.sky.homework18;

import java.util.Objects;

public class Employee {
    String firstName, lastName;

    public Employee(String firstName, String lastName) {
        if (firstName.trim().equals("") || lastName.trim().equals("")) {
            throw new IllegalArgumentException("неверно указаны имя фамилия сотрудника!");
        }
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getFirstName().equals(employee.getFirstName()) && getLastName().equals(employee.getLastName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }

    @Override
    public String toString() {
        return '"' + "firstName" + '"' + ": " + '"' + firstName + '"' + ", " +
                '"' + "lastName" + '"' + ": " + '"' + lastName + '"';
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
