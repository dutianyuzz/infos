package com.siifi.infos.mapper;

import com.siifi.infos.entity.Zoology;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ZoologyMapper {
    public List<Zoology> listAll();
    public Zoology findById(int zoologyId);
    public void save(Zoology zoology);
    public void edit(Zoology zoology);
    public void delete(int zoologyId);

}
