package crm.domain.Opportunity;

import crm.domain.Crm.Command;

public enum ProductType {
    HYBRID("hybrid"),
    FLATBED("flatbed"),
    BOX("box");

    private final String productType;

    public String getProductType()
    {
        return this.productType;
    }

    private ProductType(String productType)
    {
        this.productType= productType;
    }

    public static ProductType fromString(String text) throws ProductTypeNotFoundException {
        for (ProductType b : ProductType.values()) {
            if (b.productType.equalsIgnoreCase(text)) {
                return b;
            }
        }
        throw new ProductTypeNotFoundException(text);
    }
}
