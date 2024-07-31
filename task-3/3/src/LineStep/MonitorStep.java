package LineStep;

import Product.IProductPart;
import ProductPartRealization.Monitor;

public class MonitorStep implements ILineStep {
    @Override
    public IProductPart buildProductPart() {
        return new Monitor();
    }
}
