import java.util.Hashtable;

class CourseDB {
    
    private Hashtable<String, Integer> stringTable;
    private Hashtable<Integer, Course> courses;
    
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
        courses.remove(stringTable.get(name).getCourseNum());
        stringTable.remove(name);
    }
    
    public Hashtable<Integer, Course> export() {
        return courses;
    }
    
}
