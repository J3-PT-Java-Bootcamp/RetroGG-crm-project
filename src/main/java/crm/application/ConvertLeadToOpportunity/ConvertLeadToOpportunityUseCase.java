package crm.application.ConvertLeadToOpportunity;

import crm.domain.Account.Account;
import crm.domain.Lead.ILeadRepository;
import crm.domain.Lead.LeadNotFoundException;
import crm.domain.Opportunity.Opportunity;

public class ConvertLeadToOpportunityUseCase {

    private final ILeadRepository leadRepository;

    public ConvertLeadToOpportunityUseCase(ILeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    public void run(ConvertLeadToOpportunityPayload request) throws LeadNotFoundException {
        var lead = this.leadRepository.findById(request.leadId());
        if (lead.isEmpty()) {
            throw new LeadNotFoundException(request.leadId());
        }
        var opportunity = Opportunity.createFromLead(
                lead.get(),
                request.quantity(),
                request.productType());
        var account = Account.create(
                lead.get().getCompanyName(),
                request.companyIndustry(),
                request.numberOfEmployees(),
                request.companyCity(),
                request.companyCountry()
        );
        account.addContact(opportunity.getDecisionMaker());
        account.addOpportunity(opportunity);
        // save account
        this.leadRepository.remove(lead.get());
    }
}

