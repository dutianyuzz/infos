package com.siifi.infos.service.media;

import com.siifi.infos.entity.Media;

import java.util.List;

public interface MediaService {
    public List<Media> getMedia();
    public Media getMediaById(int mediaId);
    public void saveMedia(Media media);
    public void editMedia(Media media);
    public void deleteMedia(int mediaId);
}
