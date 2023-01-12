package munir.webservicedb.service;

import lombok.RequiredArgsConstructor;
import munir.webservicedb.model.Article;
import munir.webservicedb.model.Supplier;
import munir.webservicedb.repository.ArticleRepository;
import munir.webservicedb.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private String exceptionMessage = "No supplier found.";
    private final ArticleRepository repository;
    private final SupplierRepository supplierRepository;

    public Article readById(long id) {
        Optional<Article> oArticle = repository.findById(id);
        if (oArticle.isEmpty()) {
            throw new EntityNotFoundException(exceptionMessage + "id = " + id);
        }
        return oArticle.get();
    }

    public List<Article> readForOneSupplierAllArticles(long id) {
        Supplier supplier = supplierRepository.getReferenceById(id);
        List<Article> list = supplier.getArticleList();
        return list;
    }
}
