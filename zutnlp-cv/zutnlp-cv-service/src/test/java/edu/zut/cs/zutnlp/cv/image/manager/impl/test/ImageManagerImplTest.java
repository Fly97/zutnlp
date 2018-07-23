package edu.zut.cs.zutnlp.cv.image.manager.impl.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import edu.zut.cs.zutnlp.cv.base.service.impl.GenericGenerator;
import edu.zut.cs.zutnlp.cv.image.domain.Image;
import edu.zut.cs.zutnlp.cv.manager.ImageManager;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;

public class ImageManagerImplTest extends GenericGenerator {

    @Autowired
    ImageManager imageManager;

    @Test
    public void testAdd()
    {
        try {
            for(int i=1;i<2;i++) {
                File file=new File("G:\\Java\\ServerFiles\\image_data\\complete\\"+i+".json");
                String content= FileUtils.readFileToString(file, "utf-8");
                String []all=content.split("\"width\"");
                for(String a:all)
                {
                    if(a.length()<5)
                        continue;
                    content="{\"width\""+a.substring(0, a.length()-2);
                    if(content.charAt(content.length()-1)==',')
                        content=content.substring(0,content.length()-1);
                    JSONObject job= JSON.parseObject(content);
                    int width=job.getIntValue("width");
                    int height=job.getIntValue("height");
                    String url=job.getString("url");
                    Long image_id=null;
                    image_id=new Long(job.getLong("image_id"));
                    //{"width": 800,
                    //"url": "https://cs.stanford.edu/people/rak248/VG_100K_2/1.jpg",
                    //"height": 600, "image_id": 1, "coco_id": null, "flickr_id": null}
                    Long coco_id=null;
                    Long flickr_id=null;
                    if(job.getString("coco_id")!="null")
                    {
                        coco_id=job.getLong("coco_id");
                    }
                    if(job.getString("flickr_id")!="null")
                    {
                        flickr_id=job.getLong("flickr_id");
                    }
                    Image image=new Image();
                    //从文件中获取各种数据，插入到数据库中
                    image.setCoco_id(coco_id);
                    image.setFlickr_id(flickr_id);
                    image.setWidth(width);
                    image.setEntityName("IMAGE");
                    image.setHeight(height);
                    image.setImage_id(image_id);
                    this.imageManager.save(image);
                }
                System.out.println("第"+i+"个文件完成!");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
