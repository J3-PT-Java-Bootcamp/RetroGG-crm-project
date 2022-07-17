package crm.infrastructure.Lead;

import crm.domain.Lead.LeadRepository;
import crm.domain.Lead.Lead;

import java.util.*;

public class InMemoryLeadRepository implements LeadRepository {

    private final Map<Integer,Lead> leads;

    public InMemoryLeadRepository() {
        this.leads = new HashMap<>();
    }

    @Override
    public void save(Lead lead) {
        this.leads.put(lead.getId(), lead);
    }

    @Override
    public Optional<Lead> findById(Integer id) {
        return Optional.ofNullable(this.leads.get(id));
    }

    @Override
    public void remove(Lead lead) {
        this.leads.remove(lead.getId());
    }

    @Override
    public ArrayList<Lead> findAll() {
        return new ArrayList<>(this.leads.values());
    }

}
