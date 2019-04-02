package com.siifi.infos.service.zoology.impl;

import com.siifi.infos.entity.Zoology;
import com.siifi.infos.mapper.ZoologyMapper;
import com.siifi.infos.service.zoology.ZoologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoologyServiceImpl implements ZoologyService {
    @Autowired
    private ZoologyMapper zoologyMapper;
    public List<Zoology> getZoology(){
        return zoologyMapper.listAll();
    }
    public Zoology getZoologyById(int zoologyId){
        return zoologyMapper.findById(zoologyId);
    }
    public void saveZoology(Zoology zoology){
        zoologyMapper.save(zoology);
    }
    public void editZoology(Zoology zoology){
        zoologyMapper.edit(zoology);
    }
    public void deleteZoology(int zoologyId){
        zoologyMapper.delete(zoologyId);
    }
}
