package fractal;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class DrawingFractal extends Application {

    private double x0 = -2;
    private double y0 = 2;
    private double dx = 0.01;
    private int width;
    private int height;

    private ImageView imgView;
    private Pane pane;
    private Task<WritableImage> task = null;


    private Fractal fractal = new Mandelbrot1();
    private Palette palette = new HSBPalette();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Фракталы");

        Parent root = initInterface();
        primaryStage.setScene(new Scene(root));

        initInteraction();

        primaryStage.addEventHandler(
                KeyEvent.KEY_PRESSED,
                e -> {
                    switch (e.getCode()) {
                        case Q:
                        case W:
                            double oldDx = e.getCode() == KeyCode.W ? dx / 1.5 : dx * 1.5;
                            x0 += width * (dx - oldDx) / 2;
                            y0 -= height * (dx - oldDx) / 2;
                            dx = oldDx;
                            drawFractal();
                            break;
                        case UP:
                            y0 += dx * 50;
                            drawFractal();
                            break;
                        case DOWN:
                            y0 -= dx * 50;
                            drawFractal();
                            break;
                        case LEFT:
                            x0 -= dx * 50;
                            drawFractal();
                            break;
                        case RIGHT:
                            x0 += dx * 50;
                            drawFractal();
                            break;
                        default:
                            break;
                    }
                }
        );

        primaryStage.show();
    }

    private Parent initInterface() {
        //1) pane - сохранить как поле класса
        //2) при рисовании фрактала спрашивать размеры у pane
        //3) добавить слушателей на изменение размера pane (свойства width, height) - вызвать drawFractal
        //4) если какой-то размер 0, в методе drawFractal не надо ничего делать
        imgView = new ImageView();
        pane = new Pane(imgView);
        pane.setPrefSize(400, 400);
        return pane;
    }

    private void drawFractal() {

        if (task != null)
            task.cancel();

        width = (int) pane.getWidth();
        height = (int) pane.getHeight();

        if (width <= 0 || height <= 0)
            return;

        task = new Task<WritableImage>() {
            @Override
            protected WritableImage call() {

                WritableImage wImage = new WritableImage(width, height);
                PixelWriter pWriter = wImage.getPixelWriter();

                for (int xl = 0; xl < width; xl++) {
                    for (int yl = 0; yl < height; yl++) {
                        double x = x0 + xl * dx;
                        double y = y0 - yl * dx;
                        double colorInd = fractal.getColor(x, y);
                        Color color = palette.getColor(colorInd);
                        pWriter.setColor(xl, yl, color);
                    }
                    updateValue(copy(wImage));
                    if (isCancelled())
                        return null;
                }
                return wImage;
            }
        };

        new Thread(task).start();

        task.valueProperty().addListener(e -> imgView.setImage(task.getValue()));
        task.onSucceededProperty().addListener(e -> task = null);
    }

    private WritableImage copy(WritableImage wImage) {
        WritableImage copyWImage = new WritableImage(width, height);
        PixelReader pr = wImage.getPixelReader();
        PixelWriter pw = copyWImage.getPixelWriter();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                pw.setColor(i, j, pr.getColor(i, j));
            }
        }

        return copyWImage;
    }

    private void initInteraction() {

        pane.heightProperty().addListener(
                prop -> {
                    if (height < pane.getHeight()) {
                        height = (int) pane.getHeight();
                        drawFractal();
                    }
                }
        );

        pane.widthProperty().addListener(
                prop -> {
                    if (width < pane.getWidth()) {
                        width = (int) pane.getWidth();
                        drawFractal();
                    }
                }
        );
    }
}
