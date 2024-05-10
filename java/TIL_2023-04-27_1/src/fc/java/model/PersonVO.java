package fc.java.model;

public class PersonVO {
    private String name;
    private int age;
    private String phone;
    public PersonVO(){
        // 생성자 오버로드, 초기화 없음
    }
    public PersonVO(String name,int age,String phone){
        this.name=name;
        this.age=age;
        this.phone=phone;
    }

//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                '}';
    }
}
