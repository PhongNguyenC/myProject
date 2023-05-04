package vn.viettuts.qlsv.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


import vn.viettuts.qlsv.entity.Student;

public class StudentView extends JFrame implements ActionListener, ListSelectionListener {
    private static final long serialVersionUID = 1L;
    private JButton addStudentBtn;
    private JButton editStudentBtn;
    private JButton deleteStudentBtn;
    private JButton clearBtn;
    private JButton sortStudentGymsclassBtn;
    private JButton sortStudentNameBtn;
    private JScrollPane jScrollPaneStudentTable;
    private JScrollPane jScrollPaneAddress;
    private JTable studentTable;
    private JButton seachStudentBtn;
    private JButton statisticsBtn;
    
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel addressLabel;
    private JLabel gymsclassLabel;
    private JLabel gymsroomLabel;
    private JLabel trainerLabel;
    
    private JTextField idField;
    private JTextField nameField;
    private JTextField ageField;
    private JTextArea addressTA;

    private JComboBox<String> gymsroomComboBox;
    private JTextField trainerField;
    private JTextField seachStudentField;
    private JComboBox<String> gymsclassComboBox;
    
    // định nghĩa các cột của bảng student
    private String [] columnNames = new String [] {
            "STT", "Tên", "Tuổi", "Địa chỉ", "Loại hình ", "Phòng tập", "HLV"};
    // định nghĩa dữ liệu mặc định của bẳng student là rỗng
    private Object data = new Object [][] {};
    
    public StudentView() {
        initComponents();
    }
    
   

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        // khởi tạo các phím chức năng
        addStudentBtn = new JButton("Thêm");
        editStudentBtn = new JButton("Sửa");
        deleteStudentBtn = new JButton("Xóa");
        clearBtn = new JButton("Làm Mới");
        sortStudentGymsclassBtn = new JButton("Sắp Xếp Loại Hình");
        sortStudentNameBtn = new JButton("Sắp Xếp Tên");
        seachStudentBtn = new JButton("Tìm Kiếm");
        statisticsBtn = new JButton("Thống Kê");
        // khởi tạo bảng student
        jScrollPaneStudentTable = new JScrollPane();
        studentTable = new JTable();
        
        // khởi tạo các label
        idLabel = new JLabel("STT");
        nameLabel = new JLabel("Tên");
        ageLabel = new JLabel("Tuổi");
        addressLabel = new JLabel("Địa Chỉ");
        gymsclassLabel = new JLabel("Loại Hình");
        gymsroomLabel = new JLabel("Phòng tập");
        trainerLabel = new JLabel("HLV");
        // khởi tạo các trường nhập dữ liệu cho student
        idField = new JTextField(6);
        idField.setEditable(false);
        nameField = new JTextField(15);
        ageField = new JTextField(6);
        addressTA = new JTextArea();
        addressTA.setColumns(15);
        addressTA.setRows(5);
        jScrollPaneAddress = new JScrollPane();
        jScrollPaneAddress.setViewportView(addressTA);
        gymsclassComboBox = new JComboBox();
        gymsroomComboBox = new JComboBox();
        trainerField = new JTextField(15);
        seachStudentField = new JTextField(15);
        
//        Thêm item cho combobox gymsclass
        gymsclassComboBox.addItem("Tăng Cân");
        gymsclassComboBox.addItem("Giảm Cân");
        gymsclassComboBox.addItem("YoGa");
        gymsclassComboBox.addItem("Cơ Chân");
        gymsclassComboBox.addItem("Cơ Tay");
        gymsclassComboBox.addItem("Toàn Thân");
        
//        Thêm item cho combobox 
        gymsroomComboBox.addItem("Phòng 1");
        gymsroomComboBox.addItem("Phòng 2");
        gymsroomComboBox.addItem("Phòng 4");
        gymsroomComboBox.addItem("Phòng 5");
        gymsroomComboBox.addItem("Phòng 6");
        gymsroomComboBox.addItem("Phòng 7");
        gymsroomComboBox.addItem("Phòng 8");
        

        
        // cài đặt các cột và data cho bảng student
        studentTable.setModel(new DefaultTableModel((Object[][]) data, columnNames));
        jScrollPaneStudentTable.setViewportView(studentTable);
        jScrollPaneStudentTable.setPreferredSize(new Dimension (700, 300));
        
         // tạo spring layout
        SpringLayout layout = new SpringLayout();
        // tạo đối tượng panel để chứa các thành phần của màn hình quản lý Student
        JPanel panel = new JPanel();
        panel.setSize(800, 400);
        panel.setLayout(layout);
        panel.add(jScrollPaneStudentTable);
        
        panel.add(addStudentBtn);
        panel.add(editStudentBtn);
        panel.add(deleteStudentBtn);
        panel.add(clearBtn);
        panel.add(sortStudentGymsclassBtn);
        panel.add(sortStudentNameBtn);
        panel.add(seachStudentBtn);
        panel.add(statisticsBtn);
        
        panel.add(idLabel);
        panel.add(nameLabel);
        panel.add(ageLabel);
        panel.add(addressLabel);
        panel.add(gymsclassLabel);
        panel.add(gymsroomLabel);
        panel.add(trainerLabel);
        
        panel.add(idField);
        panel.add(nameField);
        panel.add(ageField);
        panel.add(jScrollPaneAddress);
        panel.add(gymsclassComboBox);
        panel.add(gymsroomComboBox);
        panel.add(trainerField);
        panel.add(seachStudentField);
        
        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 50, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 75, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ageLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ageLabel, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, addressLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addressLabel, 125, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, gymsclassLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, gymsclassLabel, 217, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, gymsroomLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, gymsroomLabel, 248, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, trainerLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, trainerLabel, 280, SpringLayout.NORTH, panel);
        
        
        layout.putConstraint(SpringLayout.WEST, idField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idField, 50, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameField, 75, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ageField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ageField, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, jScrollPaneAddress, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneAddress, 125, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, gymsclassComboBox, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, gymsclassComboBox, 215, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, gymsroomComboBox, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, gymsroomComboBox, 247, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, trainerField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, trainerField, 280, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, seachStudentField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, seachStudentField, 10, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, jScrollPaneStudentTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneStudentTable, 10, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, addStudentBtn, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addStudentBtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editStudentBtn, 70, SpringLayout.WEST, addStudentBtn);
        layout.putConstraint(SpringLayout.NORTH, editStudentBtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteStudentBtn, 62, SpringLayout.WEST, editStudentBtn);
        
        layout.putConstraint(SpringLayout.NORTH, clearBtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearBtn, 60, SpringLayout.WEST, deleteStudentBtn);
        
        layout.putConstraint(SpringLayout.NORTH, deleteStudentBtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sortStudentGymsclassBtn, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sortStudentGymsclassBtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sortStudentNameBtn, 150, SpringLayout.WEST, sortStudentGymsclassBtn);
        layout.putConstraint(SpringLayout.NORTH, sortStudentNameBtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, seachStudentBtn, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, seachStudentBtn, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, statisticsBtn, 570, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, statisticsBtn, 330, SpringLayout.NORTH, panel);
        
        this.add(panel);
        this.pack();
        this.setTitle("Student GYMS");
        this.setSize(1040, 420);
        // disable Edit and Delete buttons
        editStudentBtn.setEnabled(false);
        deleteStudentBtn.setEnabled(false);
        // enable Add button
        addStudentBtn.setEnabled(true);
    }
    
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    /**
     * hiển thị list student vào bảng studentTable
     * 
     * @param list
     */
    public void showListStudents(List<Student> list) {
        int size = list.size();
        // với bảng studentTable có 7 cột, 
        // khởi tạo mảng 2 chiều students, trong đó:
        // số hàng: là kích thước của list student 
        // số cột: là  
        Object [][] students = new Object[size][7];
        for (int i = 0; i < size; i++) {
            students[i][0] = list.get(i).getId();
            students[i][1] = list.get(i).getName();
            students[i][2] = list.get(i).getAge();
            students[i][3] = list.get(i).getAddress();
            students[i][4] = list.get(i).getGymsclass();
            students[i][5] = list.get(i).getGymsroom();
            students[i][6] = list.get(i).getTrainer();
           
        }
        studentTable.setModel(new DefaultTableModel(students, columnNames));
    }
    
    
    /**
     * điền thông tin của hàng được chọn từ bảng student 
     * vào các trường tương ứng của student.
     */
    public void fillStudentFromSelectedRow() {
        // lấy chỉ số của hàng được chọn 
        int row = studentTable.getSelectedRow();
        if (row >= 0) {
            idField.setText(studentTable.getModel().getValueAt(row, 0).toString());
            nameField.setText(studentTable.getModel().getValueAt(row, 1).toString());
            ageField.setText(studentTable.getModel().getValueAt(row, 2).toString());
            addressTA.setText(studentTable.getModel().getValueAt(row, 3).toString());
            gymsclassComboBox.setSelectedItem(studentTable.getModel().getValueAt(row, 4).toString());
            gymsroomComboBox.setSelectedItem(studentTable.getModel().getValueAt(row, 5).toString());
            trainerField.setText(studentTable.getModel().getValueAt(row, 6).toString());
            
            
            // enable Edit and Delete buttons
            editStudentBtn.setEnabled(true);
            deleteStudentBtn.setEnabled(true);
            // disable Add button
            addStudentBtn.setEnabled(false);
        }
    }

    /**
     * xóa thông tin student
     */
    public void clearStudentInfo() {
        idField.setText("");
        nameField.setText("");
        ageField.setText("");
        addressTA.setText("");
        gymsclassComboBox.setSelectedItem("");
        gymsroomComboBox.setSelectedItem("");
        trainerField.setText("");
        // disable Edit and Delete buttons
        editStudentBtn.setEnabled(false);
        deleteStudentBtn.setEnabled(false);
        // enable Add button
        addStudentBtn.setEnabled(true);
    }
    
    /**
     * hiện thị thông tin student
     * 
     * @param student
     */
    public void showStudent(Student student) {
        idField.setText("" + student.getId());
        nameField.setText(student.getName());
        ageField.setText("" + student.getAge());
        addressTA.setText(student.getAddress());
        gymsclassComboBox.setSelectedItem("" + student.getGymsclass());
       
        gymsroomComboBox.setSelectedItem("" + student.getGymsroom());
        trainerField.setText("" + student.getTrainer());
        // enable Edit and Delete buttons
        editStudentBtn.setEnabled(true);
        deleteStudentBtn.setEnabled(true);
        // disable Add button
        addStudentBtn.setEnabled(false);
    }
   
    public String getSeachName() {
        return seachStudentField.getText();
    }
    /**
     * lấy thông tin student
     * 
     * @return
     */
    public Student getStudentInfo() {
        // validate student
        if (!validateName() || !validateAge() || !validateAddress() || !validateGymsclass() || !validateGymsroom() || !validateTrainer()) {
            return null;
        }
        try {
            Student student = new Student();
            if (idField.getText() != null && !"".equals(idField.getText())) {
                student.setId(Integer.parseInt(idField.getText()));
            }
            student.setName(nameField.getText().trim());
            student.setAge(Byte.parseByte(ageField.getText().trim()));
            student.setAddress(addressTA.getText().trim());
            student.setGymsclass((String) gymsclassComboBox.getSelectedItem());
            student.setGymsroom((String) gymsroomComboBox.getSelectedItem());
            student.setTrainer(trainerField.getText().trim());
            return student;
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }
    
    private boolean validateName() {
        String name = nameField.getText();
        if (name == null || "".equals(name.trim())) {
            nameField.requestFocus();
            showMessage("Tên không được trống.");
            return false;
        }
        return true;
    }
    
    private boolean validateAddress() {
        String address = addressTA.getText();
        if (address == null || "".equals(address.trim())) {
            addressTA.requestFocus();
            showMessage("Địa chỉ không được trống.");
            return false;
        }
        return true;
    }
    
    private boolean validateAge() {
        try {
            Byte age = Byte.parseByte(ageField.getText().trim());
            if (age < 0 || age > 100) {
                ageField.requestFocus();
                showMessage("Tuổi không hợp lệ, Tuổi nên trong khoảng 0 đến 100.");
                return false;
            }
        } catch (Exception e) {
            ageField.requestFocus();
            showMessage("Tuổi không hợp lệ!");
            return false;
        }
        return true;
    }
    
    private boolean validateGymsclass() {
            String gymsclass = (String) gymsclassComboBox.getSelectedItem();
             if (gymsclass.equals(null)) {
            gymsclassComboBox.requestFocus();
            showMessage("Loại hình không được trống.");
            return false;
             }
        return true;
    }
    

    
    
    private boolean validateGymsroom() {
            String gymsroom = (String) gymsroomComboBox.getSelectedItem();
             if (gymsroom == null || "".equals(gymsroom.trim())) {
            gymsroomComboBox.requestFocus();
            showMessage("Phòng tập không được trống.");
            return false;
             }
        return true;
    }
    
    private boolean validateTrainer() {
            String trainer = trainerField.getText().trim();
            if (trainer == null || "".equals(trainer.trim())) {
            trainerField.requestFocus();
            showMessage("Huấn luyện viên không được trống.");
            return false;
             }
        return true;
    }
    
    public void actionPerformed(ActionEvent e) {
    }
    
    public void valueChanged(ListSelectionEvent e) {
    }
    
    public void addAddStudentListener(ActionListener listener) {
        addStudentBtn.addActionListener(listener);
    }
    
    public void addEdiStudentListener(ActionListener listener) {
        editStudentBtn.addActionListener(listener);
    }
    
    public void addDeleteStudentListener(ActionListener listener) {
        deleteStudentBtn.addActionListener(listener);
    }
    
    public void addClearListener(ActionListener listener) {
        clearBtn.addActionListener(listener);
    }
    
    public void addSortStudentGymsclassListener(ActionListener listener) {
        sortStudentGymsclassBtn.addActionListener(listener);
    }
    
    public void addSortStudentNameListener(ActionListener listener) {
        sortStudentNameBtn.addActionListener(listener);
    }
    
    public void addListStudentSelectionListener(ListSelectionListener listener) {
        studentTable.getSelectionModel().addListSelectionListener(listener);
    }
    
    public void addSeachStudentListener(ActionListener listener) {
        seachStudentBtn.addActionListener(listener);
    }
    public void addStatisticsListener(ActionListener listener){
        statisticsBtn.addActionListener(listener);
    }
}
