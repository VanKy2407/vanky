package com.example.baitap.test;
import com.example.baitap.Service.SinhVienService;

import com.example.baitap.entity.SinhVien;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class SinhVienTest {
    SinhVienService service;

    @BeforeEach
    public void setup() {
        service = new SinhVienService();
    }

    // Test thêm sinh viên hợp lệ
    @Test
    public void testAddSinhVienValid() {
        SinhVien sv = new SinhVien(1, "Nguyen Van A", "CNTT", "2023", "Java");
        service.addSinhVien(sv);
        assertEquals(1, service.getAll().size());
    }

    // Test thêm nhiều sinh viên
    @Test
    public void testAddMultipleSinhVien() {
        service.addSinhVien(new SinhVien(1, "Nguyen Van A", "CNTT", "2023", "Java"));
        service.addSinhVien(new SinhVien(2, "Tran Van B", "KTPM", "2022", "Python"));
        assertEquals(2, service.getAll().size());
    }

    // Test tìm kiếm sinh viên hợp lệ
    @Test
    public void testSearchSinhVienValid() {
        SinhVien sv = new SinhVien(1, "Nguyen Van A", "CNTT", "2023", "Java");
        service.addSinhVien(sv);

        SinhVien found = service.searchSinhVien(1);
        assertNotNull(found);
        assertEquals(1, found.getMaSV());
        assertEquals("Nguyen Van A", found.getTenSV());
    }

    // Test tìm kiếm sinh viên không tồn tại
    @Test
    public void testSearchSinhVienInvalid() {
        SinhVien found = service.searchSinhVien(999); // Không có sinh viên này
        assertNull(found);
    }

    // Test thêm sinh viên có mã số trùng
    @Test
    public void testAddDuplicateMaSV() {
        SinhVien sv1 = new SinhVien(1, "Nguyen Van A", "CNTT", "2023", "Java");
        SinhVien sv2 = new SinhVien(1, "Tran Van B", "KTPM", "2022", "Python");

        service.addSinhVien(sv1);
        service.addSinhVien(sv2);

        assertEquals(2, service.getAll().size()); // Vì chưa có check trùng, cả 2 đều thêm vào
    }

    // Test danh sách sinh viên trống
    @Test
    public void testEmptyList() {
        assertEquals(0, service.getAll().size());
    }

    // Test thêm sinh viên với thông tin null
    @Test
    public void testAddSinhVienWithNull() {
        SinhVien sv = new SinhVien(2, null, null, null, null);
        service.addSinhVien(sv);
        assertNotNull(service.searchSinhVien(2));
    }
}
