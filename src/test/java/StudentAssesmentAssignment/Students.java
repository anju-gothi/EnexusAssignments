package StudentAssesmentAssignment;

import java.util.List;

public class Students {
    int id;
    String name;
    List<Integer> marks;
    List<String> contact;
    List<Adresss> adresss;

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

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    public List<String> getContact() {
        return contact;
    }

    public void setContact(List<String> contact) {
        this.contact = contact;
    }

    public List<Adresss> getAdresss() {
        return adresss;
    }

    public void setAdresss(List<Adresss> adresss) {
        this.adresss = adresss;
    }


}
