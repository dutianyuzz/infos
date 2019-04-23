package com.siifi.infos.controller;

import com.github.pagehelper.PageHelper;
import com.siifi.infos.entity.Honey;
import com.siifi.infos.entity.PageInfo;
import com.siifi.infos.mapper.HoneyMapper;
import com.siifi.infos.service.honey.HoneyService;
import com.siifi.infos.utils.Constants;
import com.siifi.infos.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "infos")
public class HoneyImageController {

    @Autowired
    private HoneyService honeyService;

    /**
     * 跳转栏目管理视图
     *
     * @return
     */
    @RequestMapping("/honey")
    public String honey() {
        return "honey";
    }

    /**
     * 跳转栏目管理视图
     *
     * @return
     */
    @RequestMapping("/honeylist")
    public String honeylist() {
        return "honey_list";
    }

    /**
     * 添加企业资质
     *
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/saveHoney", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveHoney(@RequestBody Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        String honeyName = reqMap.get("honeyName").toString();
        String utter = reqMap.get("utter").toString();
        String date = reqMap.get("date").toString();
        String shou = reqMap.get("shou").toString();
        String imgPath = reqMap.get("imgPath").toString();
        Honey honey = new Honey();
        honey.setHoneyName(honeyName);
        honey.setUtter(utter);
        honey.setDate(date);
        honey.setShou(shou);
        honey.setImagePath(imgPath);
        honeyService.saveHoney(honey);
        map.put("code", "1");
        map.put("message", "保存成功");
        return map;
    }

    /**
     * 查询所有目录(分页查询)
     *
     * @return
     */
    @Resource
    HoneyMapper honeyMapper;
    @RequestMapping(value = "honey/lists", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Honey> getHoney(@RequestParam int pageNum) {
        PageHelper.startPage(pageNum,8);
        List<Honey> honeys=honeyMapper.listAll();
        PageInfo<Honey> pageInfo=new PageInfo<>(honeys);
        return pageInfo;
    }

    /**
     * 根据id查数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/findImage")
    public ModelAndView findImage(Integer id) {
        Honey honey = honeyService.getHoneyById(id);
        ModelAndView model = new ModelAndView("honey_image");
        model.addObject("honey", honey);
        return model;
    }

    /**
     * 上传图片
     *
     * @param file
     * @return
     */
    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map<String, Object> fileUpload(@RequestParam MultipartFile file) {
        Map<String, Object> map = new HashMap<String, Object>();
        String localPath = Constants.IMAGES_VISIT_FILE_PATH;              // 要上传的目标文件存放路径
        FileUtils fileUtils = new FileUtils();
        String imgPath = fileUtils.upload(file, localPath, file.getOriginalFilename());
        imgPath = imgPath.replace(Constants.IMAGES_VISIT_FILE_PATH, Constants.PICTURE_VISIT_FILE_PATH);
        if (imgPath != null && imgPath != "") {
            map.put("code", 1);
            map.put("message", "图片上传成功");
            map.put("imgPath", imgPath);  //返回值存入图片路径
        } else {
            map.put("code", 0);
            map.put("message", "图片上传失败");
        }
        return map;
    }

    /**
     * 根据id查数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public ModelAndView findById(Integer id) {
        Honey honey = honeyService.getHoneyById(id);
        String s = honey.getHoneyName();
        ModelAndView model = new ModelAndView("honey_edit");
        model.addObject("honey", honey);
        return model;
    }

    /**
     * 修改企业资质  改变图片的情况
     *
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/editHoneyImage", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> editHoneyImage(@RequestBody Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        String honeyId = reqMap.get("honeyId").toString();
        int id = Integer.parseInt(honeyId);
        String honeyName = reqMap.get("honeyName").toString();
        String utter = reqMap.get("utter").toString();
        String date = reqMap.get("date").toString();
        String shou = reqMap.get("shou").toString();
        String imgPath = reqMap.get("imgPath").toString();
        System.out.println(imgPath);
        Honey honey = new Honey();
        honey.setHoneyId(id);
        honey.setHoneyName(honeyName);
        honey.setUtter(utter);
        honey.setDate(date);
        honey.setShou(shou);
        honey.setImagePath(imgPath);
        honeyService.editHoney(honey);
        map.put("code", "1");
        map.put("message", "修改成功");
        return map;
    }

    /**
     * 修改企业资质  不改变图片的情况
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/editHoney", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> editHoney(@RequestBody Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        String honeyId = reqMap.get("honeyId").toString();
        int id = Integer.parseInt(honeyId);
        String honeyName = reqMap.get("honeyName").toString();
        String utter = reqMap.get("utter").toString();
        String date = reqMap.get("date").toString();
        String shou = reqMap.get("shou").toString();
        Honey honey = new Honey();
        honey.setHoneyId(id);
        honey.setHoneyName(honeyName);
        honey.setUtter(utter);
        honey.setDate(date);
        honey.setShou(shou);
        honeyService.editHoney(honey);
        map.put("code", "1");
        map.put("message", "修改成功");
        return map;
    }
    /**
     * 删除企业资质
     * @param id
     * @return
     */
    @RequestMapping("/deleteHoney")
    public String deleteHoney(Integer id) {
        honeyService.deleteHoney(id);
        return "honey_list";
    }
}

