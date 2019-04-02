package com.siifi.infos.service.maney;

import com.siifi.infos.entity.ManeysImage;

import java.util.List;

public interface ManeyImagesService {
    public List<ManeysImage> getManey();

    public ManeysImage getManeyById(int maneyId);

    public void saveManey(ManeysImage maneysImage);

    public void editManey(ManeysImage maneysImage);

    public void deleteManey(int maneyId);

}
