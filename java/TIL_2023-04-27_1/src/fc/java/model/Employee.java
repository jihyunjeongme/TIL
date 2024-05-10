package fc.java.model;
// 사원(VO, DTO)
public class Employee {
    private String name;
    private int age;
    private String phone;
    private String empDate;
    private String dept;
    private Boolean marriage;
    public Employee(){
        super();
    }

    public Employee(String name, int age, String phone, String empDate, String dept, Boolean marriage) {
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.empDate = empDate;
        this.dept = dept;
        this.marriage = marriage;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", empDate='" + empDate + '\'' +
                ", dept='" + dept + '\'' +
                ", marriage=" + marriage +
                '}';
    }
}
