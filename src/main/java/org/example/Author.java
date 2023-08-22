package org.example;

//  ласс представл€ющий јвторов
public class Author {
    public int id;
    public String surname;
    public String name;
    public String patronymic;
    
    public Author(int id, String surname, String name) {
        this.id = id;
        this.surname = surname;
        this.name = name;
    }

    public Author(int id, String surname, String name, String patronymic) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        return "Author " + surname +" " + name + " " +patronymic ;
    }
    
  


    
}

