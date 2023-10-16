package src.main;

public class Member {
    private int id;
    private String name;

    private int age;

    @Email
    private String email;


    public Member(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ValidateUser
    public void registerMember(Member member){}

    @ValidateUser
    @IsAvailable
    public void borrowBook(Member member, Book book){}

}
