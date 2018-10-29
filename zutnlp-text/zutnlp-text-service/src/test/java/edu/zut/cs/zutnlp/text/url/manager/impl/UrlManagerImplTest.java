package edu.zut.cs.zutnlp.text.url.manager.impl;

import edu.zut.cs.zutnlp.text.Url.dao.UrlRecognitionDao;
import edu.zut.cs.zutnlp.text.Url.domain.UrlRecogntion;
import edu.zut.cs.zutnlp.text.base.service.impl.GenericGenerator;
import edu.zut.cs.zutnlp.text.service.UrlManager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlManagerImplTest extends GenericGenerator {

    @Autowired
    UrlManager urlManager;

    public static void spiderURL(String url,String regex,String filename) {

        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // String time=sdf.format(new Date());

        //UrlRecogntion u = new UrlRecogntion();
        BufferedReader br=null;
        URL realURL = null;

        String regex2="<p>.*?</p>";
        Pattern pattern2=Pattern.compile(regex2);

        URLConnection connection = null;
        Pattern pattern=Pattern.compile(regex);
        try{
            realURL=new URL(url);
            connection=realURL.openConnection();
            br=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line=null;
            while((line=br.readLine())!=null){

                //System.out.println(line);

                Matcher matcher=pattern.matcher(line);
                Matcher matcher2=pattern2.matcher(line);
                while(matcher.find()){
                    String text=matcher.group();
                    text = text.replaceAll("<title>", "");
                    text = text.replaceAll("</title>", "");
                    text = text.replaceAll("\n","");
                    //  text = text.replaceAll("\\pP",""); 除去所有标点
                    System.out.println(text);
                }
                while(matcher2.find()){
                    String text2=matcher2.group();
                    text2=text2.replace(" ","");
                    text2=text2.replace("<p>","");
                    text2=text2.replace("</p>","");
                    text2 = text2.replaceAll("\n","");
                    System.out.println(text2);
                    //u.setT_data(text2);
                    //u.setT_url(url);
                    //urlManager.save(u);
                }
            }
            System.out.println("爬取成功！");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void add(){
        String url="http://ent.sina.com.cn/zl/bagua/2018-10-17/doc-ihmhafis1746727.shtml";
        UrlRecogntion u = new UrlRecogntion(url);
        u.setT_data(subRangeString(u.getT_data(),"<a","a>"));
        u.setT_data(subRangeString(u.getT_data(),"<s","an>"));
        urlManager.save(u);
        System.out.println("成功！！");
    }

    public String subRangeString(String body,String str1,String str2) {
        while (true) {
            int index1 = body.indexOf(str1);
            if (index1 != -1) {
                int index2 = body.indexOf(str2, index1);
                if (index2 != -1) {
                    String str3 = body.substring(0, index1) + body.substring(index2 +    str2.length(), body.length());
                    body = str3;
                }else {
                    return body;
                }
            }else {
                return body;
            }
        }
    }

    public static void main(String[] args) {

        String url="http://ent.sina.com.cn/zl/bagua/2018-10-17/doc-ihmhafis1746727.shtml";
//String url="http://list.youku.com/show/id_z9cd2277647d311e5b692.html?spm=a2h0j.8191423.sMain.5~5~A!2.iCUyO9";
        //String regex= "(http|https)://[\\w+\\.?/?]+\\.[A-Za-z]+";
        //   String regex = "(?<=<title>)[<title>.*?</title>]";
        //   String regex = "name=\"description\" content=\"(.+?)/>";
        // String regex="<[a-zA-Z]+.*?>([\s\S]*?)</[a-zA-Z]*>";
        // String regex="[\\u4e00-\\u9fa5]";   中文
        //(?<=顶：)表示除去  顶： 的文本信息。
        // String regex="<title>.*?</title>+";
        String regex="<title>.*?</title>";
        //"([-+*/^()\\]\\[])";  去掉特殊符号
        //提取title 和<P>
        spiderURL(url,regex,"8btc");
    }

}
