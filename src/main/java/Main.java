import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Esporte atletismo_equipes = new Esporte("equipes", "Atletismo");
        Evento atletismo = new Evento("Atletismo Moderno", "2024-06-01", atletismo_equipes, 4);
        Equipe equipe1 = new Equipe("Brasil");
        Atleta atleta1 = new Atleta("Ligeirinho");
        Atleta atleta2 = new Atleta("Flash");
        equipe1.addAtleta(atleta1);
        equipe1.addAtleta(atleta2);
        Equipe equipe2 = new Equipe("Argentina");
        Atleta atleta3 = new Atleta("Relampago Marquinhos");
        Atleta atleta4 = new Atleta("Bolt");
        equipe2.addAtleta(atleta3);
        equipe2.addAtleta(atleta4);
        Equipe equipe3 = new Equipe("França");
        Atleta atleta5 = new Atleta("Moreno");
        Atleta atleta6 = new Atleta("Coelinho Parrudo");
        equipe3.addAtleta(atleta5);
        equipe3.addAtleta(atleta6);

        Equipe equipe4 = new Equipe("Italia");
        Atleta atleta7 = new Atleta("Mario Net");
        Atleta atleta8 = new Atleta("Rei da F1");
        equipe4.addAtleta(atleta7);
        equipe4.addAtleta(atleta8);
        // Adicionando participantes aos evento
        atletismo.addParticipante(equipe1);
        atletismo.addParticipante(equipe2);
        atletismo.addParticipante(equipe3);
        atletismo.addParticipante(equipe4);

        // adicionando desempenho dos atletas
        atleta1.addPontuacao(10);
        atleta3.addPontuacao(8);
        atleta6.addPontuacao(6);
        atleta2.addPontuacao(10);
        atleta2.addPontuacao(10);
        atleta4.addPontuacao(8);
        atleta8.addPontuacao(6);
        // calcula a pontuação do desempenho de cada equipe por competidor
        atletismo.calcularPontuacao(); // Calcula o total de pontos por equipes
        // adicionando resultado dos eventos, evitando que mais de um tipo de medalha
        // pertenca ao mesmo evento
        for (Participante equipe : atletismo.getParticipantes()) {
            for (Map.Entry<Integer, List<Integer>> entry : equipe.getMedalhas().entrySet()) {
                for (int pontuacao : entry.getValue()) {
                    int pos = entry.getKey();
                    atletismo.addMedalhas(equipe, pos);
                }
            }
        }
        System.out.println(atletismo.mostrarEvento());
        System.out.println(atletismo.mostrarParticipantes());
        System.out.println(atletismo.mostrarResultados());
        // System.out.println(atletismo.getMedalhas());

        Esporte tenis = new Esporte("individual", "Tenis");
        Evento grandSlam = new Evento("Grand Slam", "2024-06-15", tenis, 32);
        Atleta a1 = new Atleta("Rafael Nadal");
        Atleta a2 = new Atleta("Gustavo Kuerten");
        Atleta a3 = new Atleta("Djokovic");
        Atleta a4 = new Atleta("Gustavo Neves");
        a2.addPontuacao(10);
        a2.addPontuacao(10);
        a4.addPontuacao(8);
        a2.addPontuacao(10);
        grandSlam.addParticipante(a1);
        grandSlam.addParticipante(a2);
        grandSlam.addParticipante(a3);
        grandSlam.addParticipante(a4);
        grandSlam.calcularPontuacao(); // Calcula o total de pontos por equipes
        // adicionando resultado dos eventos, evitando que ocorra erro de pontuação
        for (Participante atleta : grandSlam.getParticipantes()) {
            for (Map.Entry<Integer, List<Integer>> entry : atleta.getMedalhas().entrySet()) {
                for (int pontuacao : entry.getValue()) {
                    int pos = entry.getKey();
                    grandSlam.addMedalhas(atleta, pos);
                }
            }
        }
        // System.out.println(grandSlam.getGanhadores());
        System.out.println(grandSlam.mostrarEvento());
        System.out.println(grandSlam.mostrarParticipantes());
        System.out.println(grandSlam.mostrarResultados());

    }
}
