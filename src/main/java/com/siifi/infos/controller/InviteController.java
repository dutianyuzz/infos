package com.siifi.infos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.siifi.infos.entity.Invite;
import com.siifi.infos.entity.Jobintro;
import com.siifi.infos.mapper.InviteMapper;
import com.siifi.infos.service.invite.InviteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "infos")
public class InviteController {
    @Resource
    private InviteService inviteService;

    /**
     *跳转添加职位
     * @return
     */
    @RequestMapping("/inviteAdd")
    public String inviteAdd() {
        return "invite_add";
    }

    /**
     *跳转职位目录
     * @return
     */
    @RequestMapping("/inviteList")
    public String inviteList() {
        return "invite_list";
    }

    /**
     * 添加职位
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/saveInvite",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveInvite(@RequestBody Map<String, Object> reqMap){
        Map<String,Object> map = new HashMap<String,Object>();
        String inviteName=reqMap.get("inviteName").toString();
        String personName=reqMap.get("personName").toString();
        String date=reqMap.get("date").toString();
        String contentText=reqMap.get("contentText").toString();
        Invite invite=new Invite();
        invite.setInviteName(inviteName);
        invite.setPersonName(personName);
        invite.setDate(date);
        invite.setInviteText(contentText);
        int i=inviteService.saveInvite(invite);
        if(i > 0){
            map.put("code","1");
            map.put("message","保存成功");
        }
        else {
            map.put("code","0");
            map.put("message","保存失败");
        }
        return map;
    }

    /**
     * 查询所有目录（分页查询）
     * @return
     */
    @Resource
    private InviteMapper inviteMapper;
    @RequestMapping(value = "invite/lists",method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Invite> getInvite(@RequestParam int pageNum){
        PageHelper.startPage(pageNum, 8);
        List<Invite> invites=inviteMapper.listAll();
        PageInfo<Invite> pageInfo=new PageInfo<>(invites);
        return pageInfo;
    }

    /**
     * 根据id查数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/findInviteById")
    public ModelAndView findInviteById(Integer id) {
        Invite invite=inviteService.getInviteById(id);
        ModelAndView model = new ModelAndView("invite_edit");
        model.addObject("invite", invite);
        return model;
    }

    /**
     * 根据id查数据(富文本编辑器)
     * @param id
     * @return
     */
    @RequestMapping(value = "/findInviteByIds",method = RequestMethod.GET)
    @ResponseBody
    public Invite findInviteByIds(String inviteId) {
        int id=Integer.parseInt(inviteId);
        Invite invite=inviteService.getInviteById(id);
        return invite;
    }

    /**
     * 修改职位
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/editInvite",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> editInvite(@RequestBody Map<String, Object> reqMap){
        Map<String,Object> map = new HashMap<String,Object>();
        String id=reqMap.get("inviteId").toString();
        int inviteId=Integer.parseInt(id);
        String inviteName=reqMap.get("inviteName").toString();
        String personName=reqMap.get("personName").toString();
        String date=reqMap.get("date").toString();
        String contentText=reqMap.get("contentText").toString();
        Invite invite=new Invite();
        invite.setInviteId(inviteId);
        invite.setInviteName(inviteName);
        invite.setPersonName(personName);
        invite.setDate(date);
        invite.setInviteText(contentText);
        int i=inviteService.editInvite(invite);
        if(i > 0){
            map.put("code","1");
            map.put("message","保存成功");
        }
        else {
            map.put("code","0");
            map.put("message","保存失败");
        }
        return map;
    }

    /**
     * 删除目录
     * @param id
     * @return
     */
    @RequestMapping("/deleteInvite")
    public String deleteInvite(Integer id) {
        int i=inviteService.deleteInvite(id);
        return "invite_list";
    }

    /**
     * 根据id查数据(招聘简介)
     *
     * @param id
     * @return
     */
    @RequestMapping("/findJobById")
    public ModelAndView findJobById(Integer id) {
        id=1;
        Jobintro jobintro =inviteService.getJobintroById(id);
        ModelAndView model = new ModelAndView("job_ueior");
        model.addObject("jobintro", jobintro);
        return model;
    }

    /**
     * 根据id查数据(招聘简介)(富文本编辑器)
     * @param id
     * @return
     */
    @RequestMapping(value = "/findJobByIds",method = RequestMethod.GET)
    @ResponseBody
    public Jobintro findJobByIds(Integer id) {
        id=1;
        Jobintro jobintro =inviteService.getJobintroById(id);
        return jobintro;
    }

    /**
     * 修改招聘简介
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/editJob",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> editJob(@RequestBody Map<String, Object> reqMap){
        Map<String,Object> map = new HashMap<String,Object>();
        String id=reqMap.get("tid").toString();
        int jobintroId=Integer.parseInt(id);
        String content=reqMap.get("text").toString();
        Jobintro jobintro=new Jobintro();
        jobintro.setJobintroId(jobintroId);
        jobintro.setContent(content);
        int i=inviteService.editJobintro(jobintro);
        if(i > 0){
            map.put("code","1");
            map.put("message","保存成功");
        }
        else {
            map.put("code","0");
            map.put("message","保存失败");
        }
        return map;
    }
}
