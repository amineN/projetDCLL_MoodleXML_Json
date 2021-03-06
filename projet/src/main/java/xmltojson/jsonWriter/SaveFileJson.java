package xmltojson.jsonWriter;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 * @author nawal
 */
public class SaveFileJson {    
    final String jsonContent; 
    final  String pathFile;
    /**
     * @param contenu : le contenu du fichier Json 
     * @param pathFile : le Chemin du fichier en sortie.
     */
    public SaveFileJson(String contenu, String pathFile){
        this.jsonContent = contenu;
        this.pathFile = pathFile;
    }
    /**
     * cette méthode permet la sauvegarde physique d'un fichier 
     */
    public void sauvegarde (){                
        File file = new File(this.pathFile);
        try {
            if (!file.exists())
                file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write(this.jsonContent);
            writer.flush();
            writer.close();            
        } catch (IOException e) {
            System.out.println("Erreur: impossible de créer le fichier '"+ pathFile + "'");
        }
    }

}
