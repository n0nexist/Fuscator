import java.util.Random;
import java.util.Scanner;

public class Fuscator {

    public static String obf(String str) {
        Random r = new Random(System.currentTimeMillis());
        byte[] b = str.getBytes();
        int c = b.length;
        String temp = "";
        temp += "(new Object() {";
        temp += "int t;";
        temp += "public String toString() {";
        temp += "byte[] buf = new byte[";
        temp += c;
        temp += "];";
        for (int i = 0; i < c; ++i) {
            int t = r.nextInt();
            int f = r.nextInt(24) + 1;
            t = (t & ~(0xff << f)) | (b[i] << f);
            temp += "t = ";
            temp += t;
            temp += ";";
            temp += "buf[";
            temp += i;
            temp += "] = (byte) (t >>> ";
            temp += f;
            temp += ");";
        }
        temp += "return new String(buf);";
        temp += "}}.toString())";
        return temp;
    }

   

    public static void main(String args[])  
    {  
       Scanner s = new Scanner(System.in);
       while (true){
            System.out.println("\033[2J\033[H"+
            " ____  _     __   __     __   _____  ___   ___  "+
            "\n| |_  | | | ( (` / /`   / /\\   | |  / / \\ | |_) "+
            "\n|_|   \\_\\_/ _)_) \\_\\_, /_/--\\  |_|  \\_\\_/ |_| \\");
            System.out.print("> simple java string obfuscator\n\ninput: ");
            String str = s.nextLine();
            System.out.println("output:\n\n#####################\n"+obf(str)+"\n#####################");
            System.out.print("\n\npress enter (or type '!' to exit)..");
            if (s.nextLine().equals("!")){
                s.close();
                System.exit(0);
            }
       }
    }  



}
