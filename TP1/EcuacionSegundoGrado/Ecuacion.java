package EcuacionSegundoGrado;

public class Ecuacion {
    private double a;
    private double b;
    private double c;

    public Ecuacion(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Object resolver() {
        double discriminante = (this.b * this.b) - 4 * this.a * this.c;
        if (discriminante == 0) {
            return -b / (2 * a);
        }
        else if (discriminante > 0) {
            double raiz1 = (-b + Math.sqrt(discriminante)) / (2 * a);
            double raiz2 = (-b - Math.sqrt(discriminante)) / (2 * a);
            double raices[] = new double[]{raiz1, raiz2};
            return raices;
        }
        else {
            return null;
        }
    }

    public double hallarY(double x){
        return a*(x*x)+(b*x)+c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public String getEcuacion() {
        if (b>0){
            if(c>0){
                return a + "*" + a +"+"+b+"+"+c;
            }
            else{
                return a + "*" + a +"+"+b+" "+c;
            }
        }
        else{
            if(c>0){
                return a + "*" + a +" "+b+"+"+c;
            }
            else{
                return a + "*" + a +" "+b+" "+c;
            }
        }

    }
}
