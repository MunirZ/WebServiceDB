package munir.webservicedb.mapper;

import lombok.RequiredArgsConstructor;
import munir.webservicedb.model.Article;
import munir.webservicedb.request.ArticleRequest;
import munir.webservicedb.response.ArticleResponse;
import munir.webservicedb.service.SupplierService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleMapper {
    private final SupplierService service;

    public Article mapRequestToModel(ArticleRequest request) {
        Article article = new Article();
        article.setDesignation(request.getDestination());
        article.setPrice(request.getPrice());
        if (request.getSupplier() != 0) {
            article.setSupplier(service.readById(request.getSupplier()));
        }
        return article;
    }

    public Article mapRequestToModel(long id, ArticleRequest request) {
        return null;
    }

    public ArticleResponse mapModelToResponse(Article model) {
        return null;
    }
}
