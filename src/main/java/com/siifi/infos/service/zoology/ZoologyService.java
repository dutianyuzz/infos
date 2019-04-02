package com.siifi.infos.service.zoology;

import com.siifi.infos.entity.Zoology;

import java.util.List;

public interface ZoologyService {
    public List<Zoology> getZoology();
    public Zoology getZoologyById(int zoologyId);
    public void saveZoology(Zoology zoology);
    public void editZoology(Zoology zoology);
    public void deleteZoology(int zoologyId);
}
