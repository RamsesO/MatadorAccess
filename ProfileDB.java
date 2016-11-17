import java.util.Hashtable;
import java.lang.File;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


class ProfileDB {
  private Hashtable<Integer, Profile> profiles;
  private Hashtable<String, Integer> stringTable;
  
  public ProfileDB(){
    profiles = new Hashtable<Integer, Profile>();
    stringTable = new Hashtable<String, Integer>();
  }
  
  public Profile search(Integer id){
    return profiles.get(id);
  }
  public Profile search(String name){
    return profiles.get(stringTable.get(name));
  }
  public void add(Profile prof){
    profiles.put(prof.getId(), prof);
    stringTable.put(prof.getName(), prof.getId());
  }

  public void remove(Integer id){
    String profileName = profiles.remove(id).getName();
    stringTable.remove(profileName);
  }
  public void remove(String profileName){
    profiles.remove(stringTable.get(profileName));
    stringTable.remove(profileName);
  }
  public Hashtable export(){
    return profiles;
  }
  public void importProfiles(String csvFile){
    BufferredReader reader = null;
    String line = "";
    String splitBy = ",";
    try{
      br = new BufferedReader(new FileReader(csvFile));
      while((line = br.readLine()) != null){
        String[] profile = line.split(splitBy);
      }
    } catch (FileNotFoundException e) {
            e.printStackTrace();
    } catch (IOException e) {
            e.printStackTrace();
    } finally {
        if (br != null) {
           try {
               br.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
        }
     } 
  }
}
