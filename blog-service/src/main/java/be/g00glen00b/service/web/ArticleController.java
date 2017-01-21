package be.g00glen00b.service.web;

import be.g00glen00b.service.data.ArticleQuery;
import be.g00glen00b.service.data.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/article")
public class ArticleController {
    private ArticleService service;

    @Autowired
    public ArticleController(ArticleService service) {
        this.service = service;
    }

    @GetMapping
    public ArticlesDTO findAll(
        @RequestParam(required = false) String search,
        @RequestParam(required = false) Long user,
        @RequestParam(required = false, defaultValue = "0") int offset,
        @RequestParam(required = false, defaultValue = "10") int limit,
        @RequestParam(required = false, defaultValue = "-created") ArticleSort sort
    ) {
        return service.findAll(new ArticleQuery(search, user), offset, limit, sort);
    }
}