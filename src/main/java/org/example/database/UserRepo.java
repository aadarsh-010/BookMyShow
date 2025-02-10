package org.example.database;

import org.example.models.user.Creator;
import org.example.models.user.Customer;

import java.util.HashMap;
import java.util.Objects;

public class UserRepo {

    public HashMap<String, Creator> creatorDB=new HashMap<>();
    public HashMap<String, Customer> customerDB=new HashMap<>();


    public Creator getCreator(String uid) {
        if (Objects.equals(userIsA(uid), "CREATOR") && creatorDB.containsKey(uid)) {
            return creatorDB.get(uid);
        } else System.out.println("INVALID USER ID USER NOT PRESENT");

        return null;
    }

    public Customer getCustomer(String uid) {
        if (Objects.equals(userIsA(uid), "CUSTOMER") && customerDB.containsKey(uid)) {
            return customerDB.get(uid);
        } else System.out.println("INVALID USER ID USER NOT PRESENT");

        return null;
    }

    public void deleteCreator(String uid) {
            creatorDB.remove(uid);
    }

    public void deleteCustomer(String uid) {
        customerDB.remove(uid);
    }


    public void addCustomer(String id, Customer obj1) {
        customerDB.putIfAbsent(id,obj1);
    }

    public void addCreator(String id, Creator obj1) {
        creatorDB.putIfAbsent(id,obj1);
    }

    public String userIsA(String id) {
        if (customerDB.containsKey(id)) {
            return "CUSTOMER";
        } else if (creatorDB.containsKey(id)) {
            return "CREATOR";
        }
        return "INVALID USER";
    }
}
