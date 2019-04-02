package com.siifi.infos.service.cultivate;

import com.siifi.infos.entity.Cultivate;

import java.util.List;

public interface CultivateService {
    public List<Cultivate> getCultivate();
    public Cultivate getCultivateById(int cultivateId);
    public void saveCultivate(Cultivate cultivate);
    public void editCultivate(Cultivate cultivate);
    public void deleteCultivate(int cultivateId);
}
