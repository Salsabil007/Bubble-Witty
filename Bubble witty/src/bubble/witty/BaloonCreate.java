/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bubble.witty;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author Susmi
 */
public class BaloonCreate {
    public int xspd;
    public int clrr;
    public double radius;
    public Circle circle;
    public double iniX;
    public double iniY;
    public double inc=50;
    public Text ans= new Text("Yess");
    BaloonCreate(int x,int y,int clr,int spd, AnchorPane rt)
    {
        xspd=spd;
        ans.setX(x-10);
        ans.setY(y);
        ans.setFont(Font.font("Tahoma", FontWeight.BOLD,2));
        ans.setFill(Color.RED);
        clrr=clr;
        iniX=x;
        iniY=y;
        circle = new Circle(x, y,5);
        if(clrr  == 0)
        {
            circle.setFill(Color.CORNSILK);
        }
        if(clrr  == 1)
        {
            circle.setFill(Color.ANTIQUEWHITE);
        }
        if(clrr  == 2)
        {
            circle.setFill(Color.YELLOW);
        }
        if(clrr  == 3)
        {
            circle.setFill(Color.DARKGREY);
        }
        if(clrr  == 4)
        {
            circle.setFill(Color.THISTLE);
        }
        if(clrr  == 5)
        {
            circle.setFill(Color.CYAN);
        }
        if(clrr  == 6)
        {
            circle.setFill(Color.DARKKHAKI);
        }
        if(clrr  == 7)
        {
            circle.setFill(Color.DARKTURQUOISE);
        }
        if(clrr  == 8)
        {
            circle.setFill(Color.YELLOWGREEN);
        }
        if(clrr  == 9)
        {
            circle.setFill(Color.THISTLE);
        }
        if(clrr  == 10)
        {
            circle.setFill(Color.SEASHELL);
        }
        radius=5;
       //Button button = new Button("Red");
       //button.setOnAction(e -> circle.setFill(Color.BLUE));
       // rt.getChildren().add(Im);
       rt.getChildren().addAll(circle,ans);
        
    }
    
    void setColorr(int clrrr)
    {
       if(clrrr  == 0)
        {
            circle.setFill(Color.CORNSILK);
        }
        if(clrrr  == 1)
        {
            circle.setFill(Color.ANTIQUEWHITE);
        }
        if(clrrr  == 2)
        {
            circle.setFill(Color.YELLOW);
        }
        if(clrrr  == 3)
        {
            circle.setFill(Color.DARKGREY);
        }
        if(clrrr  == 4)
        {
            circle.setFill(Color.AQUA);
        }
        if(clrrr  == 5)
        {
            circle.setFill(Color.CYAN);
        }
        if(clrrr  == 6)
        {
            circle.setFill(Color.DARKKHAKI);
        }
        if(clrrr  == 7)
        {
            circle.setFill(Color.DARKTURQUOISE);
        }
        if(clrrr  == 8)
        {
            circle.setFill(Color.YELLOWGREEN);
        }
        if(clrrr  == 9)
        {
            circle.setFill(Color.THISTLE);
        }
        if(clrrr  == 10)
        {
            circle.setFill(Color.SEASHELL);
        } 
    }
    
    void updateAns(String ss)
    {
        ans.setText(ss);
    }
    
    
    void UpdatePos(double y)
    {
       // Im.setY(Im.getY()-y);
        double fX=0;
        double b=circle.getCenterY()-y;
        if(xspd==1)
        {
            fX= circle.getCenterX()-y/1.5;            
        }
        else if(xspd==2)
        {
            fX= circle.getCenterX()-y/5;
        }
        else if(xspd==3)
        {
            fX= circle.getCenterX()+y/5;
        }
        else if(xspd==4)
        {
            fX= circle.getCenterX()+y/1.5;
        }
        circle.setCenterX(fX);
        ans.setY(b);
        ans.setX(fX);
        radius=radius+(y/9);
        ans.setFont(Font.font("Tahoma", FontWeight.BOLD,radius/4));
        circle.setRadius(radius);
        circle.setCenterY(b);
    }
    double getRadiuss()
    {
        return radius;
    }
    void setRadiuss(double r)
    {
        radius=r;
    }
    void setXpos(double x)
    {
        circle.setCenterX(x);
    }
    void setYpos(double y)
    {
       circle.setCenterY(y);
    }
    
    double getXpos()
    {
        return circle.getCenterX();
    }
    double getYpos()
    {
        return circle.getCenterY();
    }
    double getiniXpos()
    {
        return iniX;
        
    }
    void setiniXpos(double x)
    {
        inc= (-1)*inc;
        iniX=x+inc;
    }
    
    void setiniXY()
    {
        circle.setCenterX(iniX);
        circle.setCenterY(iniY);
    }
    
    
    
}
