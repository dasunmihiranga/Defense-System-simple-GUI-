
package defensesystem;

public class DefenseSystem {
    public static void main(String[] args) {
        
        DefenceObservable defenceObservable=new DefenceObservable();
        MainController mainController=new MainController(defenceObservable);
        
        Helicopter helicopter=new Helicopter(mainController, 1);
        Tank tank=new Tank(mainController, 2);
        Submarine submarine=new Submarine(mainController, 3);
      
        defenceObservable.add(helicopter);
        defenceObservable.add(tank);
        defenceObservable.add(submarine);
        mainController.setVisible(true);
      
        
    }
    
}
