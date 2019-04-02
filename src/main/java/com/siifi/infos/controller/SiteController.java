package com.siifi.infos.controller;

import com.siifi.infos.entity.*;
import com.siifi.infos.service.column.ColumnService;
import com.siifi.infos.service.cultivate.CultivateService;
import com.siifi.infos.service.intell.IntellService;
import com.siifi.infos.service.invite.InviteService;
import com.siifi.infos.service.media.MediaService;
import com.siifi.infos.service.tid.TidService;
import com.siifi.infos.service.zoology.ZoologyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "infos")
public class SiteController {
    @Resource
    private ColumnService columnService;
    @Resource
    private IntellService intellService;
    @Resource
    private ZoologyService zoologyService;
    @Resource
    private MediaService mediaService;
    @Resource
    private CultivateService cultivateService;
    @Resource
    private InviteService inviteService;
    @Resource
    private TidService tidService;

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("/index.html")
    public String index() {
        return "index";
    }

    /**
     *
     *
     * @return
     */
    @RequestMapping("/text")
    public String text() {
        return "text";
    }

    /**
     * 头部导航栏(取出每张表的第一条数据放到盒子里)
     *
     * @return
     */
    @RequestMapping("/topNavigationBar")
    public ModelAndView topNavigationBar() {
        List<Intell> intellList = intellService.getIntell();
        int intellId = intellList.get(0).getIntellId();
        List<Zoology> zoologyList = zoologyService.getZoology();
        int zoologyId = zoologyList.get(0).getZoologyId();
        List<Media> mediaList = mediaService.getMedia();
        int mediaId = mediaList.get(0).getMediaId();
        List<Cultivate> cultivateList = cultivateService.getCultivate();
        int cultivateId = cultivateList.get(0).getCultivateId();
        Box box = new Box();
        box.setIntellId(intellId);
        box.setZoologyId(zoologyId);
        box.setMediaId(mediaId);
        box.setCultivateId(cultivateId);
        ModelAndView model = new ModelAndView("top-navigation-bar");
        model.addObject("box", box);
        return model;
    }

    /**
     * 尾部导航栏
     *
     * @return
     */
    @RequestMapping("/bottomNavigationBar")
    public String bottomNavigationBar() {
        return "bottom-navigation-bar";
    }


    /**
     * 根据id查数据(关于集团)
     *
     * @param id
     * @return
     */
    @RequestMapping("/about")
    public ModelAndView findColumn(Integer id) {
        Column column = columnService.getColumnById(id);
        ModelAndView model = new ModelAndView("about");
        model.addObject("column", column);
        return model;
    }

    /**
     * 企业资质
     *
     * @return
     */
    @RequestMapping("/aboutCer")
    public String aboutCer() {
        return "about-cer";
    }

    /**
     * 智能产业
     *
     * @return
     */
    @RequestMapping("/industryIntelligent")
    public ModelAndView findIntell(Integer id) {
        Intell intell = intellService.getIntellById(id);
        ModelAndView model = new ModelAndView("industry-intelligent");
        model.addObject("intell", intell);
        return model;
    }

    /**
     * 典型案例
     *
     * @return
     */
    @RequestMapping("/industryCase")
    public String industryCase() {
        return "industry-case";
    }

    /**
     * 生态产业
     *
     * @return
     */
    @RequestMapping("/industryEcology")
    public ModelAndView industryEcology(Integer id) {
        Zoology zoology = zoologyService.getZoologyById(id);
        ModelAndView model = new ModelAndView("industry-ecology");
        model.addObject("zoology", zoology);
        return model;
    }

    /**
     * 文化传媒
     *
     * @return
     */
    @RequestMapping("/industryMedia")
    public ModelAndView industryMedia(Integer id) {
        Media media = mediaService.getMediaById(id);
        ModelAndView model = new ModelAndView("industry-media");
        model.addObject("media", media);
        return model;
    }

    /**
     * 教育培训
     *
     * @return
     */
    @RequestMapping("/industryEducation")
    public ModelAndView industryEducation(Integer id) {
        Cultivate cultivate = cultivateService.getCultivateById(id);
        ModelAndView model = new ModelAndView("industry-education");
        model.addObject("cultivate", cultivate);
        return model;
    }

    /**
     * 诚信声明
     *
     * @return
     */
    @RequestMapping("/responsibilityHonest")
    public String responsibilityHonest() {
        return "responsibility-honest";
    }

    /**
     * 黑名单
     *
     * @return
     */
    @RequestMapping("/responsibilityBlacklist")
    public String responsibilityBlacklist() {
        return "responsibility-blacklist";
    }

    /**
     * 联系方式
     *
     * @return
     */
    @RequestMapping("/tome")
    public String tome() {
        return "tome";
    }

    /**
     * 招聘简介
     *
     * @return
     */
    @RequestMapping("/recruitingIntroduction")
    public String recruitingIntroduction() {
        return "recruiting-introduction";
    }

    /**
     * 招聘职位
     *
     * @return
     */
    @RequestMapping("/recruitingPosition")
    public String recruitingPosition() {
        return "recruiting-position";
    }

    /**
     * 职位详情
     *
     * @return
     */
    @RequestMapping("/applyOnline")
    public ModelAndView applyOnline(Integer id) {
        System.out.println(id);
        Invite invite = inviteService.getInviteById(id);
        ModelAndView model = new ModelAndView("apply-online");
        model.addObject("invite", invite);
        return model;
    }

    /**
     * 保存前端变量(关于集团)
     *
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/saveNn", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveNn(@RequestParam int n) {
        Map<String, Object> map = new HashMap<>();
        String nn = String.valueOf(n);
        Tid tid = new Tid();
        tid.setId(1);
        tid.setTid(nn);
        tidService.editTid(tid);
        map.put("message", "1");
        return map;
    }

    /**
     * 取出前端变量
     *
     * @return
     */
    @RequestMapping(value = "/findNn", method = RequestMethod.GET)
    @ResponseBody
    public Tid findNn() {
        Tid tid = tidService.findByIdTid(1);
        return tid;
    }

    /**
     * 保存前端变量(智能产业)
     *
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/saveNna", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveNna(@RequestParam int n) {
        Map<String, Object> map = new HashMap<>();
        String nn = String.valueOf(n);
        Tid tid = new Tid();
        tid.setId(2);
        tid.setTid(nn);
        tidService.editTid(tid);
        map.put("message", "1");
        return map;
    }

    /**
     * 取出前端变量(智能产业)
     *
     * @return
     */
    @RequestMapping(value = "/findNna", method = RequestMethod.GET)
    @ResponseBody
    public Tid findNna() {
        Tid tid = tidService.findByIdTid(2);
        return tid;
    }

    /**
     * 保存前端变量(生态产业)
     *
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/saveNnb", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveNnb(@RequestParam int n) {
        Map<String, Object> map = new HashMap<>();
        String nn = String.valueOf(n);
        Tid tid = new Tid();
        tid.setId(3);
        tid.setTid(nn);
        tidService.editTid(tid);
        map.put("message", "1");
        return map;
    }

    /**
     * 取出前端变量(生态产业)
     *
     * @return
     */
    @RequestMapping(value = "/findNnb", method = RequestMethod.GET)
    @ResponseBody
    public Tid findNnb() {
        Tid tid = tidService.findByIdTid(3);
        return tid;
    }

    /**
     * 保存前端变量(文化传媒)
     *
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/saveNnc", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveNnc(@RequestParam int n) {
        Map<String, Object> map = new HashMap<>();
        String nn = String.valueOf(n);
        Tid tid = new Tid();
        tid.setId(4);
        tid.setTid(nn);
        tidService.editTid(tid);
        map.put("message", "1");
        return map;
    }

    /**
     * 取出前端变量(文化传媒)
     *
     * @return
     */
    @RequestMapping(value = "/findNnc", method = RequestMethod.GET)
    @ResponseBody
    public Tid findNnc() {
        Tid tid = tidService.findByIdTid(4);
        return tid;
    }

    /**
     * 保存前端变量(教育培训)
     *
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/saveNnd", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveNnd(@RequestParam int n) {
        Map<String, Object> map = new HashMap<>();
        String nn = String.valueOf(n);
        Tid tid = new Tid();
        tid.setId(5);
        tid.setTid(nn);
        tidService.editTid(tid);
        map.put("message", "1");
        return map;
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/findNnd", method = RequestMethod.GET)
    @ResponseBody
    public Tid findNnd() {
        Tid tid = tidService.findByIdTid(5);
        return tid;
    }
}
