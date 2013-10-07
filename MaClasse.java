import java.io.*;
import java.util.*;
import java.awt.*; 
import java.lang.*;
import java.applet.*; 



public class MaClasse {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		//
		
		
		// -------- Creation d une table de comptage -------------------
		int luminosite[] = new int[256];
		int n=0;
		
		// Initialisation de lumoosite
		for (n=0; n<luminosite.length; n++){
			luminosite[n]=0;
		}
		
			
		// --------------------- Lecture fichier ----------------------
		Scanner scanner = new Scanner(new FileReader("lena.pgm"));
		
		
		int i=0; // compteur permettant de marquer le terme traite dans le fichier pgm						
		String str = null;
		Integer mot = new Integer(0) ;
		
		while (scanner.hasNext()) {
			i=i+1;
		    String test=scanner.next();
			
			// on ne traite pas les quatre premiers termes du fichier pgm (	P2, #, 512, 512, 255)		
		    if (i>5){
		    	mot = Integer.parseInt(test); // conversion du String en int
		    	
		    	luminosite[mot]=luminosite[mot]+1;
			}
		    
		  }  
		
		//-------- Ecriture des valeurs obtenues dans un  fichier txt
		Writer writer = new FileWriter("Nombre de pixels ayant une luminosite donnee.txt");
		
		int g=0;
		int somme=0;
		for(g=0; g<256; g++){
			writer.write(" Nombre de pixels ayant une luminosite "+ g+ " : "+ luminosite[g]+ "\n");
			writer.flush();
			somme=somme+luminosite[g];
			
		    
		}
		writer.close();  
		
		// on verrifie bien que la somme fait la totalite du nombre de pixel de l'image initial, c est a dire -> 512*512=262144
		System.out.println(" Au total, nous avons "+somme+ " pixels");
		}
}
