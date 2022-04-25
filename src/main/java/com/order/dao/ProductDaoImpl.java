package com.order.dao;

import com.order.entities.Category;
import com.order.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductDaoImpl implements ProductDao{
    @Autowired
    private DataSource dataSource;

    public void closeConn(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void closePs(PreparedStatement ps, ResultSet rs) {
        try {
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Product findById(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM product WHERE product_id = ?";
        Product c = new Product();
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();


            while (rs.next()) {
                int productId = rs.getInt("product_id");
                String name = rs.getString("product_name");
                int price  = rs.getInt("price");
                int soLuong = rs.getInt("so_luong");
                int categoryId = rs.getInt("category_id");

                c.setProductId(productId);
                c.setProductName(name);
                c.setPrice(price);
                c.setNumber(soLuong);
                c.setCategoryId(categoryId);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeConn(conn);
            closePs(ps, rs);
        }
        return c;

    }

    @Override
    public List<Product> findProductByCategory(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM product WHERE category_id = ?";
        List<Product> lst = new ArrayList<>();
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();


            while (rs.next()) {
                int productId = rs.getInt("product_id");
                String name = rs.getString("product_name");
                int price  = rs.getInt("price");
                int number = rs.getInt("number");
                int categoryId = rs.getInt("category_id");
                lst.add(new Product(productId,name,price,number,categoryId));

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeConn(conn);
            closePs(ps, rs);
        }
        return lst;
    }

    @Override
    public Boolean create(Product product) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO product (product_name,price, number,category_id) VALUE (?,?,?,?)";
        boolean result = false;

        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setString(1, product.getProductName());
            ps.setInt(2,product.getPrice());
            ps.setInt(3,product.getNumber());
            ps.setInt(4,product.getCategoryId());

            int e = ps.executeUpdate();
            if (e > 0) result = true;

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeConn(conn);
            closePs(ps, null);
        }

        return result;
    }
}
