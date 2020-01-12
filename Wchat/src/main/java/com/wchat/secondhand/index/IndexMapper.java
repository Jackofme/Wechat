package com.wchat.secondhand.index;

import com.wchat.secondhand.entity.Items;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import java.util.List;


@Mapper
@Component
public interface IndexMapper {
    public List<Items> getItemsList();
    public int insertItems(Items items);
}
