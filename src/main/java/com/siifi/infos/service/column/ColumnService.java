package com.siifi.infos.service.column;

import com.siifi.infos.entity.Column;

import java.util.List;

public interface ColumnService {
    public List<Column> getColumn();
    public Column getColumnById(int columnId);
    public void saveColumn(Column column);
    public void editColumn(Column column);
    public void deleteColumn(int columnId);
}
