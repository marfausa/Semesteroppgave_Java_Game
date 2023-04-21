package no.uib.inf101.sem2.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;


public class QuizWordFactory {
    
//String[] quizWords;
QuizWord[] level5 = {
        new QuizWord("Få hugilt","bli ille til mote", Color.BLUE),
        new QuizWord("Kome or vona", "miste håpet", Color.BLUE),
        new QuizWord("Rettferdsvederlag", "Billighetserstatning", Color.BLUE),
        new QuizWord("Kome på rakedeisen", "Komme på avveie", Color.BLUE),
        new QuizWord("Vørdsamt", "Ærbødigst", Color.BLUE),
        new QuizWord("Åtgjerd", "Tiltak", Color.BLUE),
        new QuizWord("Vørdsle", "I orden", Color.BLUE),
        new QuizWord("Hugleik", "Fantasi", Color.BLUE),
        new QuizWord("Hovmod", "Arroganse", Color.BLUE)
};

QuizWord[] level4 = {
    new QuizWord("Korkje","Verken", Color.MAGENTA),
    new QuizWord("Reiarlag", "Rederi", Color.MAGENTA),
    new QuizWord("Hopehav", "Fellesskap", Color.MAGENTA),
    new QuizWord("Eigenfråsegn", "Egenerklæring", Color.MAGENTA),
    new QuizWord("Røyndom", "Virkelighet", Color.MAGENTA),
    new QuizWord("Semje", "Enighet", Color.MAGENTA),
    new QuizWord("Framifrå", "Fremragende", Color.MAGENTA),
    new QuizWord("Samrøystes", "Enstemmig", Color.MAGENTA),
    new QuizWord("Omsutsfull", "Omsorgsfull", Color.MAGENTA)
};

QuizWord[] level3 = {
    new QuizWord("Forkava","Stresset", Color.ORANGE),
    new QuizWord("Teieplikt", "Taushetsplikt", Color.ORANGE),
    new QuizWord("Høve", "Anledning", Color.ORANGE),
    new QuizWord("Til dømes", "For eksempel", Color.ORANGE),
    new QuizWord("Løyndom", "Hemmelighet", Color.ORANGE),
    new QuizWord("Vørdnad", "Verdighet", Color.ORANGE),
    new QuizWord("Lønsemd", "Lønnsomhet", Color.ORANGE),
    
};

QuizWord[] level2 = {
new QuizWord("Augneblink","Øyeblikk", Color.YELLOW),
new QuizWord("Synfaring", "Befaring", Color.YELLOW),
new QuizWord("Verksemd", "Bedrift", Color.YELLOW),
new QuizWord("Tilsetja", "Ansette", Color.YELLOW),
new QuizWord("Melding", "Anmeldelse", Color.YELLOW),
new QuizWord("Merknad", "Anmerkning", Color.YELLOW),
new QuizWord("Tilsett", "Ansatt", Color.YELLOW),

};

QuizWord[] level1 = {
    new QuizWord("Yrkedag","Virkedag", Color.WHITE),
    new QuizWord("Arbeidsløyse", "Arbeidsledighet", Color.WHITE),
    new QuizWord("Byrja", "Begynne", Color.WHITE),
    new QuizWord("Eigenfråsegn", "Egenerklæring", Color.WHITE),
    new QuizWord("Førespurnad", "forespørsel", Color.WHITE),
    new QuizWord("Fridom", "Frihet", Color.WHITE),
    new QuizWord("Viten", "Kunnskap", Color.WHITE),
    new QuizWord("Kvifor", "Hvorfor", Color.WHITE),
    new QuizWord("Korleis", "Hvordan", Color.WHITE)
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

