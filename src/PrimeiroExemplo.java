import javax.swing.JOptionPane;

public class PrimeiroExemplo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1 - gerar numero randomico entre 1 e 10
		//2 - nesse numero pega as 10 primeiras letras e avançar as casas
		//3 - gera um segundo numero entre 11 e 15
		//4 - pego as letras subsequentes a décima letra e avanço o número de casas
		
		int randomUm = (int)(Math.random()*10);
		randomUm++;
		
		int randomDois = (int)(Math.random()*5);
		randomUm+=11;
		
		String dado = JOptionPane.showInputDialog("Digite algo: ");
		StringBuffer dadoCriptografado = new StringBuffer();
		
		dadoCriptografado.append((char)(65+randomUm));
		
		for(int i = 0; i < Math.min(10, dado.length()); i++){
			char c = dado.charAt(i);
			c += randomUm;
			dadoCriptografado.append(c);
		}
		
		if (dado.length() > 10){
			dadoCriptografado.append((char)(65+randomDois));
			for(int i = 10; i < dado.length(); i++){
				char c = dado.charAt(i);
				c += randomDois;
				dadoCriptografado.append(c);
			}
		}
		
		///////processo de descriptografia
		
		int rUm = dadoCriptografado.charAt(0) - 65;
		StringBuffer dadoDescriptografado = new StringBuffer();
		for(int i = 1; i < Math.min(10, dadoCriptografado.length()); i++){
			char c = dadoCriptografado.charAt(i);
			c -= rUm;
			dadoDescriptografado.append(c);			
		}
		
		if(dadoCriptografado.length() >12){
			int rDois = dadoCriptografado.charAt(11) - 65;
			for(int i = 12; i < dadoCriptografado.length(); i++){
				char c = dadoCriptografado.charAt(i);
				c -= rDois;
				dadoDescriptografado.append(c);			
			}
		}
		
		JOptionPane.showMessageDialog(null, "Criptografado: " + dadoCriptografado.toString());
		JOptionPane.showMessageDialog(null, "Descriptografado: " + dadoDescriptografado.toString());
	}
}
