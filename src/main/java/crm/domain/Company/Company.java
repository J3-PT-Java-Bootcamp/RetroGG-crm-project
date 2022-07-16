package crm.domain.Company;

import crm.domain.Opportunity.Contact;
import crm.domain.Opportunity.Opportunity;

import java.util.ArrayList;
import java.util.UUID;

public class Company {
    private UUID id;
    private Industry industry;
    private int employeeCount;
    private String city;
    private String country;
    private ArrayList<Contact> contacts;
    private ArrayList<Opportunity> opportunities;

    private Company() {}

    private Company(UUID id, Industry industry, int employeeCount, String city, String country, ArrayList<Contact> contacts, ArrayList<Opportunity> oportunities) {
        this.id = id;
        this.industry = industry;
        this.employeeCount = employeeCount;
        this.city = city;
        this.country = country;
        this.contacts = contacts;
        this.oportunities = oportunities;
    }

    public static Company create(Industry industry, int employeeCount, String city, String country) {
        return new Company(UUID.randomUUID(), industry, employeeCount, city,country, new ArrayList<Contact>(), new ArrayList<Opportunity>());
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
}
