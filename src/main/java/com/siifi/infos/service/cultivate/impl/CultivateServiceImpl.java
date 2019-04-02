package com.siifi.infos.service.cultivate.impl;

import com.siifi.infos.entity.Cultivate;
import com.siifi.infos.mapper.CultivateMapper;
import com.siifi.infos.service.cultivate.CultivateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CultivateServiceImpl implements CultivateService {
    @Autowired
    private CultivateMapper cultivateMapper;
    public List<Cultivate> getCultivate(){
        return cultivateMapper.listAll();
    }
    public Cultivate getCultivateById(int cultivateId){
        return cultivateMapper.findById(cultivateId);
    }
    public void saveCultivate(Cultivate cultivate){
        cultivateMapper.save(cultivate);
    }
    public void editCultivate(Cultivate cultivate){
        cultivateMapper.edit(cultivate);
    }
    public void deleteCultivate(int cultivateId){
        cultivateMapper.delete(cultivateId);
    }
}
