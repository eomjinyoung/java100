package java100.app;

import java.util.Scanner;

public class Member {
    
    protected String name;
    protected String email;
    protected String password;
    
    public Member() {}
    
    public Member(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Member [name=" + name + ", email=" + email + ", password=" + password + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void print() {
        System.out.printf("%-4s, %s\n",  
                this.name, 
                this.email);
    }
    
    public void input() {
        Scanner keyScan = new Scanner(System.in);
        
        System.out.print("이름? ");
        this.name = keyScan.nextLine();
        
        System.out.print("이메일? ");
        this.email = keyScan.nextLine();
        
        System.out.print("암호? ");
        this.password = keyScan.nextLine();
    }
}









