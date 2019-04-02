package com.siifi.infos.controller;

import com.siifi.infos.entity.Intell;
import com.siifi.infos.service.intell.IntellService;
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
public class IntellController {
    @Autowired
    private IntellService intellService;

    /**
     * 跳转栏目管理视图
     * @return
     */
    @RequestMapping("/intell")
    public String intell() {
        return "intell";
    }

    /**
     * 跳转添加目录视图
     * @return
     */
    @RequestMapping("/intelladd")
    public String intelladd() {
        return "intell_add";
    }

    /**
     * 查询所有目录
     * @return
     */
    @RequestMapping(value = "intell/lists",method = RequestMethod.GET)
    @ResponseBody
    public List<Intell> getIntell(){
        List<Intell> intells=intellService.getIntell();
        return intells;
    }

    /**
     * 根据id查数据
     * @param id
     * @return
     */
    @RequestMapping("/findIntell")
    public ModelAndView findIntell(Integer id) {
        Intell intell=intellService.getIntellById(id);
        ModelAndView model = new ModelAndView("intell_edit");
        model.addObject("intell",intell);
        return model;
    }

    /**
     * 根据id查数据(富文本编辑器)
     * @param id
     * @return
     */
    @RequestMapping(value = "/findIntells",method = RequestMethod.GET)
    @ResponseBody
    public Intell findIntells(String intellId) {
        int id=Integer.parseInt(intellId);
        Intell intell=intellService.getIntellById(id);
        return intell;
    }

    /**
     * 添加目录
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/saveIntell",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveIntell(@RequestBody Map<String, Object> reqMap){
        Map<String,Object> map = new HashMap<String,Object>();
        String intellName=reqMap.get("intellName").toString();
        String shou=reqMap.get("shou").toString();
        Intell intell=new Intell();
        intell.setIntellName(intellName);
        intell.setShou(shou);
        intellService.saveIntell(intell);
        map.put("code","1");
        map.put("message","保存成功");
        return map;
    }

    /**
     * 修改目录
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/editIntell",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> editIntell(@RequestBody Map<String, Object> reqMap){
        Map<String,Object> map = new HashMap<String,Object>();
        String intellId=reqMap.get("intellId").toString();
        int id=Integer.parseInt(intellId);
        String intellName=reqMap.get("intellName").toString();
        String shou=reqMap.get("shou").toString();
        Intell intell=new Intell();
        intell.setIntellId(id);
        intell.setIntellName(intellName);
        intell.setShou(shou);
        intellService.editIntell(intell);
        map.put("code",1);
        map.put("message","修改成功");
        return map;
    }

    /**
     * 删除目录
     * @param id
     * @return
     */
    @RequestMapping("/deleteIntell")
    public String deleteIntell(Integer id) {
        intellService.deleteIntell(id);
        return "intell";
    }

    /**
     * 编辑栏目内容
     * @param id
     * @return
     */
    @RequestMapping("/findUeiorIntell")
    public ModelAndView findUeiorIntell(Integer id) {
        Intell intell=intellService.getIntellById(id);
        ModelAndView model = new ModelAndView("intell_ueior");
        model.addObject("intell",intell);
        return model;
    }

    /**
     * 修改栏目内容
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/editUeiorIntell",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> editUeiorIntell(@RequestBody Map<String, Object> reqMap){
        Map<String,Object> map = new HashMap<String,Object>();
        String intellId=reqMap.get("tid").toString();
        int id=Integer.parseInt(intellId);
        String content=reqMap.get("text").toString();
        Intell intell=new Intell();
        intell.setIntellId(id);
        intell.setContent(content);
        intellService.editIntell(intell);
        map.put("code",1);
        map.put("message","修改成功");
        return map;
    }

}
