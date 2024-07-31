import AssemblyLine.IAssemblyLine;
import AssemblyLine.LaptopAssemblyLine;
import LineStep.CaseStep;
import LineStep.ILineStep;
import LineStep.MonitorStep;
import LineStep.MotherboardStep;
import Product.IProduct;
import Product.Laptop;

public class Main {
    public static void main(String[] args) {
        ILineStep caseStep = new CaseStep();
        ILineStep motherboardStep = new MotherboardStep();
        ILineStep monitorStep = new MonitorStep();

        IAssemblyLine assemblyLine = new LaptopAssemblyLine(caseStep, motherboardStep, monitorStep);
        IProduct laptop = new Laptop();

        assemblyLine.assembleProduct(laptop);
    }
}