package com.example.baitap.Service;

import com.example.baitap.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();

    // Thêm nhân viên
    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    // Sửa nhân viên theo ID
    public boolean updateEmployee(int id, Employee newEmp) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                emp.setFirstName(newEmp.getFirstName());
                emp.setLastName(newEmp.getLastName());
                emp.setEmail(newEmp.getEmail());
                return true;
            }
        }
        return false;
    }

    // Xóa nhân viên theo ID
    public boolean deleteEmployee(int id) {
        return employees.removeIf(emp -> emp.getId() == id);
    }

    // Lấy danh sách nhân viên
    public List<Employee> getAll() {
        return employees;
    }

    // Tìm kiếm nhân viên theo ID
    public Employee searchEmployee(int id) {
        return employees.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
