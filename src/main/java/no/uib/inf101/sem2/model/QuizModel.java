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

    private QuizWord currentQuizWord; // I staden for eigen klasse, gjerne string?
    private QuizWordFactory quizWordFactory;

    private String currentInput = "";   
    private String currentQuestion;
    private String currentAnswer;


    public QuizModel(QuizWordFactory quizWordFactory) {
        this.quizWordFactory = quizWordFactory;
        this.gameState = GameState.ACTIVE_GAME;
        this.levelList = new ArrayList<>();
        nextLevel();
        System.out.println(levelList);
        
        
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
        if (input == this.currentAnswer){
            getCurrentWord();
            return true;
        } else{
            return false;
        }
    }


    public QuizWord getCurrentWord(){
        if (levelList.size() >0){
            Random randomWord = new Random();
            int randomIndex = randomWord.nextInt(levelList.size());
            currentQuizWord = levelList.get(randomIndex);
            this.levelList.remove(randomIndex);
            }
        return currentQuizWord;
        
         }

    public ArrayList<QuizWord> getWordList(){
        return this.levelList;
    }
    public String getInputAnswer(){
        return currentInput;
    }


    private void nextLevel(){
        if ((levelList.size() == 0 && this.level <= 5) || level == 0){
            this.level +=1;
            this.levelList = this.quizWordFactory.GetNewQuizWords(level);
        }
    }

   
    }


    
    


