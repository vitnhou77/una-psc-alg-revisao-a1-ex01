import java.util.Scanner;

public class Virus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nome;
        int idade;
        int risco = 0;

        System.out.print("Informe o seu nome: ");
        nome = scanner.nextLine();

        System.out.print("Informe a sua idade: ");
        idade = scanner.nextInt();
        scanner.nextLine(); 

        String vacina = perguntarSimNao(scanner, "Seu cartão de vacina está em dia?");
        String sintomas = perguntarSimNao(scanner, "Teve algum dos sintomas recentemente?");
        String contato = perguntarSimNao(scanner, "Teve contato com pessoas com sintomas gripais nos últimos dias?");
        String viagem = perguntarSimNao(scanner, "Está retornando de viagem realizada no exterior?");

        if (vacina.equals("NAO")) risco += 10;
        if (sintomas.equals("SIM")) risco += 30;
        if (contato.equals("SIM")) risco += 30;
        if (viagem.equals("SIM")) risco += 30;
        
        String orientacao;

        if (risco <= 30) {
            if (viagem.equals("SIM")) {
                orientacao = "Você ficará sob observação por 05 dias.";
            } else {
                orientacao = "Paciente sob observação. Caso apareça algum sintoma, gentileza buscar assistência médica.";
            }
        } else if (risco <= 60) {
            orientacao = "Paciente com risco de estar infectado. Gentileza aguardar em lockdown por 02 dias para ser acompanhado.";
        } else if (risco <= 89) {
            orientacao = "Paciente com alto risco de estar infectado. Gentileza aguardar em lockdown por 05 dias para ser acompanhado.";
        } else {
            orientacao = "Paciente crítico! Gentileza aguardar em lockdown por 10 dias para ser acompanhado.";
        }

        System.out.println("\n--- RELATÓRIO FINAL ---");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Cartão de vacina em dia: " + vacina);
        System.out.println("Teve sintomas recentemente: " + sintomas);
        System.out.println("Teve contato com pessoas infectadas: " + contato);
        System.out.println("Retornando de viagem: " + viagem);
        System.out.println("Probabilidade de infecção: " + risco + "%");
        System.out.println("Orientação: " + orientacao);

        scanner.close();
    }

    public static String perguntarSimNao(Scanner scanner, String pergunta) {
        int tentativas = 0;
        while (tentativas < 3) {
            System.out.print(pergunta + " (SIM/NAO) ");
            String resposta = scanner.nextLine().trim().toUpperCase();
            if (resposta.equals("SIM") || resposta.equals("NAO")) {
                return resposta;
            }
            System.out.println("Resposta inválida, responda SIM ou NAO.");
            tentativas++;
        }

        System.out.println("Não foi possível realizar o diagnóstico.");
        System.out.println("Gentileza procurar ajuda médica caso apareça algum sintoma.");
        scanner.close();
        System.exit(0); 
        return ""; 
    }
}
