package Register;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by steinar on 28.04.2015.
 *
 * superclass for our registers
 * Methods to add and update entries. Theres not a way to delete entries, this is intended.
 * Theres also methods for writing to\from file
 * //linky; https://docs.oracle.com/javase/tutorial/extra/generics/methods.html
 */
abstract class Register {

    Map register;

    public Register(HashMap hashMap)
    {
        register = hashMap;
    }

    <K, O> boolean add(K key, O object) {
        if ( !register.containsKey(key) ) {
            register.put(key, object);
            return true;
        }
        return false;
    }

    <K, O> Object getWithKey( K key )
    {
        return register.get(key);
    }

    <K, O> boolean update( K key, O object) {
        if( register.containsKey(key) ) {
            register.replace(key, object); //todo check if this method throws an exception
            return true;
        }
        return false;
    }

    public Collection getRegister() { return register.values(); }
    protected int getNumberofObjectsStored() {
        return register.size();
    }

    public void saveRegister() throws IOException {
        ObjectOutputStream output = null;
        try {
            output = new ObjectOutputStream( new FileOutputStream("Register.data"));
            output.writeObject(register);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null )
                output.close();
        }
    }

    public void loadRegister() {

        ObjectInputStream input = null;
        try {
            input = new ObjectInputStream( new FileInputStream("Register.data"));
            register = (Map)input.readObject();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}