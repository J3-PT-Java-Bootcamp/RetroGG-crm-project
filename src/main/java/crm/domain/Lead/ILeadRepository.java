package crm.domain.Lead;

import java.util.Optional;
import java.util.UUID;

public interface ILeadRepository {
    void save(Lead lead);
    Optional<Lead> findById(Integer id);
}
