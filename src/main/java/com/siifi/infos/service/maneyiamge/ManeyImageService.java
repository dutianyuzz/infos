package com.siifi.infos.service.maneyiamge;

import com.siifi.infos.entity.ManeyImage;

import java.util.List;

public interface ManeyImageService {
    public List<ManeyImage> getManeyImage();
    public ManeyImage getManeyImageById(int maneyImageId);
    public void saveManeyImage(ManeyImage maneyImage);
    public void editManeyImage(ManeyImage maneyImage);
    public void deleteManeyImage(int maneyImageId);
    public void saveRelativityManey(List<ManeyImage> maneyImages);
}
