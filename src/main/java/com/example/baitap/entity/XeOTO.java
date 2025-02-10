package com.example.baitap.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class XeOTO {
    private int id;

    private String ten;

    private float gia;

    private String ghiChu;


}
