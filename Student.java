package Student_class;

public class Student {
    private int id;
    private String name;
    private String email;
    private String city;
    private long phone;

    public Student(int id, String name, String email, String city, long phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.city = city;
        this.phone = phone;    
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCity() {
        return city;
    }

    public long getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", email=" + email + ", city=" + city + ", phone=" + phone + "]";
    }
}
