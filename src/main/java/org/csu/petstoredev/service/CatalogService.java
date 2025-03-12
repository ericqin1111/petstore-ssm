package org.csu.petstoredev.service;

import org.csu.petstoredev.vo.CategoryVO;
import org.csu.petstoredev.vo.ProductVO;

public interface CatalogService {
    public CategoryVO getCategory(String categoryId);

    public ProductVO getProduct(String productId);
}
