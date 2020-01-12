package com.wchat.secondhand.index;

import com.wchat.secondhand.entity.Items;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IndexService {
    public List<Items> getItemsList();
    public boolean insertItems(Items items);
}
