package munir.webservicedb.controller;

import lombok.RequiredArgsConstructor;
import munir.webservicedb.mapper.SupplierMapper;
import munir.webservicedb.model.Supplier;
import munir.webservicedb.request.SupplierRequest;
import munir.webservicedb.response.SupplierResponse;
import munir.webservicedb.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/guestbook/suppliers")
@RequiredArgsConstructor
public class SupplierController {
    private final SupplierMapper mapper;
    private final SupplierService service;

    @PostMapping
    public SupplierResponse addSupplier(@Valid @RequestBody SupplierRequest request) {
        Supplier supplierRequest = mapper.mapRequestToModel(request);
        Supplier supplierResponse = service.create(supplierRequest);
        return mapper.mapModelToResponse(supplierResponse);
    }

    @GetMapping
    public SupplierResponse readById(@Valid @RequestBody Long id) {
        Supplier supplier = service.readById(id);
        return mapper.mapModelToResponse(supplier);
    }

    @PutMapping
    public SupplierResponse update(@Valid @RequestBody Long id, SupplierRequest request) {
        Supplier supplier = mapper.mapRequestToModel(request);
        service.update(supplier, id);
        return mapper.mapModelToResponse(supplier);
    }

}
