package org.csu.petstoredev.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.csu.petstoredev.entity.Category;
import org.csu.petstoredev.entity.Item;
import org.csu.petstoredev.entity.Product;
import org.csu.petstoredev.persistence.CategoryMapper;
import org.csu.petstoredev.persistence.ItemMapper;
import org.csu.petstoredev.persistence.ProductMapper;
import org.csu.petstoredev.service.CatalogService;
import org.csu.petstoredev.vo.CategoryVO;
import org.csu.petstoredev.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CatalogService")
public class CatalogServiceImpl implements CatalogService {
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    ItemMapper itemMapper;
    @Override
    public CategoryVO getCategory(String categoryId) {
        CategoryVO categoryVO=new CategoryVO();
        Category category=categoryMapper.selectById(categoryId);

        QueryWrapper<Product> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("category",categoryId);
        List<Product> productList=productMapper.selectList(queryWrapper);

        categoryVO.setCategoryId(categoryId);
        categoryVO.setCategoryName(category.getName());
        categoryVO.setProductList(productList);

        return categoryVO;
    }

    public ProductVO getProduct(String productId){
        ProductVO productVo=new ProductVO();

        QueryWrapper<Item> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("productId",productId);
        List<Item> itemList=itemMapper.selectList(queryWrapper);
        String categoryId = productMapper.selectById(productId).getCategoryId();

        productVo.setCategoryId(categoryId);
        productVo.setProductId(productId);
        productVo.setItemList(itemList);

        return productVo;
    }


}
