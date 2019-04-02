package com.siifi.infos.controller;

import com.siifi.infos.entity.Media;
import com.siifi.infos.service.media.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "infos")
public class MediaController {
    @Autowired
    private MediaService mediaService;

    @RequestMapping(value = "media")
    public String media(){
        return "media";
    }

    @RequestMapping(value = "mediaadd")
    public String mediaadd(){
        return "media_add";
    }

    /**
     * 查询所有目录
     * @return
     */
    @RequestMapping(value = "media/lists",method = RequestMethod.GET)
    @ResponseBody
    public List<Media> getMedia(){
        List<Media> media=mediaService.getMedia();
        return media;
    }

    /**
     * 添加目录
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/saveMedia",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveMedia(@RequestBody Map<String, Object> reqMap){
        Map<String,Object> map = new HashMap<String,Object>();
        String mediaName=reqMap.get("mediaName").toString();
        String shou=reqMap.get("shou").toString();
        Media media=new Media();
        media.setMediaName(mediaName);
        media.setShou(shou);
        mediaService.saveMedia(media);
        map.put("code","1");
        map.put("message","保存成功");
        return map;
    }

    /**
     * 根据id查数据
     * @param id
     * @return
     */
    @RequestMapping(value = "/findMedia",method = RequestMethod.GET)
    public ModelAndView findMedia(@RequestParam Integer id) {
        Media media=mediaService.getMediaById(id);
        ModelAndView model = new ModelAndView("media_edit");
        model.addObject("media",media);
        return model;
    }

    /**
     * 根据id查数据(富文本编辑器)
     * @param id
     * @return
     */
    @RequestMapping(value = "/findMedias",method = RequestMethod.GET)
    @ResponseBody
    public Media findMedias(String mediaId) {
        int id=Integer.parseInt(mediaId);
        Media media=mediaService.getMediaById(id);
        return media;
    }

    /**
     * 修改目录
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/editMedia",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> editMedia(@RequestBody Map<String, Object> reqMap){
        Map<String,Object> map = new HashMap<String,Object>();
        String mediaId=reqMap.get("mediaId").toString();
        int id=Integer.parseInt(mediaId);
        String mediaName=reqMap.get("mediaName").toString();
        String shou=reqMap.get("shou").toString();
        Media media=new Media();
        media.setMediaId(id);
        media.setMediaName(mediaName);
        media.setShou(shou);
        mediaService.editMedia(media);
        map.put("code","1");
        map.put("message","修改成功");
        return map;
    }

    /**
     * 删除目录
     * @param id
     * @return
     */
    @RequestMapping("/deleteMedia")
    public String deleteMedia(Integer id) {
        mediaService.deleteMedia(id);
        return "media";
    }

    /**
     * 编辑栏目内容
     * @param id
     * @return
     */
    @RequestMapping("/findUeiorMedia")
    public ModelAndView findUeiorMedia(Integer id) {
        Media media=mediaService.getMediaById(id);
        String content=media.getContent();
        ModelAndView model = new ModelAndView("media_ueior");
        model.addObject("media",media);
        return model;
    }

    /**
     * 修改栏目内容
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/editUeiorMedia",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> editUeiorMedia(@RequestBody Map<String, Object> reqMap){
        Map<String,Object> map = new HashMap<String,Object>();
        String mediaId=reqMap.get("tid").toString();
        int id=Integer.parseInt(mediaId);
        String content=reqMap.get("text").toString();
        Media media=new Media();
        media.setMediaId(id);
        media.setContent(content);
        mediaService.editMedia(media);
        map.put("code","1");
        map.put("message","修改成功");
        return map;
    }

}
