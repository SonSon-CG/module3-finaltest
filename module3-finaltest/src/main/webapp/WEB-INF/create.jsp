<%--
  Created by IntelliJ IDEA.
  User: SON
  Date: 2/14/2025
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Tạo Mới Mặt Bằng</title>
</head>
<body>
<h2>Tạo Mới Mặt Bằng</h2>
<form action="/matbang" method="post">
    <label>Mã Mặt Bằng</label>
    <input type="text" name="maMatBang" required><br>

    <label>Diện Tích</label>
    <input type="number" name="dienTich" required><br>

    <label>Trạng Thái</label>
    <select name="trangThai">
        <option value="Trống">Trống</option>
        <option value="Hạ tầng">Hạ tầng</option>
        <option value="Đầy đủ">Đầy đủ</option>
    </select><br>

    <label>Số Tầng</label>
    <select name="soTang">
        <% for (int i = 1; i <= 15; i++) { %>
        <option value="<%= i %>"><%= i %></option>
        <% } %>
    </select><br>

    <label>Loại</label>
    <select name="loai">
        <option value="Share">Share</option>
        <option value="Full">Full</option>
    </select><br>

    <label>Mô Tả</label>
    <textarea name="moTa"></textarea><br>

    <label>Giá Cho Thuê</label>
    <input type="number" name="giaChoThue" required><br>

    <label>Ngày Bắt Đầu</label>
    <input type="date" name="ngayBatDau" required><br>

    <label>Ngày Kết Thúc</label>
    <input type="date" name="ngayKetThuc" required><br>

    <button type="submit">Tạo Mới</button>
</form>
</body>
</html>
