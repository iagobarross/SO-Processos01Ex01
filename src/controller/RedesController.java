/*EXERCÍCIO 1:
Criar em Eclipse, um novo Java Project com uma classe chamada RedesController.java no
package controller e uma classe Main.java no package view.
A classe RedesController.java deve ter 3 métodos.
1) O primeiro, chamado os, que identifica e retorna o nome do Sistema Operacional (Fazê-lo
privado)
2) O segundo, chamado ip, que verifica o Sistema Operacional e, de acordo com o S.O., faz a
chamada de configuração de IP.
A leitura do processo chamado deve verificar cada linha e, imprimir, apenas, o nome do
adaptador de rede e o IPv4, portanto, adaptadores sem IPv4 não devem ser mostrados
3) O terceiro, chamado ping, que verifica o Sistema Operacional e, de acordo com o S.O. e, faz a
chamada de ping em IPv4 com 10 iterações.
A leitura do processo chamado deve verificar as linhas de saída e exibir, apenas, o tempo médio
do ping. O teste de ping deve ser feito com a URL www.google.com.br
A Classe Main.java deve dar as opções de chamadas do método ip ou do método ping com
JOptionPane e, dependendo da escolha, instanciar a Classe RedesController.java e chamar o
método escolhido. A opção de finalizar a aplicação também deve estar disponível.*/
package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	public RedesController() {
		super();
	}

	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}

	@SuppressWarnings("deprecation")
	public void ip() {
		String os = os();
		if (os.contains("Windows")) {
			String ip = "IPCONFIG";
			try {
				Process p = Runtime.getRuntime().exec(ip);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();

				while (linha != null) {
					if (linha.contains("IPv4")) {
						System.out.println(linha);
						linha = buffer.readLine();
					} else {
						linha = buffer.readLine();
					}
				}

			} catch (Exception e) {
				String msg = e.getMessage();
				System.err.println(msg);
			}
		} else if (os.contains("Linux")) {
			String ip = "ipp addr";
			try {
				Process p = Runtime.getRuntime().exec(ip);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();

				while (linha != null) {
					if (linha.contains("inet")) {
						System.out.println(linha);
						linha = buffer.readLine();
					} else {
						linha = buffer.readLine();
					}
				}

			} catch (Exception e) {
				String msg = e.getMessage();
				System.err.println(msg);
			}
		}

	}

	public void ping() {
		String os = os();
		if (os.contains("Windows")) {
			String ping = "ping -4 -n 10 www.google.com.br";
			try {
				Process p = Runtime.getRuntime().exec(ping);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();

				while (linha != null) {

					if (linha.contains("tempo=")) {
						String[] tempo = linha.split("=");
						tempo = tempo[2].split(" ");
						System.out.println("Ping = " + tempo[0]);
						linha = buffer.readLine();
					} else {
						linha = buffer.readLine();
					}

				}
				buffer.close();
				leitor.close();
				fluxo.close();

			} catch (Exception e) {
				String msg = e.getMessage();
				System.err.println(msg);
			}
		} else if (os.contains("Linux")) {
			String ping = "ping -4 -c 10 www.google.com.br";
			try {
				Process p = Runtime.getRuntime().exec(ping);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();

				while (linha != null) {

					if (linha.contains("time=")) {
						String[] tempo = linha.split("=");
						System.out.println("Ping = " + tempo[3]);
						linha = buffer.readLine();
					} else {
						linha = buffer.readLine();
					}

				}
				buffer.close();
				leitor.close();
				fluxo.close();

			} catch (Exception e) {
				String msg = e.getMessage();
				System.err.println(msg);
			}
		}
	}
}
