package com.example.baitap.Service;

import com.example.baitap.entity.XeOTO;

import java.util.ArrayList;
import java.util.List;

public class XeOTOService {
    private final List<XeOTO> xeList = new ArrayList<>();

    public void addXeOTO(XeOTO xe) {
        xeList.add(xe);
    }

    public List<XeOTO> getAll() {
        return xeList;
    }

    public void updateXeOTO(XeOTO xe, int id) {
        for (int i = 0; i < xeList.size(); i++) {
            if (xeList.get(i).getId() == id) {
                xeList.set(i, xe);
                return;
            }
        }
    }

    public void deleteXeOTO(int id) {
        xeList.removeIf(xe -> xe.getId() == id);
    }

    public XeOTO searchXeOTO(int id) {
        return xeList.stream().filter(xe -> xe.getId() == id).findFirst().orElse(null);
    }
}
