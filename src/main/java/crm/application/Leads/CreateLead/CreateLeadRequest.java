package crm.application.Leads.CreateLead;

public record CreateLeadRequest(
        String name,
        String phoneNumber,
        String email,
        String company
) {
}
