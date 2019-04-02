package com.siifi.infos.service.tid.impl;

import com.siifi.infos.entity.Tid;
import com.siifi.infos.mapper.TidMapper;
import com.siifi.infos.service.tid.TidService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TidServiceImpl implements TidService {
    @Resource
    TidMapper tidMapper;
    public Tid findByIdTid(int tid){
        return tidMapper.findById(tid);
    }
    public int editTid(Tid tid){
        return tidMapper.edit(tid);
    }
}
