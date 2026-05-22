public class TipoArvore {
    private String especie;
    private byte[] textura;
    private byte[] modelo3D;

    public TipoArvore(String especie) {
        this.especie = especie;
        
        // Simula o peso de 100 KB, mas agora isso será feito poucas vezes
        this.textura = new byte[50000]; 
        this.modelo3D = new byte[50000];
    }

    public String getEspecie() {
        return especie;
    }
}