package crm.domain.Lead;

import java.util.Optional;

public interface LeadRepository {
    void save(Lead lead);
    Optional<Lead> findById(Integer id);
    void remove(Lead lead);
}
