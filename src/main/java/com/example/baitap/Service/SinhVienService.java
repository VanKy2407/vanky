package com.example.baitap.Service;


import com.example.baitap.entity.SinhVien;

import java.util.ArrayList;
import java.util.List;
public class SinhVienService {
    private List<SinhVien> danhSachSinhVien = new ArrayList<>();


    public void addSinhVien(SinhVien sv) {
        danhSachSinhVien.add(sv);
    }




    public SinhVien searchSinhVien(int maSV) {
        return danhSachSinhVien.stream()
                .filter(sv -> sv.getMaSV() == maSV)
                .findFirst()
                .orElse(null);
    }

    // Lấy danh sách sinh viên
    public List<SinhVien> getAll() {
        return danhSachSinhVien;
    }
}
