package crm.domain.Opportunity;

import crm.domain.Lead.Lead;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class Opportunity {
    private UUID id;
    private Contact decisionMaker;
    private int quantity;
    private ProductType productType;
    private OpportunityStatus status;

    private ArrayList<String> notes;
    private String note;

    private Opportunity() {
    }

    public Opportunity(UUID id, Contact decisionMaker, int quantity, ProductType productType, OpportunityStatus status) {
        this.id = id;
        System.out.println(id);
        this.decisionMaker = decisionMaker;
        this.quantity = quantity;
        this.productType = productType;
        this.status = status;
        this.notes = new ArrayList<String>();
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

    public void closeWon() {
        this.status = OpportunityStatus.CLOSED_WON;
    }

    public void addNote(String note) {
        this.note = note;
        this.notes.add(LocalDateTime.now().toString().substring(0, 19) + "   " + note + ",");
    }

    @Override
    public String toString() {
        return "OPPORTUNITY{" +
                "id=" + id +
                ", decisionMaker=" + decisionMaker +
                ", quantity=" + quantity +
                ", productType=" + productType +
                ", status=" + status +
                '}' + "NOTES: " + notes;
    }


}
