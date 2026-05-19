public class Paciente {
    private String nombre;
    private int edad;
    private double peso; 
    private double altura; 

    public Paciente(String nombre, int edad, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    public double calcularIMC() {
        return peso / (altura * altura);
    }

    public String obtenerEstadoPeso() {
        double imc = calcularIMC();
        if (imc < 18.5) return "Peso bajo";
        if (imc >= 18.5 && imc <= 24.9) return "Peso normal";
        return "Sobrepeso";
    }

    public String getNombre() { 
        return nombre; 
    }
    public int getEdad() { 
        return edad; 
    }
    public double getPeso() {
        return peso; 
    }
    public double getAltura() {
        return altura; 
    }
}