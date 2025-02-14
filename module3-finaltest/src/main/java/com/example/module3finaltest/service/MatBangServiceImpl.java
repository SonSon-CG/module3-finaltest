package com.example.module3finaltest.service;

import com.example.module3finaltest.model.MatBang;

import java.util.ArrayList;
import java.util.List;

public class MatBangServiceImpl implements IMatBangService{
   private static List<MatBang> matBangs = new ArrayList<>();
    @Override
    public List<MatBang> findAll() {
        return matBangs;
    }

    @Override
    public void create(MatBang matBang) {
        matBangs.add(matBang);
    }
}
