package crm.domain.Opportunity;

import java.util.UUID;

public class Opportunity {
    private UUID id;
    private Contact decisionMaker;
    private int quantity;
    private ProductType productType;
    private OpportunityStatus status;

    private Opportunity() {}

    public Opportunity(UUID id, Contact decisionMaker, int quantity, ProductType productType, OpportunityStatus status) {
        this.decisionMaker = decisionMaker;
        this.quantity = quantity;
        this.productType = productType;
        this.status = status;
    }

    public static Opportunity createFromLead(Contact decisionMaker, int quantity, ProductType productType) {
        return new Opportunity(UUID.randomUUID(), decisionMaker, quantity, productType, OpportunityStatus.OPEN);
    }

}
