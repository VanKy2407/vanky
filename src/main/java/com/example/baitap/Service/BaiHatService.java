package com.example.baitap.Service;

import com.example.baitap.entity.BaiHat;

import java.util.ArrayList;
import java.util.List;

public class BaiHatService {
    private List<BaiHat> baiHatList = new ArrayList<>();

    // Thêm bài hát (Chỉ thêm nếu doDai > 0)
    public boolean addBaiHat(BaiHat baiHat) {
        if (baiHat.getDoDai() > 0) {
            baiHatList.add(baiHat);
            return true;
        }
        return false;
    }

    // Xóa bài hát theo ID
    public boolean deleteBaiHat(String id) {
        return baiHatList.removeIf(bh -> bh.getId().equals(id));
    }

    // Lấy danh sách bài hát
    public List<BaiHat> getAll() {
        return baiHatList;
    }

    // Tìm bài hát theo ID
    public BaiHat searchBaiHat(String id) {
        return baiHatList.stream()
                .filter(bh -> bh.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
