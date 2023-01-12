package munir.webservicedb.service;

import lombok.RequiredArgsConstructor;
import munir.webservicedb.model.Supplier;
import munir.webservicedb.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupplierService {
    private String exceptionMessage = "No supplier found.";
    private final SupplierRepository repository;

    public Supplier create(Supplier supplier) {
        repository.save(supplier);
        return supplier;
    }

    public Supplier readById(long id) {
        Optional<Supplier> oSupplier = repository.findById(id);
        if (oSupplier.isEmpty()) {
            throw new EntityNotFoundException(exceptionMessage + "id = " + id);
        }
        return oSupplier.get();
    }

    public List<Supplier> readAll() {
        List<Supplier> suppliers = repository.findAll();
        for (Supplier supplier : suppliers) {
            if (supplier == null) {
                throw new EntityNotFoundException(exceptionMessage);
            }
        }
        return suppliers;
    }

    public void delete(long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(exceptionMessage + "id = " + id);
        }
        repository.deleteById(id);
    }

    public void update(Supplier supplier, long id) {
        Optional<Supplier> repositorySupplier = repository.findById(id);
        repositorySupplier.get().setName(supplier.getName());
        repositorySupplier.get().setPhone(supplier.getPhone());
        repositorySupplier.get().setEmail(supplier.getEmail());
        repository.save(repositorySupplier.get());
    }
}
