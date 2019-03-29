package XuLieHua;

import java.io.*;

/**
 * Created by Paser on 2019/2/27.
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("/Users/Paser/man.txt"));
        Man man=(Man) in.readObject();
        in.close();
        man.show();
    }
}
