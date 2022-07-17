package crm.application.CreateLead;

import crm.domain.Lead.LeadRepository;
import crm.domain.Lead.Lead;

public final class CreateLeadUseCase {

    private final LeadRepository leadRepository;
    public CreateLeadUseCase(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    public void run(CreateLeadRecord request) {
        var lead = new Lead(request.name(), request.phoneNumber(), request.email(), request.company());
        this.leadRepository.save(lead);
    }
}