
package source;

import components.Question;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.QuestionModel;

public class Environtment {
    public static final String FILE_NAME = "QUESTION.txt";
    
    public static void writeQuestion(ArrayList<QuestionModel> listQuestion) {
        try {
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listQuestion);
            fos.close();
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Environtment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Environtment.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ArrayList<QuestionModel> readQuestion() {
        ArrayList<QuestionModel> list = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
            list = (ArrayList<QuestionModel>) ois.readObject();
            fis.close();
            ois.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Environtment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Environtment.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Environtment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public static void main(String[] args) {
        writeQuestion(Question.listQuestion);
    }
}
