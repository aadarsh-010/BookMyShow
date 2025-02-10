package org.example.services;

import org.example.repository.DatabaseCollection;
import org.example.repository.UserRepository;
import org.example.models.user.Creator;
import org.example.models.user.Customer;


import java.util.List;
import java.util.Objects;


public class UserService {

    private static UserService userServiceObject;
    UserRepository usertable;

    UserService() {
        usertable = DatabaseCollection.instance().UserTable;
    }

    public static UserService instance() {
        if (userServiceObject == null) userServiceObject = new UserService();
        return userServiceObject;
    }

    public void createUser(String id, String name, String email, String phoneNumber, String userType) {
        if (Objects.equals(userType, "CREATOR")) {
            Creator obj1 = new Creator(id, name, email, phoneNumber);
            usertable.addCreator(id, obj1);
        } else {

            Customer obj1 = new Customer(id, name, email, phoneNumber);
            usertable.addCustomer(id, obj1);
        }

    }

    //*************
    public void deleteUser(String id) throws Exception {
        if (Objects.equals(usertable.userIsA(id), "CREATOR")) {
            for (int i = 0; i <usertable.getCreator(id).getTheatresOwned().size() ; i++) {
                    TheaterService.instance().DeleteTheater(usertable.getCreator(id).getTheatresOwned().get(i));
            }
            usertable.deleteCreator(id);
        } else if (Objects.equals(usertable.userIsA(id), "CUSTOMER")) {
            usertable.deleteCustomer(id);
        } else throw new Exception("INVALID USER ID ");
    }


    public List<String> getOwnedTheatres(String userid) throws Exception {
        if (Objects.equals(usertable.userIsA(userid), "CREATOR")) {
            return usertable.getCreator(userid).getTheatresOwned();
        } else throw new Exception("user ID is not a creator type");

    }

    public void addOwnedTheatres(String userid,String thid) throws Exception {
        if (Objects.equals(usertable.userIsA(userid), "CREATOR")) {
            usertable.getCreator(userid).setTheatresOwned(thid);
        } else throw new Exception("user ID is not a creator type");

    }

    public void removeOwnedTheatres(String userid,String thid) throws Exception {
        if (Objects.equals(usertable.userIsA(userid), "CREATOR")) {
            usertable.getCreator(userid).removeTheatresOwned(thid);
        } else throw new Exception("user ID is not a creator type");

    }


    // still implementation pending;
    public List<String> getBookings(String userid) throws Exception {
        if (Objects.equals(usertable.userIsA(userid), "CUSTOMER")) {
            return usertable.getCustomer(userid).getUserBookings();
        } else throw new Exception("user ID is not a customer type");

    }

    public void removeUserBookings(String userid,String bid) throws Exception {
        if (Objects.equals(usertable.userIsA(userid), "CUSTOMER")) {
            usertable.getCustomer(userid).removeUserBookings(bid);
        } else throw new Exception("user ID is not a customer type");

    }

    public void addUserBookings(String userid,String bid) throws Exception {
        if (Objects.equals(usertable.userIsA(userid), "CUSTOMER")) {
            System.out.println("check " + usertable.customerDB.containsKey("u1"));
            usertable.getCustomer(userid).setUserBookings(bid);
        } else throw new Exception("user ID is not a customer type");

    }

}
