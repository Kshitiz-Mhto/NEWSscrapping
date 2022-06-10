package com.web;

import java.io.IOException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.Jsoup;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.select.Elements;

public class WebScrap extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
            response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String web = request.getParameter("url");
            String encodedUrl = web;
             try
                {
                    // Decoding using decode()
                    String decodedUrl = URLDecoder.decode(encodedUrl, "UTF-8");
    
        //   ignore document's content type while parsing | ignore HTTP errors while connecting to the URL
                    Document page;
                    page = Jsoup.connect(decodedUrl).ignoreContentType(true).ignoreHttpErrors(true).get();
                    
        //      set the timeout of 60 seconds i.e. 60000 in milliseconds by default 30 sec[after ward throws SocketTimeOutException exception]
                    Connection connection = Jsoup.connect(decodedUrl).timeout(60000);
                    
                    //get the response 
                    Response resp = Jsoup.connect(decodedUrl).execute();
                    int responseCode =(int) resp.statusCode();
                    if (responseCode==200){
                        Elements title = page.select("h1 > a[data-type=title]");
                        Elements subNews0 = page.select("h2 > a[onclick]");
                        Elements subNews1 = page.select("h3 > a[data-type=title]");
                        
                        out.println(""
                                + "<!DOCTYPE html>"
                                + "<html>"
                                + "<head>"
                                + "<meta charset=\"utf-8\">\n" +
                                    "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
                                + "<meta property=\"og:title\" content=\"कान्तिपुर - नेपालको राष्ट्रिय दैनिक, Online News and articles from Kantipur Daily\">"
                                + "<title> कान्तिपुर - नेपालको राष्ट्रिय दैनिक </title>"
                                + "</head>"
                                + "<body>");
                        out.println("<link rel=\"stylesheet\" href=\"./style1.css\" type=\"text/css\"/>");
                        // iterate the Elements
                        for(Element elm: title){
                            out.println("<div><p>"+elm.text()+"</p>"
                                            +"<br></div>");
                        }
                        // iterate the Elements
                        for(Element elm: subNews1){
                            out.println("<div> <p>"+elm.text()+"</p>"
                                            +"<br></div>");
                        }
                        // iterate the Elements
                        for(Element elm: subNews0){
                            out.println("<div> <p>"+elm.text()+"</p>"
                                            +"<br> </div>");
                        }
                        out.println("</body>"
                                + "</html>");
                    }
                    if(responseCode==404){
                        response.sendRedirect("error404.jsp");
                    }
                    if(responseCode>=400 && responseCode != 404){
                        response.sendRedirect("errorHandle.jsp");
                    }
                } catch (UnsupportedEncodingException e)
                {
                    out.println(e.getMessage());
                }
    }
}
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    processRequest(request, response);
}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    processRequest(request, response);
}
    
}
