package com.siifi.infos.mapper;

import com.siifi.infos.entity.ManeysImage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ManeyImagesMapper {
    public List<ManeysImage> listAll();

    public ManeysImage findById(int maneyId);

    public void save(ManeysImage maneysImage);

    public void edit(ManeysImage maneysImage);

    public void delete(int maneyId);
}
