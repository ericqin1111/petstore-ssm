package org.csu.petstoredev.persistence;

import org.apache.ibatis.annotations.Mapper;
import org.csu.petstoredev.entity.Product;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
@Repository
public interface ProductMapper extends BaseMapper<Product> {

}
