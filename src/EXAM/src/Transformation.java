import TurtleGraphics.Pen;
import TurtleGraphics.StandardPen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Transformation {
    public static void main(String[] args) {
        //task 1

        String s = "F";
        int times = 10;
        StringTransformer transformer = a -> a.replace("F", "F+F--F+F");
        System.out.println(transformer.transform(s, times));

        Path path = Path.of("./transformer.txt");
        try {
            Files.writeString(path, transformer.transform("F", times));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //task 2
        String rect = "<rect x=\"0\" y=\"0\" height=\"100\" width=\"100\" style=\"stroke: red; fill: #yellow\" />";

//        StringTransformer transformer1 = b -> {
//            StringBuffer buff =new StringBuffer();
//        }

        //task 3
        Pen turtle = new StandardPen();

        turtle.move(0);
        turtle.turn(-90);
        turtle.up();
        turtle.down();

        try {
            String readFile = Files.readString(path);
//            int r = readFile.length();
            for (int i = 0; i < readFile.length(); i++) {
                Character c = readFile.charAt(i);
                if (c == 'F')
                    turtle.move(0.005);
                if (c == '-')
                    turtle.turn(-60);
                if (c == '+')
                    turtle.turn(60);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}