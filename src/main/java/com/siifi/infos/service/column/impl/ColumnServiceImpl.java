package com.siifi.infos.service.column.impl;

import com.siifi.infos.entity.Column;
import com.siifi.infos.mapper.ColumnMapper;
import com.siifi.infos.service.column.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColumnServiceImpl implements ColumnService {
    @Autowired
    private ColumnMapper columnMapper;

    public List<Column> getColumn() {
        return columnMapper.listAll();
    }
    public Column getColumnById(int columnId){
        return columnMapper.findById(columnId);
    }
    public void saveColumn(Column column){
        columnMapper.save(column);
    }
    public void editColumn(Column column){
        columnMapper.edit(column);
    }
    public void deleteColumn(int columnId){
        columnMapper.delete(columnId);
    }
}
