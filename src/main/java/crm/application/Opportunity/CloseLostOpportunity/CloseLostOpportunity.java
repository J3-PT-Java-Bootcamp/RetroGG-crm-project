package crm.application.Opportunity.CloseLostOpportunity;

import crm.application.Opportunity.FindOpportunity.FindOpportunity;
import crm.application.Shared.UUIDRequest;
import crm.domain.Opportunity.OpportunityNotFoundException;
import crm.domain.Opportunity.OpportunityRepository;

public final class CloseLostOpportunity {

    private final OpportunityRepository opportunityRepository;
    private final FindOpportunity findOpportunity;

    public CloseLostOpportunity(OpportunityRepository opportunityRepository, FindOpportunity findOpportunity) {
        this.opportunityRepository = opportunityRepository;
        this.findOpportunity = findOpportunity;
    }

    public void run(UUIDRequest request) throws OpportunityNotFoundException {
        var opportunity = this.findOpportunity.run(request.id());
        opportunity.closeLost();
        opportunity.addNote(request.note());
        this.opportunityRepository.save(opportunity);
    }
}
