package com.siifi.infos.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.siifi.infos.entity.Product;
import com.siifi.infos.mapper.ProductMapper;
import com.siifi.infos.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.jws.WebService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebService
@Controller
@RequestMapping(value = "infos")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "product")
    public String product() {
        return "product";
    }

    @RequestMapping(value = "siifi")
    public String siifi() {
        return "siifi";
    }

    @RequestMapping(value = "productlist")
    public String productlist() {
        return "product_list";
    }

    @RequestMapping(value = "vuetest")
    public String vue_test() {
        return "vue_test";
    }

    /**
     * 添加工程案例
     *
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> saveProduct(@RequestBody Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        String productName = reqMap.get("productName").toString();
        String utter = reqMap.get("utter").toString();
        String date = reqMap.get("date").toString();
        String shou = reqMap.get("shou").toString();
        String imgPath = reqMap.get("imgPath").toString();
        Product product = new Product();
        product.setProductName(productName);
        product.setUtter(utter);
        product.setDate(date);
        product.setShou(shou);
        product.setImagePath(imgPath);
        Boolean bool = productService.saveProduct(product);
        if (bool == true) {
            map.put("code", "1");
            map.put("message", "保存成功");
        } else {
            map.put("code", "0");
            map.put("message", "保存失败");
        }
        return map;
    }

    /**
     * 查询所有目录(分页查询)
     *
     * @return
     */
    @Resource
    private ProductMapper productMapper;
    @RequestMapping(value = "product/lists", method = RequestMethod.GET)
    @ResponseBody
    public PageInfo<Product> getProduct(@RequestParam int pageNum) {
        PageHelper.startPage(pageNum,6);
        List<Product> products = productMapper.listAll();
        PageInfo<Product> productPageInfo=new PageInfo<>(products);
        return productPageInfo;
    }

    /**
     * 根据id查数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/findProductById")
    public ModelAndView findProductById(Integer id) {
        Product product = productService.getProductById(id);
        ModelAndView model = new ModelAndView("product_edit");
        model.addObject("product", product);
        return model;
    }

    /**
     * 修改工程案例  改变图片的情况
     *
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/editProductImage", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> editProductImage(@RequestBody Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        String productId = reqMap.get("productId").toString();
        int id = Integer.parseInt(productId);
        String productName = reqMap.get("productName").toString();
        String utter = reqMap.get("utter").toString();
        String date = reqMap.get("date").toString();
        String shou = reqMap.get("shou").toString();
        String imgPath = reqMap.get("imgPath").toString();
        Product product = new Product();
        product.setProductId(id);
        product.setProductName(productName);
        product.setDate(date);
        product.setUtter(utter);
        product.setShou(shou);
        product.setImagePath(imgPath);
        Boolean bool = productService.editProduct(product);
        if (bool == true) {
            map.put("code", "1");
            map.put("message", "修改成功");
        } else {
            map.put("code", "0");
            map.put("message", "修改失败");
        }
        return map;
    }

    /**
     * 修改工程案例  不改变图片的情况
     *
     * @param reqMap
     * @return
     */
    @RequestMapping(value = "/editProduct", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> editProduct(@RequestBody Map<String, Object> reqMap) {
        Map<String, Object> map = new HashMap<String, Object>();
        String productId = reqMap.get("productId").toString();
        int id = Integer.parseInt(productId);
        String productName = reqMap.get("productName").toString();
        String utter = reqMap.get("utter").toString();
        String date = reqMap.get("date").toString();
        String shou = reqMap.get("shou").toString();
        Product product = new Product();
        product.setProductId(id);
        product.setProductName(productName);
        product.setDate(date);
        product.setUtter(utter);
        product.setShou(shou);
        Boolean bool = productService.editProduct(product);
        if (bool == true) {
            map.put("code", "1");
            map.put("message", "修改成功");
        } else {
            map.put("code", "0");
            map.put("message", "修改失败");
        }
        return map;
    }

    /**
     * 根据id查数据
     *
     * @param id
     * @return
     */
    @RequestMapping("/findProductImage")
    public ModelAndView findProductImage(Integer id) {
        Product product = productService.getProductById(id);
        ModelAndView model = new ModelAndView("product_image");
        model.addObject("product", product);
        return model;
    }

    /**
     * 删除工程案例
     * @param id
     * @return
     */
    @RequestMapping("/deleteProduct")
    public String deleteProduct(Integer id) {
        productService.deleteProduct(id);
        return "product_list";
    }
}
