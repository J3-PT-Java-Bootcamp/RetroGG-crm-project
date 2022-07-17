package crm.domain.Opportunity;

import crm.domain.Lead.Lead;

import java.util.UUID;

public class Opportunity {
    private UUID id;
    private Contact decisionMaker;
    private int quantity;
    private ProductType productType;
    private OpportunityStatus status;

    private Opportunity() {
    }

    private Opportunity(UUID id, Contact decisionMaker, int quantity, ProductType productType, OpportunityStatus status) {
        this.id = id;
        System.out.println(this.id);
        this.decisionMaker = decisionMaker;
        this.quantity = quantity;
        this.productType = productType;
        this.status = status;
    }

    public static Opportunity createFromLead(Lead lead, int quantity, ProductType productType) {
        var decisionMaker = Contact.fromLead(lead);
        return new Opportunity(UUID.randomUUID(), decisionMaker, quantity, productType, OpportunityStatus.OPEN);
    }

    public UUID getId() {
        return id;
    }

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public int getQuantity() {
        return quantity;
    }

    public ProductType getProductType() {
        return productType;
    }

    public OpportunityStatus getStatus() {
        return status;
    }

    public void closeLost() {
        this.status = OpportunityStatus.CLOSED_LOST;
    }
    @Override
    public String toString() {
        return "Opportunity{" +
                "id=" + id +
                ", decisionMaker=" + decisionMaker +
                ", quantity=" + quantity +
                ", productType=" + productType +
                ", status=" + status +
                '}';
    }
}
