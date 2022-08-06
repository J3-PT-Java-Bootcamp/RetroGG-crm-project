package crm.application.Opportunity.CloseLostOpportunity;

import crm.application.Crm.Crm;
import crm.application.Shared.UUIDRequest;
import crm.domain.Lead.LeadNotFoundException;
import crm.domain.Opportunity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CloseLostOpportunityTest {

    Crm crm;
    CloseLostOpportunity closeLostOpportunity;
    Opportunity o1;
    Contact contact;
    UUIDRequest uuidRequest;

    @BeforeEach
    void setup() throws LeadNotFoundException {
        crm = new Crm();
        closeLostOpportunity = new CloseLostOpportunity(crm.getOpportunityRepository(), crm.getFindOpportunity());
        crm.getLeadsRepository().findAll().clear();
        o1 = new Opportunity(UUID.randomUUID(), contact, 1, ProductType.HYBRID, OpportunityStatus.OPEN);
        crm.getOpportunityRepository().save(o1);
        uuidRequest = new UUIDRequest(o1.getId(), "Test note");
    }

    @Test
    void run() throws OpportunityNotFoundException {
        closeLostOpportunity.run(uuidRequest);
        assertEquals(o1.getStatus(), OpportunityStatus.CLOSED_LOST);
    }
}