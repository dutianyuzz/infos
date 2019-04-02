package com.siifi.infos.service.msc.impl;

import com.siifi.infos.entity.Msc;
import com.siifi.infos.mapper.MscMapper;
import com.siifi.infos.service.msc.MscService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MscServiceImpl implements MscService {
    @Resource
    private MscMapper mscMapper;

    public List<Msc> getMsc(){
        return mscMapper.listAll();
    }
    public Msc getMscById(int mscId){
        return mscMapper.findById(mscId);
    }
    public boolean saveMsc(Msc msc){
        return mscMapper.save(msc);
    }

    public boolean editMsc(Msc msc){
        return mscMapper.edit(msc);
    }
    public boolean deleteMsc(int mscId){
        return mscMapper.delete(mscId);
    }

}
