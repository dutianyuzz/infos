package com.siifi.infos.controller;

import com.siifi.infos.entity.Cultivate;
import com.siifi.infos.service.cultivate.CultivateService;
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
public class CultivateController {
    @Autowired
    private CultivateService cultivateService;

    @RequestMapping(value = "cultivate")
    public String cultivate(){
        return "cultivate";
    }

    @RequestMapping(value = "cultivateadd")
    public String cultivateadd(){
        return "cultivate_add";
    }

    /**
     * 查询所有目录
     * @return
     */
    @RequestMapping(value = "cultivate/lists",method = RequestMethod.GET)
    @ResponseBody
    public List<Cultivate> getMedia(){
        List<Cultivate> cultivates=cultivateService.getCultivate();
        return cultivates;
    }

    /**
     * 添加目录
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/saveCultivate",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveCultivate(@RequestBody Map<String, Object> reqMap){
        Map<String,Object> map = new HashMap<String,Object>();
        String cultivateName=reqMap.get("cultivateName").toString();
        String shou=reqMap.get("shou").toString();
        Cultivate cultivate=new Cultivate();
        cultivate.setCultivateName(cultivateName);
        cultivate.setShou(shou);
        cultivateService.saveCultivate(cultivate);
        map.put("code","1");
        map.put("message","保存成功");
        return map;
    }

    /**
     * 根据id查数据
     * @param id
     * @return
     */
    @RequestMapping("/findCultivate")
    public ModelAndView findCultivate(Integer id) {
        Cultivate cultivate=cultivateService.getCultivateById(id);
        ModelAndView model = new ModelAndView("cultivate_edit");
        model.addObject("cultivate",cultivate);
        return model;
    }

    /**
     * 根据id查数据(富文本编辑器)
     * @param id
     * @return
     */
    @RequestMapping(value = "/findCultivates",method = RequestMethod.GET)
    @ResponseBody
    public Cultivate findCultivates(String cultivateId) {
        int id=Integer.parseInt(cultivateId);
        Cultivate cultivate=cultivateService.getCultivateById(id);
        return cultivate;
    }

    /**
     * 修改目录
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/editCultivate",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> editCultivate(@RequestBody Map<String, Object> reqMap){
        Map<String,Object> map = new HashMap<String,Object>();
        String cultivateId=reqMap.get("cultivateId").toString();
        int id=Integer.parseInt(cultivateId);
        String cultivateName=reqMap.get("cultivateName").toString();
        String shou=reqMap.get("shou").toString();
        Cultivate cultivate=new Cultivate();
        cultivate.setCultivateId(id);
        cultivate.setCultivateName(cultivateName);
        cultivate.setShou(shou);
        cultivateService.editCultivate(cultivate);
        map.put("code","1");
        map.put("message","修改成功");
        return map;
    }

    /**
     * 编辑栏目内容
     * @param id
     * @return
     */
    @RequestMapping("/findUeiorCultivate")
    public ModelAndView findUeiorCultivate(Integer id) {
        Cultivate cultivate=cultivateService.getCultivateById(id);
        ModelAndView model = new ModelAndView("cultivate_ueior");
        model.addObject("cultivate",cultivate);
        return model;
    }

    /**
     * 修改栏目内容
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/editUeiorCultivate",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> editUeiorCultivate(@RequestBody Map<String, Object> reqMap){
        Map<String,Object> map = new HashMap<String,Object>();
        String cultivateId=reqMap.get("tid").toString();
        int id=Integer.parseInt(cultivateId);
        String content=reqMap.get("text").toString();
        Cultivate cultivate=new Cultivate();
        cultivate.setCultivateId(id);
        cultivate.setContent(content);
        cultivateService.editCultivate(cultivate);
        map.put("code","1");
        map.put("message","修改成功");
        return map;
    }

    /**
     * 删除目录
     * @param id
     * @return
     */
    @RequestMapping("/deleteCultivate")
    public String deleteCultivate(Integer id) {
        cultivateService.deleteCultivate(id);
        return "cultivate";
    }

}
