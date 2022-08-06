package crm.domain.Account;

import crm.domain.Opportunity.Contact;
import crm.domain.Opportunity.Opportunity;

import java.util.ArrayList;
import java.util.UUID;

public class Account {
    private UUID id;
    private String name;
    private Industry industry;
    private int employeeCount;
    private String city;
    private String country;
    private ArrayList<Contact> contacts;
    private ArrayList<Opportunity> opportunities;

    private Account() {
    }

    private Account(UUID id, String name, Industry industry, int employeeCount, String city, String country, ArrayList<Contact> contacts, ArrayList<Opportunity> oportunities) {
        this.id = id;
        this.name = name;
        this.industry = industry;
        this.employeeCount = employeeCount;
        this.city = city;
        this.country = country;
        this.contacts = contacts;
        this.opportunities = oportunities;
    }

    public static Account create(String name, Industry industry, int employeeCount, String city, String country) {
        return new Account(UUID.randomUUID(), name, industry, employeeCount, city, country, new ArrayList<Contact>(), new ArrayList<Opportunity>());
    }

    public UUID getId() {
        return id;
    }

    public Industry getIndustry() {
        return industry;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }

    public void addOpportunity(Opportunity opportunity) {
        this.opportunities.add(opportunity);
    }
}
