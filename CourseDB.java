import java.util.Hashtable;

class CourseDB {

    private Hashtable<Integer, Course> courses;
    
    public Course search(Integer id) {
        return courses.get(id);
    }
    
    public void add(Integer id, Course crs) {
        courses.put(id, crs);
    }
    
    public void delete(Integer id) {
        courses.remove(id);
    }
    
    public Hashtable<Integer, Course> export() {
        return courses;
    }
    
}
