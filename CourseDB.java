import java.util.Hashtable;
import java.io.Serializable;

class CourseDB implements Serializable{
    
    private static final long serialVersionUID = 1902501367567782416L;

    private Hashtable<String, Integer> stringTable;
    private Hashtable<Integer, Course> courses;
    
    public CourseDB() {
        this.stringTable = new Hashtable<String, Integer>();
        this.courses = new Hashtable<Integer, Course>();
    }
    
    public Course search(Integer id) {
        return courses.get(id);
    }
    
    public Course search(String name) {
        return courses.get(stringTable.get(name));
    }
    
    public void add(Course crs) {
        courses.put(crs.getCourseNum(), crs);
        stringTable.put(crs.getName(), crs.getCourseNum());
    }
    
    public void delete(Integer id) {
        stringTable.remove(courses.get(id).getCourseNum());
        courses.remove(id);
    }
    
    public void delete(String name) {
        courses.remove(stringTable.get(name));
        stringTable.remove(name);
    }
    
    public Hashtable<Integer, Course> export() {
        return courses;
    }
    
}
