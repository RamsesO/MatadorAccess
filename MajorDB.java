import java.util.Hashtable;

class MajorDB {

    private Hashtable<Integer, Major> major;
    
    public Major search(Integer id) {
        return major.get(id);
    }
    
    public void add(Integer id, Major m) {
        courses.put(id, m);
    }
    
    public void delete(Integer id, Major m) {
        courses.remove(id, m);
    }
    
    public Hashtable<Integer, Major> export() {
        return major;
    }
    
}
