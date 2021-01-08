package StudentAssesmentAssignment;

import java.util.List;

public class StudentPojo {
     String username;
     String password;
     List<Integer> sessionid;
     List<Students> students;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Integer> getSessionid() {
        return sessionid;
    }

    public void setSessionid(List<Integer> sessionid) {
        this.sessionid = sessionid;
    }

    public List<Students> getStudents() {
        return students;
    }

    public void setStudents(List<Students> students) {
        this.students = students;
    }


}
