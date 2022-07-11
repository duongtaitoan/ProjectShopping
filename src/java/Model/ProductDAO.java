/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;


import Entity.CategoryDTO;
import Entity.ProductDTO;
import Entity.SizeDTO;
import Uitilis.DBUitils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author duong
 */
public class ProductDAO implements Serializable {

    private Connection conn;
    private PreparedStatement state;
    private ResultSet rs;

    private void closeConnection() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (state != null) {
            state.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public ArrayList<ProductDTO> getProductByParam(String productName, Integer categoryID) throws Exception {
        ArrayList<ProductDTO> listProduct = new ArrayList<>();
        String sql = "SELECT p.product_id, p.product_name, p.description, p.sale_price, p.import_price,"
                + " p.quantity, p.status, p.import_date, p.category_id, p.product_image, ct.type_category"
                + " FROM tblProduct p"
                + " INNER JOIN tblCategory ct"
                + " ON p.category_id = ct.category_id"
                + " WHERE"
                + " p.quantity >= 0 and p.product_name LIKE ?";
        if (categoryID > 0) {
            sql += " and ct.category_id = " + categoryID;
        }
        sql += " and p.status = '"+Boolean.TRUE+"' Order by p.import_date DESC";
        try {
            conn = DBUitils.implementConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, "%" + productName + "%");
            rs = state.executeQuery();
            while (rs.next()) {
                ProductDTO product = new ProductDTO();
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setDescription(rs.getString("description"));
                product.setSalePrice(rs.getFloat("sale_price"));
                product.setImportPrice(rs.getFloat("import_price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setStatus(rs.getBoolean("status"));
                product.setImportDate(rs.getDate("import_date").toString());
                product.setProductImage(rs.getString("product_image"));

                CategoryDTO categorys = new CategoryDTO();
                categorys.setCategoryId(rs.getInt("category_id"));
                categorys.setTypeCategory(rs.getString("type_category"));
                product.setCategory(categorys);

                listProduct.add(product);
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return listProduct;
    }

    public Boolean insertProduct(ProductDTO product) throws Exception {
        boolean isSuccess = false;
        String sql = "INSERT INTO tblProduct"
                + " (product_name, description, sale_price, import_price, quantity,"
                + " status, import_date, category_id, product_image)"
                + " VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            conn = DBUitils.implementConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, product.getProductName());
            state.setString(2, product.getDescription());
            state.setFloat(3, product.getSalePrice());
            state.setFloat(4, product.getImportPrice());
            state.setInt(5, product.getQuantity());
            state.setBoolean(6, Boolean.TRUE);
            state.setTimestamp(7, java.sql.Timestamp.valueOf(product.getImportDate()));
            state.setInt(8, product.getCategoryId());
            state.setString(9, product.getProductImage());
            state.executeUpdate();
            isSuccess = true;
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return isSuccess;

    }

    public ProductDTO getProductByID(int productID) throws Exception {
        ProductDTO product = new ProductDTO();
        CategoryDTO category = new CategoryDTO();
        String sql = "SELECT p.product_id, p.product_name, p.description, p.sale_price, p.import_price, p.quantity,"
                + " p.status, p.import_date, p.product_image, p.category_id, ct.type_category"
                + " FROM tblProduct p"
                + " INNER JOIN tblCategory ct ON p.category_id = ct.category_id"
                + " WHERE p.product_id = ?";
        try {
            conn = DBUitils.implementConnection();
            state = conn.prepareStatement(sql);
            state.setInt(1, productID);
            rs = state.executeQuery();
            if (rs.next()) {
                product.setProductId(rs.getInt("product_id"));
                product.setProductName(rs.getString("product_name"));
                product.setDescription(rs.getString("description"));
                product.setSalePrice(rs.getFloat("sale_price"));
                product.setImportPrice(rs.getFloat("import_price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setStatus(rs.getBoolean("status"));
                product.setImportDate(rs.getDate("import_date").toString());
                product.setProductImage(rs.getString("product_image"));

                category.setCategoryId(rs.getInt("category_id"));
                category.setTypeCategory(rs.getString("type_category"));
                product.setCategory(category);
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return product;
    }

    public Boolean updateProduct(ProductDTO product) throws Exception {
        Boolean isSuccess = false;
        String sql = "UPDATE tblProduct set product_name = ?, description = ?, sale_price = ?, import_price = ?,"
                + " Quantity = ?, import_date = ?, product_image = ?, category_id = ?"
                + " WHERE product_id = ?";
        try {
            conn = DBUitils.implementConnection();
            state = conn.prepareStatement(sql);
            state.setString(1, product.getProductName());
            state.setString(2, product.getDescription());
            state.setFloat(3, product.getSalePrice());
            state.setFloat(4, product.getImportPrice());
            state.setInt(5, product.getQuantity());
            state.setString(6, product.getImportDate());
            state.setString(7, product.getProductImage());
            state.setInt(8, product.getCategoryId());
            state.setInt(9, product.getProductId());

            if (state.executeUpdate() > 0) {
                isSuccess = true;
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return isSuccess;
    }

    public Boolean deleteProduct(int productId) throws Exception {
        Boolean isSuccess = false;
        String sql = "UPDATE tblProduct set status = ? WHERE product_id = ?";
        try {
            conn = DBUitils.implementConnection();
            state = conn.prepareStatement(sql);
            state.setBoolean(1, Boolean.FALSE);
            state.setInt(2, productId);

            if (state.executeUpdate() > 0) {
                isSuccess = true;
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return isSuccess;
    }
    
    public int getQuantity(int productID) throws Exception {
        int quantity = 0;
        String sql = "SELECT quantity FROM tblProduct WHERE product_id = ?";
        try {
            conn = DBUitils.implementConnection();
            state = conn.prepareStatement(sql);
            state.setInt(1, productID);
            rs = state.executeQuery();
            while (rs.next()) {
                quantity = rs.getInt("quantity");
            }
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
        return quantity;
    }
    
    public void subQuantity(int productId, int subQuantity) throws Exception {
        String sql = "UPDATE tblProduct SET quantity = quantity - ? where product_id = ?";
        try {
            conn = DBUitils.implementConnection();
            state = conn.prepareStatement(sql);
            state.setInt(1, subQuantity);
            state.setInt(2, productId);
            state.executeUpdate();
        } catch (Exception e) {
        } finally {
            closeConnection();
        }
    }
}
