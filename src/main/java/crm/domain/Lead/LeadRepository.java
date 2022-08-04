package crm.domain.Lead;

import java.util.ArrayList;
import java.util.Optional;

public interface LeadRepository {

    void save(Lead lead);
    void remove(Lead lead);

    Optional<Lead> findById(Integer id);
    ArrayList<Lead> findAll();
}
