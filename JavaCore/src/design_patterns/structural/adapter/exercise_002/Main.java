package design_patterns.structural.adapter.exercise_002;

public class Main {
    public static void main(String[] args) {
        // 1й способ. Использование наследования
        VectorGraphicsInterface vg1 = new AdapterRasterToVector01();
        vg1.drawLine();
        vg1.drawSquare();
        System.out.println("-----");
        // 2й способ. Использование композиции
        VectorGraphicsInterface vg2 = new AdapterRasterToVector02();
        vg2.drawLine();
        vg2.drawSquare();
    }
}
