package crm.application.Leads.ConvertLeadToOpportunity;

import crm.domain.Account.Industry;
import crm.domain.Opportunity.ProductType;

public record ConvertLeadToOpportunityPayload(
        Integer leadId,
        ProductType productType,
        Integer quantity,
        Industry companyIndustry,
        Integer numberOfEmployees,
        String companyCity,
        String companyCountry
) {}
