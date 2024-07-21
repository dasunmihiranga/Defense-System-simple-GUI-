package defensesystem;
public interface Observer {
    public void AreaUsage(boolean areaMessage);
    public void Message(String Mainmessage);
    public void Strength(Strength strength);
    public int Ammo();
    public int Soldier();
    public void PrivateMessage(String message);
    
}
