package com.siifi.infos.mapper;

import com.siifi.infos.entity.Dynamic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface DynamicMapper {
    @Select("select DYNAMIC_ID,DYNAMIC_NAME,PERSON_NAME,SYS_DATE,CONTENT,SHOU from sys_dynamic")
    public List<Dynamic> listAll();
    public Dynamic findById(int dynamicId);
    public void save(Dynamic dynamic);
    public void edit(Dynamic dynamic);
    public void delete(int dynamicId);
}
