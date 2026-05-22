import java.util.HashMap;
import java.util.Map;

public class FlorestaFactory {
    private static Map<String, TipoArvore> tiposCriados = new HashMap<>();

    public static TipoArvore getTipo(String especie) {
        if (!tiposCriados.containsKey(especie)) {
            tiposCriados.put(especie, new TipoArvore(especie));
        }
        return tiposCriados.get(especie);
    }
}