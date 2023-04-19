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


    public QuizModel(QuizWordFactory quizWordFactory) {
        this.quizWordFactory = quizWordFactory;
        this.gameState = GameState.ACTIVE_GAME;
        this.levelList = new ArrayList<>();
        nextLevel();
        
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    @Override
    public GameState getGameState() {
        return this.gameState;
    }

    @Override
    public void updateInputString(char c) {
        currentInput += c;
        System.out.println(currentInput);
    }


    public QuizWord getCurrentWord(){
        Random randomWord = new Random();
        int randomIndex = randomWord.nextInt(levelList.size());
        currentQuizWord = levelList.get(randomIndex);
        this.levelList.remove(randomIndex);

        return currentQuizWord;
        }

    private void nextLevel(){
        if ((levelList.size() == 0 && this.level <= 5) || level == 0){
            this.level +=1;
            this.levelList = this.quizWordFactory.getWordList(this.level);
        }
    }
    }


    
    


