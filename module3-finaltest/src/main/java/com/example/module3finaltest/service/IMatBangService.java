package com.example.module3finaltest.service;

import com.example.module3finaltest.model.MatBang;

import java.util.List;

public interface IMatBangService {
    List<MatBang> findAll();

    void create(MatBang matBang);


}
