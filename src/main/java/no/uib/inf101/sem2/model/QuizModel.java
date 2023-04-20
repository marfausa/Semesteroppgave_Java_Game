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

    private QuizWord currentQuizWord; // I staden for eigen klasse, gjerne string?
    private QuizWordFactory quizWordFactory;

    private String currentInput = "";   
    private String currentQuestion;
    private String currentAnswer;
    private String wrongAnswers;


    public QuizModel(QuizWordFactory quizWordFactory) {
        this.quizWordFactory = quizWordFactory;
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
        System.out.println(currentInput);
    }

    @Override
    public boolean inputCheckAnswer(String input) {
        if (input.equalsIgnoreCase(this.currentAnswer)){
            getCurrentWord();
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

    @Override
    public void startLevel(){
        if ((levelList.size() == 0 && this.level <= 5) || level == 0){
            this.level +=1;
            this.levelList = this.quizWordFactory.GetNewQuizWords(level);
        }
    }

    public void level1(){

    }

    @Override
    public int getCurrentLevel() {
        return this.level;
    }
   
    }


    
    


