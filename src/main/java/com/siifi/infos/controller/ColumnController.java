package com.siifi.infos.controller;

import com.siifi.infos.entity.Column;
import com.siifi.infos.service.column.ColumnService;
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
public class ColumnController {
    @Autowired
    private ColumnService columnService;

    /**
     * 跳转栏目管理视图
     * @return
     */
    @RequestMapping("/column")
    public String column() {
        return "column";
    }

    /**
     * 跳转添加目录视图
     * @return
     */
    @RequestMapping("/columnadd")
    public String columnadd() {
        return "column_add";
    }

    /**
     * 查询所有目录
     * @return
     */
    @RequestMapping(value = "column/lists",method = RequestMethod.GET)
    @ResponseBody
    public List<Column> getColumn(){
        List<Column> column=columnService.getColumn();
        return column;
    }

    /**
     * 添加目录
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/saveColumn",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> saveColumn(@RequestBody Map<String, Object> reqMap){
        Map<String,Object> map = new HashMap<String,Object>();
        String columnName=reqMap.get("columnName").toString();
        String shou=reqMap.get("shou").toString();
        Column column=new Column();
        column.setColumnName(columnName);
        column.setShou(shou);
        columnService.saveColumn(column);
        map.put("code","1");
        map.put("message","保存成功");
        return map;
    }

    /**
     * 根据id查数据
     * @param id
     * @return
     */
    @RequestMapping("/findColumn" )
    public ModelAndView findColumn(Integer id) {
        Column column=columnService.getColumnById(id);
        ModelAndView model = new ModelAndView("columnedit");
        model.addObject("column",column);
        return model;
    }

    /**
     * 根据id查数据(富文本编辑器)
     * @param id
     * @return
     */
    @RequestMapping(value = "/findColumns",method = RequestMethod.GET)
    @ResponseBody
    public Column findColumns(String columnId) {
        int id=Integer.parseInt(columnId) ;
        Column column=columnService.getColumnById(id);
        return column;
    }

    /**
     * 修改目录
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/editColumn",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> editColumn(@RequestBody Map<String, Object> reqMap){
        Map<String,Object> map = new HashMap<String,Object>();
        String columnId=reqMap.get("columnId").toString();
        int id=Integer.parseInt(columnId);
        String columnName=reqMap.get("columnName").toString();
        String shou=reqMap.get("shou").toString();
        Column column=new Column();
        column.setColumnId(id);
        column.setColumnName(columnName);
        column.setShou(shou);
        columnService.editColumn(column);
        map.put("code",1);
        map.put("message","修改成功");
        return map;
    }

    /**
     * 编辑栏目内容
     * @param id
     * @return
     */
    @RequestMapping("/findUeiorColumn")
    public ModelAndView findUeiorColumn(Integer id) {
        Column column=columnService.getColumnById(id);
        ModelAndView model = new ModelAndView("column_ueior");
        model.addObject("column",column);
        return model;
    }

    /**
     * 修改栏目内容
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/editUeiorColumn",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> editUeior(@RequestBody Map<String, Object> reqMap){
        Map<String,Object> map = new HashMap<String,Object>();
        String columnId=reqMap.get("tid").toString();
        int id=Integer.parseInt(columnId);
        String content=reqMap.get("text").toString();
        Column column=new Column();
        column.setColumnId(id);
        column.setContent(content);
        columnService.editColumn(column);
        map.put("code",1);
        map.put("message","修改成功");
        return map;
    }

    /**
     * 删除目录
     * @param id
     * @return
     */
    @RequestMapping("/deleteColumn")
    public String deleteColumn(Integer id) {
        columnService.deleteColumn(id);
        return "column";
    }

}
