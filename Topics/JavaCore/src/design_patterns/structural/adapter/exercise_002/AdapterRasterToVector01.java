package design_patterns.structural.adapter.exercise_002;

public class AdapterRasterToVector01 extends RasterGraphics implements VectorGraphicsInterface {

    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}
