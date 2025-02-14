package com.example.module3finaltest.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class MatBang {
    private static final Set<String> maMatBangSet = new HashSet<>(); // Để kiểm tra trùng mã mặt bằng
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private String maMatBang;
    private double dienTich;
    private String trangThai;
    private int soTang;
    private String loai;
    private String moTa;
    private long giaThue;
    private Date ngayBatDau;
    private Date ngayKetThuc;

    public MatBang(String maMatBang, double dienTich, String trangThai, int soTang, String loai, String moTa, long giaThue, String ngayBatDau, String ngayKetThuc) throws ParseException {
        setMaMatBang(maMatBang);
        setDienTich(dienTich);
        setTrangThai(trangThai);
        setSoTang(soTang);
        setLoai(loai);
        this.moTa = moTa;
        setGiaThue(giaThue);
        setNgayBatDauKetThuc(ngayBatDau, ngayKetThuc);
    }

    public String getMaMatBang() {
        return maMatBang;
    }

    public double getDienTich() {
        return dienTich;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public int getSoTang() {
        return soTang;
    }

    public String getLoai() {
        return loai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public long getGiaThue() {
        return giaThue;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public MatBang(String maMatBang, double dienTich, String trangThai, int soTang, String loai, String moTa, long giaThue, Date ngayBatDau, Date ngayKetThuc) {
        this.maMatBang = maMatBang;
        this.dienTich = dienTich;
        this.trangThai = trangThai;
        this.soTang = soTang;
        this.loai = loai;
        this.moTa = moTa;
        this.giaThue = giaThue;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public MatBang() {

    }

    public void setMaMatBang(String maMatBang) {
        if (!maMatBang.matches("^[A-Z0-9]{3}-[A-Z0-9]{2}-[A-Z0-9]{2}$")) {
            throw new IllegalArgumentException("Mã mặt bằng không đúng định dạng XXX-XX-XX.");
        }
        if (maMatBangSet.contains(maMatBang)) {
            throw new IllegalArgumentException("Mã mặt bằng đã tồn tại.");
        }
        this.maMatBang = maMatBang;
        maMatBangSet.add(maMatBang);
    }

    public void setDienTich(double dienTich) {
        if (dienTich <= 20) {
            throw new IllegalArgumentException("Diện tích phải lớn hơn 20m2.");
        }
        this.dienTich = dienTich;
    }

    public void setTrangThai(String trangThai) {
        if (!trangThai.equals("trống") && !trangThai.equals("hạ tầng") && !trangThai.equals("đầy đủ")) {
            throw new IllegalArgumentException("Trạng thái không hợp lệ.");
        }
        this.trangThai = trangThai;
    }

    public void setSoTang(int soTang) {
        if (soTang < 1 || soTang > 15) {
            throw new IllegalArgumentException("Số tầng phải từ 1 đến 15.");
        }
        this.soTang = soTang;
    }

    public void setLoai(String loai) {
        if (!loai.equals("share") && !loai.equals("full")) {
            throw new IllegalArgumentException("Loại mặt bằng không hợp lệ.");
        }
        this.loai = loai;
    }

    public void setGiaThue(long giaThue) {
        if (giaThue <= 1000000) {
            throw new IllegalArgumentException("Giá thuê phải lớn hơn 1,000,000 VNĐ.");
        }
        this.giaThue = giaThue;
    }

    public void setNgayBatDauKetThuc(String ngayBatDau, String ngayKetThuc) throws ParseException {
        Date start = dateFormat.parse(ngayBatDau);
        Date end = dateFormat.parse(ngayKetThuc);

        long diffMonths = (end.getTime() - start.getTime()) / (1000L * 60 * 60 * 24 * 30);
        if (diffMonths < 6) {
            throw new IllegalArgumentException("Ngày kết thúc phải lớn hơn ngày bắt đầu ít nhất 6 tháng.");
        }

        this.ngayBatDau = start;
        this.ngayKetThuc = end;
    }
}
