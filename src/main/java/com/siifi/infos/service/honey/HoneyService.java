package com.siifi.infos.service.honey;

import com.siifi.infos.entity.Honey;
import com.siifi.infos.entity.PageInfo;

public interface HoneyService {
    public PageInfo<Honey> getHoney(Integer pageNum,Integer pageSize);
    public Honey getHoneyById(int honeyId);
    public void saveHoney(Honey honey);
    public void editHoney(Honey honey);
    public void deleteHoney(int honeyId);
}
