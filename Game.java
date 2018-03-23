/**
 * @author Sagar Shah
 * Playing cards from: https://github.com/hayeah/playing-cards-assets
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.util.ArrayList;

import java.util.concurrent.ThreadLocalRandom;

public class Game extends Application {
    public void start(Stage primaryStage) {
        //layout setup
        VBox rootPane = new VBox();
        rootPane.setAlignment(Pos.CENTER);
        rootPane.setSpacing(20);
        GridPane humanMiscPane = new GridPane();
        humanMiscPane.setAlignment(Pos.BOTTOM_CENTER);
        GridPane humanPane = new GridPane();
        humanPane.setAlignment(Pos.CENTER);
        GridPane pilePane = new GridPane();
        pilePane.setAlignment(Pos.CENTER);
        GridPane computerMiscPane = new GridPane();
        computerMiscPane.setAlignment(Pos.TOP_CENTER);
        GridPane computerPane = new GridPane();
        computerPane.setAlignment(Pos.CENTER);
        GridPane humanControlPane = new GridPane();
        humanControlPane.setAlignment(Pos.CENTER);
        humanControlPane.setHgap(10);
        rootPane.getChildren().addAll(humanMiscPane, humanPane, humanControlPane, pilePane, computerPane, computerMiscPane);

        //player setup
        Deck deck = new Deck();
        deck.createPile();
        Player human = new Player(deck.draw5cards());
        ArrayList<Card> humanHand = human.getHand();
        ComputerPlayer computer = new ComputerPlayer(deck.draw5cards());
        ArrayList<Card> computerHand = computer.getHand();

        //controls
        //human - askFor comboBox
        ComboBox<String> cbAskFor = new ComboBox<String>();
        cbAskFor.setEditable(false);
        for (int i = 0; i < humanHand.size(); i++) {
            String format = humanHand.get(i).getRankString();
            if (!cbAskFor.getItems().contains(format))
                cbAskFor.getItems().add(format);
        }
        cbAskFor.setPrefWidth(150);
        //pilePane - go fish button
        Button btGoFish = new Button("Go Fish!");
        //humanControl
        Label lbAskFor = new Label("You may ask the computer for all cards of the following rank:");
        Button btAsk = new Button("Ask!");
        //humanMisc
        Label lbHuman = new Label("Your Hand");
        //computerMisc
        Label lbComputer = new Label("Computer's Hand");

        //---------------image setup and adding other nodes to the panels---------------
        //boilerplate
        ArrayList<Image> humanImages = new ArrayList<Image>();
        ArrayList<Image> computerImages = new ArrayList<Image>();
        ArrayList<ImageView> humanImageViews = new ArrayList<ImageView>();
        ArrayList<ImageView> computerImageViews = new ArrayList<ImageView>();
        for (int img = 0; img < humanHand.size(); img++) {
            humanImages.add(humanHand.get(img).getImage());
        }
        for (int img = 0; img < computerHand.size(); img++) {
            computerImages.add(computerHand.get(img).getImage());
        }
        double scale = 1.25;
        for (int imgView = 0; imgView < humanImages.size(); imgView++) {
            humanImageViews.add(new ImageView());
            humanImageViews.get(imgView).setImage(humanImages.get(imgView));
            humanImageViews.get(imgView).setFitWidth(68.7 * scale);
            humanImageViews.get(imgView).setFitHeight(100 * scale);
        }
        for (int imgView = 0; imgView < computerImages.size(); imgView++) {
            computerImageViews.add(new ImageView());
            computerImageViews.get(imgView).setImage(computerImages.get(imgView));
            computerImageViews.get(imgView).setFitWidth(68.7 * scale);
            computerImageViews.get(imgView).setFitHeight(100 * scale);
        }
        //start adding
        humanMiscPane.add(lbHuman, 0, 0);
        //human cards
        int humanColumn = 0;
        for (int humanIV = 0; humanIV < humanImageViews.size(); humanIV++) {
            humanPane.add(humanImageViews.get(humanIV), humanColumn, 0);
            humanColumn++;
        }
        humanControlPane.add(lbAskFor, 0, 0);
        humanControlPane.add(cbAskFor, 1, 0);
        humanControlPane.add(btAsk, 2, 0);
        Image imgBack = new Image("/png/back.png");
        ImageView ivBack = new ImageView(imgBack);
        ivBack.setFitWidth(68.7 * scale);
        ivBack.setFitHeight(100 * scale);
        pilePane.add(ivBack, 0, 0);
        pilePane.add(btGoFish, 1, 0);
        //computer cards
        int computerColumn = 0;
        for (int computerIV = 0; computerIV < computerImageViews.size(); computerIV++) {
            computerPane.add(computerImageViews.get(computerIV), computerColumn, 0);
            computerColumn++;
        }
        computerMiscPane.add(lbComputer, 0, 0);

        Scene scene = new Scene(rootPane, 800, 600);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Go Fish");
        primaryStage.show();

        btAsk.setOnAction(e -> {
            String askChoice = cbAskFor.getValue();
            int newCards = 0;
            ArrayList<Card> computerToHuman = new ArrayList<Card>();
            for (int i = 0; i < computerHand.size(); i++) {
                //adding cards to temp array
                if (computerHand.get(i).getRankString().equals(askChoice)) {
                    computerToHuman.add(computerHand.get(i));
                    newCards++;
                    computerHand.remove(computerHand.get(i));
                }
            }
            //if temp not empty, then add to real hand
            if (!computerToHuman.isEmpty()) {
                JOptionPane.showMessageDialog(null, "You recieved (" + newCards + ") " + computerToHuman.get(0).getRankString() + "s from the computer's hand!");
                human.addToHand(computerToHuman); //addToHand In Player object
                //adding new cards to humanPane
                humanImages.clear();
                humanImageViews.clear();
                for (int img = 0; img < humanHand.size(); img++) {
                    humanImages.add(humanHand.get(img).getImage());
                }
                double humanScale = 1.25;
                for (int imgView = 0; imgView < humanHand.size(); imgView++) {
                    humanImageViews.add(new ImageView());
                    humanImageViews.get(imgView).setFitWidth(68.7 * humanScale);
                    humanImageViews.get(imgView).setFitHeight(100 * humanScale);
                    humanImageViews.get(imgView).setImage(humanImages.get(imgView));
                }
                int humanColumn1 = 0;
                for (int humanIV = 0; humanIV < humanImageViews.size(); humanIV++) {
                    humanPane.add(humanImageViews.get(humanIV), humanColumn1, 0);
                    humanColumn1++;
                }
                computerToHuman.clear();
                computerImages.clear();
                computerImageViews.clear();
                ArrayList<javafx.scene.Node> computerNodes = new ArrayList<javafx.scene.Node>();
                computerNodes.addAll(computerPane.getChildren());
                int computerSize = computerNodes.size();
                computerPane.getChildren().remove(0, computerSize);
                for (int img = 0; img < computerHand.size(); img++) {
                    computerImages.add(computerHand.get(img).getImage());
                }
                for (int imgView = 0; imgView < computerImages.size(); imgView++) {
                    computerImageViews.add(new ImageView());
                    computerImageViews.get(imgView).setImage(computerImages.get(imgView));
                    computerImageViews.get(imgView).setFitWidth(68.7 * scale);
                    computerImageViews.get(imgView).setFitHeight(100 * scale);
                }
                int computerColumn1 = 0;
                for (int computerIV = 0; computerIV < computerImageViews.size(); computerIV++) {
                    computerPane.add(computerImageViews.get(computerIV), computerColumn1, 0);
                    computerColumn1++;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Computer says: Go Fish!");
            }
            human.createBooks();
        });
        btGoFish.setOnAction(e -> {
            ArrayList<Card> remainingPile = deck.getPile();
            ArrayList<Card> pileToPlayer = new ArrayList<Card>();
            int rand = ThreadLocalRandom.current().nextInt(0, remainingPile.size());
            if (remainingPile.get(rand).getRankString().equals(cbAskFor.getValue())) {
                JOptionPane.showMessageDialog(null, "You picked a matching card from the pile!");
                human.addToHand(remainingPile.get(rand));
                pileToPlayer.add(remainingPile.get(rand));
                remainingPile.remove(rand);
                humanImages.add(pileToPlayer.get(0).getImage());
                humanImageViews.add(new ImageView());
                humanImageViews.get(humanImages.size() - 1).setImage(humanImages.get(humanImages.size() - 1));
                int location = humanImageViews.size();
                humanImageViews.get(location-1).setFitWidth(67*scale);
                humanImageViews.get(location-1).setFitHeight(100*scale);
                int humanSize = human.getHand().size();
                humanPane.add(humanImageViews.get(location-1), humanSize, 0);
            } else if (!(remainingPile.get(rand).getRankString().equals(cbAskFor.getValue()))) {
                JOptionPane.showMessageDialog(null, "Your pick from the pile didn't match, computer's turn!");
                String computerChoice = computer.choice();
                int newCards = 0;
                ArrayList<Card> humanToComputer = new ArrayList<Card>();
                for (int c = 0; c < humanHand.size(); c++) {
                    if (humanHand.get(c).getRankString().equals(computerChoice)) {
                        humanToComputer.add(humanHand.get(c));
                        newCards++;
                        humanHand.remove(humanHand.get(c));
                    }
                }
                ///////////////////////////////////////////////////////////
                if (!humanToComputer.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Computer recieved (" + newCards + ") " + humanToComputer.get(0).getRankString() + "s from your hand!");
                    computer.addToHand(humanToComputer); //addToHand In Player object
                    //adding new cards to computerPane
                    computerImages.clear();
                    computerImageViews.clear();
                    for (int img = 0; img < computerHand.size(); img++) {
                        computerImages.add(computerHand.get(img).getImage());
                    }
                    double computerScale = 1.25;
                    for (int imgView = 0; imgView < computerHand.size(); imgView++) {
                        computerImageViews.add(new ImageView());
                        computerImageViews.get(imgView).setFitWidth(68.7 * computerScale);
                        computerImageViews.get(imgView).setFitHeight(100 * computerScale);
                        computerImageViews.get(imgView).setImage(computerImages.get(imgView));
                    }
                    int computerColumn1 = 0;
                    for (int computerIV = 0; computerIV < computerImageViews.size(); computerIV++) {
                        computerPane.add(computerImageViews.get(computerIV), computerColumn1, 0);
                        computerColumn1++;
                    }
                    humanToComputer.clear();
                    humanImages.clear();
                    humanImageViews.clear();
                    ArrayList<javafx.scene.Node> humanNodes = new ArrayList<javafx.scene.Node>();
                    humanNodes.addAll(humanPane.getChildren());
                    int humanSize = humanNodes.size();
                    humanPane.getChildren().remove(0, humanSize);
                    for (int img = 0; img < humanHand.size(); img++) {
                        humanImages.add(humanHand.get(img).getImage());
                    }
                    for (int imgView = 0; imgView < humanImages.size(); imgView++) {
                        humanImageViews.add(new ImageView());
                        humanImageViews.get(imgView).setImage(humanImages.get(imgView));
                        humanImageViews.get(imgView).setFitWidth(68.7 * scale);
                        humanImageViews.get(imgView).setFitHeight(100 * scale);
                    }
                    int humanColumn1 = 0;
                    for (int humanIV = 0; humanIV < humanImageViews.size(); humanIV++) {
                        humanPane.add(humanImageViews.get(humanIV), humanColumn1, 0);
                        humanColumn1++;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Computer didn't match any of your cards, so you told the computer to go fish!");
                    String goFishComputerPick = computer.goFish(deck.getPile());
                    ArrayList<Card> pileToComputer = new ArrayList<Card>();
                    if(goFishComputerPick.equals(computerChoice)){
                        JOptionPane.showMessageDialog(null, "Computer picked a matching card from the pile!");
                        computer.addToHand(remainingPile.get(rand));
                        pileToComputer.add(remainingPile.get(rand));
                        remainingPile.remove(rand);
                        computerImages.add(pileToComputer.get(0).getImage());
                        computerImageViews.add(new ImageView());
                        computerImageViews.get(computerImages.size() - 1).setImage(humanImages.get(humanImages.size() - 1));
                        int location = computerImageViews.size();
                        int computerSize = computer.getHand().size();
                        computerImageViews.get(location-1).setFitWidth(67*scale);
                        computerImageViews.get(location-1).setFitHeight(100*scale);
                        computerPane.add(computerImageViews.get(location-1), computerSize, 0);
                    }
                    else if(!(goFishComputerPick.equals(computerChoice))){
                        JOptionPane.showMessageDialog(null, "Computer pick from pile didn't match, your's turn!");
                    }
                }
                human.createBooks();
                if(computer.getHand().size()==0)
                    JOptionPane.showMessageDialog(null, "You Win!");
                if(human.getHand().size()==0)
                    JOptionPane.showMessageDialog(null, "Computer Wins!");
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
