package vn.viettuts.qlsv.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private byte age;
    private String address;
    /* điểm trung bình của sinh viên */
    private String gymsclass;
    private String gymsroom;
    private String trainer;

    public Student() {
    }

    public Student(int id, String name, byte age, String address, String gymsclass, String gymsroom, String trainer) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gymsclass = gymsclass;
        this.gymsroom = gymsroom;
        this.trainer = trainer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGymsclass() {
        return gymsclass;
    }

    public void setGymsclass(String gymsclass) {
        this.gymsclass = gymsclass;
    }
    
    public String getGymsroom() {
        return gymsroom;
    }
    
    public void setGymsroom(String gymsroom) {
        this.gymsroom = gymsroom;
    }
    
    public String getTrainer() {
        return trainer;
    }
    
    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }
}
