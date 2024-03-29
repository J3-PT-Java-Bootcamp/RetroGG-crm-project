package crm.domain.Opportunity;

import crm.domain.Lead.Lead;

import java.util.UUID;

public class Contact {
    private UUID id;
    private String phoneNumber;
    private String name;

    public Contact(UUID id, String phoneNumber, String name) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public static Contact fromLead(Lead lead) {
        return new Contact(UUID.randomUUID(), lead.getPhoneNumber(), lead.getName());
    }

    public UUID getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
