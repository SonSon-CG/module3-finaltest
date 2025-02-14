package com.example.module3finaltest.service;

import com.example.module3finaltest.model.MatBang;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class MatBangServiceDB implements IMatBangService{

    private Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/matbang";
            String username = "root";
            String password = "Svd2024@";
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    @Override
    public List<MatBang> findAll() {
        Connection connection = getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement("select * from matbang;");
            ResultSet resultSet = statement.executeQuery();
            List<MatBang> matBangs = new ArrayList<>();
            while (resultSet.next()) {
                MatBang matBang = new MatBang();
                matBang.setMaMatBang(resultSet.getString("ma_mat_bang"));
                matBang.setTrangThai(resultSet.getString("trang_thai"));
                matBang.setSoTang(resultSet.getInt("so_tang"));
                matBang.setDienTich(resultSet.getInt("dien_tich"));
                matBang.setLoai(resultSet.getString("loai"));
                matBang.setGiaThue(resultSet.getInt("gia_tien_thue"));
                matBang.setNgayBatDau(resultSet.getDate("ngay_bat_dau"));
                matBang.setNgayKetThuc(resultSet.getDate("ngay_ket_thuc"));
                matBangs.add(matBang);
            }
            return matBangs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(MatBang matBang) {
    }
}
