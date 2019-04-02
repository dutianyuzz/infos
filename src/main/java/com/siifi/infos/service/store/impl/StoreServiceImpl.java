package com.siifi.infos.service.store.impl;


import com.siifi.infos.entity.Store;
import com.siifi.infos.mapper.StoreMapper;
import com.siifi.infos.service.store.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreMapper storeMapper;
    public List<Store> getStore(){
        return storeMapper.selectAll();
    }


}
