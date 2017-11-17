import javax.sound.sampled.*;

/**
 * Write a description of class Sound here.
 * 
 * @author Brandon
 * @version version 1.0.1
 */
public class Sound
{
    // each of the following variables corisponds to a state that one of the loops could be in
    private int buttonId;
    int[] activeLoops = {0,0,0,0,0,0,0};
    final int empty = 0;
    final int record = 1;
    final int loop = 2;
    final int pause = 3;
    
    // there will be 2 playback modes, recording or looping. when in looping mode only empty tracks
    //will be recordable pushing an existing track will only pause and start it from the begining
    String mode = "looping";
   
    private int previous = 0;

    /**
     * Constructor for objects of class Sound
     */
    public Sound()
    {
        initialize();
    } 
    
    
    
    public void buttonHandler(int id)
    {
        
        //set the button behaviors when the playback mode is set to loop
        if(mode=="looping")
        {
            if(id <6 && activeLoops[id-1] == empty)
        {
            activeLoops[id-1]=record;
        }
             
        else if(id <6 && activeLoops[id-1] == record)
        {
            activeLoops[id-1]=loop;
        }
            
        else if(id <6 && activeLoops[id-1] == loop)
        {
            activeLoops[id-1]=pause;
        }
        
        else if(id <6 && activeLoops[id-1] == pause)
        {
            activeLoops[id-1]=loop;
        }
        
        if(id == 6 && mode=="looping")
        {mode = "recording";}
        
           if(id==7)
        {totalReset();}
        
        }
        
        
        
    //set the button behaviors if the playback mode is set to record
        if(mode=="recording")
        {
            if(id <6 && activeLoops[id-1] == empty)
        {
            activeLoops[id-1]=record;
        }
             
        else if(id <6 && activeLoops[id-1] == record)
        {
            activeLoops[id-1]=loop;
        }
            
        else if(id <6 && activeLoops[id-1] == loop)
        {
            activeLoops[id-1]= pause;
        }
        
        else if(id <6 && activeLoops[id-1] == pause)
        {
            activeLoops[id-1]=record;
        }
        
        else if(id==6 && mode=="recording")
        {mode = "looping";}
        
             if(id==7)
        {totalReset();}
    }
        stateChange(activeLoops);
        }
        
        
    
    private void stateChange(int[] state)
    {
        
        
    }
    
    public void initialize()
    {
        
        
    }
    
    
    public void startLoop()
    {
        
        
    }
    
    public void endLoop()
    {
        
    }
    
    public void masterRecord()
    {
        
    }
    
    public void rerecord()
    {
        
    }
    
    public void totalReset()
    {
        
    }



    public void reset(int button)
    {
        
    }
    
    public int[] getActiveLoops()
    {
        
        return activeLoops;
        
    }
    
    public void terminate()
    {
        
        
    }
    
   

 
}
