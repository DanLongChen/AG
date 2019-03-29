package XuLieHua;

import java.io.*;

/**
 * Created by Paser on 2019/2/27.
 */
public class Man implements Externalizable{
    private String name="Man";
    private transient int age=0;
    private static final long serialVersionUID=123L;
    public Man(String name){
        this.name=name;
    }
    public void show(){
        System.out.println(name);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name=(String)in.readObject();
    }
}
