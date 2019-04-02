package com.siifi.infos.service.media.impl;

import com.siifi.infos.entity.Media;
import com.siifi.infos.mapper.MediaMapper;
import com.siifi.infos.service.media.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MediaServiceImpl implements MediaService {
    @Autowired
    private MediaMapper mediaMapper;
    public List<Media> getMedia(){
        return mediaMapper.listAll();
    }
    public Media getMediaById(int mediaId){
        return mediaMapper.findById(mediaId);
    }
    public void saveMedia(Media media){
        mediaMapper.save(media);
    }
    public void editMedia(Media media){
        mediaMapper.edit(media);
    }
    public void deleteMedia(int mediaId){
        mediaMapper.delete(mediaId);
    }
}
