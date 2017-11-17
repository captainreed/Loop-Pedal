
/**
 * This is a loop pedal script that controlls the GUI and hardware connected to the pedal device
 * @author Brandon
 * @version Version 1.0.1
 */ 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.*;




public class Main
{


     static JLabel tester = new JLabel("this is a test",JLabel.CENTER); 
     static Sound player = new Sound();
    
    /**
     * Constructor for objects of class Haleys_Comet_master
     */
    public static void Main()
    {
            setupGui();
            initializeButtons();
            setButtonText(0);
            player.initialize();
            
            
        }
        
        public static void setupGui() {
               
        JFrame mainFrame = new JFrame("Haleys Comet");
        mainFrame.addWindowListener(new WindowAdapter(){ public void windowClosing(WindowEvent windowEvent){player.terminate(); System.exit(0);}});
        
        mainFrame.add(tester);
        mainFrame.setSize(400,400);
        mainFrame.setVisible(true);
        
    }
    
    public static void initializeButtons()    
    {
        
        GpioController gpio = GpioFactory.getInstance();
        
        GpioPinDigitalInput loop1 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_08,PinPullResistance.PULL_DOWN);
        loop1.setShutdownOptions(true);
        loop1.addListener(new GpioPinListenerDigital(){
            @Override public void handleGpioPinDigitalStateChangeEvent( GpioPinDigitalStateChangeEvent event) {buttonTriggered(1);}});
        
        GpioPinDigitalInput loop2 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_09,PinPullResistance.PULL_DOWN);
        loop2.setShutdownOptions(true);
        loop2.addListener(new GpioPinListenerDigital(){
            @Override public void handleGpioPinDigitalStateChangeEvent( GpioPinDigitalStateChangeEvent event) {buttonTriggered(2);}});
  
        
        GpioPinDigitalInput loop3 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_07,PinPullResistance.PULL_DOWN);
        loop3.setShutdownOptions(true);
        loop3.addListener(new GpioPinListenerDigital(){
            @Override public void handleGpioPinDigitalStateChangeEvent( GpioPinDigitalStateChangeEvent event) {buttonTriggered(3);}});
        
        GpioPinDigitalInput loop4 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_15,PinPullResistance.PULL_DOWN);
        loop4.setShutdownOptions(true);
        loop4.addListener(new GpioPinListenerDigital(){
            @Override public void handleGpioPinDigitalStateChangeEvent( GpioPinDigitalStateChangeEvent event) {buttonTriggered(4);}});
        
        GpioPinDigitalInput loop5 = gpio.provisionDigitalInputPin(RaspiPin.GPIO_16,PinPullResistance.PULL_DOWN);
        loop5.setShutdownOptions(true);
        loop5.addListener(new GpioPinListenerDigital(){
            @Override public void handleGpioPinDigitalStateChangeEvent( GpioPinDigitalStateChangeEvent event) {buttonTriggered(5);}});
        
        GpioPinDigitalInput trim = gpio.provisionDigitalInputPin(RaspiPin.GPIO_01,PinPullResistance.PULL_DOWN);
        trim.setShutdownOptions(true);
        trim.addListener(new GpioPinListenerDigital(){
            @Override public void handleGpioPinDigitalStateChangeEvent( GpioPinDigitalStateChangeEvent event) {buttonTriggered(6);}});
                
        GpioPinDigitalInput clear = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02,PinPullResistance.PULL_DOWN);
        clear.setShutdownOptions(true);
        clear.addListener(new GpioPinListenerDigital(){
            @Override public void handleGpioPinDigitalStateChangeEvent( GpioPinDigitalStateChangeEvent event) {buttonTriggered(7);}});
        
    }
    
        
        public static void buttonTriggered(int id)
        {
            
              setButtonText(id);
              player.buttonHandler(id);

           
        }
        
          public static void setButtonText(int id){
              int previousState = 1;
            if(id >0 && id<6){
                   tester.setText("Loop "+ Integer.toString(id) + " Active");   
                   previousState = id;
            }
            if( id==6)
            {
                tester.setText("change play mode");
                previousState = 1;
                
            }
           
            
            if( id==7)
            {
                tester.setText("reset");
                player.clip(previousState);
            }
           
             if( id==0)
            {
                tester.setText("No Active Loop");
                
            }
    }

    }
