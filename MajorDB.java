import java.util.Hashtable;
import java.io.Serializable;

class MajorDB implements Serializable{

    private static final long serialVersionUID = 9184085222891215235L;
    
    private Hashtable<String, Integer> stringTable;
    private Hashtable<Integer, Major> majors;
    
    public MajorDB() {
        this.stringTable = new Hashtable<String, Integer>();
        this.majors = new Hashtable<Integer, Major>();
    }
    
    public Major search(Integer id) {
        return majors.get(id);
    }
    
    public Major search(String name) {
        return majors.get(stringTable.get(name));
    }
    
    public void add(Major mjr) {
        majors.put(mjr.getMajorId(), mjr);
        stringTable.put(mjr.getMajorName(), mjr.getMajorId());
    }
    
    public void delete(Integer id) {
        stringTable.remove(majors.get(id).getMajorId());
        majors.remove(id);
    }
    
    public void delete(String name) {
        majors.remove(stringTable.get(name));
        stringTable.remove(name);
    }
    
    public Hashtable<Integer, Major> export() {
        return majors;
    }
    
}
