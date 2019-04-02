package com.siifi.infos.mapper;

import com.siifi.infos.entity.Media;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MediaMapper {
    public List<Media> listAll();
    public Media findById(int mediaId);
    public void save(Media media);
    public void edit(Media media);
    public void delete(int mediaId);
}
