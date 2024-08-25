import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Hashtable;

public abstract class Participante {
    public Map<Integer, List<Integer>> medalhas;
    protected String nome;
    protected int pontuacao;
    private static final int MAX_MEDALHAS = 3;

    public Participante(String nome) {
        this.nome = nome;
        this.medalhas = new Hashtable<Integer, List<Integer>>(MAX_MEDALHAS);
    }

    public String getNome() {
        return nome;
    }

    public int getPontuacao() {
        return this.pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao += pontuacao;
    }

    public Map<Integer, List<Integer>> getMedalhas() {
        return medalhas;
    }
    public void addPontuacao(int pontuacao) {
        int tipoMedalha;

        if (pontuacao == 6) {
            tipoMedalha = 3;  // Bronze
        } else if (pontuacao == 8) {
            tipoMedalha = 2;  // Prata
        } else if (pontuacao == 10) {
            tipoMedalha = 1;  // Ouro
        } else {
            throw new IllegalArgumentException("Pontuação inválida para essa competição");
        }

        // Inicializa a lista se ela ainda não existir
        if (!medalhas.containsKey(tipoMedalha)) {
            medalhas.put(tipoMedalha, new ArrayList<Integer>(MAX_MEDALHAS));
        }
        // Adiciona a pontuação na lista correta
        medalhas.get(tipoMedalha).add(pontuacao);

        // Atualiza a pontuação total do participante
        this.pontuacao += pontuacao;
    }


    public abstract String mostrarCompetidor();
}
