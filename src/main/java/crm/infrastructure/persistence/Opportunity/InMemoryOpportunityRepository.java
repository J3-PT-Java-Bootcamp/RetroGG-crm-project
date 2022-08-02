package crm.infrastructure.persistence.Opportunity;

import crm.domain.Opportunity.Opportunity;
import crm.domain.Opportunity.OpportunityRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class InMemoryOpportunityRepository implements OpportunityRepository {

    private final Map<UUID, Opportunity> opportunities;

    public InMemoryOpportunityRepository() {
        this.opportunities = new HashMap<>();
    }

    @Override
    public void save(Opportunity opportunity) {
        this.opportunities.put(opportunity.getId(), opportunity);
    }

    @Override
    public Optional<Opportunity> findById(UUID id) {
        return Optional.ofNullable(this.opportunities.get(id));
    }
}
