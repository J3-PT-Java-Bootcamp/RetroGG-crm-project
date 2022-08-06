package crm.domain.Opportunity;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface OpportunityRepository {
    void save(Opportunity opportunity);

    Optional<Opportunity> findById(UUID id);

    Map<UUID, Opportunity> getOpportunities();
}
