package Product;

public class Laptop implements IProduct {
    private IProductPart casePart;
    private IProductPart motherboardPart;
    private IProductPart monitorPart;

    @Override
    public void installFirstPart(IProductPart part) {
        this.casePart = part;
        System.out.println("Корпус установлен");
    }

    @Override
    public void installSecondPart(IProductPart part) {
        this.motherboardPart = part;
        System.out.println("Материнская плата установлена");
    }

    @Override
    public void installThirdPart(IProductPart part) {
        this.monitorPart = part;
        System.out.println("Монитор установлен");
    }
}
