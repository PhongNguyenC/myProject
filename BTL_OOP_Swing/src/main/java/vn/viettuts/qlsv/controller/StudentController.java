     package vn.viettuts.qlsv.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import vn.viettuts.qlsv.dao.StudentDao;
import vn.viettuts.qlsv.entity.Student;
import vn.viettuts.qlsv.view.StudentView;

public class StudentController {
    private StudentDao studentDao;
    private StudentView studentView;

    public StudentController(StudentView view) {
        this.studentView = view;
        studentDao = new StudentDao();

        view.addAddStudentListener(new AddStudentListener());
        view.addEdiStudentListener(new EditStudentListener());
        view.addDeleteStudentListener(new DeleteStudentListener());
        view.addClearListener(new ClearStudentListener());
        view.addSortStudentGymsclassListener(new SortStudentGymsclassListener());
        view.addSortStudentNameListener(new SortStudentNameListener());
        view.addListStudentSelectionListener(new ListStudentSelectionListener());
        view.addSeachStudentListener(new SeachStudentListener());
        view.addStatisticsListener(new StatisticsListener());
    }

    public void showStudentView() {
        List<Student> studentList = studentDao.getListStudents();
        studentView.setVisible(true);
        studentView.showListStudents(studentList);
    }

    /**
     * Lớp AddStudentListener 
     * chứa cài đặt cho sự kiện click button "Add"
     * 
     * @author viettuts.vn
     */
    class AddStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            if (student != null) {
                studentDao.add(student);
                studentView.showStudent(student);
                studentView.showListStudents(studentDao.getListStudents());
                studentView.showMessage("Thêm thành công!");
            }
        }
    }

    /**
     * Lớp EditStudentListener 
     * chứa cài đặt cho sự kiện click button "Edit"
     * 
     * @author viettuts.vn
     */
    class EditStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            if (student != null) {
                studentDao.edit(student);
                studentView.showStudent(student);
                studentView.showListStudents(studentDao.getListStudents());
                studentView.showMessage("Cập nhật thành công!");
            }
        }
    }

    /**
     * Lớp DeleteStudentListener 
     * chứa cài đặt cho sự kiện click button "Delete"
     * 
     * @author viettuts.vn
     */
    class DeleteStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            if (student != null) {
                studentDao.delete(student);
                studentView.clearStudentInfo();
                studentView.showListStudents(studentDao.getListStudents());
                studentView.showMessage("Xóa thành công!");
            }
        }
    }

    /**
     * Lớp ClearStudentListener 
     * chứa cài đặt cho sự kiện click button "Clear"
     * 
     * @author viettuts.vn
     */
    class ClearStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            studentView.clearStudentInfo();
        }
    }

    /**
     * Lớp SortStudentGPAListener 
     * chứa cài đặt cho sự kiện click button "Sort By Gymsclass"
     * 
     * @author viettuts.vn
     */
    class SortStudentGymsclassListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            studentDao.sortStudentByGymsclass();
            studentView.showListStudents(studentDao.getListStudents());
        }
    }

    /**
     * Lớp SortStudentGPAListener 
     * chứa cài đặt cho sự kiện click button "Sort By Name"
     * 
     * @author viettuts.vn
     */
    class SortStudentNameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            studentDao.sortStudentByName();
            studentView.showListStudents(studentDao.getListStudents());
        }
    }
    /**
     * Lớp ListStudentSelectionListener 
     * chứa cài đặt cho sự kiện chọn student trong bảng student
     * 
     * @author viettuts.vn
     */
    class ListStudentSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            studentView.fillStudentFromSelectedRow();
        }
    }
    
    /**
    * Lớp SreachStudentListener
    * chứa cài đặt sự kiện click button "Search"
    * tìm kiếm 
    */
    class SeachStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String keyword = studentView.getSeachName();
            List<Student> seachResult = studentDao.seach(keyword);
            studentView.showListStudents(seachResult);
        }
    }    

    /**
     * Lớp StatisticsListener
     * chứa cài đặt cho sự kiện click button "Statistics"
     * Thống kê
     */
    class StatisticsListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        List<Student> allStudents = studentDao.getAllStudents();
        int[] ageCount = new int[100];
        int maxAge = 0;
        for (Student student : allStudents) {
            int age = student.getAge();
            if (age > maxAge) {
                maxAge = age;
            }
            ageCount[age]++;
        }
        StringBuilder result = new StringBuilder();
        result.append("Thong ke tuoi sinh vien:\n");
        for (int i = 0; i <= maxAge; i++) {
            if (ageCount[i] > 0) {
                result.append("So nguoi ").append(i).append(" tuoi la: ").append(ageCount[i]).append("\n");
            }
        }
        JOptionPane.showMessageDialog(studentView, result.toString());
    }
}


}
