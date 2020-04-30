package design_patterns.structural.adapter.exercise_002;

public class AdapterRasterToVector02 implements VectorGraphicsInterface {
    RasterGraphics rg = new RasterGraphics();

    @Override
    public void drawLine() {
        rg.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        rg.drawRasterSquare();
    }
}
