package com.labanta.servidorlocal.Service;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;


    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    public void enviarEmailBoasVindas(String emailDestino, String nomeUtilizador) {

        // Criar um email simples (testo limpo) de boas vindas para um novo usuario
        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setTo(emailDestino);
        msg.setSubject("Bem Vindo ao Marketplace");
        msg.setText("Olá " + nomeUtilizador + "!\n\n" +
                "A tua conta foi criada com sucesso.Ja podes fazer login " +
                "e explorar os nossos servicos.\n\n" +
                " com os melhores cumprementos \nEquipa de Marketplace");


//Enviar!
        mailSender.send(msg);
    }

    public void enviarOrcamentoPorEmail(String emailDestino, String nomeServico, Double precoConvertido, String moeda) {

        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setTo(emailDestino);
        mensagem.setSubject("O teu Orçamento do Marketplace");

        // Criar o texto do corpo do email
        String texto = String.format(
                "Olá!\n\nAqui tens o orçamento solicitado para o serviço:\n\n" +
                        "Serviço: %s\n" +
                        "Preço Final: %.2f %s\n\n" +
                        "Este valor foi calculado com a taxa de câmbio em tempo real.\n" +
                        "Obrigado por usares o nosso Marketplace!",
                nomeServico, precoConvertido, moeda
        );

        mensagem.setText(texto);
        mailSender.send(mensagem);
    }

    public void enviarAlertaSegurança(
            String emailDestino,
            String cidade,
            String pais
    ) {

        SimpleMailMessage mensagem = new SimpleMailMessage();

        mensagem.setTo(emailDestino);
        mensagem.setSubject("Aviso de Segurança");

        mensagem.setText(
                "Aviso de Segurança: Detetámos uma nova atividade " +
                        "na tua conta do Marketplace a partir de " +
                        "cidade" + cidade  +  "pais"  + pais +
                        ". Se não foste tu, altera a tua password imediatamente!"
        );

        mailSender.send(mensagem);
    }

}

