package view;

import controller.RedesController;
import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		RedesController rCont = new RedesController();
		int opc = 0;
		
		while(opc != 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("\t Menu Processos\n\n1- Verificar Ipv4\n2- Verificar Ping\n9- Finalizar Programa" ));
			switch(opc) {
			case 1:
				rCont.ip();
				break;
			
			case 2:
				rCont.ping();
				break;
			
			case 9:
				JOptionPane.showMessageDialog(null,"Programa Finalizado");
				System.exit(0);
			
			default:
				JOptionPane.showMessageDialog(null, "Opção Inválida");
			}
		}
	}

}
