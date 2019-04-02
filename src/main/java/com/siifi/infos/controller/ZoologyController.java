package com.siifi.infos.controller;

import com.siifi.infos.entity.Zoology;
import com.siifi.infos.service.zoology.ZoologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "infos")
public class ZoologyController {
    @Autowired
    private ZoologyService zoologyService;

    /**
     * 跳转栏目管理视图
     *
     * @return
     */
    @RequestMapping("/zoology")
    public String zoology() {
        return "zoology";
    }

    /**
     * 跳转栏目管理视图
     *
     * @return
     */
    @RequestMapping("/image")
    public String image() {
        return "image";
    }

    /**
     * 跳转添加目录视图
     *
     * @return
     */
    @RequestMapping("/zoologyadd")
    public String zoologyadd() {
        return "zoology_add";
    }

    /**
     * 查询所有目录
     *
     * @return
     */
    @RequestMapping(value = "zoology/lists", method = RequestMethod.GET)
    @ResponseBody
    public List<Zoology> getZoology() {
        List<Zoology> zoologies = zoologyService.getZoology();
        return zoologies;
    }

    /**
     * 添加目录
     *
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/saveZoology", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveZoology(@RequestBody Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        String zoologyName = reqMap.get("zoologyName").toString();
        String shou = reqMap.get("shou").toString();
        Zoology zoology = new Zoology();
        zoology.setZoologyName(zoologyName);
        zoology.setShou(shou);
        zoologyService.saveZoology(zoology);
        map.put("code", "1");
        map.put("message", "保存成功");
        return map;
    }

    /**
     * 根据id查数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/findZoology")
    public ModelAndView findZoology(Integer id) {
        Zoology zoology = zoologyService.getZoologyById(id);
        ModelAndView model = new ModelAndView("zoology_edit");
        model.addObject("zoology", zoology);
        return model;
    }

    /**
     * 根据id查数据(富文本编辑器)
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/findZoologys", method = RequestMethod.GET)
    @ResponseBody
    public Zoology findZoologys(String zoologyId) {
        int id = Integer.parseInt(zoologyId);
        Zoology zoology = zoologyService.getZoologyById(id);
        return zoology;
    }

    /**
     * 修改目录
     *
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/editZoology", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> editZoology(@RequestBody Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        String zoologyId = reqMap.get("zoologyId").toString();
        int id = Integer.parseInt(zoologyId);
        String zoologyName = reqMap.get("zoologyName").toString();
        String shou = reqMap.get("shou").toString();
        Zoology zoology = new Zoology();
        zoology.setZoologyId(id);
        zoology.setZoologyName(zoologyName);
        zoology.setShou(shou);
        zoologyService.editZoology(zoology);
        map.put("code", 1);
        map.put("message", "修改成功");
        return map;
    }

    /**
     * 删除目录
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteZoology")
    public String deleteZoology(Integer id) {
        zoologyService.deleteZoology(id);
        return "zoology";
    }

    /**
     * 编辑栏目内容
     *
     * @param id
     * @return
     */
    @RequestMapping("/findUeiorZoology")
    public ModelAndView findUeiorZoology(Integer id) {
        Zoology zoology = zoologyService.getZoologyById(id);
        ModelAndView model = new ModelAndView("zoology_ueior");
        model.addObject("zoology", zoology);
        return model;
    }

    /**
     * 修改栏目内容
     *
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/editUeiorZoology", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> editUeiorZoology(@RequestBody Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        String zoologyId = reqMap.get("tid").toString();
        int id = Integer.parseInt(zoologyId);
        String content = reqMap.get("text").toString();
        Zoology zoology = new Zoology();
        zoology.setZoologyId(id);
        zoology.setContent(content);
        zoologyService.editZoology(zoology);
        map.put("code", 1);
        map.put("message", "修改成功");
        return map;
    }
}
