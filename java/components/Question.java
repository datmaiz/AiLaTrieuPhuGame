
package components;

import java.util.ArrayList;
import model.QuestionModel;
import source.Environtment;

public class Question {
    public static ArrayList<QuestionModel> listQuestion = Environtment.readQuestion();

    public Question() {
    }
    public static void main(String[] args) {
        
    }
    
}
