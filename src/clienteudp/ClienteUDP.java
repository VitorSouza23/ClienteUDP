/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Aluno
 */
public class ClienteUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        try {
            //Primeiro argumento é o IP do host destino
            System.out.println("Digite o ID do Servidor:");
            InetAddress addr = InetAddress.getByName(entrada.nextLine());
            System.out.println("Digite a porta do Servidor:");
            int port = Integer.parseInt(entrada.nextLine());
            System.out.println("Digite a Mensagem:");
            byte[] msg = entrada.nextLine().getBytes();
            //Monta o pacote a ser enviado
            DatagramPacket pkg = new DatagramPacket(msg, msg.length, addr, port);
            // Cria o DatagramSocket que será responsável por enviar a mensagem
            DatagramSocket ds = new DatagramSocket();
            //Envia a mensagem
            ds.send(pkg);
            System.out.println("Mensagem enviada para: " + addr.getHostAddress() + "\n"
                    + "Porta: " + port + "\n" + "Mensagem: " + new String(msg));

            //Fecha o DatagramSocket
            ds.close();
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Erro: " + ioe.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

}
