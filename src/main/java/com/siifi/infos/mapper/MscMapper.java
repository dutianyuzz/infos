package com.siifi.infos.mapper;

import com.siifi.infos.entity.Msc;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MscMapper {
    public List<Msc> listAll();
    public Msc findById(int mscId);
    public boolean save(Msc msc);
    public boolean edit(Msc msc);
    public Boolean delete(int mscId);
}
