public class Arvore {
    private double x, y, z;
    private float diametro;

    private TipoArvore tipo;

    public Arvore(double x, double y, double z, float diametro, TipoArvore tipo) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.diametro = diametro;
        this.tipo = tipo;
    }
}