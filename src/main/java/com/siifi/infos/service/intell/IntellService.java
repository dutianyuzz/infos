package com.siifi.infos.service.intell;
import com.siifi.infos.entity.Intell;

import java.util.List;

public interface IntellService {
    public List<Intell> getIntell();
    public Intell getIntellById(int intellId);
    public void saveIntell(Intell intell);
    public void editIntell(Intell intell);
    public void deleteIntell(int intellId);
}
