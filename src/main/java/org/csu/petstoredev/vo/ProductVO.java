package org.csu.petstoredev.vo;


import lombok.Data;
import org.csu.petstoredev.entity.Item;

import java.util.List;

@Data
public class ProductVO {
    private String categoryId;
    private String productId;
    private String name;
    private List<Item> itemList;
}
