import java.util.ArrayList;
import java.util.List;

public class Equipe extends Participante {
    private int qtdAtletas;
    private final int MAX_ATLETAS = 12;
    private List<Atleta> atletas;
    public int pontuacao = 0;

    public Equipe(String nome) {
        super(nome);
        this.pontuacao = 0;
        this.qtdAtletas = 0;
        this.atletas = new ArrayList<Atleta>(MAX_ATLETAS);
        // medalhas = new ArrayList<Atleta>(MAX_ATLETAS);
    }

    public void addAtleta(Atleta a) {
        if (qtdAtletas < MAX_ATLETAS) {
            atletas.add(a);
            qtdAtletas++;
        } else {
            throw new IllegalArgumentException("Número máximo de atletas atingido");
        }
    }

    public int getQtdAtletas() {
        return qtdAtletas;
    }

    public List<Atleta> getAtletas() {
        return atletas;
    }

    @Override
    public String mostrarCompetidor() {
        StringBuilder retorno = new StringBuilder();
        retorno.append("Nome da Equipe: " + this.getNome() + ", Pontuação: " + this.getPontuacao() + "\n");
        for (Atleta a : this.atletas) {
            retorno.append("    Atleta: " + a.getNome() + ", Pontuação: " + a.getPontuacao() + "\n");
        }
        return retorno.toString();
    }
}
