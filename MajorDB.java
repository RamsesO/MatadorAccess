import java.util.Hashtable;
import java.io.Serializable;

class MajorDB implements Serializable{

    private static final long serialVersionUID = 9184085222891215235L;
    
    private Hashtable<Integer, Major> major;
    
    public Major search(Integer id) {
        return major.get(id);
    }
    
    public void add(Integer id, Major m) {
        major.put(id, m);
    }
    
    public void delete(Integer id, Major m) {
        major.remove(id, m);
    }
    
    public Hashtable<Integer, Major> export() {
        return major;
    }
    
}
