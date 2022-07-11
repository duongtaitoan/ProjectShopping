/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;

/**
 *
 * @author duong
 */
public class CategoryDTO implements Serializable{
    private int categoryId;
    private String typeCategory;

    public CategoryDTO() {
    }

    public CategoryDTO(int categoryId, String typeCategory) {
        this.categoryId = categoryId;
        this.typeCategory = typeCategory;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getTypeCategory() {
        return typeCategory;
    }

    public void setTypeCategory(String typeCategory) {
        this.typeCategory = typeCategory;
    }
    
    
    
}
