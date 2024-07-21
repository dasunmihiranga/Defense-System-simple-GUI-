
package defensesystem;

public interface DefenseObservableInterface {
    public void setAreaUsage(boolean AreaMessage);
    public void setMassage(String message);
    public void setStrength(Strength strength);
    public int getAmmo(int num);
    public int getSoldier(int num);
    public void setPrivateMessage(String message,int num);
    
    
}
