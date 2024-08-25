public class Esporte {
    private String tipo;
    private String esporteNome;
    private Evento[] eventos;
    private int qtdEventos;
    private final static int MAX_EVENTOS = 10000;

    public Esporte(String tipo, String esporteNome) {
        if (tipo.equals("individual") || tipo.equals("equipes")) {
            this.tipo = tipo;
        } else {
            throw new IllegalArgumentException("Tipo de evento inválido");
        }
        this.eventos = new Evento[MAX_EVENTOS];
        this.esporteNome = esporteNome;
        this.qtdEventos = 0;
    }

    public void addEvento(Evento e) {
        if (qtdEventos < MAX_EVENTOS) {
            this.eventos[this.qtdEventos] = e;
            this.qtdEventos++;
        } else {
            System.out.println("Número máximo de eventos atingido");
        }
    }

    public String getTipo() {
        return this.tipo;
    }

    public String getEsporteNome() {
        return esporteNome;
    }

    public int getQtdEventos() {
        return qtdEventos;
    }

    public Evento[] getEventos() {
        return eventos;
    }
    
    public String competicoes() {
        StringBuilder retorno = new StringBuilder();
        for (int i = 0; i < this.qtdEventos; i++) {
            Evento evento = this.eventos[i];
            retorno.append("Evento: ").append(evento.getEventoNome())
                   .append(" - Data: ").append(evento.getData())
                   .append(" - Tipo: ").append(evento.getEsporte().getTipo())
                   .append(" Nº de Participantes: ").append(evento.getQtdParticipantes())
                   .append("\n");
        }
        return retorno.toString();
    }
}
