package no.uib.inf101.sem2.model;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

import no.uib.inf101.sem2.controller.ControllableQuizModel;
import no.uib.inf101.sem2.view.ViewableQuizModel;

public class QuizModel implements ViewableQuizModel, ControllableQuizModel {
    public GameState gameState;
    public ArrayList<QuizWord> levelList;
    public int level = 0;
    public int stageCounter = 1;
    public int userTries = 0;

    private QuizWord currentQuizWord; // I staden for eigen klasse, gjerne string?
    private QuizWordFactory quizWordFactory;

    public String currentInput = "";   
    public String currentQuestion;
    public String currentAnswer;
    public Color currentColor;

    public String wrongAnswers;
    public String correctAnswers;

    public int answeredCorrect = 0;


    public QuizModel() {
        this.quizWordFactory = new QuizWordFactory();
        this.gameState = GameState.ACTIVE_GAME;
        this.levelList = new ArrayList<>();

        startLevel();
      
        for (int i =0 ; i <levelList.size();i++){
           System.out.println(levelList.get(i).getQuestion());
        } 

        currentQuizWord = getCurrentWord();
        currentQuestion = currentQuizWord.getQuestion();
        currentAnswer = currentQuizWord.getAnswer();
        currentColor = currentQuizWord.getWordColor();

        // print fasitsvar
        System.out.println("Level " + this.level + ": " + getCurrentQuestion() + " = " + this.currentAnswer);
        
        
        
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
            this.correctAnswers = input;
            return true;
        } else{
            this.wrongAnswers = input;
            return false;
        }
    }


    @Override
    public boolean startLevel(){
        if ((levelList.size() == 0 && this.level < 5) || level == 0){
            this.level +=1;
            this.levelList = this.quizWordFactory.GetNewQuizWords(level);
            return true;
        }
        return false;
    }


    @Override
    public int getCurrentLevel() {
        if (this.level == 1) {
            return 1;
        } else if (this.level == 2) {
            return 2;
        } else if (this.level == 3) {
            return 3;
        } else if (this.level == 4) {
            return 4;
        } else if (this.level == 5) {
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

    public String getWrongUserAnswer(){
        return wrongAnswers;
    }
    public String getCorrectUserAnswer(){
        return correctAnswers;
    }

    public String getCurrentQuestion(){
        return this.currentQuestion;
    }

    public String getCurrentAnswer(){
        return this.currentAnswer;
    }
    public Color getCurrentColor(){
        return this.currentColor;
    }

    public int getStageProgression(){
        return stageCounter;
    }

    public void updateGameState(GameState gs){
        this.gameState = gs;
    }

    public int getWordsLeftInLevel(){
        return this.levelList.size();
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
        this.currentColor = this.currentQuizWord.getWordColor();
        this.currentInput = "";   
        this.wrongAnswers = null;

        
    }
    public void nextStage(){
        this.stageCounter += 1;
        this.answeredCorrect += 1;

        startLevel();

        this.currentQuizWord = getCurrentWord();
        this.currentQuestion = this.currentQuizWord.getQuestion();
        this.currentAnswer = this.currentQuizWord.getAnswer();
        this.currentColor = this.currentQuizWord.getWordColor();
        this.currentInput = "";   
        this.wrongAnswers = null;
        

         // Print fasitsvar
        System.out.println("Level " + this.level + ": " + getCurrentQuestion() + " = " + this.currentAnswer);
        
        

        }


    
    }


    
    


