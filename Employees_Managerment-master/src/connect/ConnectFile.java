package connect;
import java.util.ArrayList;
import java.io.*;
import model.Account;

public class ConnectFile {
    private final String filePath = "C:\\Java/file.txt"; 
    
    public void addAccount(Account a) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(filePath, true)); 
            //pw.println(a.getEmail());
            //pw.println(a.getPassword());
            //pw.println(a.getId());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }
    
    public ArrayList<Account> getList() throws IOException {
        ArrayList<Account> list = new ArrayList<Account>();
        File f = new File(filePath);
        BufferedReader br = new BufferedReader(new FileReader(f));
        
        String email, password;
        int id;
        
        while ((email = br.readLine()) != null) {
            password = br.readLine();
            id = Integer.parseInt(br.readLine());
            //list.add(new Account(id, email, password));
        }
        
        br.close();
        
        return list;
    }
    
    public void setAccount(Account a, int id) {
        try {
            File inputFile = new File(filePath);
            File tempFile = new File("C:\\Java/temp.txt"); 

            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String email, password;
            int accountId;

            String line;
            while ((line = br.readLine()) != null) {
                email = line;
                password = br.readLine();
                accountId = Integer.parseInt(br.readLine());

                if (accountId == id) {
                    //pw.println(a.getEmail());
                    //pw.println(a.getPassword());
                    //pw.println(a.getId());
                } else {
                    pw.println(email);
                    pw.println(password);
                    pw.println(accountId);
                }
            }

            br.close();
            pw.flush();
            pw.close();

            if (inputFile.delete()) {
                if (!tempFile.renameTo(inputFile)) {
                    System.out.println("Không thể đổi tên file tạm thành tên file ban đầu.");
                }
            } else {
                System.out.println("Không thể xóa file ban đầu.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }
}