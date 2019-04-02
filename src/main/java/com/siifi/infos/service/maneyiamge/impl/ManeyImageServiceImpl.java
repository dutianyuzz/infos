package com.siifi.infos.service.maneyiamge.impl;

import com.siifi.infos.entity.ManeyImage;
import com.siifi.infos.mapper.ManeyImageMapper;
import com.siifi.infos.service.maneyiamge.ManeyImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManeyImageServiceImpl implements ManeyImageService {
    @Autowired
    private ManeyImageMapper maneyImageMapper;

    public List<ManeyImage> getManeyImage(){
        return maneyImageMapper.listAll();
    }
    public ManeyImage getManeyImageById(int maneyImageId){
        return maneyImageMapper.findById(maneyImageId);
    }
    public void saveManeyImage(ManeyImage maneyImage){
        maneyImageMapper.save(maneyImage);
    }
    public void editManeyImage(ManeyImage maneyImage){
        maneyImageMapper.edit(maneyImage);
    }
    public void deleteManeyImage(int maneyImageId){
        maneyImageMapper.delete(maneyImageId);
    }
    public void saveRelativityManey(List<ManeyImage> maneyImages){
        maneyImageMapper.saveRelativity(maneyImages);
    }
}
