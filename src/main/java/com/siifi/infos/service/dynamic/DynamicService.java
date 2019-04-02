package com.siifi.infos.service.dynamic;

import com.siifi.infos.entity.Dynamic;
import com.siifi.infos.entity.PageInfo;

public interface DynamicService {
    public PageInfo<Dynamic> getDynamic(Integer pageNum, Integer pageSize);
    public Dynamic getDynamicById(int dynamicId);
    public void saveDynamic(Dynamic dynamic);
    public void editDynamic(Dynamic dynamic);
    public void deleteDynamic(int dynamicId);
}
