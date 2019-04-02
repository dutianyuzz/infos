package com.siifi.infos.service.honey.impl;
import com.github.pagehelper.PageHelper;
import com.siifi.infos.entity.Honey;
import com.siifi.infos.entity.PageInfo;
import com.siifi.infos.mapper.HoneyMapper;
import com.siifi.infos.service.honey.HoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HoneyServiceImpl implements HoneyService {
    @Autowired
    private HoneyMapper honeyMapper;
    public PageInfo<Honey> getHoney(Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Honey> honeys=honeyMapper.listAll();
        PageInfo<Honey> pageInfo=new PageInfo<>(honeys);
        return pageInfo;
    }
    public Honey getHoneyById(int honeyId){
        return honeyMapper.findById(honeyId);
    }
    public void saveHoney(Honey honey){
        honeyMapper.save(honey);
    }
    public void editHoney(Honey honey){ honeyMapper.edit(honey);
    }
    public void deleteHoney(int honeyId){
        honeyMapper.delete(honeyId);
    }
}
