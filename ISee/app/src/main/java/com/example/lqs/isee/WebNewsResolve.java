package com.example.lqs.isee;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by lqs on 2017/11/21.
 */

public class WebNewsResolve {
    private ArrayList<String> newsText;
    private ArrayList<String> newsLink;
    private ArrayList<String> newsImage;
    public WebNewsResolve(final String resolveUrl) {
        try {
            newsText = new ArrayList<>();
            newsLink = new ArrayList<>();
            newsImage = new ArrayList<>();
            Document doc = Jsoup.connect(resolveUrl).get();
            Element topElement = doc.getElementById("topcol1");
            Document topNewsDoc = Jsoup.parse(topElement.toString());
            Elements news = topNewsDoc.getElementsByClass("item");
            for (Element item : news) {
                Document newsDoc = Jsoup.parse(item.toString());
                Elements content = newsDoc.getElementsByClass("ii");
                Elements imageLink = newsDoc.select("a img");
                Elements articleLink = newsDoc.getElementsByClass("ourh");

                newsText.add(content.text());
                newsLink.add(articleLink.attr("href"));
                newsImage.add(imageLink.attr("src"));
            }
            Elements lastNews = topNewsDoc.getElementsByClass("last item");
            Document lastNewsDoc = Jsoup.parse(lastNews.toString());
            newsText.add(lastNewsDoc.getElementsByClass("ii").text());
            newsLink.add(lastNewsDoc.getElementsByClass("ourh").attr("href"));
            newsImage.add(lastNewsDoc.select("a img").attr("src"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getNewsText() {
        return newsText;
    }

    public ArrayList<String> getNewsImage() {
        return newsImage;
    }

    public ArrayList<String> getNewsLink() {
        return newsLink;
    }
}
