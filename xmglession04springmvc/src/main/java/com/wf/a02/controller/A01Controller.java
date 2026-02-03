package com.wf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@SessionAttributes("articleId")
public class A01Controller {

    private final String[] sensitiveWords = new String[]{"k1","k2"};

    @ModelAttribute("comment")
    public String replaceSensitiveWords(String comment) throws IOException{
        if(comment != null){
            System.out.println("原始comment:"+comment);
            for (String sensitiveWord : sensitiveWords) {
                comment = comment.replace(sensitiveWord,"");
            }
            System.out.println("去除敏感词后comment:"+comment);
        }
        return comment;
    }

    // 127.0.0.1:8080/articles/67/comment?comment=好s2赞k1赞k2
    @RequestMapping(value = "/articles/{articleId}/comment")
    public String doComment(@PathVariable String articleId, RedirectAttributes attributes,Model model){

        attributes.addFlashAttribute("comment",model.asMap().get("comment"));
        model.addAttribute("articleId",articleId);

        return "redirect:/showArticle";
    }

    @RequestMapping(value = "/showArticle",method = RequestMethod.GET)
    public String showArticle(Model model, SessionStatus sessionStatus){

        String articleId = (String)model.asMap().get("articleId");

        model.addAttribute("articleTitle",articleId+"号文章标题");
        model.addAttribute("article",articleId+"号文章内容");
        sessionStatus.setComplete();
        return "article";
    }

    /* 去除敏感词在注释 ModelAttribute的replaceSensitiveWords方法中执行。
    *1. 请求发送到服务器后，服务器程序会进行配分一个Socket线程来跟他进行连接，接着创建出request 和 response，然后交给对应的Servlet处理。
    *   这样请求就从Servlet容器传递到了Servlet。
    *2. 在Servlet中请求首先被HttpServlet处理，在HttpServlet的service方法中将ServletRequest和ServletResponse转换成HttpServletRequest
    *  和HttpServletResponse。
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    * */






}
