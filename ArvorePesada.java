public class ArvorePesada {
    private double x, y, z;
    private float diametro;
    private String especie;

    private byte[] textura;
    private byte[] modelo3D;

    public ArvorePesada(double x, double y, double z, float diametro, String especie) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.diametro = diametro;
        this.especie = especie;
        
        // Simula 100 KB de peso cada vez que a árvore é instanciada
        this.textura = new byte[50000]; // 50 KB
        this.modelo3D = new byte[50000]; // 50 KB
    }   
}