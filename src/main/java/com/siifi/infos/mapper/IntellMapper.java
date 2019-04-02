package com.siifi.infos.mapper;

import com.siifi.infos.entity.Intell;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IntellMapper {
    public List<Intell> listAll();
    public Intell findById(int intellId);
    public void save(Intell intell);
    public void edit(Intell intell);
    public void delete(int intellId);
}
