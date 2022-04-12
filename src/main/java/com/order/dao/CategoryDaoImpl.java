package com.order.dao;

import com.order.entities.Category;
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
public class CategoryDaoImpl implements CategoryDao{
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
    public Category findById(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM category WHERE category_id = ?";
        Category c = new Category();
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();


            while (rs.next()) {
                int categoryId = rs.getInt("category_id");
                String name = rs.getString("category_title");
                c.setCategoryId(categoryId);
                c.setCategoryTitle(name);

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
    public Category findByName(String name) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM category WHERE category_id like '%"+ name + "%' ";
        Category c = new Category();
        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();


            while (rs.next()) {
                int categoryId = rs.getInt("category_id");
                String categoryTitle = rs.getString("category_title");
                c.setCategoryId(categoryId);
                c.setCategoryTitle(categoryTitle);

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
    public Boolean create(Category category) {
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO category (category_id, category_title) VALUE (?,?)";
        boolean result = false;

        try {
            conn = dataSource.getConnection();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, category.getCategoryId());
            ps.setString(2, category.getCategoryTitle());

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
