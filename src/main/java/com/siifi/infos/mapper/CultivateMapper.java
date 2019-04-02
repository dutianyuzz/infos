package com.siifi.infos.mapper;

import com.siifi.infos.entity.Cultivate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CultivateMapper {
    public List<Cultivate> listAll();
    public Cultivate findById(int cultivateId);
    public void save(Cultivate cultivate);
    public void edit(Cultivate cultivate);
    public void delete(int cultivateId);
}
