package munir.webservicedb.request;

import lombok.Getter;
import munir.webservicedb.model.Supplier;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.*;

@Getter
public class ArticleRequest {
    private long id;
    @NotBlank(message = "Name is mandatory.")
    @Size(max = 50, message = "Name must not have more than 50 characters.")
    private String name;
    @NotBlank(message = "Destination is mandatory.")
    @Size(max = 50, message = "Destination must not have more than 50 characters.")
    private String destination;
    @NotBlank(message = "Price is mandatory")
    @DecimalMin("0.0")
    @Digits(integer = 4, fraction = 2)
    private Double price;
    @NotBlank(message = "Supplier is mandatory.")
    private long supplier;
}
