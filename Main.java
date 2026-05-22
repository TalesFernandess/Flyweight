public class Main {
    public static void main(String[] args) {
        int quantidadeDeArvores = 10000; 
        
        System.out.println("Iniciando simulação com " + quantidadeDeArvores + " árvores...\n");

        System.out.println("Teste sem o padrão Flyweight:");
        limparMemoria();
        long memoriaAntesRuim = medirMemoria();

        ArvorePesada[] florestaPesada = new ArvorePesada[quantidadeDeArvores];
        
        for (int i = 0; i < quantidadeDeArvores; i++) {
            // Cria os dados pesados todas as 10.000 vezes
            florestaPesada[i] = new ArvorePesada(1.0, 2.0, 3.0, 10.5f, "Castanheira");
        }
        
        long memoriaDepoisRuim = medirMemoria();
        long consumoRuim = memoriaDepoisRuim - memoriaAntesRuim;
        System.out.println("Memória consumida: " + formatarEmMB(consumoRuim) + " MB\n");

        System.out.println("2. Teste com o padrão Flyweight:");
        
        florestaPesada = null; 
        limparMemoria();
        
        long memoriaAntesBoa = medirMemoria();
        
        Arvore[] florestaOtimizada = new Arvore[quantidadeDeArvores];
        
        for (int i = 0; i < quantidadeDeArvores; i++) {
            TipoArvore tipo = FlorestaFactory.getTipo("Castanheira");
            florestaOtimizada[i] = new Arvore(1.0, 2.0, 3.0, 10.5f, tipo);
        }
        
        long memoriaDepoisBoa = medirMemoria();
        long consumoBom = memoriaDepoisBoa - memoriaAntesBoa;
        System.out.println("Memória consumida: " + formatarEmMB(consumoBom) + " MB");
    }


    private static void limparMemoria() {
        System.gc();
        try {
            Thread.sleep(500); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Calcula o uso atual da memória
    private static long medirMemoria() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

    private static long formatarEmMB(long bytes) {
        return bytes / (1024 * 1024);
    }
}
