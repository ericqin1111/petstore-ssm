package org.csu.petstoredev.service;

import org.csu.petstoredev.vo.CategoryVO;
import org.csu.petstoredev.vo.ProductVo;

public interface CatalogService {
    public CategoryVO getCategory(String categoryId);

    public ProductVo getProduct(String productId);
}
