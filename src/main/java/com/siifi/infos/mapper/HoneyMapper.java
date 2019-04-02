package com.siifi.infos.mapper;
import com.siifi.infos.entity.Honey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface HoneyMapper {
    @Select("SELECT HONEY_ID,HONEY_NAME,UTTER,SHOU,DATE,IMAGEPATH from sys_honey")
    public List<Honey> listAll();
    public Honey findById(int honeyId);
    public void save(Honey honey);
    public void edit(Honey honey);
    public void delete(int honeyId);

}
