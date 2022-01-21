/*
Maxime Sotsky
COMP 2611
FINAL ASSIGNMENT
*/

import javafx.application.Application;
import javafx.event.ActionEvent; 
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import java.util.Random;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
//import java.Util.Collection;

public class Main extends Application
{
    Scene sceneGame;
    Scene startMenu;
    //Stage win;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) //throws Exception 
    {
        //=================================================qtree
        Boundry boundry = new Boundry(0,0,100,100);
        QuadTree tree = new QuadTree(1,boundry);
        int random = 0;
        int x = 0;
        int y = 0;
       
        for(int i = 0; i != 16; i++)//generating 16 random value between 0 - 100 inserting into tree
        {
            //tree build
            if(x % 4 == 0)
                x += 10;
            random = (int)(Math.random() *100);
            tree.insert(random,random,1);
            if(y == 1)
                y = 0;
            y += 5;
            x++;
            if(y > 15)
                y = 1;
        }
        //QuadTree.dfs(tree);
        int p1 = 0;
        int p2 = 0; //prizes
        int p3 = 0;
        int count = 0;

        for (Node node : tree.nodes) {//lvl 1 
            if (count == 1)
                p1 = (node.x); //its a square //x y the same
            if(count == 2)
                p2 = (node.x);
            if(count == 3)
                p3 = (node.x);
            count++;
        }
        //invisible prize labels to access by event handler
        Label lblp1 = new Label(Integer.toString(p1));
        Label lblp2 = new Label(Integer.toString(p2));
        Label lblp3 = new Label(Integer.toString(p3));
        //Label cost = new Label("-10");
//====================================================================================================
        
        GridPane MenuLayout = new GridPane();
        Scene startMenu = new Scene(MenuLayout, 700, 400);
        GridPane gameLayout = new GridPane();
        Scene sceneGame = new Scene(gameLayout, 700, 400, Color.WHITE);
        GridPane grid = new GridPane();
        MenuLayout.setPadding(new Insets(5));
        MenuLayout.setHgap(1);
        MenuLayout.setVgap(1);
        gameLayout.setPadding(new Insets(5));
        gameLayout.setHgap(5);
        gameLayout.setVgap(5);
//====================================================================================================
        Label instuction = new Label(
                "Welcome! \n Here are some instruction on how this works \n1)Press the play button to try your luck! \n2)You beggin with a bank of 30 points \n3)You can choose rectangles by clicking one section for a chance to win!!!! \n4)Each time there is 3-1 winning rectangles \n5)The more rectangles you hit, the more likely you will run out of funds\n6)Revealing a rectangle contents costs 10 points each\n7)When your bank goes to zero you lose! You can hit the CASHOUT button to start fresh \n Doesn't that sound like a lot of fun!!! enjoy!");
        grid.add(instuction, 100, 100);
//====================================================================================================
        Button button = new Button("Play");
        button.setOnAction(e -> primaryStage.setScene(sceneGame));
        primaryStage.setTitle("Final assignment");
        MenuLayout.getChildren().addAll(button, instuction);
        primaryStage.setScene(startMenu);
        primaryStage.show();
//====================================================================================================
        double height = 50;
        double width = 50;

        Button visRec = new Button();
        Button visRec2 = new Button();
        Button visRec3 = new Button();
        Button visRec4 = new Button();
        visRec.setPrefSize(width,height);
        visRec.setText("1");
        visRec2.setPrefSize(width,height);
        visRec2.setText("2");
        visRec3.setPrefSize(width,height);
        visRec3.setText("3");
        visRec4.setPrefSize(width,height);
        visRec4.setText("4");

        Button visRec5 = new Button();
        Button visRec6 = new Button();
        Button visRec7 = new Button();
        Button visRec8 = new Button();
        visRec5.setPrefSize(width,height);
        visRec5.setText("5");
        visRec6.setPrefSize(width,height);
        visRec6.setText("6");
        visRec7.setPrefSize(width,height);
        visRec7.setText("7");
        visRec8.setPrefSize(width,height);
        visRec8.setText("8");

        Button visRec9 = new Button();
        Button visRec10 = new Button();
        Button visRec11 = new Button();
        Button visRec12 = new Button();
        visRec9.setPrefSize(width,height);
        visRec9.setText("9");
        visRec10.setPrefSize(width,height);
        visRec10.setText("10");
        visRec11.setPrefSize(width,height);
        visRec11.setText("11");
        visRec12.setPrefSize(width,height);
        visRec12.setText("12");

        Button visRec13 = new Button();
        Button visRec14 = new Button();
        Button visRec15 = new Button();
        Button visRec16 = new Button();
        visRec13.setPrefSize(width,height);
        visRec13.setText("13");
        visRec14.setPrefSize(width,height);
        visRec14.setText("14");
        visRec15.setPrefSize(width,height);
        visRec15.setText("15");
        visRec16.setPrefSize(width,height);
        visRec16.setText("16");

        // col 1
        grid.add(visRec, 0, 1);
        grid.add(visRec2, 0, 5);
        grid.add(visRec3, 0, 10);
        grid.add(visRec4, 0, 15);
        // col 2
        grid.add(visRec5, 10, 1);
        grid.add(visRec6, 10, 5);
        grid.add(visRec7, 10, 10);
        grid.add(visRec8, 10, 15);
        // col 3
        grid.add(visRec9, 20, 1);
        grid.add(visRec10, 20, 5);
        grid.add(visRec11, 20, 10);
        grid.add(visRec12, 20, 15);
        // col 4
        grid.add(visRec13, 30, 1);
        grid.add(visRec14, 30, 5);
        grid.add(visRec15, 30, 10);
        grid.add(visRec16, 30, 15);

        //String bank = "0";
        Label lbl1  = new Label("Bank:");
        Label lblBank = new Label("30");
        grid.add(lblBank,40, 1);
        grid.add(lbl1,35,1);

        Label displayWinning = new Label();
        grid.add(displayWinning,40, 5);
        Label lbl2 = new Label("You won:");
        grid.add(lbl2, 35,5);


//====================================================================================================
        Label lose = new Label("You're out of funds, you lose \n hit cash out to start fresh");
        grid.add(lose,40,20);
        lose.setVisible(false);
        EventHandler<ActionEvent> defEvent = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent x)
            {
                displayWinning.setText("-10");
                String strSub = displayWinning.getText();
                String strbank = lblBank.getText();
                int intSub = Integer.parseInt(strSub);
                int intbank = Integer.parseInt(strbank);
                int total = intSub + intbank;
                String strTotal = Integer.toString(total);
                lblBank.setText(strTotal);
                
                Button source = (Button) x.getSource();
                source.setVisible(false);
                if(total <= 0)
                {
                    lose.setVisible(true);
                }
            }
        };
        //default cost (-10 pts) for each try
        visRec.setOnAction(defEvent);
        visRec2.setOnAction(defEvent);
        visRec3.setOnAction(defEvent);
        visRec4.setOnAction(defEvent);
        visRec5.setOnAction(defEvent);
        visRec6.setOnAction(defEvent);
        visRec7.setOnAction(defEvent);
        visRec8.setOnAction(defEvent);
        visRec9.setOnAction(defEvent);
        visRec10.setOnAction(defEvent);
        visRec11.setOnAction(defEvent);
        visRec12.setOnAction(defEvent);
        visRec13.setOnAction(defEvent);
        visRec14.setOnAction(defEvent);
        visRec15.setOnAction(defEvent);
        visRec16.setOnAction(defEvent);
        EventHandler<ActionEvent> event1 = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent x)
            {
                displayWinning.setText(lblp1.getText());
                String strAdd = displayWinning.getText();
                String strbank = lblBank.getText();
                int intadd = Integer.parseInt(strAdd);
                int intbank = Integer.parseInt(strbank);
                int total = intadd + intbank;
                String strTotal = Integer.toString(total);
                lblBank.setText(strTotal);

                Button source = (Button) x.getSource();
                source.setVisible(false);
            }
        };
        EventHandler<ActionEvent> event2 = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent x)
            {
                displayWinning.setText(lblp2.getText());
                String strAdd = displayWinning.getText();
                String strbank = lblBank.getText();
                int intadd = Integer.parseInt(strAdd);
                int intbank = Integer.parseInt(strbank);
                int total = intadd + intbank;
                String strTotal = Integer.toString(total);
                lblBank.setText(strTotal);

                Button source = (Button) x.getSource();
                source.setVisible(false);
            }
        };
        EventHandler<ActionEvent> event3 = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent x)
            {
                displayWinning.setText(lblp3.getText());
                String strAdd = displayWinning.getText();
                String strbank = lblBank.getText();
                int intadd = Integer.parseInt(strAdd);
                int intbank = Integer.parseInt(strbank);
                int total = intadd + intbank;
                String strTotal = Integer.toString(total);
                lblBank.setText(strTotal);

                Button source = (Button) x.getSource();
                source.setVisible(false);
            }
        };
//====================================================================================================

            //assigning
        int win = 0;
        int c = 0; //counter (3 winner buttons)
        //reassinging events for 3 or less buttons from subtracting -10 from winning prizes from tree
        while(c < 3)
        {
            win = winnerButton();
            if(win == 1){
                if(c == 0)
                    visRec.setOnAction(event1);
                else if (c== 1)
                    visRec.setOnAction(event2);
                else
                    visRec.setOnAction(event3);
            }   
            else if(win == 2){
                if(c == 0)
                    visRec2.setOnAction(event1);
                else if(c == 1)
                    visRec2.setOnAction(event2);
                else
                    visRec2.setOnAction(event3);
            }
            else if(win == 3){
                if(c == 0)
                    visRec3.setOnAction(event1);
                else if(c == 1)
                    visRec3.setOnAction(event2);
                else{
                    visRec3.setOnAction(event3);
                }
            }
            else if(win == 4){
                if(c == 0)
                    visRec4.setOnAction(event1);
                else if(c == 1)
                    visRec4.setOnAction(event2);
                else
                    visRec4.setOnAction(event3);
            }
            else if(win == 5){
                if(c == 0)
                    visRec5.setOnAction(event1);
                else if(c == 1)
                    visRec5.setOnAction(event2);
                else
                    visRec5.setOnAction(event3);
            }
            else if(win == 6){
                if(c == 0)
                    visRec6.setOnAction(event1);
                else if(c == 1)
                    visRec6.setOnAction(event2);
                else
                    visRec6.setOnAction(event3);
            }
            else if(win == 7){
                if(c == 0)
                    visRec7.setOnAction(event1);
                else if(c == 1)
                    visRec7.setOnAction(event2);
                else
                    visRec7.setOnAction(event3);
            }
            else if(win == 8){
                if(c == 0)
                    visRec8.setOnAction(event1);
                else if(c == 1)
                    visRec8.setOnAction(event2);
                else
                    visRec8.setOnAction(event3);
            }
            else if(win == 9){
                if(c == 0)
                    visRec9.setOnAction(event1);
                else if(c== 1)
                    visRec9.setOnAction(event2);
                else
                    visRec9.setOnAction(event3);
            }
            else if(win == 10){
                if(c == 0)
                    visRec10.setOnAction(event1);
                else if(c == 1)
                    visRec10.setOnAction(event2);
                else
                    visRec10.setOnAction(event3);
            }
            else if(win == 11){
                if(c == 0)
                    visRec11.setOnAction(event1);
                else if (c == 1)
                    visRec11.setOnAction(event2);
                else
                    visRec11.setOnAction(event3);
            }
            else if(win == 12){
                if(c == 0)
                    visRec12.setOnAction(event1);
                else if (c == 1)
                    visRec12.setOnAction(event2);
                else
                    visRec12.setOnAction(event3);
            }
            else if(win == 13){
                if(c == 0)
                    visRec13.setOnAction(event1);
                else if (c == 1)
                    visRec13.setOnAction(event2);
                else 
                    visRec13.setOnAction(event3);
            }
            else if(win == 14){
                if(c == 0)
                    visRec14.setOnAction(event1);
                else if (c == 1)
                    visRec14.setOnAction(event2);
                else
                    visRec14.setOnAction(event3);
            }
            else if(win == 15){
                if(c== 0)
                    visRec15.setOnAction(event1); 
                else if (c == 1)
                    visRec15.setOnAction(event2);
                else
                    visRec15.setOnAction(event3);
            }
            else{
                if(c == 0)
                    visRec16.setOnAction(event1);
                else if (c==1)
                    visRec16.setOnAction(event2);
                else
                    visRec16.setOnAction(event3);
            }
            c++;
        }
        //=========================================================
        Button cashOut = new Button("CASH OUT");
        //grid.add(lbl1,35,1)
        grid.add(cashOut,35, 15);
        
        EventHandler<ActionEvent> cashOutEvent = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent x)
            {
                String playerBank = lblBank.getText();
                start(primaryStage);
                lblBank.setText(playerBank);
            }
        };
        cashOut.setOnAction(cashOutEvent);
        //=========================================================
    
        gameLayout.getChildren().addAll(visRec,visRec2,visRec3,visRec4,visRec5,visRec6,visRec7,visRec8,visRec9,visRec10,visRec11,visRec12,visRec13,visRec14,visRec15,visRec16,lblBank,displayWinning,lbl1,lbl2,cashOut,lose);
    }
    public int winnerButton()  
    {
        Random ran = new Random();
        int winner = ran.nextInt(16) + 1;
        //System.out.println("chosen: " + winner);
        return winner;
    }
    public int amountWin(Label winnings)
    {
        int x = Integer.parseInt(winnings.getText());
        return x;
    }


}
