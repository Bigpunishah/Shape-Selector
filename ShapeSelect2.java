import java.util.Scanner;
import java.text.DecimalFormat;

public class Driver {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter\n1)Two dimensional shape\n2)Three dimensional shape:");
        int num = input.nextInt();
            if(num == 1){
                System.out.print("Enter\n1)Circle\n2)Square\n3)Tirangle:");
                num = input.nextInt();
                TwoDimensionalShape tDimensionalShape = new TwoDimensionalShape();
                tDimensionalShape.getShapeInput(num);
            }
            else if(num == 2){
                System.out.print("Enter\n1)Sphere\n2)Cube\n3)Tetrahedron:");
                num = input.nextInt();
                ThreeDimensionalShape thrDimensionalShape = new ThreeDimensionalShape();
                thrDimensionalShape.getShapeInput(num);
            }
            input.close();     
    }
}

abstract class Shape{
    DecimalFormat df = new DecimalFormat(".00");
    Scanner sc = new Scanner(System.in);
    abstract public void getShapeInput(int num);
    
}

class TwoDimensionalShape extends Shape{
    public void getShapeInput(int num){
        if(num == 1){
            circle c = new circle();
            double radius;
            System.out.print("Enter radius of circle:");
            radius = sc.nextDouble();
            System.out.printf("Area: %.2f \nPerimeter: %.2f", c.getArea(radius), c.getPerimeter());


        }
        else if(num == 2){
            square s = new square();
            System.out.print("Enter side of square:");
            double side = sc.nextDouble();
            System.out.printf("Area: %.2f \nPerimeter: %.2f", s.getArea(side), s.getPerimeter());

        }
        else if(num == 3){ //! The programming lab is able to get most of whats on the line before entering a value.
            double sideA, sideB, sideC;
            System.out.print("Enter side of trinalge:");
                sideA = sc.nextDouble();                
            System.out.print("Enter side of trinalge:");
                sideB = sc.nextDouble();
            System.out.print("Enter side of trinalge:");
                sideC = sc.nextDouble();
            triangle t = new triangle();
            System.out.printf("Area: %.2f \nPerimeter: %.2f", t.getArea(sideA, sideB, sideC), t.getPerimeter());
        }
    }
}

class circle extends TwoDimensionalShape{
    private double radius, area, perimeter;
    public double getArea(double radius){
        this.radius = radius;
        area = (radius * radius) * Math.PI;
        return area;
    }
    public double getPerimeter(){
        perimeter = (2 * Math.PI) * radius;
        return perimeter;
    }
    

}

class square extends TwoDimensionalShape{
    private double side, area, perimeter;
    public double getArea(double side){
        this.side = side;
        area = (side * side);
        return area;
    }
    
    public double getPerimeter(){
        perimeter = (side * 4);
        return perimeter;
    }

}

class triangle extends TwoDimensionalShape{
    private double sideA, sideB, sideC, area, perimeter, semiPerimeter;
    public double getArea(double a, double b, double c){
        sideA = a;
        sideB = b;
        sideC = c;
        semiPerimeter = (sideA + sideB + sideC)/(2);
        area = Math.sqrt(semiPerimeter * (semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC));
        return area;
    }

public double getPerimeter(){
    perimeter = sideA + sideB + sideC;
    return perimeter;
}

}



class ThreeDimensionalShape extends Shape{
    public void getShapeInput(int num){
        if(num == 1){
            System.out.print("Enter radius of sphere:");
            double radius = sc.nextDouble();
            sphere s = new sphere();
            System.out.printf("Surface area: %.2f \nVolume: %.2f", s.getSurfaceArea(radius), s.getVolume());
        }
        else if(num == 2){
            System.out.print("Enter side of cube:");
            double side = sc.nextDouble();
            cube c = new cube();
            System.out.printf("Surface area: %.2f \nVolume: %.2f", c.getSurfaceArea(side), c.getVolume());

        }
        else if(num == 3){
            System.out.print("Enter side of tetrahedron:");
            double side = sc.nextDouble();
            tetrahedron t = new tetrahedron();
            System.out.printf("Surface area: %.2f \nVolume: %.2f", t.getSurfaceArea(side), t.getVolume());


        }
    }

}

class sphere extends ThreeDimensionalShape{
    private double radius, surfaceArea, volumne;
    public double getSurfaceArea(double radius){
        this.radius = radius;
        surfaceArea = (4 * Math.PI) * ( Math.pow(radius, 2));
        return surfaceArea;
    }
    public double getVolume(){
        volumne = (1.333333333) * (Math.PI * Math.pow(radius, 3 ));
        return volumne;
    }
}

class cube extends ThreeDimensionalShape{
    private double side, surfaceArea, volumne;
    public double getSurfaceArea(double side){
        this.side = side;
        surfaceArea =  (6 * Math.pow(side, 2));
        return surfaceArea;
    }

    public double getVolume(){
        volumne = Math.pow(side, 3);
        return volumne;
    }
}

class tetrahedron extends ThreeDimensionalShape{
    private double surfaceArea, side, volumne;
    public double getSurfaceArea(double side){
        this.side = side;
        surfaceArea = (Math.sqrt(3)) * (Math.pow(side, 2));
        return surfaceArea;
    }

    public double getVolume(){
        volumne = (Math.pow(side, 3)) / (6 * Math.sqrt(2));
        return volumne;
    }
}