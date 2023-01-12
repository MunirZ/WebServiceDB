package munir.webservicedb.mapper;

import lombok.RequiredArgsConstructor;
import munir.webservicedb.model.Supplier;
import munir.webservicedb.request.SupplierRequest;
import munir.webservicedb.response.SupplierResponse;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplierMapper {

    public Supplier mapRequestToModel(SupplierRequest request) {
        Supplier supplier = new Supplier();
        supplier.setName(request.getName());
        supplier.setPhone(request.getPhone());
        supplier.setEmail(request.getEmail());
        return supplier;
    }

    public Supplier mapRequestToModel(long id, SupplierRequest request) {
        Supplier supplier = mapRequestToModel(request);
        supplier.setId(id);
        return supplier;
    }

    public SupplierResponse mapModelToResponse(Supplier model) {
        SupplierResponse response = new SupplierResponse();
        response.setName(model.getName());
        response.setEmail(model.getEmail());
        response.setPhone(model.getPhone());
        return response;
    }
}
