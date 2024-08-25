import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Evento {
    private List<Participante> participantes;
    private Map<String, List<String>> ganhadores;
    private String nome;
    private String data;
    private Esporte esporte;
    private int qtdParticipantes;
    protected final static int MAX_PARTICIPANTES = 10000;
    private int ouro=1;
    private int  prata=1;
    private int bronze=1;
    private int qtd_ouro, qtd_prata, qtd_bronze;

    public Evento(String nome, String data, Esporte esporte, int qtdParticipantes) {
        this.nome = nome;
        this.data = data;
        this.esporte = esporte;
        this.qtdParticipantes = 0; // Inicia com 0 participantes
        this.participantes = new ArrayList<Participante>(MAX_PARTICIPANTES);
        this.ganhadores = new HashMap<String, List<String>>(MAX_PARTICIPANTES);
    }

    public String getEventoNome() {
        return nome;
    }

    public String getData() {
        return data;
    }

    public Esporte getEsporte() {
        return esporte;
    }

    public int getQtdParticipantes() {
        return qtdParticipantes;
    }

    public List<Participante> getParticipantes() {
        return this.participantes;
    }
    public Map<String, List<String>> getGanhadores() {
        return this.ganhadores;
    }

    public void addParticipante(Participante participante) {
        if (qtdParticipantes < MAX_PARTICIPANTES) {
            if ((esporte.getTipo().equals("individual") && participante instanceof Atleta) ||
                    (esporte.getTipo().equals("equipes") && participante instanceof Equipe)) {
                this.participantes.add(participante);
                qtdParticipantes++;
            } else {
                System.out.println("Tipo de participante incompatível com o tipo de evento.");
            }
        } else {
            System.out.println("Número máximo de participantes atingido");
        }
    }

    public void calcularPontuacao() {
        for (Participante p : this.participantes) {
            if (p instanceof Equipe) {
                int pontos = 0;
                for (Atleta a : ((Equipe) p).getAtletas()) {
                    for (Map.Entry<Integer, List<Integer>> entry : a.getMedalhas().entrySet()) {
                        {
                            for (Integer medalha : entry.getValue())
                                p.addPontuacao(medalha);
                        }
                    }
                    // pontos += a.getPontuacao();
                }
                p.setPontuacao(pontos);
            }
        }
    }

    public void addMedalhas(Participante p, int pos) {
        String medalha;

        if (pos == 1) {
            medalha = "Ouro";
            this.qtd_ouro = ouro ++;
            if (!ganhadores.containsKey(medalha)) {
                ganhadores.put(medalha, new ArrayList<String>());
            }
            ganhadores.get(medalha).add(this.qtd_ouro +"º Competição" + ": " + p.getNome());

            
        } else if (pos == 2) {
            medalha = "Prata";
            this.qtd_prata = prata ++;
            if (!ganhadores.containsKey(medalha)) {
                ganhadores.put(medalha, new ArrayList<String>());
            }
            ganhadores.get(medalha).add(this.qtd_prata +"º Competição" + ": " + p.getNome());
        } else if (pos == 3) {
            medalha = "Bronze";
            this.qtd_bronze = bronze ++;
            if (!ganhadores.containsKey(medalha)) {
                ganhadores.put(medalha, new ArrayList<String>());
            }
            ganhadores.get(medalha).add(this.qtd_bronze +"º Competição" + ": " + p.getNome());
            qtd_bronze++;
        } else {
            throw new IllegalArgumentException("Posição inválida");
        }

    }

    public String mostrarResultados() {
        StringBuilder retorno = new StringBuilder();
        for (Map.Entry<String, List<String>> entry : ganhadores.entrySet()) {
            retorno.append("Ganhadores de medalhas de " + entry.getKey() + ": \n");
            for (String ganhador : entry.getValue()) {
                retorno.append("    " + ganhador + "\n");
            }
            retorno.append("\n");
        }
        return retorno.toString();
    }

    public String mostrarEvento() {
        StringBuilder retorno = new StringBuilder();
        retorno.append("Nome do evento: " + this.nome +
                ", Data: " + this.data +
                ", Tipo de evento: " + this.esporte.getTipo() +
                ", Participantes: " + this.qtdParticipantes +
                ", Nome do Esporte: " + this.esporte.getEsporteNome());
        return retorno.toString();
    }

    public String mostrarParticipantes() {
        StringBuilder retorno = new StringBuilder();
        retorno.append("Participantes no evento " + this.nome).append(": \n");
        for (Participante p : participantes) {
            retorno.append(p.mostrarCompetidor()).append("\n");
        }
        return retorno.toString();
    }
}
