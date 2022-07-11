/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.CategoryDTO;
import Entity.SizeDTO;
import Uitilis.DBUitils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author duong
 */
public class CategoryDAO implements Serializable{
    
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
    
    public ArrayList<CategoryDTO> getAllCategorys() throws SQLException, Exception {
        ArrayList<CategoryDTO> listCategory = new ArrayList<>();
        String sql = "SELECT category_id, type_category FROM tblCategory";
        try {
            conn = DBUitils.implementConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            while (rs.next()) {
                CategoryDTO cate = new CategoryDTO();
                cate.setCategoryId(rs.getInt("category_id"));
                cate.setTypeCategory(rs.getString("type_category"));
                listCategory.add(cate);
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return listCategory;
    }
    public ArrayList<SizeDTO> getAllSizeById(int productId) throws SQLException, Exception {
        ArrayList<SizeDTO> listSize = new ArrayList<>();
        String sql = "SELECT size_product, size_id FROM tblProductSize WHERE product_id = ?";
        try {
            conn = DBUitils.implementConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, productId);
            rs = preStm.executeQuery();
            while (rs.next()) {
                SizeDTO size = new SizeDTO();
                size.setSizeProduct(rs.getInt("size_product"));
                size.setSizeId(rs.getInt("size_id"));
                listSize.add(size);
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return listSize;
    }
}
