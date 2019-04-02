package com.siifi.infos.mapper;
import com.siifi.infos.entity.Tid;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TidMapper {
    Tid findById(int tid);
    int edit(Tid tid);
}
