/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SourceCode;
import java.io.*;
import javazoom.jl.player.Player;
import javazoom.jl.decoder.JavaLayerException;
import java.util.logging.*;
import javax.swing.JOptionPane;
/**
 *
 * @author ankur
 */
public class MusicClass {
    FileInputStream FIS;
    BufferedInputStream BIS;
    
    public Player  player;
    public long pauseLocation;
    public long songTotalLength;
    public String filelocation;
    
    public void stop()
    {
        if(player != null)
        {
            player.close();
            
        }
        
        
    }
    
    
    
    public void pause()
    {
        if(player != null)
        {
            try {
                pauseLocation=FIS.available();
                player.close();
            } catch (IOException ex) {
                Logger.getLogger(MusicClass.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
    }
    public void Resume()
    {
        try {  
            FIS=new FileInputStream(filelocation);
            BIS=new BufferedInputStream(FIS);   
            player= new Player(BIS);
            FIS.skip(songTotalLength-pauseLocation );
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Play");
        }
        
        new Thread()
        {
         @Override
         public void run()
         {
             try {
                 player.play();
             } catch (JavaLayerException ex) {
                 JOptionPane.showMessageDialog(null,"error ");
                  
                
             }
             
             
             
         }
            
            
        }.start();
        
        
    }
    
    public void play(String path)
    {
        try {  
            FIS=new FileInputStream(path);
            BIS=new BufferedInputStream(FIS);   
            player= new Player(BIS);
            songTotalLength=FIS.available();
            filelocation=path+"";
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Play");
        }
        
        new Thread()
        {
         @Override
         public void run()
         {
             try {
                 player.play();
             } catch (JavaLayerException ex) {
                 JOptionPane.showMessageDialog(null,"error ");
                  
                
             }
             
             
             
         }
            
            
        }.start();
        
        
    }
    
}
