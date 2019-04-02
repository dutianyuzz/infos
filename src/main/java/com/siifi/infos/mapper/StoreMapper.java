package com.siifi.infos.mapper;

import com.siifi.infos.entity.Store;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface StoreMapper {
    public List<Store> selectAll();
}
