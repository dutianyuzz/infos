package com.siifi.infos.mapper;

import com.siifi.infos.entity.Column;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ColumnMapper {
    public List<Column> listAll();
    public Column findById(int columnId);
    public void save(Column column);
    public void edit(Column column);
    public void delete(int columnId);
}
