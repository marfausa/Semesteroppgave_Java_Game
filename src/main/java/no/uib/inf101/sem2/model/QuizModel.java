package no.uib.inf101.sem2.model;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

import no.uib.inf101.sem2.controller.ControllableQuizModel;
import no.uib.inf101.sem2.view.ViewableQuizModel;

public class QuizModel implements ViewableQuizModel, ControllableQuizModel {
    private GameState gameState;
    private ArrayList<QuizWord> levelList;
    private int level = 0;
    private int stageCounter = 1;
    private int userTries = 0;

    private QuizWord currentQuizWord; // I staden for eigen klasse, gjerne string?
    private QuizWordFactory quizWordFactory;

    private String currentInput = "";   
    private String currentQuestion;
    private String currentAnswer;
    private String wrongAnswers;

    private int answeredCorrect = 0;


    public QuizModel() {
        this.quizWordFactory = new QuizWordFactory();
        this.gameState = GameState.ACTIVE_GAME;
        this.levelList = new ArrayList<>();
        startLevel();
        currentQuizWord = getCurrentWord();
        currentQuestion = currentQuizWord.getQuestion();
        currentAnswer = currentQuizWord.getAnswer();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    @Override
    public GameState getGameState() {
        return this.gameState;
    }

    @Override
    public void updateInputString(String input) {
        currentInput = input;

    }

    @Override
    public boolean inputCheckAnswer(String input) {
        if (input.equalsIgnoreCase(this.currentAnswer)){
            getNextWord();
            return true;
        } else{
            this.wrongAnswers = input;
            return false;
        }
    }
    

    @Override
    public void getNextWord(){
        this.currentQuizWord = getCurrentWord();
        this.stageCounter +=1;

    }

    @Override
    public void startLevel(){
        if ((levelList.size() == 0 && this.level < 5) || level == 0){
            this.level +=1;
            this.levelList = this.quizWordFactory.GetNewQuizWords(level);
        }
    }


    @Override
    public int getCurrentLevel() {
        if (this.level >0 && this.level <= 5) {
            return 1;
        } else if (this.level > 5 && this.level <= 10) {
            return 2;
        } else if (this.level >10 && this.level <= 15) {
            return 3;
        } else if (this.level >15 && this.level <= 20) {
            return 4;
        } else if (this.level >20 && this.level <= 25) {
            return 5;
        } else {
            return 0;
        }
    }
   


    public QuizWord getCurrentWord(){
        if (levelList.size() >0){
            Random randomWord = new Random();
            int randomIndex = randomWord.nextInt(levelList.size());
            currentQuizWord = levelList.get(randomIndex);
            this.levelList.remove(randomIndex);
            }
        else if (levelList.size() == 0 && this.level >=1){
            startLevel();
        }
        return currentQuizWord;
        
         }
    

    public ArrayList<QuizWord> getWordList(){
        //for testing purposes mostly
        return this.levelList;
    }

    public String getInputAnswer(){
        return currentInput;
    }

    public String getWrongAnswer(){
        return wrongAnswers;
    }

    public String getCurrentQuestion(){
        return this.currentQuestion;
    }

    public String getCurrentAnswer(){
        return this.currentAnswer;
    }

    public int getStageProgression(){
        return stageCounter;
    }

    public void updateGameState(GameState gs){
        this.gameState = gs;
    }

   

    public void reset() {
        this.quizWordFactory = new QuizWordFactory();

        this.level = 0;
        this.stageCounter = 1;
        this.userTries += 1;
        this.answeredCorrect = 0;
        
        this.gameState = GameState.ACTIVE_GAME;
        this.levelList = new ArrayList<>();
        startLevel();
        
        this.currentQuizWord = getCurrentWord();
        this.currentQuestion = this.currentQuizWord.getQuestion();
        this.currentAnswer = this.currentQuizWord.getAnswer();
        this.currentInput = "";   
        this.wrongAnswers = null;

        
    }
    }


    
    


