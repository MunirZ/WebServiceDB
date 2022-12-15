package munir.webservicedb.request;

import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
public class SupplierRequest {
    private long id;
    @NotBlank(message = "Name is mandatory.")
    @Size(max = 50, message = "Name must not have more than 50 characters.")
    private String name;
    private String phone;
    @NotBlank(message = "Emails is mandatory.")
    private String email;
}
