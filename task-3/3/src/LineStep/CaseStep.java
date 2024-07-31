package LineStep;

import Product.IProductPart;
import ProductPartRealization.LaptopCase;

public class CaseStep implements ILineStep{
    public IProductPart buildProductPart(){
        return new LaptopCase();
    }
}
