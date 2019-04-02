package com.siifi.infos.service.msc;

import com.siifi.infos.entity.Msc;

import java.util.List;

public interface MscService {
    public List<Msc> getMsc();
    public Msc getMscById(int mscId);
    public boolean saveMsc(Msc msc);
    public boolean editMsc(Msc msc);
    public boolean deleteMsc(int mscId);
}
