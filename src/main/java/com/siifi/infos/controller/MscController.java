package com.siifi.infos.controller;

import com.siifi.infos.entity.Msc;
import com.siifi.infos.service.msc.MscService;
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
public class  MscController {
    @Autowired
    private MscService mscService;

    @RequestMapping("/msc")
    public String msc(){
        return "msc";
    }

    @RequestMapping("/mscadd")
    public String mscadd(){
        return "msc_add";
    }

    /**
     * 查询所有目录
     * @return
     */
    @RequestMapping(value = "msc/lists",method = RequestMethod.GET)
    @ResponseBody
    public List<Msc> getMsc(){
        List<Msc> msc=mscService.getMsc();
        return msc;
    }

    /**
     * 添加目录
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/saveMsc",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveMsc(@RequestBody Map<String, Object> reqMap) throws Exception{
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            String mscName=reqMap.get("mscName").toString();
            String shou=reqMap.get("shou").toString();
            Msc msc=new Msc();
            msc.setMscName(mscName);
            msc.setShou(shou);
            Boolean bool=mscService.saveMsc(msc);
            if (bool == true){
                map.put("code","1");
                map.put("message","保存成功");
            }
            else {
                map.put("code","0");
                map.put("message","保存失败");
            }

        }catch (Exception e){
            map.put("code", "0");
            map.put("status", "fail");
            map.put("message", e.getMessage());
        }
        return map;
    }

    /**
     * 根据id查数据
     * @param id
     * @return
     */
    @RequestMapping("/findMsc")
    public ModelAndView findMsc(Integer id) {
        Msc msc = mscService.getMscById(id);
        ModelAndView model = new ModelAndView("msc_edit");
        model.addObject("msc", msc);
        return model;
    }

    /**
     * 根据id查数据
     * @param id
     * @return
     */
    @RequestMapping(value = "/findMscs",method = RequestMethod.GET)
    @ResponseBody
    public Msc findMscs(String mscId) {
        int id=Integer.parseInt(mscId);
        Msc msc = mscService.getMscById(id);
        return msc;
    }

    /**
     * 修改目录
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/editMsc",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> editMsc(@RequestBody Map<String, Object> reqMap) throws Exception{
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            String mscId=reqMap.get("mscId").toString();
            int id=Integer.parseInt(mscId);
            String mscName=reqMap.get("mscName").toString();
            String shou=reqMap.get("shou").toString();
            Msc msc=new Msc();
            msc.setMscId(id);
            msc.setMscName(mscName);
            msc.setShou(shou);
            Boolean bool=mscService.editMsc(msc);
            if (bool == true){
                map.put("code","1");
                map.put("message","修改成功");
            }
            else {
                map.put("code","0");
                map.put("message","修改失败");
            }

        }catch (Exception e){
            map.put("code", "0");
            map.put("status", "fail");
            map.put("message", e.getMessage());
        }
        return map;
    }

    /**
     * 根据id查数据
     * @param id
     * @return
     */
    @RequestMapping("/findUeiorMsc")
    public ModelAndView findUeiorMsc(Integer id) {
        Msc msc = mscService.getMscById(id);
        ModelAndView model = new ModelAndView("msc_ueior");
        model.addObject("msc", msc);
        return model;
    }

    /**
     * 修改目录
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/editUeiorMsc",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> editUeiorMsc(@RequestBody Map<String, Object> reqMap) throws Exception{
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            String mscId=reqMap.get("tid").toString();
            int id=Integer.parseInt(mscId);
            String content=reqMap.get("text").toString();
            Msc msc=new Msc();
            msc.setMscId(id);
            msc.setContent(content);
            Boolean bool=mscService.editMsc(msc);
            if (bool == true){
                map.put("code","1");
                map.put("message","修改成功");
            }
            else {
                map.put("code","0");
                map.put("message","修改失败");
            }

        }catch (Exception e){
            map.put("code", "0");
            map.put("status", "fail");
            map.put("message", e.getMessage());
        }
        return map;
    }
}
