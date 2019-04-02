package com.siifi.infos.controller;

import com.siifi.infos.entity.ManeyImage;
import com.siifi.infos.entity.ManeysImage;
import com.siifi.infos.service.maney.ManeyImagesService;
import com.siifi.infos.service.maneyiamge.ManeyImageService;
import com.siifi.infos.utils.Constants;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value = "infos")
public class ManeyImageController {
    @Autowired
    private ManeyImagesService maneyImagesService;
    @Autowired
    private ManeyImageService maneyImageService;

    /**
     * 跳转轮播图页面
     *
     * @return
     */
    @RequestMapping("/maneyIamge")
    public String maneyIamge() {
        return "maney_image";
    }

    /**
     * 多图片上传
     *
     * @param file
     * @param areaName
     * @throws Exception
     */
    @RequestMapping("/uploadImg")
    @ResponseBody
    public Map<String, Object> uploadImg(MultipartFile file[], HttpServletRequest request) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        String areaName = request.getParameter("areaName");
        ManeysImage maneysImage = new ManeysImage();
        maneysImage.setName(areaName);
        maneyImagesService.saveManey(maneysImage);
        int id = maneysImage.getManeyId();
        String maneyId = String.valueOf(id);
        String imgPath = "D:/fileImage/image/";
        List<ManeyImage> list=new ArrayList<>();
        for (MultipartFile f : file) {
            String imgName = System.currentTimeMillis() + f.getOriginalFilename();
            //上传文件
            uploadFileUtil(f.getBytes(), imgPath, imgName);
            String sqlPath = Constants.PICTURE_VISIT_FILE_PATH + imgName;
            ManeyImage maneyImage=new ManeyImage();
            maneyImage.setManeyId(maneyId);
            maneyImage.setTid(sqlPath);
            list.add(maneyImage);
        }
        maneyImageService.saveRelativityManey(list);
        map.put("code", 1);
        map.put("message", "图片上传成功");
        return map;
    }

    /**
     * 上传文件的方法
     *
     * @param file：文件的字节
     * @param imgPath：文件的路径
     * @param imgName：文件的名字
     * @throws Exception
     */
    public void uploadFileUtil(byte[] file, String imgPath, String imgName) throws Exception {
        File targetFile = new File(imgPath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(imgPath + imgName);
        out.write(file);
        out.flush();
        out.close();
    }
}
