package com.wchat.secondhand.index;

import com.wchat.secondhand.entity.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class IndexServiceImp implements  IndexService{

    @Autowired
    IndexMapper indexMapper;

    public List<Items> getItemsList(){  // 防止数据库中的异常数据的出现
        return indexMapper.getItemsList();
    }

    @Override
    public boolean insertItems(Items items) {
        int result = indexMapper.insertItems(items);
        if(result == 1){
            return true;
        }else {
            return false;
        }
    }
}
