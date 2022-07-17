package crm.domain.Crm;

import crm.application.ConvertLeadToOpportunity.ConvertLeadToOpportunityPayload;
import crm.application.ConvertLeadToOpportunity.ConvertLeadToOpportunityUseCase;
import crm.application.CreateLead.CreateLeadRecord;
import crm.application.CreateLead.CreateLeadUseCase;
import crm.domain.Account.AccountRepository;
import crm.domain.Account.Industry;
import crm.domain.Account.IndustryNotFoundException;
import crm.domain.Lead.LeadRepository;
import crm.domain.Lead.LeadNotFoundException;
import crm.domain.Opportunity.ProductType;
import crm.domain.Opportunity.ProductTypeNotFoundException;
import crm.infrastructure.Lead.InMemoryAccountRepository;
import crm.infrastructure.Lead.InMemoryLeadRepository;

import java.util.Scanner;

public class Crm {

    private final Scanner scanner = new Scanner(System.in);

    private final CreateLeadUseCase createLeadUseCase;
    private final ConvertLeadToOpportunityUseCase convertLeadToOpportunity;

    public Crm() {
        LeadRepository leadsRepository = new InMemoryLeadRepository();
        AccountRepository accountRepository = new InMemoryAccountRepository();
        this.createLeadUseCase = new CreateLeadUseCase(leadsRepository);
        this.convertLeadToOpportunity = new ConvertLeadToOpportunityUseCase(leadsRepository, accountRepository);
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
                case CONVERT -> this.convertLeadToOpportunity();
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

}
