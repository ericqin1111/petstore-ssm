package org.csu.petstoredev.vo;

import lombok.Data;
import org.csu.petstoredev.entity.Product;

import java.util.List;

@Data
public class CategoryVO {
    private String categoryId;
    private String categoryName;
    private List<Product> productList;
}
