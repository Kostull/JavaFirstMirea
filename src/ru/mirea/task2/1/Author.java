package ru.mirea.task2;

public class Author {
    private final String name;
    private String email;
    private final char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                '}';
    }
}

class TestAuthor{
    public static void main(String[] args) {
        Author a1 = new Author("Alex", "alex2005@gmail.com", 'm');
        System.out.println(a1);
        a1.setEmail("alex2005@mail.ru");
        System.out.println(a1);
        System.out.println("name: " + a1.getName() + ", email: "
                + a1.getEmail() + ", gender: " + a1.getGender());
    }
}
