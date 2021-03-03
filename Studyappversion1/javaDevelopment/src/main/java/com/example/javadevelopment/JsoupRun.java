package com.example.javadevelopment;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupRun{
    public static void main(String[] args) throws IOException{
        WebClient webClient = new WebClient();

        HtmlPage page = (HtmlPage) webClient.getPage("https://ma-andover.myfollett.com/aspen/logon.do");
        HtmlForm form = page.getFormByName("logonForm");
        form.getInputByName("username").type("myUsername");
        form.getInputByName("password").type("myPassword");

        page = (HtmlPage) form.getInputByValue("Log On").click();

        System.out.println(page.asText());
    }
}