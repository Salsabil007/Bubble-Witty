/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubble.witty;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Susmi
 */
public class BubbleWitty extends Application {
    Connection conn;
    int i=1;
    String a,b,c,d,e;
    int cllr=2;
    double score=0;
    double xCheck=300;
    double yCheck=628;
    int color=0;
    Text scr = new Text();
    int life=3;
    int h=40;
    double bestscore=0;
    int flag=0;
    Text ques = new Text("Are you a human ?");
     Text ques2 = new Text("Are you a monkey ?");
    
    
    
    
    @Override
    public void start(Stage primaryStage) throws SQLException {
        //CheckConnection();
        
        
        
        
        Rectangle life2 = new Rectangle(1140,10,120,30);
        life2.setFill(Color.GREEN);
        
        Rectangle d2 = new Rectangle(1260,10,0,30);
        d2.setFill(Color.RED);
        
        Text txt2= new Text(38,50,"SCORE :");
        txt2.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        txt2.setFill(Color.DARKMAGENTA);
        Text finalscr= new Text(700,250,"BEST SCORE :");
        finalscr.setFont(Font.font("Tahoma", FontWeight.BOLD, 60));
        scr.setX(120);
        scr.setY(50);
        scr.setText(String.format("%.0f",score));
        scr.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        
        Text fscr= new Text();
        fscr.setX(900);
        fscr.setY(350);
        fscr.setFont(Font.font("Tahoma", FontWeight.BOLD, 60));
        
        
        
        AnchorPane root = new AnchorPane();
        BackgroundImage backgroundImage ;        
        Image I=new Image("wall.png",1400,700,false,true);   
        ImageView i1=new ImageView(I);
        i1.setX(0);
        i1.setY(0);
        root.getChildren().add(i1);
       // backgroundImage=new  BackgroundImage(I,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
      //  Background background = new Background(backgroundImage);
       // root.setBackground(background);
        
        AnchorPane root1 = new AnchorPane();
        BackgroundImage backgroundImage1 ;        
        Image ii1=new Image("gameover.png");      
        backgroundImage1=new  BackgroundImage(ii1,BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT,BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        Background background1 = new Background(backgroundImage1);
        root1.setBackground(background1);
        root1.getChildren().addAll(finalscr,fscr);
        
        
        //ADDING BALLONS 
        
        ques.setX(500);
        ques.setY(40);
        ques.setFont(Font.font("Tahoma", FontWeight.BOLD, 22));
        ques.setFill(Color.DARKMAGENTA);
        
        ques2.setX(500);
        ques2.setY(40);
        ques2.setFont(Font.font("Tahoma", FontWeight.BOLD, 22));
        ques2.setFill(Color.DARKMAGENTA);
        
        BaloonCreate rblln = new BaloonCreate(670,868,cllr,1,root);       
        BaloonCreate bblln = new BaloonCreate(690,880,cllr+1,2,root);
        BaloonCreate gblln = new BaloonCreate(710,855,cllr+2,3,root);
        BaloonCreate wblln = new BaloonCreate(730,850,cllr+3,4,root);

        
        Rectangle rt = new Rectangle(38,9,30,15);
        rt.setFill(Color.RED);
        root.getChildren().addAll(rt,scr,txt2,life2,d2,ques);
        
        
        Scene mainscene=new Scene(root,1400,700);
        Scene gameover=new Scene(root1,1300,600);
        
        //baloon updating   
            CheckConnection();
       readQues(1); 
        
       new AnimationTimer()
        {
            @Override
            public void handle(long now) {
                if(score==0)
                {
                    ques.setText(a);
                    rblln.updateAns(b);
                    gblln.updateAns(c);
                    bblln.updateAns(d);
                    wblln.updateAns(e);
                    xCheck = rblln.getXpos();
                    yCheck= rblln.getYpos();
                }
                
                if(score<=5)
                {
                    
                    rblln.UpdatePos(2);
                    
                    gblln.UpdatePos(2);
                    
                    bblln.UpdatePos(2);
                    
                    wblln.UpdatePos(2);
                    
                    
                    System.out.println(xCheck + "  " + yCheck);
                }
                else if(score<=15)
                {
                    gblln.UpdatePos(2.8);
                    bblln.UpdatePos(2.8);
                    wblln.UpdatePos(2.8);
                }
                else if(score<=30)
                {
                    rblln.UpdatePos(4);
                
                    gblln.UpdatePos(4);
                    bblln.UpdatePos(4);
                    wblln.UpdatePos(4);
                }
                else
                {
                    rblln.UpdatePos(5.5);
                
                    gblln.UpdatePos(5.5);
                    bblln.UpdatePos(5.5);
                    wblln.UpdatePos(5.5);
                }
                 /*if(color==0)
                    {
                        xCheck = (rblln.getXpos())+30;
                        yCheck = rblln.getYpos();
                    }
                    if(color==1)
                    {
                       
                        xCheck = (bblln.getXpos())+30;
                        yCheck = bblln.getYpos();
                    }
                    
                    if(color==2)
                    {
                       
                        xCheck = (gblln.getXpos())+30;
                        yCheck = gblln.getYpos();
                    }*/
                    
                    
                    
                
                mainscene.setOnMouseClicked(event->{
                    double mouseX= event.getX();
                    double mouseY = event.getY();
                    
                    System.out.println(mouseX + "xcoordinate");
                    System.out.println(mouseY + "ycoordinate");
                    double Uprad=rblln.getRadiuss();
                    
                   if(((xCheck-Uprad)<=mouseX && mouseX<=xCheck+Uprad) && (yCheck-Uprad<=mouseY && mouseY<=yCheck+Uprad))
                    {
                        
                    // Media music3=new Media("file:///C:/Users/Susmi/Downloads/Balloon pop sound effect.mp3");
                    //MediaPlayer m3=new MediaPlayer(music3);
                        
                        score++;
                        i++;
                    try {
                        readQues(i);
                    } catch (SQLException ex) {
                        Logger.getLogger(BubbleWitty.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    Random rndd = new Random();
                    int Rightblln = rndd.nextInt(4);
                    if(Rightblln==0)
                    {
                        ques.setText(a);
                    rblln.updateAns(b);
                    gblln.updateAns(c);
                    bblln.updateAns(d);
                    wblln.updateAns(e);
                    xCheck = rblln.getXpos();
                    yCheck= rblln.getYpos();
                    }
                 
                    
                    if(Rightblln==1)
                    {
                        ques.setText(a);
                    rblln.updateAns(e);
                    gblln.updateAns(c);
                    bblln.updateAns(d);
                    wblln.updateAns(b);
                    xCheck = wblln.getXpos();
                    yCheck= wblln.getYpos();
                    }
                    
                    if(Rightblln==2)
                    {
                        ques.setText(a);
                    rblln.updateAns(c);
                    gblln.updateAns(b);
                    bblln.updateAns(d);
                    wblln.updateAns(e);
                    xCheck = gblln.getXpos();
                    yCheck= gblln.getYpos();
                    }
                    
                    if(Rightblln==3)
                    {
                        ques.setText(a);
                    rblln.updateAns(d);
                    gblln.updateAns(c);
                    bblln.updateAns(b);
                    wblln.updateAns(e);
                    xCheck = bblln.getXpos();
                    yCheck= bblln.getYpos();
                    }
                    
                        scr.setText(String.format("%.0f",score));
                        if(score>bestscore)
                            bestscore=score;
                        
                        System.out.println(mouseX);
                        System.out.println(mouseY);
                        /*double xx = gblln.getiniXpos();
                        double yy = rblln.getiniXpos();
                        rblln.setiniXpos(xx);
                        gblln.setiniXpos(yy);
                    
                    
                        double zz = gblln.getiniXpos();
                        double kk = bblln.getiniXpos();
                        bblln.setiniXpos(zz);
                        gblln.setiniXpos(kk);*/
                    
                    
                    
                    
                        rblln.setiniXY();
                        bblln.setiniXY();
                        gblln.setiniXY();
                        wblln.setiniXY();
                        
                        rblln.setRadiuss(5);
                        bblln.setRadiuss(5);
                        gblln.setRadiuss(5);
                        wblln.setRadiuss(5);
                        
                        Random srand = new Random();
                        color = srand.nextInt(11);
                        rblln.setColorr(color);
                        bblln.setColorr((color+1)%11);
                        gblln.setColorr((color+2)%11);
                        wblln.setColorr((color+3)%11);
                        System.out.println(color +"ayeshar random");
                    
                        /*if(color==0)
                        {
                            rt.setFill(Color.RED);
                            xCheck = (rblln.getXpos())+30;
                            yCheck = rblln.getYpos();
                        }
                        else if(color==1)
                        {
                            rt.setFill(Color.BLUE);
                            xCheck = (bblln.getXpos())+30;
                            yCheck = bblln.getYpos();
                        }
                    
                        else if(color==2)
                        {
                            rt.setFill(Color.GREEN);
                            xCheck = (gblln.getXpos())+30;
                            yCheck = gblln.getYpos();
                        }*/
                    
                        
                    }
                    
                    
                    
                });
                
                    
                
                
                
                if(rblln.getYpos()<-150)
                {
                    i++;
                    try {
                        readQues(i);
                    } catch (SQLException ex) {
                        Logger.getLogger(BubbleWitty.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Random srand1 = new Random();
                    cllr = srand1.nextInt(11);
                    
                        rblln.setColorr(cllr);
                        bblln.setColorr((cllr+1)%11);
                        gblln.setColorr((cllr+2)%11);
                        wblln.setColorr((cllr+3)%11);
                    
                    
                    
                    life--;
                    d2.setX(1260-h);
                    d2.setWidth(h);
                    h=h+40;
                    score=0;
                    scr.setText(String.format("%.0f",score));
                   /* if(life==0)
                    {
                        fscr.setText(String.format("%.0f",bestscore));
                       primaryStage.setScene(gameover);
                       
                    }*/
                    
                    
                    Random srand = new Random();
                    color = srand.nextInt(3);
                    System.out.println(color +"ayeshar random");
                    
                    /*if(color==0)
                    {
                        rt.setFill(Color.RED);
                        xCheck = (rblln.getXpos())+30;
                        yCheck = rblln.getYpos();
                    }
                    else if(color==1)
                    {
                        rt.setFill(Color.BLUE);
                        xCheck = (bblln.getXpos())+30;
                        yCheck = bblln.getYpos();
                    }
                    
                    else if(color==2)
                    {
                        rt.setFill(Color.GREEN);
                        xCheck = (gblln.getXpos())+30;
                        yCheck = gblln.getYpos();
                    }*/
                    
                    
                    /*double xx = gblln.getiniXpos();
                    double yy = rblln.getiniXpos();
                    rblln.setiniXpos(xx);
                    gblln.setiniXpos(yy);
                    
                    
                    double zz = gblln.getiniXpos();
                    double kk = bblln.getiniXpos();
                    bblln.setiniXpos(zz);
                    gblln.setiniXpos(kk);*/
                    
                    
                    
                    
                    rblln.setiniXY();
                    bblln.setiniXY();
                    gblln.setiniXY();
                    wblln.setiniXY();
                    
                    rblln.setRadiuss(5);
                    bblln.setRadiuss(5);
                    gblln.setRadiuss(5);
                    wblln.setRadiuss(5);
                    
                    
                }
                
            }
            
        }.start();
      
        
               
        
        
        
        
        
        
        
        
        
        
        
        //FOR FINDING A POINTS CO-ORDINATE
        mainscene.setOnMouseClicked(event->{
            System.out.println(event.getX());
            System.out.println(event.getY());           
        });
        
        
        
        
        
        primaryStage.setTitle("");
        primaryStage.setScene(mainscene);
        
        
        primaryStage.show();
        
        
        
        

    }
    
        public void CheckConnection()
    {
        conn = DBconnectionW.DbConnector();
        if(conn == null)
        {
            System.out.println("no");
            //System.exit(1);
        }
        else 
        {
            System.out.println("bngo");
        }
    }
    
    public void readQues(int ii) throws SQLException
    {
        conn = DBconnectionW.DbConnector();
        Statement st=conn.createStatement();
        
        int xxxx=2;
        String s1=Integer.toString(ii);
        
       String s="SELECT * FROM newTable WHERE id="+s1;
       ResultSet rs = st.executeQuery(s);
       while(rs.next())
       {
           int x = (rs.getInt("id"));
           a=(rs.getString("ques"));
           System.out.println(a);
           b=(rs.getString("a"));
           System.out.println(b);
           c=(rs.getString("w1"));
           System.out.println(c);
           d=(rs.getString("w2"));
           System.out.println(d);
           e=(rs.getString("w3"));
           System.out.println(e);
     }
       rs.close();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
}

