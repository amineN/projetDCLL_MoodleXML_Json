package filecompare;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;


import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Comparateur {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Comparateur cmp=new Comparateur();
		cmp.compare("src/test/resources/fulltest.xml","src/test/resources/fulltest.xml");


	}
	public boolean compare(String filename1,String filename2){
		boolean b=false;
		String ext1;
		String ext2;



		/*on regarde l'extesnion du fichier*/
		ext1=filename1.substring(filename1.lastIndexOf('.'));
		ext2=filename2.substring(filename2.lastIndexOf('.'));
		/*si on a affaire à deux fichiers Json*/
		if(ext1.equals(".json") && ext2.equals(".json")){
			Reader reader1= null;
			Reader reader2= null;
			JSONObject o1 = null;
			JSONObject o2 = null;

			try {
				reader1 = new FileReader(filename1);
				reader2 = new FileReader(filename2);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			JSONTokener jsonT1 = new JSONTokener(reader1);
			JSONTokener jsonT2 = new JSONTokener(reader2);

			try {
				o1 = new JSONObject(jsonT1);
				o2 = new JSONObject(jsonT2);
				/*on compare les deux objets*/
				b = o1.toString().equals(o2.toString());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		/*else if(ext1.equals(".xml") && ext2.equals(".xml")){
			org.jdom2.Document doc1;
			org.jdom2.Document doc2;
			
			Element racine1;
			Element racine2;
			SAXBuilder sxb = new SAXBuilder();
			  doc1 = null;
			  doc2 = null;
			  try {
			     doc1 = sxb.build(new File(filename1));
			     doc2 = sxb.build(new File(filename2));
			  } catch (Exception e) {
			  e.printStackTrace(); //TODO gestion erreur
			  }
			 
			  racine1 = doc1.getRootElement();
			  racine2 = doc2.getRootElement();
			
		}*/
		else{
			System.out.println("cas non pris en compte");
		}
		
		
		
		return b;
	}
	







}
