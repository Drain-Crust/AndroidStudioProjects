package com.example.libs;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class MyClass {
    public static void main(String[] args) throws Exception {
        WebClient webClient = new WebClient();
        kamarLogin(webClient);




        Document doc = Jsoup.parse("file:///C:/Users/Adrian%20Cruz/Downloads/java.html");
        Elements body = doc.select("table.table_table-bordered");
        System.out.println(body.select("tbody.tr").size());
    }

    private static void kamarLogin(WebClient webClient) throws Exception{
        HtmlPage currentPage = (HtmlPage) webClient.getPage("https://kamarportal.mrgs.school.nz/index.php"); //Load page at the STRING address.
        HtmlInput username = (HtmlInput) currentPage.getHtmlElementsByIdAndOrName("login-username"); //Find element called loginuser for username
        username.setValueAttribute("17162"); //Set value for username
        HtmlInput password = (HtmlInput) currentPage.getHtmlElementsByIdAndOrName("login-password"); //Find element called loginpassword for password
        password.setValueAttribute("bLigh!6"); //Set value for password

    }
}