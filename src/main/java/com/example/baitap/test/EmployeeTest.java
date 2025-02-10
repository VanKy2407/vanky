package com.example.baitap.test;


import com.example.baitap.Service.EmployeeService;
import com.example.baitap.entity.Employee;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class EmployeeTest {

    EmployeeService service;

    @BeforeEach
    public void setup() {
        service = new EmployeeService();
    }

    // 1️⃣ Test thêm nhân viên hợp lệ
    @Test
    public void testAddEmployeeValid() {
        Employee emp = new Employee(1, "John", "Doe", "john@example.com");
        service.addEmployee(emp);
        assertEquals(1, service.getAll().size());
    }

    // 2️⃣ Test thêm nhiều nhân viên
    @Test
    public void testAddMultipleEmployees() {
        service.addEmployee(new Employee(1, "John", "Doe", "john@example.com"));
        service.addEmployee(new Employee(2, "Jane", "Smith", "jane@example.com"));
        assertEquals(2, service.getAll().size());
    }

    // 3️⃣ Test sửa thông tin nhân viên hợp lệ
    @Test
    public void testUpdateEmployeeValid() {
        Employee emp = new Employee(1, "John", "Doe", "john@example.com");
        service.addEmployee(emp);

        Employee updatedEmp = new Employee(1, "Johnny", "Doe", "johnny@example.com");
        boolean result = service.updateEmployee(1, updatedEmp);

        assertTrue(result);
        assertEquals("Johnny", service.searchEmployee(1).getFirstName());
    }

    // 4️⃣ Test sửa nhân viên không tồn tại
    @Test
    public void testUpdateEmployeeInvalid() {
        Employee updatedEmp = new Employee(99, "Jack", "Brown", "jack@example.com");
        boolean result = service.updateEmployee(99, updatedEmp);
        assertFalse(result);
    }

    // 5️⃣ Test xóa nhân viên hợp lệ
    @Test
    public void testDeleteEmployeeValid() {
        Employee emp = new Employee(1, "John", "Doe", "john@example.com");
        service.addEmployee(emp);

        boolean result = service.deleteEmployee(1);
        assertTrue(result);
        assertEquals(0, service.getAll().size());
    }

    // 6️⃣ Test xóa nhân viên không tồn tại
    @Test
    public void testDeleteEmployeeInvalid() {
        boolean result = service.deleteEmployee(99);
        assertFalse(result);
    }

    // 7️⃣ Test tìm kiếm nhân viên hợp lệ
    @Test
    public void testSearchEmployeeValid() {
        Employee emp = new Employee(1, "John", "Doe", "john@example.com");
        service.addEmployee(emp);

        Employee found = service.searchEmployee(1);
        assertNotNull(found);
        assertEquals("John", found.getFirstName());
    }

    // 8️⃣ Test tìm kiếm nhân viên không tồn tại
    @Test
    public void testSearchEmployeeInvalid() {
        Employee found = service.searchEmployee(99);
        assertNull(found);
    }

    // 9️⃣ Test danh sách nhân viên trống
    @Test
    public void testEmptyEmployeeList() {
        assertEquals(0, service.getAll().size());
    }

    // 🔟 Test thêm nhân viên có email null
    @Test
    public void testAddEmployeeWithNullEmail() {
        Employee emp = new Employee(2, "Jane", "Smith", null);
        service.addEmployee(emp);
        assertNull(service.searchEmployee(2).getEmail());
    }

    // 1️⃣1️⃣ Test sửa nhân viên với thông tin trống
    @Test
    public void testUpdateEmployeeWithEmptyFields() {
        Employee emp = new Employee(1, "John", "Doe", "john@example.com");
        service.addEmployee(emp);

        Employee updatedEmp = new Employee(1, "", "", "");
        boolean result = service.updateEmployee(1, updatedEmp);

        assertTrue(result);
        assertEquals("", service.searchEmployee(1).getFirstName());
    }

    // 1️⃣2️⃣ Test thêm nhân viên với ID âm
    @Test
    public void testAddEmployeeWithNegativeId() {
        Employee emp = new Employee(-1, "Alice", "Green", "alice@example.com");
        service.addEmployee(emp);
        assertNull(service.searchEmployee(-1));
    }

    // 1️⃣3️⃣ Test thêm nhân viên trùng ID
    @Test
    public void testAddDuplicateEmployeeId() {
        Employee emp1 = new Employee(1, "John", "Doe", "john@example.com");
        Employee emp2 = new Employee(1, "Jane", "Smith", "jane@example.com");

        service.addEmployee(emp1);
        service.addEmployee(emp2);

        assertEquals(2, service.getAll().size()); // Do chưa kiểm tra trùng ID
    }

    // 1️⃣4️⃣ Test tìm kiếm nhân viên sau khi xóa
    @Test
    public void testSearchAfterDelete() {
        Employee emp = new Employee(1, "John", "Doe", "john@example.com");
        service.addEmployee(emp);
        service.deleteEmployee(1);

        Employee found = service.searchEmployee(1);
        assertNull(found);
    }

    // 1️⃣5️⃣ Test sửa nhân viên với email null
    @Test
    public void testUpdateEmployeeWithNullEmail() {
        Employee emp = new Employee(1, "John", "Doe", "john@example.com");
        service.addEmployee(emp);

        Employee updatedEmp = new Employee(1, "John", "Doe", null);
        boolean result = service.updateEmployee(1, updatedEmp);

        assertTrue(result);
        assertNull(service.searchEmployee(1).getEmail());
    }
}
