package com.siifi.infos.controller;

import com.siifi.infos.entity.*;
import com.siifi.infos.service.column.ColumnService;
import com.siifi.infos.service.cultivate.CultivateService;
import com.siifi.infos.service.dynamic.DynamicService;
import com.siifi.infos.service.honey.HoneyService;
import com.siifi.infos.service.intell.IntellService;
import com.siifi.infos.service.invite.InviteService;
import com.siifi.infos.service.media.MediaService;
import com.siifi.infos.service.product.ProductService;
import com.siifi.infos.service.tid.TidService;
import com.siifi.infos.service.zoology.ZoologyService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private DynamicService dynamicService;
    @Resource
    private TidService tidService;
    @Resource
    private HoneyService honeyService;
    @Resource
    private ProductService productService;
    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("/siifi.html")
    public String index() {
        return "siifi/siifi";
    }

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping("/login.html")
    public String login() {
        return "siifi/login";
    }

    @RequestMapping("/register.html")
    public String register() {
        return "siifi/register";
    }

    /**
     * 头部导航栏(取出每张表的第一条数据放到实体里)
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
        ModelAndView model = new ModelAndView("siifi/top-navigation-bar");
        model.addObject("box", box);
        return model;
    }

    /**
     * 尾部导航栏
     *
     * @return
     */
    @RequestMapping("/bottomNavigationBar")
    public ModelAndView bottomNavigationBar() {
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
        ModelAndView model = new ModelAndView("siifi/bottom-navigation-bar");
        model.addObject("box", box);
        return model;
    }

    /**
     * 中部导航
     *
     * @return
     */
    @RequestMapping("/contactInformation")
    public String ContactInformation() {
        return "siifi/contact-information";
    }


    /**
     * 根据id查数据(关于集团)
     *
     * @param id
     * @return
     */
    @RequestMapping("/generalDetailsPage")
    public ModelAndView findColumn(Integer id) {
        Column column = columnService.getColumnById(id);
        ModelAndView model = new ModelAndView("siifi/general-details-page");
        model.addObject("column", column);
        return model;
    }

    /**
     * 企业资质
     *
     * @return
     */
    @RequestMapping("/enterpriseQualification")
    public String aboutCer() {
        return "siifi/enterprise-qualification";
    }

    /**
     * 智能产业
     *
     * @return
     */
    @RequestMapping("/intelligentIndustry")
    public ModelAndView findIntell(Integer id) {
        Intell intell = intellService.getIntellById(id);
        ModelAndView model = new ModelAndView("siifi/intelligent-industry");
        model.addObject("intell", intell);
        return model;
    }

    /**
     * 典型案例
     *
     * @return
     */
    @RequestMapping("/intelligentClassicCase")
    public String industryCase() {
        return "siifi/intelligent-classic-case";
    }

    /**
     * 生态产业
     *
     * @return
     */
    @RequestMapping("/industryEcology")
    public ModelAndView industryEcology(Integer id) {
        Zoology zoology = zoologyService.getZoologyById(id);
        ModelAndView model = new ModelAndView("siifi/industry-ecology");
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
        ModelAndView model = new ModelAndView("siifi/industry-media");
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
        ModelAndView model = new ModelAndView("siifi/industry-education");
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
        return "siifi/responsibility-honest";
    }

    /**
     * 黑名单
     *
     * @return
     */
    @RequestMapping("/responsibilityBlacklist")
    public String responsibilityBlacklist() {
        return "siifi/responsibility-blacklist";
    }

    /**
     * 联系方式
     *
     * @return
     */
    @RequestMapping("/contact")
    public String contact() {
        return "siifi/contact";
    }

    /**
     * 招聘简介
     *
     * @return
     */
    @RequestMapping("/recruitingIntroduction")
    public String recruitingIntroduction() {
        return "siifi/recruiting-introduction";
    }

    /**
     * 招聘职位
     *
     * @return
     */
    @RequestMapping("/recruitingPosition")
    public String recruitingPosition() {
        return "siifi/recruiting-position";
    }

    /**
     * 职位详情
     *
     * @return
     */
    @RequestMapping("/recruitDetails")
    public ModelAndView applyOnline(Integer id) {
        System.out.println(id);
        Invite invite = inviteService.getInviteById(id);
        ModelAndView model = new ModelAndView("siifi/recruit-details");
        model.addObject("invite", invite);
        return model;
    }

    /**
     * 跳转集团动态新闻页面
     * @return
     */
    @RequestMapping("/news")
    public String news(){
        return "siifi/news";
    }
    /**
     * 根据新闻id查数据(跳转集团动态新闻（详情页面）)
     * @param id
     * @return
     */
    @RequestMapping("/findDynamicByIdGw")
    public ModelAndView findDynamicByIdGw(Integer id) {
        Dynamic dynamic=dynamicService.getDynamicById(id);
        ModelAndView model = new ModelAndView("siifi/news-content");
        model.addObject("dynamic", dynamic);
        return model;
    }

    /**
     * 根据id查企业资质图片
     *
     * @param id
     * @return
     */
    @RequestMapping("/honeyImage")
    public ModelAndView findImage(Integer id) {
        Honey honey = honeyService.getHoneyById(id);
        ModelAndView model = new ModelAndView("siifi/enterprise-qualification-image");
        model.addObject("honey", honey);
        return model;
    }

    /**
     * 根据id查案例图片
     *
     * @param id
     * @return
     */
    @RequestMapping("/productImage")
    public ModelAndView findProductImage(Integer id) {
        Product product = productService.getProductById(id);
        ModelAndView model = new ModelAndView("siifi/intelligent-classic-case-image");
        model.addObject("product", product);
        return model;
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
     *取出前端变量(教育培训)
     * @return
     */
    @RequestMapping(value = "/findNnd", method = RequestMethod.GET)
    @ResponseBody
    public Tid findNnd() {
        Tid tid = tidService.findByIdTid(5);
        return tid;
    }
}
