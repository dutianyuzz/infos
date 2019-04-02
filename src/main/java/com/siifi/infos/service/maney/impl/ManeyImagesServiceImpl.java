package com.siifi.infos.service.maney.impl;

import com.siifi.infos.entity.ManeysImage;
import com.siifi.infos.mapper.ManeyImagesMapper;
import com.siifi.infos.service.maney.ManeyImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManeyImagesServiceImpl implements ManeyImagesService {
    @Autowired
    private ManeyImagesMapper maneyImagesMapper;

    public List<ManeysImage> getManey() {
        return maneyImagesMapper.listAll();
    }

    public ManeysImage getManeyById(int maneyId) {
        return maneyImagesMapper.findById(maneyId);
    }

    public void saveManey(ManeysImage maneysImage) {
        maneyImagesMapper.save(maneysImage);
    }

    public void editManey(ManeysImage maneysImage) {
        maneyImagesMapper.edit(maneysImage);
    }

    public void deleteManey(int maneyId) {
        maneyImagesMapper.delete(maneyId);
    }

}
