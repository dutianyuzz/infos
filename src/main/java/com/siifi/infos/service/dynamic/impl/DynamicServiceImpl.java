package com.siifi.infos.service.dynamic.impl;

import com.github.pagehelper.PageHelper;
import com.siifi.infos.entity.Dynamic;
import com.siifi.infos.entity.PageInfo;
import com.siifi.infos.mapper.DynamicMapper;
import com.siifi.infos.service.dynamic.DynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DynamicServiceImpl implements DynamicService {
    @Autowired
    private DynamicMapper dynamicMapper;
    public PageInfo<Dynamic> getDynamic(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Dynamic> dynamics=dynamicMapper.listAll();
        PageInfo<Dynamic> pageInfo=new PageInfo<>(dynamics);
        return pageInfo;
    }
    public Dynamic getDynamicById(int dynamicId){
        return dynamicMapper.findById(dynamicId);
    }
    public void saveDynamic(Dynamic dynamic){
        dynamicMapper.save(dynamic);
    }
    public void editDynamic(Dynamic dynamic){
        dynamicMapper.edit(dynamic);
    }
    public void deleteDynamic(int dynamicId){
        dynamicMapper.delete(dynamicId);
    }

}
