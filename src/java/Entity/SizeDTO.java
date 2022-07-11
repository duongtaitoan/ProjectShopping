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
public class SizeDTO implements Serializable{
    private int sizeId;
    private int sizeProduct;

    public SizeDTO() {
    }

    public SizeDTO(int sizeId, int sizeProduct) {
        this.sizeId = sizeId;
        this.sizeProduct = sizeProduct;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public int getSizeProduct() {
        return sizeProduct;
    }

    public void setSizeProduct(int sizeProduct) {
        this.sizeProduct = sizeProduct;
    }
    
}
