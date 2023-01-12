package munir.webservicedb.controller;

import lombok.RequiredArgsConstructor;
import munir.webservicedb.mapper.ArticleMapper;
import munir.webservicedb.model.Article;
import munir.webservicedb.model.Supplier;
import munir.webservicedb.response.ArticleResponse;
import munir.webservicedb.response.SupplierResponse;
import munir.webservicedb.service.ArticleService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/guestbook/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleMapper mapper;
    private final ArticleService service;

    @GetMapping
    public ArticleResponse readById(@Valid @RequestBody Long id) {
        Article article = service.readById(id);
        return mapper.mapModelToResponse(article);
    }

    @GetMapping(value = "/{id}/article")
    public List<ArticleResponse> getForOneSupplierAllArticles(@PathVariable long id) {
        service.readForOneSupplierAllArticles(id).forEach((n) -> {
            List<ArticleResponse> responseList = new ArrayList<>();
            return responseList.add(mapper.mapModelToResponse(n));
        });
        return responseList;
    }
}
