package com.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class MainSocial {
    public static void main(String[] args) {
        System.out.println(getBaiduMarketDownloadNum());
        System.out.println(get91MarketDownloadNum());
        System.out.println(getAndroidMarketDownloadNum());
        System.out.println(getAnzhiMarketDownloadNum());
        System.out.println(getGooglePlayMarketDownloadNum());
    }

    /**
     * 百度手机市场
     *
     * @return
     */
    private static String getBaiduMarketDownloadNum() {
        String value = null;
        try {
            String marketUrl = "http://shouji.baidu.com/software/9347418.html";
            Document document = Jsoup.connect(marketUrl).get();
            Elements elementsByClass = document.getElementsByClass("download-num");
            value = "百度下载次数：" + elementsByClass.text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }


    /**
     * 91手机市场
     *
     * @return
     */
    private static String get91MarketDownloadNum() {
        String value = null;
        try {
            String marketUrl = "http://apk.91.com/Soft/Android/com.vipabc.vipmobile-4-1.0.19.html";
            Document document = Jsoup.connect(marketUrl).get();
            Elements elementsByClass = document.getElementsByClass("s_info");
            value = "91下载次数：" + elementsByClass.select("li").get(1).text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * 安卓手机市场
     *
     * @return
     */
    private static String getAndroidMarketDownloadNum() {
        String value = null;
        try {
            String marketUrl = "http://apk.hiapk.com/appinfo/com.vipabc.vipmobile/4";
            Document document = Jsoup.connect(marketUrl).get();
            Elements elementsByClass = document.getElementsByClass("line_content");
            value = "安卓下载次数：" + elementsByClass.get(1).select("span").get(1).text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }


    /**
     * 安智手机市场
     *
     * @return
     */
    private static String getAnzhiMarketDownloadNum() {
        String value = null;
        try {
            String marketUrl = "http://www.anzhi.com/soft_2599813.html";
            Document document = Jsoup.connect(marketUrl).get();
            Elements elementsByClass = document.getElementsByClass("spaceleft");
            value = "安智下载次数：" + elementsByClass.get(0).text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * GooglePlay市场
     *
     * @return
     */
    private static String getGooglePlayMarketDownloadNum() {
        String value = null;
        try {
            String marketUrl = "https://play.google.com/store/apps/details?id=com.vipabc.vipmobile";
            Document document = Jsoup.connect(marketUrl).proxy("192.168.23.199", 8080).get();
            Elements elementsByClass = document.getElementsByClass("content");
            value = "GooglePlay下载次数：" + elementsByClass.get(2).text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

}
