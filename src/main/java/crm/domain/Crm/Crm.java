package crm.domain.Crm;

import crm.application.Leads.ConvertLeadToOpportunity.ConvertLeadToOpportunityPayload;
import crm.application.Leads.ConvertLeadToOpportunity.ConvertLeadToOpportunityUseCase;
import crm.application.Leads.CreateLead.CreateLeadRecord;
import crm.application.Leads.CreateLead.CreateLeadUseCase;
import crm.application.Leads.FindAll.FindAllLeads;
import crm.application.Opportunity.FindOpportunity.FindOpportunity;
import crm.application.Opportunity.FindOpportunity.FindOpportunityRequest;
import crm.domain.Opportunity.OpportunityNotFoundException;
import crm.domain.Account.AccountRepository;
import crm.domain.Account.Industry;
import crm.domain.Account.IndustryNotFoundException;
import crm.domain.Lead.LeadRepository;
import crm.domain.Lead.LeadNotFoundException;
import crm.domain.Opportunity.OpportunityRepository;
import crm.domain.Opportunity.ProductType;
import crm.domain.Opportunity.ProductTypeNotFoundException;
import crm.infrastructure.persistence.Account.InMemoryAccountRepository;
import crm.infrastructure.persistence.Lead.InMemoryLeadRepository;
import crm.infrastructure.persistence.Opportunity.InMemoryOpportunityRepository;

import java.util.Scanner;
import java.util.UUID;

public class Crm {

    private final Scanner scanner = new Scanner(System.in);

    private final CreateLeadUseCase createLeadUseCase;
    private final ConvertLeadToOpportunityUseCase convertLeadToOpportunity;
    private final FindAllLeads findAllLeads;
    private final FindOpportunity findOpportunity;

    public Crm() {
        LeadRepository leadsRepository = new InMemoryLeadRepository();
        AccountRepository accountRepository = new InMemoryAccountRepository();
        OpportunityRepository opportunityRepository = new InMemoryOpportunityRepository();
        this.createLeadUseCase = new CreateLeadUseCase(leadsRepository);
        this.convertLeadToOpportunity = new ConvertLeadToOpportunityUseCase(leadsRepository, accountRepository, opportunityRepository);
        this.findAllLeads = new FindAllLeads(leadsRepository);
        this.findOpportunity = new FindOpportunity(opportunityRepository);
    }

    public void start() {
        this.printWelcome();
        String inputCommand;
        boolean exit = false;
        do {
            this.printCommandRequest();
            inputCommand = scanner.nextLine().toLowerCase();
            Command command = Command.fromString(inputCommand);
            switch (command) {
                case CREATE_LEAD -> this.createLead();
                case SHOW_LEADS -> this.showLeads();
                case CONVERT -> this.convertLeadToOpportunity();
                case OPPORTUNITY_LOOKUP -> this.showOpportunity();
                case HELP -> this.printHelp();
                case EXIT -> exit = true;
                default -> System.out.println("Unavailable command.");
            }
        } while (!exit);
        this.printQuit();
    }

    private void printCommandRequest() {
        System.out.println("Type " + Command.HELP.getCommand() + " to show the available commands.");
        System.out.print("Command: ");
    }

    private void printWelcome() {
        System.out.println("Welcome to the CRM. You can start managing your customers.");
    }

    private void printQuit() {
        System.out.println("Saving all changes...");
        System.out.println("CRM has been shut down");
    }

    private void printHelp() {
        System.out.println("""
                Commands list
                ================================
                \tnew lead \t-\tStarts a create lead wizard.
                \tshow leads \t-\tShow all leads.
                \tconvert <<lead-id>> \t-\tIf lead with id is found, convert lead to opportunity.
                """);
    }

    public void createLead() {
        System.out.println("Lead creation wizard");
        System.out.println("========================");

        System.out.println("Name: ");
        String name = scanner.nextLine();

        System.out.println("Phone: ");
        String phone = scanner.nextLine();

        System.out.println("Email: ");
        String email = scanner.nextLine();

        System.out.println("Company: ");
        String company = scanner.nextLine();
        var request = new CreateLeadRecord(name, phone, email, company);
        this.createLeadUseCase.run(request);
        System.out.println("Lead created successfully!");
    }

    private void convertLeadToOpportunity() {
        System.out.println("Which lead do you want to convert?");
        System.out.print("ID: ");
        int leadId = scanner.nextInt();
        ProductType productType = null;
        do {
            try {
                System.out.println("Product interest?");
                for (ProductType type: ProductType.values()) {
                    System.out.printf("\t%s%n", type);
                }
                String productTypeInput = scanner.nextLine();
                productType = ProductType.fromString(productTypeInput);
            } catch (ProductTypeNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } while (productType == null);

        System.out.println("Which quantity?");
        int quantity = scanner.nextInt();

        Industry industry = null;
        do {
            try {
                System.out.println("Industry?");
                for (Industry type: Industry.values()) {
                    System.out.printf("\t%s%n", type);
                }
                String industryInput = scanner.nextLine();
                industry = Industry.fromString(industryInput);
            } catch (IndustryNotFoundException e) {
                System.out.println(e.getMessage());
            }
        } while (industry == null);

        System.out.println("Number of employees?");
        int numberOfEmployees = scanner.nextInt();

        System.out.println("City?");
        String city = scanner.nextLine();
        System.out.println("Country?");
        String country = scanner.nextLine();

        var request = new ConvertLeadToOpportunityPayload(leadId, productType, quantity, industry, numberOfEmployees, city, country);
        try {
            this.convertLeadToOpportunity.run(request);
            System.out.println("Lead converted successfully.");
        } catch (LeadNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private void showLeads() {
        var leads = this.findAllLeads.run();
        System.out.println("""
                ID - Name
                """);
        System.out.println(leads);
    }

    private void showOpportunity() {
        System.out.print("ID: ");
        String idInput = scanner.nextLine();
        UUID id = UUID.fromString(idInput);
        try {
            var opportunity = this.findOpportunity.run(new FindOpportunityRequest(id));
            System.out.println(opportunity);
        } catch (OpportunityNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
