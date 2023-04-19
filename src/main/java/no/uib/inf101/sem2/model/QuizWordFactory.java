package no.uib.inf101.sem2.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;


public class QuizWordFactory {
    
//String[] quizWords;
QuizWord[] level1 = {
        new QuizWord("Få hugilt","bli ille til mote", Color.RED),
        new QuizWord("Kome or vona", "miste håpet", Color.BLUE),
        new QuizWord("Rettferdsvederlag", "Billighetserstatning", Color.RED),
        new QuizWord("Kome på rakedeisen", "Komme på avveie", Color.BLUE),
        new QuizWord("Vørdsamt", "Ærbødigst", Color.RED),
        new QuizWord("Åtgjerd", "Tiltak", Color.BLUE),
        new QuizWord("Vørdsle", "I orden", Color.RED),
        new QuizWord("Hugleik", "Fantasi", Color.RED),
        new QuizWord("Hovmod", "Arroganse", Color.BLUE)
};

QuizWord[] level2 = {
    new QuizWord("Korkje","Verken", Color.RED),
    new QuizWord("Reiarlag", "Rederi", Color.BLUE),
    new QuizWord("Hopehav", "Fellesskap", Color.RED),
    new QuizWord("Eigenfråsegn", "Egenerklæring", Color.BLUE),
    new QuizWord("Røyndom", "Virkelighet", Color.RED),
    new QuizWord("Semje", "Enighet", Color.BLUE),
    new QuizWord("Framifrå", "Fremragende", Color.RED),
    new QuizWord("Samrøystes", "Enstemmig", Color.RED),
    new QuizWord("Omsutsfull", "Omsorgsfull", Color.BLUE)
};

QuizWord[] level3 = {
    new QuizWord("Forkava","Stresset", Color.RED),
    new QuizWord("Teieplikt", "Taushetsplikt", Color.BLUE),
    new QuizWord("Høve", "Anledning", Color.RED),
    new QuizWord("Til dømes", "For eksempel", Color.BLUE),
    new QuizWord("Løyndom", "Hemmelighet", Color.RED),
    new QuizWord("Vørdnad", "Verdighet", Color.BLUE),
    new QuizWord("Lønsemd", "Lønnsomhet", Color.RED),
    
};

QuizWord[] level4 = {
new QuizWord("Augneblink","Øyeblikk", Color.RED),
new QuizWord("Synfaring", "Befaring", Color.BLUE),
new QuizWord("Verksemd", "Bedrift", Color.RED),
new QuizWord("Tilsetja", "Ansette", Color.BLUE),
new QuizWord("Melding", "Anmeldelse", Color.RED),
new QuizWord("Merknad", "Anmerkning", Color.BLUE),
new QuizWord("Tilsett", "Ansatt", Color.RED),

};

QuizWord[] level5 = {
    new QuizWord("Yrkedag","Virkedag", Color.RED),
    new QuizWord("Arbeidsløyse", "Arbeidsledighet", Color.BLUE),
    new QuizWord("Byrja", "Begynne", Color.RED),
    new QuizWord("Eigenfråsegn", "Egenerklæring", Color.BLUE),
    new QuizWord("Førespurnad", "forespørsel", Color.RED),
    new QuizWord("Fridom", "Frihet", Color.BLUE),
    new QuizWord("Viten", "Kunnskap", Color.RED),
    new QuizWord("Kvifor", "Hvorfor", Color.RED),
    new QuizWord("Korleis", "Hvordan", Color.BLUE)
    };

ArrayList<QuizWord> level1Words = new ArrayList<>();
ArrayList<QuizWord> level2Words = new ArrayList<>();
ArrayList<QuizWord> level3Words = new ArrayList<>();
ArrayList<QuizWord> level4Words = new ArrayList<>();
ArrayList<QuizWord> level5Words = new ArrayList<>();

public QuizWordFactory() {
    for (int i = 0; i < level1.length; i++) {
        level1Words.add(level1[i]);
    }
    for (int i = 0; i < level2.length; i++) {
        level2Words.add(level2[i]);
    }
    for (int i = 0; i < level3.length; i++) {
        level3Words.add(level3[i]);
    }
    for (int i = 0; i < level4.length; i++) {
        level4Words.add(level4[i]);
    }
    for (int i = 0; i < level5.length; i++) {
        level5Words.add(level5[i]);
    }
}

public ArrayList<QuizWord> getWordList(int level){
    ArrayList<QuizWord> returnList = new ArrayList<>();
    switch (level){
        case 1 :
            returnList = level1Words;
            break;
        case 2:
            returnList = level2Words;
            break;
        case 3:
            returnList = level3Words;
            break;
        case 4:
            returnList = level4Words;
            break;
        case 5:
            returnList = level5Words;
            break;
    }
    return returnList;
}

public ArrayList<QuizWord> GetNewQuizWords(int level) {
    ArrayList<QuizWord> chosenLevel = getWordList(level);
    ArrayList<QuizWord> selection = new ArrayList<>();
    
    Random r = new Random();

    // Loop 5 times to select 5 random elements
    for (int j = 0; j < 5; j++) {
        // Generate a random index
        int randomIndex = r.nextInt(chosenLevel.size());
        
        // Get the element at the random index and add it to the selection list
        selection.add(chosenLevel.get(randomIndex));
        
        // fjern frå questions
        chosenLevel.remove(randomIndex);
  }

    return selection;
}


}

