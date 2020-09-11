package com.example.demo.controller;

import com.example.demo.entity.Article;
import com.example.demo.repository.ArticleRepository;
import com.example.demo.result.ExceptionMsg;
import com.example.demo.result.Response;
import com.example.demo.result.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("article")
public class ArticleController {

    protected Response result(ExceptionMsg msg){
        return new Response(msg);
    }

    protected Response result(){
        return new Response();
    }

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseData getArticleList() {
        List<Article> list = new ArrayList<Article>(articleRepository.findAll());
        return new ResponseData(ExceptionMsg.SUCCESS,list);

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseData add(Article article) {
        System.out.println("reached here...");
        articleRepository.save(article);
        return new ResponseData(ExceptionMsg.SUCCESS,article);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Response delete(@PathVariable("id") long id) {
        articleRepository.deleteById(id);
        return result(ExceptionMsg.SUCCESS);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseData update(Article model) {
        articleRepository.save(model);
        return new ResponseData(ExceptionMsg.SUCCESS,model);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseData findArticle(@PathVariable("id") Integer id) throws IOException {
        Article article = articleRepository.findById(id);
        if (article != null) {
            return new ResponseData(ExceptionMsg.SUCCESS,article);
        }
        return new ResponseData(ExceptionMsg.FAILED,article);
    }

    @RequestMapping(value = "/re/{id}", method = RequestMethod.GET)
    public Article findArticled(@PathVariable("id") Integer id) throws IOException {
        RestTemplate client= restTemplateBuilder.build();
        String uri = "http://localhost:8080/article/"+id;
        System.out.println(uri);
        Article article = client.getForObject(uri,Article.class,id);
        return article;
    }
}