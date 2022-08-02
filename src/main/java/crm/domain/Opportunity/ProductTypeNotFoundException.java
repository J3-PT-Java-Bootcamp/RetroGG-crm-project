package crm.domain.Opportunity;

public class ProductTypeNotFoundException extends Exception {
    public ProductTypeNotFoundException(String productType) {
        super(String.format("Product type %s not valid.", productType));
    }
}
