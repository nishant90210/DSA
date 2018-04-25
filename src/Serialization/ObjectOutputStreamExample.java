package Serialization;

import java.io.*;

/**
 * Created by NISHANT on 4/24/18.
 */
public class ObjectOutputStreamExample {

    public static void main(String[] args) {

        Employee employee = new Employee("Nishant");
        employee.setAge(28);
        employee.setGender("Male");
        employee.setRole("Engi");
        System.out.println(employee);

        serialize(employee);
        try {
            deSerialize(employee);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void deSerialize(Employee employee) throws IOException, ClassNotFoundException {

        FileInputStream is = new FileInputStream("Employee.ser");
        ObjectInputStream ois = new ObjectInputStream(is);
        Employee emp = (Employee) ois.readObject();

        ois.close();
        is.close();
        System.out.println(emp.toString());
    }

    private static void serialize(Employee employee) {
        try {
            FileOutputStream fos = new FileOutputStream("Employee.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // write object to file
            oos.writeObject(employee);
            System.out.println("Done");
            // closing resources
            oos.close();
            fos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
