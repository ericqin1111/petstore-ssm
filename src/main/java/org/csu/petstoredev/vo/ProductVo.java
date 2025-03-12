package org.csu.petstoredev.vo;


import lombok.Data;
import org.csu.petstoredev.entity.Item;

import java.util.List;

@Data
public class ProductVo {
    private String categoryId;
    private String productId;
    private List<Item> itemList;
}
