package vn.viettuts.qlsv.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import vn.viettuts.qlsv.entity.Student;
import vn.viettuts.qlsv.entity.StudentXML;
import vn.viettuts.qlsv.utils.FileUtils;

/**
 * StudentDao class
 * 
 * @author viettuts.vn
 */
public class StudentDao {
    private static final String STUDENT_FILE_NAME = "student.xml";
    private List<Student> listStudents;

    public StudentDao() {
        this.listStudents = readListStudents();
        if (listStudents == null) {
            listStudents = new ArrayList<Student>();
        }
    }
    
    /**
     * Lưu các đối tượng student vào file student.xml
     * 
     * @param students
     */
    public void writeListStudents(List<Student> students) {
        StudentXML studentXML = new StudentXML();
        studentXML.setStudent(students);
        FileUtils.writeXMLtoFile(STUDENT_FILE_NAME, studentXML);
    }

    /**
     * Đọc các đối tượng student từ file student.xml
     * 
     * @return list student
     */
    public List<Student> readListStudents() {
        List<Student> list = new ArrayList<Student>();
        StudentXML studentXML = (StudentXML) FileUtils.readXMLFile(
                STUDENT_FILE_NAME, StudentXML.class);
        if (studentXML != null) {
            list = studentXML.getStudent();
        }
        return list;
    }
    

    /**
     * thêm student vào listStudents và lưu listStudents vào file
     * 
     * @param student
     */
   public void add(Student student) {
        int id = 1;
        if (listStudents != null && listStudents.size() > 0) {
            // Lấy STT lớn nhất hiện có trong danh sách sinh viên
            int maxId = listStudents.stream().mapToInt(Student::getId).max().getAsInt();
            // Tăng STT lên 1 đơn vị
            id = maxId + 1;
        }
        student.setId(id);
        listStudents.add(student);
        writeListStudents(listStudents);
    }

    /**
     * cập nhật student vào listStudents và lưu listStudents vào file
     * 
     * @param student
     */
    public void edit(Student student) {
        int size = listStudents.size();
        for (int i = 0; i < size; i++) {
            if (listStudents.get(i).getId() == student.getId()) {
                listStudents.get(i).setName(student.getName());
                listStudents.get(i).setAge(student.getAge());
                listStudents.get(i).setAddress(student.getAddress());
                listStudents.get(i).setGymsclass(student.getGymsclass());
                listStudents.get(i).setGymsroom(student.getGymsroom());
                listStudents.get(i).setTrainer(student.getTrainer());
                writeListStudents(listStudents);
                break;
            }
        }
    }

    /**
     * xóa student từ listStudents và lưu listStudents vào file
     * 
     * @param student
     */
    public boolean delete(Student student) {
        boolean isFound = false;
        int size = listStudents.size();
        for (int i = 0; i < size; i++) {
            if (listStudents.get(i).getId() == student.getId()) {
                student = listStudents.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            listStudents.remove(student);
            // Cập nhật lại ID của các sinh viên ở trên
            for (int i = 0; i < listStudents.size(); i++) {
                listStudents.get(i).setId(i + 1);
                }
            writeListStudents(listStudents);
            return true;
        }
        return false;
    }

    /**
     * sắp xếp danh sách student theo name theo tứ tự tăng dần
     */
    public void sortStudentByName() {
        Collections.sort(listStudents, new Comparator<Student>() {
            public int compare(Student student1, Student student2) {
                return student1.getName().compareTo(student2.getName());
            }
        });
    }

    /**
     * sắp xếp danh sách student theo Gymsclass theo tứ tự tăng dần
     */
    public void sortStudentByGymsclass() {
        Collections.sort(listStudents, new Comparator<Student>() {
            public int compare(Student student1, Student student2) {
                return student1.getGymsclass().compareTo(student2.getGymsclass());
            }
        });
    }

    
    /**
     * Tìm kiếm danh sách học sinh theo Name hoặc Address
     * @param keyword
     * @return 
     */
    public List<Student> seach(String keyword) {
        List<Student> resultList = new ArrayList<>();
        for (Student student : listStudents) {
            if (student.getName().toLowerCase().contains(keyword.toLowerCase()) || student.getAddress().toLowerCase().contains(keyword.toLowerCase())){
                resultList.add(student);
            }
        }
        return resultList;
    }
    
    public List<Student> getAllStudents() {
    return listStudents;
}

    
    public List<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(List<Student> listStudents) {
        this.listStudents = listStudents;
    }
}