package no.uib.inf101.sem2.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;


public class QuizWordFactory {
    private Color darkBlue = new Color(0, 153 , 153);
    ArrayList<QuizWord> level1Words = new ArrayList<>();
    ArrayList<QuizWord> level2Words = new ArrayList<>();
    ArrayList<QuizWord> level3Words = new ArrayList<>();
    ArrayList<QuizWord> level4Words = new ArrayList<>();
    ArrayList<QuizWord> level5Words = new ArrayList<>();
    
    //String[] quizWords;
    QuizWord[] level5 = {
        new QuizWord("Få hugilt","Bli ille til mote", darkBlue),
        new QuizWord("Kome or vona", "Miste håpet", darkBlue),
        new QuizWord("Rettferdsvederlag", "Billighetserstatning", darkBlue),
        new QuizWord("Kome på rakedeisen", "Komme på avveie", darkBlue),
        new QuizWord("Vørdsamt", "Ærbødigst", darkBlue),
        new QuizWord("Åtgjerd", "Tiltak", darkBlue),
        new QuizWord("Vørdsle", "Stelle", darkBlue),
        new QuizWord("Hugleik", "Fantasi", darkBlue),
        new QuizWord("Hovmod", "Arroganse", darkBlue),
        new QuizWord("Ottesam", "Urolig", darkBlue),
        new QuizWord("Vørde", "Ærede", darkBlue),
        new QuizWord("Sokneråd", "Menighetsråd", darkBlue),
        new QuizWord("Kyrkjelyd", "Menighet", darkBlue),
        new QuizWord("Den Høgvørde Kronprinsessa", "Hennes Kongelige Høyhet Kronprinsessen", darkBlue),
        new QuizWord("Røynsle", "Erfaring", darkBlue),
        new QuizWord("Hugnadsam", "Hyggelig", darkBlue),
        new QuizWord("Vonbrot", "Skuffelse", darkBlue),
        new QuizWord("Jåss", "Tøys", darkBlue),
        new QuizWord("Følgjast åt", "Ledsage", darkBlue),
        new QuizWord("åtak", "angrep", darkBlue)

    };

    QuizWord[] level4 = {
        new QuizWord("Korkje","Verken", Color.MAGENTA.darker()),
        new QuizWord("Reiarlag", "Rederi", Color.MAGENTA.darker()),
        new QuizWord("Hopehav", "Fellesskap", Color.MAGENTA.darker()),
        new QuizWord("Eigenfråsegn", "Egenerklæring", Color.MAGENTA.darker()),
        new QuizWord("Røyndom", "Virkelighet", Color.MAGENTA.darker()),
        new QuizWord("Semje", "Enighet", Color.MAGENTA.darker()),
        new QuizWord("Framifrå", "Fremragende", Color.MAGENTA.darker()),
        new QuizWord("Samrøystes", "Enstemmig", Color.MAGENTA.darker()),
        new QuizWord("Omsutsfull", "Omsorgsfull", Color.MAGENTA.darker()),
        new QuizWord("Røyndomsfjern", "Virkelighetsfjern", Color.MAGENTA.darker()),
        new QuizWord("Velgjerd", "Veldedighet", Color.MAGENTA.darker()),
        new QuizWord("Utferding", "Utstedelse", Color.MAGENTA.darker()),
        new QuizWord("Beinveges", "Umiddelbar", Color.MAGENTA.darker()),
        new QuizWord("Dragnad", "Tilbøyelighet", Color.MAGENTA.darker()),
        new QuizWord("Venleik", "Skjønnhet", Color.MAGENTA.darker()),
        new QuizWord("Mellombels", "Midlertidig", Color.MAGENTA.darker()),
        new QuizWord("Førebels", "Foreløpig", Color.MAGENTA.darker()),
        new QuizWord("Medynk", "Medlidenhet", Color.MAGENTA.darker()),
        new QuizWord("Keisemd", "Kjedsomhet", Color.MAGENTA.darker()),
        new QuizWord("Avretting", "Henrettelse", Color.MAGENTA.darker()),
        new QuizWord("Attval", "Gjenvalg", Color.MAGENTA.darker()),
        new QuizWord("Tverrbuar", "Gjenboer", Color.MAGENTA.darker()),
        new QuizWord("Føremon", "Fordel", Color.MAGENTA.darker()),
        new QuizWord("Rørsle", "Bevegelse", Color.MAGENTA.darker()),
        new QuizWord("Monaleg", "Betydelig", Color.MAGENTA.darker()),
        new QuizWord("Stogg", "Stopp", Color.MAGENTA.darker()),
        new QuizWord("Vitlaus", "Forrykt", Color.MAGENTA.darker()),
        new QuizWord("Fråhald", "Avhold", Color.MAGENTA.darker()),
        new QuizWord("I røynda", "I virkeligheten", Color.MAGENTA.darker()),
        new QuizWord("Lét", "Lot", Color.MAGENTA.darker()),
        new QuizWord("Lèt", "Lar", Color.MAGENTA.darker()),
        new QuizWord("Vitje", "Besøke", Color.MAGENTA.darker()),
        new QuizWord("Plar", "Pleier", Color.MAGENTA.darker()),
        new QuizWord("Løyne", "Skjule", Color.MAGENTA.darker()),
        new QuizWord("Handsaming", "Behandling", Color.MAGENTA.darker()),
        new QuizWord("lagnad", "skjebne", Color.MAGENTA.darker())



    };

    QuizWord[] level3 = {
        new QuizWord("Forkava","Stresset", Color.ORANGE),
        new QuizWord("Teieplikt", "Taushetsplikt", Color.ORANGE),
        new QuizWord("Høve", "Anledning", Color.ORANGE),
        new QuizWord("Til dømes", "For eksempel", Color.ORANGE),
        new QuizWord("Løyndom", "Hemmelighet", Color.ORANGE),
        new QuizWord("Vørdnad", "Verdighet", Color.ORANGE),
        new QuizWord("Lønsemd", "Lønnsomhet", Color.ORANGE),
        new QuizWord("Vitnesbyrd", "Vitnemål", Color.ORANGE),
        new QuizWord("Rettleiing", "Veiledning", Color.ORANGE),
        new QuizWord("Varsemd", "Varsomhet", Color.ORANGE),
        new QuizWord("Valkrins", "Valgkrets", Color.ORANGE),
        new QuizWord("Somme", "Noen", Color.ORANGE),
        new QuizWord("Utettervend", "Utadvendt", Color.ORANGE),
        new QuizWord("Uklårleik", "Uklarhet", Color.ORANGE),
        new QuizWord("Aktløyse", "Uaktsomhet", Color.ORANGE),
        new QuizWord("Trass i", "Til tross for", Color.ORANGE),
        new QuizWord("Løyve", "Tillatelse", Color.ORANGE),
        new QuizWord("Tidhøveleg", "Tidsmessig", Color.ORANGE),
        new QuizWord("Tryggingstenesta", "Sikkerhetstjenesten", Color.ORANGE),
        new QuizWord("Sjølveigarhusvære", "Selveierleilighet", Color.ORANGE),
        new QuizWord("Setel", "Seddel", Color.ORANGE),
        new QuizWord("Overtyde", "Overbevise", Color.ORANGE),
        new QuizWord("Merksemd", "Oppmerksomhet", Color.ORANGE),
        new QuizWord("Omland", "Omegn", Color.ORANGE),
        new QuizWord("Målmedviten", "Målbevisst", Color.ORANGE),
        new QuizWord("Styresmaktene", "Myndighetene", Color.ORANGE),
        new QuizWord("Lovføresegn", "Lovbestemmelse", Color.ORANGE),
        new QuizWord("Likesæl", "Likegyldig", Color.ORANGE),
        new QuizWord("Kunnig", "Kyndig", Color.ORANGE),
        new QuizWord("Omsyn", "Hensyn", Color.ORANGE),
        new QuizWord("Føremålstenleg", "Hensiktsmessig", Color.ORANGE),
        new QuizWord("Gje att", "Gjengi", Color.ORANGE),
        new QuizWord("Føreseieleg", "Forutsigbar", Color.ORANGE),
        new QuizWord("Ureina", "Forurense", Color.ORANGE),
        new QuizWord("Framhald", "Fortsettelse", Color.ORANGE),
        new QuizWord("Forsytar", "Forsørger", Color.ORANGE),
        new QuizWord("Samhøve", "Samsvar", Color.ORANGE),
        new QuizWord("Brotsverk", "Forbrytelse", Color.ORANGE),
        new QuizWord("Førebuing", "Forberedelse", Color.ORANGE),
        new QuizWord("Atterhald", "Forbehold", Color.ORANGE),
        new QuizWord("Einskapleg", "Enhetlig", Color.ORANGE),
        new QuizWord("Omgrep", "Begrep", Color.ORANGE),
        new QuizWord("Ålmen", "Allmenn", Color.ORANGE),
        new QuizWord("Naudsynt", "Nødvendig", Color.ORANGE),
        new QuizWord("Likeins", "Likedan", Color.ORANGE),
        new QuizWord("Tilråding", "Anbefaling", Color.ORANGE),
        new QuizWord("Eining", "Enhet", Color.ORANGE),
        new QuizWord("Oppseding", "Oppdragelse", Color.ORANGE),
        new QuizWord("framsyning","forestilling", Color.ORANGE),
        new QuizWord("Oppmode", "Anmode", Color.ORANGE)

           
    };

    QuizWord[] level2 = {
        new QuizWord("Augneblink","Øyeblikk", Color.YELLOW),
        new QuizWord("Synfaring", "Befaring", Color.YELLOW),
        new QuizWord("Verksemd", "Virksomhet", Color.YELLOW),
        new QuizWord("Tilsetja", "Ansette", Color.YELLOW),
        new QuizWord("Melding", "Anmeldelse", Color.YELLOW),
        new QuizWord("Merknad", "Anmerkning", Color.YELLOW),
        new QuizWord("Tilsett", "Ansatt", Color.YELLOW),
        new QuizWord("Åtvare", "Advare", Color.YELLOW),
        new QuizWord("Openheit", "Åpenhet", Color.YELLOW),
        new QuizWord("Øvst", "Øverst", Color.YELLOW),
        new QuizWord("Uynskt", "Uønsket", Color.YELLOW),
        new QuizWord("Utgreiing", "Utredning", Color.YELLOW),
        new QuizWord("Utnemning", "Utnevnelse", Color.YELLOW),
        new QuizWord("Underskot", "Underskudd", Color.YELLOW),
        new QuizWord("Upårekna", "Uforutsett", Color.YELLOW),
        new QuizWord("Tola", "Tåle", Color.YELLOW),
        new QuizWord("Tryggleik", "Sikkerhet", Color.YELLOW),
        new QuizWord("Tena", "Tjene", Color.YELLOW),
        new QuizWord("Tilskot", "Tilskudd", Color.YELLOW),
        new QuizWord("Røysterett", "Stemmerett", Color.YELLOW),
        new QuizWord("Skulverk", "Skolevesen", Color.YELLOW),
        new QuizWord("Sjølvmelding", "Egenmelding", Color.YELLOW),
        new QuizWord("Samvit", "Samvittighet", Color.YELLOW),
        new QuizWord("Sanning", "Sannhet", Color.YELLOW),
        new QuizWord("Rettleia", "Rettlede", Color.YELLOW),
        new QuizWord("Personlegdom", "Personlighet", Color.YELLOW),
        new QuizWord("Omstende", "Omstendighet", Color.YELLOW),
        new QuizWord("Omgjevnad", "Omgivelse", Color.YELLOW),
        new QuizWord("Marknad", "Marked", Color.YELLOW),
        new QuizWord("Lækjar", "Lege", Color.YELLOW),
        new QuizWord("Klårleik", "Klarhet", Color.YELLOW),
        new QuizWord("Kjensle", "Følelse", Color.YELLOW),
        new QuizWord("Framand", "Fremmed", Color.YELLOW),
        new QuizWord("Framkomst", "Ankomst", Color.YELLOW),
        new QuizWord("Skilnad", "Forskjell", Color.YELLOW),
        new QuizWord("Etterskot", "Etterskudd", Color.YELLOW),
        new QuizWord("Einsemd", "Ensomhet", Color.YELLOW),
        new QuizWord("Dugleik", "Dyktighet", Color.YELLOW),
        new QuizWord("Grunngje", "Begrunne", Color.YELLOW),
        new QuizWord("Hermeteikn", "Anførselstegn", Color.YELLOW),
        new QuizWord("Hjå", "Hos", Color.YELLOW),
        new QuizWord("Attergangar", "Gjenganger", Color.YELLOW),
        new QuizWord("Føresetnad", "Forutsetning", Color.YELLOW),
        new QuizWord("vêr", "vær", Color.YELLOW),
        new QuizWord("Samstundes", "Samtidig", Color.MAGENTA.darker()),
        new QuizWord("Vanske", "Vanskelighet", Color.MAGENTA.darker()),
        new QuizWord("Ærlegdom", "Ærlighet", Color.MAGENTA.darker()),
        new QuizWord("Sparsemd", "Sparsomhet", Color.MAGENTA.darker()),
        new QuizWord("Åtferd", "Adferd", Color.MAGENTA.darker())
        
        

    };

    QuizWord[] level1 = {
        new QuizWord("Yrkedag","Virkedag", Color.WHITE),
        new QuizWord("Arbeidsløyse", "Arbeidsledighet", Color.WHITE),
        new QuizWord("Byrja", "Begynne", Color.WHITE),
        new QuizWord("Førespurnad", "Forespørsel", Color.WHITE),
        new QuizWord("Fridom", "Frihet", Color.WHITE),
        new QuizWord("Viten", "Kunnskap", Color.WHITE),
        new QuizWord("Kvifor", "Hvorfor", Color.WHITE),
        new QuizWord("Korleis", "Hvordan", Color.WHITE),
        new QuizWord("Kledning", "Bekledning", Color.WHITE),
        new QuizWord("Øyremerkt", "Øremerket", Color.WHITE),
        new QuizWord("Auka", "Øke", Color.WHITE),
        new QuizWord("Opning", "Åpning", Color.WHITE),
        new QuizWord("Opne", "Åpne", Color.WHITE),
        new QuizWord("Vald", "Vold", Color.WHITE),
        new QuizWord("Vitskapleg", "Vitenskapelig", Color.WHITE),
        new QuizWord("Veke", "Uke", Color.WHITE),
        new QuizWord("Storleik", "Størrelse", Color.WHITE),
        new QuizWord("Straum", "Strøm", Color.WHITE),
        new QuizWord("Sjølvstende", "Selvstendighet", Color.WHITE),
        new QuizWord("Sjølvsagt", "Selvsagt", Color.WHITE),
        new QuizWord("Selja", "Selge", Color.WHITE),
        new QuizWord("Omsetjing", "Oversettelse", Color.WHITE),
        new QuizWord("Oppgjer", "Oppgjør", Color.WHITE),
        new QuizWord("Nykel", "Nøkkel", Color.WHITE),
        new QuizWord("Nyting", "Nytelse", Color.WHITE),
        new QuizWord("Namn", "Navn", Color.WHITE),
        new QuizWord("Munnleg", "Muntlig", Color.WHITE),
        new QuizWord("Milestolpe", "Milepæl", Color.WHITE),
        new QuizWord("Meistra", "Mestre", Color.WHITE),
        new QuizWord("Lausøyre", "Løsøre", Color.WHITE),
        new QuizWord("Løysing", "Løsning", Color.WHITE),
        new QuizWord("Lyft", "Løft", Color.WHITE),
        new QuizWord("Lærestad", "Lærested", Color.WHITE),
        new QuizWord("Lovgjeving", "Lovgivning", Color.WHITE),
        new QuizWord("Innbrot", "Innbrudd", Color.WHITE),
        new QuizWord("Hushald", "Husholdning", Color.WHITE),
        new QuizWord("Gåve", "Gave", Color.WHITE),
        new QuizWord("Førre", "Forrige", Color.WHITE),
        new QuizWord("Føretak", "Foretak", Color.WHITE),
        new QuizWord("Flaum", "Flom", Color.WHITE),
        new QuizWord("Elles", "Ellers", Color.WHITE),
        new QuizWord("Dryg", "Drøy", Color.WHITE),
        new QuizWord("Botn", "Bunn", Color.WHITE),
        new QuizWord("Breidd", "Bredde", Color.WHITE),
        new QuizWord("Bilete", "Bilde", Color.WHITE),
        new QuizWord("Kven", "Hvem", Color.WHITE),
        new QuizWord("Kva for", "Hvilken", Color.WHITE),
        new QuizWord("Ynskje", "Ønske", Color.WHITE),
        new QuizWord("Mykje", "Mye", Color.WHITE),
        new QuizWord("Fyrst", "Først", Color.WHITE),
        new QuizWord("Forelsking", "Forelskelse", Color.WHITE),
        new QuizWord("Opphav", "Opprinnelse", Color.WHITE),
        new QuizWord("Anten", "Enten", Color.WHITE),
        new QuizWord("Kjem", "Kommer", Color.WHITE),
        new QuizWord("Rekkje", "Rekke", Color.WHITE),
        new QuizWord("Vart", "Ble", Color.WHITE),
        new QuizWord("Verte", "Bli", Color.WHITE),
        new QuizWord("Vert", "Blir", Color.WHITE),
        new QuizWord("Eg", "Jeg", Color.WHITE),
        new QuizWord("Me", "Vi", Color.WHITE),
        new QuizWord("Ikkje", "Ikke", Color.WHITE)


    };
    

    /**
     * Konstruktøren lager ny liste av QuizWord-objektene som kan hentes fra QuizModel.
     */
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

/**
     * @param level Tar inn en verdi som er lik nivået til listen som skal returneres ved en switch case funksjon.
     * @return hele listen som tilhører nivået.
     */
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

  /**
     * @param level Kaller på metoden getWordList og sender videre verdien som er lik nivået til listen som skal returneres.
     * @return selection. Returnerer en ny liste som går igjennom nivåets korresponderende ordliste og henter inn kun 5 tilfeldige ord fra den.
     */
public ArrayList<QuizWord> GetNewQuizWords(int level) {
    ArrayList<QuizWord> chosenLevel = getWordList(level);
    ArrayList<QuizWord> selection = new ArrayList<>();
    
    Random r = new Random();

    for (int j = 0; j < 5; j++) {
   
        int randomIndex = r.nextInt(chosenLevel.size());
        
        selection.add(chosenLevel.get(randomIndex));
    
        chosenLevel.remove(randomIndex);
  }

    return selection;
}


}

