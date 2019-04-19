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
import java.util.List;

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

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("/siifi.html")
    public String index() {
        return "/siifi/siifi";
    }

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping("/login.html")
    public String login() {
        return "/siifi/login";
    }

    @RequestMapping("/register.html")
    public String register() {
        return "/siifi/register";
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
        ModelAndView model = new ModelAndView("/siifi/top-navigation-bar");
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
        ModelAndView model = new ModelAndView("/siifi/bottom-navigation-bar");
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
        return "/siifi/contact-information";
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
        ModelAndView model = new ModelAndView("/siifi/general-details-page");
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
        return "/siifi/enterprise-qualification";
    }

    /**
     * 智能产业
     *
     * @return
     */
    @RequestMapping("/intelligentIndustry")
    public ModelAndView findIntell(Integer id) {
        Intell intell = intellService.getIntellById(id);
        ModelAndView model = new ModelAndView("/siifi/intelligent-industry");
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
        return "/siifi/intelligent-classic-case";
    }

    /**
     * 生态产业
     *
     * @return
     */
    @RequestMapping("/industryEcology")
    public ModelAndView industryEcology(Integer id) {
        Zoology zoology = zoologyService.getZoologyById(id);
        ModelAndView model = new ModelAndView("/siifi/industry-ecology");
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
        ModelAndView model = new ModelAndView("/siifi/industry-media");
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
        ModelAndView model = new ModelAndView("/siifi/industry-education");
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
        return "/siifi/responsibility-honest";
    }

    /**
     * 黑名单
     *
     * @return
     */
    @RequestMapping("/responsibilityBlacklist")
    public String responsibilityBlacklist() {
        return "/siifi/responsibility-blacklist";
    }

    /**
     * 联系方式
     *
     * @return
     */
    @RequestMapping("/contact")
    public String contact() {
        return "/siifi/contact";
    }

    /**
     * 招聘简介
     *
     * @return
     */
    @RequestMapping("/recruitingIntroduction")
    public String recruitingIntroduction() {
        return "/siifi/recruiting-introduction";
    }

    /**
     * 招聘职位
     *
     * @return
     */
    @RequestMapping("/recruitingPosition")
    public String recruitingPosition() {
        return "/siifi/recruiting-position";
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
        ModelAndView model = new ModelAndView("/siifi/recruit-details");
        model.addObject("invite", invite);
        return model;
    }
}
