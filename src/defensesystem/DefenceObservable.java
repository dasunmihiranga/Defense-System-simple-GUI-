
package defensesystem;

import java.util.ArrayList;


public class DefenceObservable implements DefenseObservableInterface {
    private boolean areaMessage;
    private final ArrayList<Observer>observerList=new ArrayList<>();

    
    public void add(Observer ob){
        observerList.add(ob);
    }
    @Override
    public void setAreaUsage(boolean areaMessage){
        if(this.areaMessage!=areaMessage){
            this.areaMessage=areaMessage;
            notifyAreaMessage();
        }
        
    }
    @Override
    public void setMassage(String Mainmessage){
        for (Observer ob :observerList) {
            ob.Message(Mainmessage);
            
        }
        
    }
    
    public void notifyAreaMessage(){
        for (Observer ob : observerList) {
            ob.AreaUsage(areaMessage);
            
        }
        
    }
    

    @Override
    public void setStrength(Strength strength) {
        for (Observer ob : observerList) {
            ob.Strength(strength);
            
        }
       
    }

    @Override
    public int getAmmo(int num) {
        switch(num){
            case 1:
                return observerList.get(0).Ammo();
            case 2:
                return observerList.get(1).Ammo();
            case 3:
                return observerList.get(2).Ammo();
        }
        return -1;
        
        
    }

    @Override
    public int getSoldier(int num) {
        switch(num){
            case 1:
                return observerList.get(0).Soldier();
            case 2:
                return observerList.get(1).Soldier();
            case 3:
                return observerList.get(2).Soldier();
            
        }
        return -1;
    }

    @Override
    public void setPrivateMessage(String message, int num) {
       switch(num){
            case 1:
               observerList.get(0).PrivateMessage(message);
               break;
            case 2:
                observerList.get(1).PrivateMessage(message);
               break;
            case 3:
                observerList.get(2).PrivateMessage(message);
               break;
                
       }
    }

   
    
}
