package com.example.baitap.test;
import com.example.baitap.Service.BaiHatService;
import com.example.baitap.entity.BaiHat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class BaiHatTest {

    BaiHatService service;

    @BeforeEach
    public void setup() {
        service = new BaiHatService();
    }

    // 1️⃣ Test thêm bài hát hợp lệ
    @Test
    public void testAddBaiHatValid() {
        BaiHat baiHat = new BaiHat("1", "Bai Hat A", "Ca Si A", 200, "Nhac Si A");
        boolean result = service.addBaiHat(baiHat);
        assertTrue(result);
        assertEquals(1, service.getAll().size());
    }

    // 2️⃣ Test thêm bài hát có doDai <= 0 (Không hợp lệ)
    @Test
    public void testAddBaiHatWithInvalidDuration() {
        BaiHat baiHat = new BaiHat("2", "Bai Hat B", "Ca Si B", -50, "Nhac Si B");
        boolean result = service.addBaiHat(baiHat);
        assertFalse(result);
        assertEquals(0, service.getAll().size());
    }

    // 3️⃣ Test thêm nhiều bài hát
    @Test
    public void testAddMultipleBaiHat() {
        service.addBaiHat(new BaiHat("1", "Bai Hat A", "Ca Si A", 150, "Nhac Si A"));
        service.addBaiHat(new BaiHat("2", "Bai Hat B", "Ca Si B", 200, "Nhac Si B"));
        assertEquals(2, service.getAll().size());
    }

    // 4️⃣ Test xóa bài hát hợp lệ
    @Test
    public void testDeleteBaiHatValid() {
        BaiHat baiHat = new BaiHat("1", "Bai Hat A", "Ca Si A", 180, "Nhac Si A");
        service.addBaiHat(baiHat);

        boolean result = service.deleteBaiHat("1");
        assertTrue(result);
        assertEquals(0, service.getAll().size());
    }

    // 5️⃣ Test xóa bài hát không tồn tại
    @Test
    public void testDeleteBaiHatInvalid() {
        boolean result = service.deleteBaiHat("99");
        assertFalse(result);
    }

    // 6️⃣ Test tìm kiếm bài hát hợp lệ
    @Test
    public void testSearchBaiHatValid() {
        BaiHat baiHat = new BaiHat("1", "Bai Hat A", "Ca Si A", 210, "Nhac Si A");
        service.addBaiHat(baiHat);

        BaiHat found = service.searchBaiHat("1");
        assertNotNull(found);
        assertEquals("Bai Hat A", found.getTen());
    }

    // 7️⃣ Test tìm kiếm bài hát không tồn tại
    @Test
    public void testSearchBaiHatInvalid() {
        BaiHat found = service.searchBaiHat("99");
        assertNull(found);
    }

    // 8️⃣ Test danh sách bài hát trống
    @Test
    public void testEmptyBaiHatList() {
        assertEquals(0, service.getAll().size());
    }

    // 9️⃣ Test thêm bài hát có tên trống
    @Test
    public void testAddBaiHatWithEmptyName() {
        BaiHat baiHat = new BaiHat("3", "", "Ca Si C", 220, "Nhac Si C");
        boolean result = service.addBaiHat(baiHat);
        assertTrue(result);
        assertEquals("", service.searchBaiHat("3").getTen());
    }

    // 🔟 Test xóa bài hát khi danh sách rỗng
    @Test
    public void testDeleteBaiHatFromEmptyList() {
        boolean result = service.deleteBaiHat("1");
        assertFalse(result);
    }

    // 1️⃣1️⃣ Test thêm bài hát với ID null
    @Test
    public void testAddBaiHatWithNullId() {
        BaiHat baiHat = new BaiHat(null, "Bai Hat D", "Ca Si D", 250, "Nhac Si D");
        boolean result = service.addBaiHat(baiHat);
        assertTrue(result);
        assertNull(service.searchBaiHat(null).getId());
    }

    // 1️⃣2️⃣ Test thêm bài hát có doDai = 0
    @Test
    public void testAddBaiHatWithZeroDuration() {
        BaiHat baiHat = new BaiHat("5", "Bai Hat E", "Ca Si E", 0, "Nhac Si E");
        boolean result = service.addBaiHat(baiHat);
        assertFalse(result);
    }

    // 1️⃣3️⃣ Test tìm kiếm bài hát sau khi xóa
    @Test
    public void testSearchAfterDelete() {
        BaiHat baiHat = new BaiHat("6", "Bai Hat F", "Ca Si F", 300, "Nhac Si F");
        service.addBaiHat(baiHat);
        service.deleteBaiHat("6");

        BaiHat found = service.searchBaiHat("6");
        assertNull(found);
    }

    // 1️⃣4️⃣ Test thêm bài hát với doDai rất lớn
    @Test
    public void testAddBaiHatWithLargeDuration() {
        BaiHat baiHat = new BaiHat("7", "Bai Hat G", "Ca Si G", 999999, "Nhac Si G");
        boolean result = service.addBaiHat(baiHat);
        assertTrue(result);
        assertEquals(999999, service.searchBaiHat("7").getDoDai());
    }

    // 1️⃣5️⃣ Test tìm kiếm bài hát có tên cụ thể
    @Test
    public void testSearchBaiHatByName() {
        BaiHat baiHat = new BaiHat("8", "Mot Ngay Moi", "Ca Si H", 230, "Nhac Si H");
        service.addBaiHat(baiHat);

        BaiHat found = service.searchBaiHat("8");
        assertEquals("Mot Ngay Moi", found.getTen());
    }
}
