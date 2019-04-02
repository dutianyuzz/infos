package com.siifi.infos.mapper;

import com.siifi.infos.entity.ManeyImage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ManeyImageMapper {
    public List<ManeyImage> listAll();
    public ManeyImage findById(int maneyImageId);
    public void save(ManeyImage maneyImage);
    public void edit(ManeyImage maneyImage);
    public void delete(int maneyImageId);
    //批量新增
    public void saveRelativity(List<ManeyImage> maneyImages);
}
