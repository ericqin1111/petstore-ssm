package org.csu.petstoredev.controller;

import jakarta.servlet.http.HttpSession;
import org.csu.petstoredev.service.CatalogService;
import org.csu.petstoredev.vo.CategoryVO;
import org.csu.petstoredev.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/catalog")
public class CatalogController {
    @Autowired
    private CatalogService catalogService;

    @GetMapping("index")
    public String index(){
        return "catalog/main";
    }

    @GetMapping("viewCategory")
    public String viewCategory(@RequestParam String categoryId, Model model){
        CategoryVO categoryVO=catalogService.getCategory(categoryId);
        System.out.println("CVO:"+categoryVO.getProductList());
        model.addAttribute("category",categoryVO);
        return "catalog/category";
    }

    @GetMapping("viewProduct")
    public String viewProduct(@RequestParam String productId,Model model){
        ProductVo productVo=catalogService.getProduct(productId);
        System.out.println("VPO:"+productVo.getProductId());
        System.out.println("VPO:"+productVo.getItemList());
        model.addAttribute("product",productVo);

        return "catalog/product";
    }


}
