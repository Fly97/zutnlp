package edu.zut.cs.zutnlp.text.Url.domain;

import edu.zut.cs.zutnlp.base.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Table(name = "Urldata")
@Entity
public class UrlRecogntion extends BaseEntity {
    @Column(name = "T_URL")
    private String t_url;

    @Column(name = "T_DATA")
    private String t_data;

    public String getT_url() {
        return t_url;
    }

    public void setT_url(String t_url) {
        this.t_url = t_url;
    }

    public String getT_data() {
        return t_data;
    }

    public void setT_data(String t_data) {
        this.t_data = t_data;
    }

    public UrlRecogntion(){

    }
    public UrlRecogntion (String url){
        String text="";
        UrlRecogntion ur=new UrlRecogntion();
        ur.setT_url(url);
        String regex1="<title>.*?</title>";
        String regex2="<p>.*?</p>";
        BufferedReader br=null;
        URL realURL = null;
        URLConnection connection=null;
        Pattern pattern1=Pattern.compile(regex1);
        Pattern pattern2=Pattern.compile(regex2);
        try{
            realURL=new URL(url);
            connection=realURL.openConnection();
            br=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line=null;
            while((line=br.readLine())!=null){
                Matcher matcher1=pattern1.matcher(line);
                Matcher matcher2=pattern2.matcher(line);
                while(matcher1.find()){
                    String text1=matcher1.group();
                    text1 = text1.replaceAll("<title>", "");
                    text1 = text1.replaceAll("</title>", "");
                    text1 = text1.replaceAll("\n","");
                    //  text = text.replaceAll("\\pP",""); 除去所有标点
                    text+=text1;
                }
                while(matcher2.find()){
                    String text2=matcher2.group();
                    text2=text2.replace(" ","");
                    text2=text2.replace("<p>","");
                    text2=text2.replace("</p>","");
                    text2 = text2.replaceAll("\n","");
                    //System.out.println(text2);
                    text+=text2;
                }
            }
            text=subRangeString(text,"<a","a>");
            text=subRangeString(text,"<s","an>");
            text=text.replaceAll(" ","\n");
            this.t_data=text;
            this.t_url=url;
            System.out.println("爬取成功！");
        }catch(Exception e){
            e.printStackTrace();
        }
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

    @Override
    public String toString() {
        return "UrlRecogntion{" +
                "t_url='" + t_url + '\'' +
                ", t_data='" + t_data + '\'' +
                '}';
    }
}
