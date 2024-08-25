public class Atleta extends Participante {
    public Atleta(String nome) {
        super(nome);
    }
    
    @Override
    public String mostrarCompetidor() {
        StringBuilder retorno = new StringBuilder();
        retorno.append("    Nome do Atleta: ").append(this.getNome())
               .append(", Pontuação: ").append(this.pontuacao);
               // .append(", Medalhas: ").append(this.medalhistas).append("\n");
        return retorno.toString();
    }
}
