package com.siifi.infos.service.intell.impl;

import com.siifi.infos.entity.Intell;
import com.siifi.infos.mapper.IntellMapper;
import com.siifi.infos.service.intell.IntellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntellServiceImpl implements IntellService {
    @Autowired
    private IntellMapper intellMapper;
    public List<Intell> getIntell(){
        return intellMapper.listAll();
    }
    public Intell getIntellById(int intellId){
        return intellMapper.findById(intellId);
    }
    public void saveIntell(Intell intell){
        intellMapper.save(intell);
    }
    public void editIntell(Intell intell){
        intellMapper.edit(intell);
    }
    public void deleteIntell(int intellId){
        intellMapper.delete(intellId);
    }

}
