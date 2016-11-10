import java.util.Hashtable;
class ProfileDB {
  private Hashtable<Integer, Profile> profiles;
  
  public ProfileDB(){
    profiles = new Hashtable<Integer, Profile>();
  }
  
  public Profile search(int id){
    return profiles.get((Integer) id);
  }
  public void add(int id, Profile prof){
    profiles.put((Integer) id, prof);
  }
  public Hashtable export(){
    return profiles;
  }
  public void remove(int id){
   profiles.remove(id);
  }
}
