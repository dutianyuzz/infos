package com.siifi.infos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.siifi.infos.entity.Dynamic;
import com.siifi.infos.entity.Honey;
import com.siifi.infos.mapper.DynamicMapper;
import com.siifi.infos.service.dynamic.DynamicService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "infos")
public class DynamicController {
    @Resource
    private DynamicService dynamicService;

    /**
     *跳转新闻发布
     * @return
     */
    @RequestMapping("/dynamicAdd")
    public String dynamicAdd() {
        return "dynamic_add";
    }

    /**
     *跳转新闻目录
     * @return
     */
    @RequestMapping("/dynamicList")
    public String dynamicList() {
        return "dynamic_list";
    }

    /**
     * 添加新闻
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/saveDynamic",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveDynamic(@RequestBody Map<String, Object> reqMap){
        Map<String,Object> map = new HashMap<String,Object>();
        String dynamicName=reqMap.get("dynamicName").toString();
        String personName=reqMap.get("personName").toString();
        String date=reqMap.get("date").toString();
        String imagePath=reqMap.get("imagePath").toString();
        String contentText=reqMap.get("contentText").toString();
        int shou=0;
        Dynamic dynamic=new Dynamic();
        dynamic.setDynamicName(dynamicName);
        dynamic.setPersonName(personName);
        dynamic.setSysDate(date);
        dynamic.setImagePath(imagePath);
        dynamic.setContent(contentText);
        dynamic.setShou(shou);
        dynamicService.saveDynamic(dynamic);
        map.put("code","1");
        map.put("message","保存成功");
        return map;
    }

    /**
     * 查询所有目录（分页查询）
     * @return
     */
    @Resource
    private DynamicMapper dynamicMapper;
    @RequestMapping(value = "dynamic/lists",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Dynamic> getInvite(@RequestParam int pageNum){
        PageHelper.startPage(pageNum, 6);
        List<Dynamic> dynamics=dynamicMapper.listAll();
        PageInfo<Dynamic> pageInfo=new PageInfo<>(dynamics);
        return pageInfo;
    }

    /**
     * 根据id查数据
     * @param id
     * @return
     */
    @RequestMapping("/findDynamicById")
    public ModelAndView findDynamicById(Integer id) {
        Dynamic dynamic=dynamicService.getDynamicById(id);
        ModelAndView model = new ModelAndView("dynamic_edit");
        model.addObject("dynamic", dynamic);
        return model;
    }

    /**
     * 根据id查封面
     * @param id
     * @return
     */
    @RequestMapping("/findDynamicImage")
    public ModelAndView findDynamicImage(Integer id) {
        Dynamic dynamic=dynamicService.getDynamicById(id);
        ModelAndView model = new ModelAndView("dynamic_image");
        model.addObject("dynamic", dynamic);
        return model;
    }

    /**
     * 根据id查数据(富文本编辑器)
     * @param id
     * @return
     */
    @RequestMapping(value = "/findDynamicByIds",method = RequestMethod.GET)
    @ResponseBody
    public Dynamic findInviteByIds(String dynamicId) {
        int id=Integer.parseInt(dynamicId);
        Dynamic dynamic=dynamicService.getDynamicById(id);
        return dynamic;
    }

    /**
     * 修改新闻(不修改封面)
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/editDynamic",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> editDynamic(@RequestBody Map<String, Object> reqMap){
        Map<String,Object> map = new HashMap<String,Object>();
        String id=reqMap.get("dynamicId").toString();
        int dynamicId=Integer.parseInt(id);
        String dynamicName=reqMap.get("dynamicName").toString();
        String personName=reqMap.get("personName").toString();
        String date=reqMap.get("date").toString();
        String contentText=reqMap.get("contentText").toString();
        Dynamic dynamic=new Dynamic();
        dynamic.setDynamicId(dynamicId);
        dynamic.setDynamicName(dynamicName);
        dynamic.setPersonName(personName);
        dynamic.setSysDate(date);
        dynamic.setContent(contentText);
        dynamicService.editDynamic(dynamic);
        map.put("code","1");
        map.put("message","保存成功");
        return map;
    }

    /**
     * 修改新闻(包括封面修改)
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/editDynamicImage",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> editDynamicImage(@RequestBody Map<String, Object> reqMap){
        Map<String,Object> map = new HashMap<String,Object>();
        String id=reqMap.get("dynamicId").toString();
        int dynamicId=Integer.parseInt(id);
        String dynamicName=reqMap.get("dynamicName").toString();
        String personName=reqMap.get("personName").toString();
        String date=reqMap.get("date").toString();
        String imagePath=reqMap.get("imagePath").toString();
        String contentText=reqMap.get("contentText").toString();
        Dynamic dynamic=new Dynamic();
        dynamic.setDynamicId(dynamicId);
        dynamic.setDynamicName(dynamicName);
        dynamic.setPersonName(personName);
        dynamic.setSysDate(date);
        dynamic.setImagePath(imagePath);
        dynamic.setContent(contentText);
        dynamicService.editDynamic(dynamic);
        map.put("code","1");
        map.put("message","保存成功");
        return map;
    }
    /**
     * 删除目录
     * @param id
     * @return
     */
    @RequestMapping("/deleteDynamic")
    public String editDynamic(Integer id) {
        dynamicService.deleteDynamic(id);
        return "dynamic_list";
    }

}
