package com.diegoBermudez;


import com.diegoBermudez.entities.EnterpriseProfile;
import com.diegoBermudez.entities.UserProfile;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        //group 1
        UserProfile user1 = new UserProfile("Diego", 21);
        UserProfile user2 = new UserProfile("Alejandro", 20);
        UserProfile user3 = new UserProfile("Daniel", 40);
        UserProfile user4 = new UserProfile("Maria", 35);
        UserProfile user5 = new UserProfile("Luis", 28);
        UserProfile user6 = new UserProfile("Sara", 30);
        UserProfile user7 = new UserProfile("Andrea", 23);
        UserProfile user8 = new UserProfile("Carlos", 32);
        UserProfile user9 = new UserProfile("Sofia", 25);
        UserProfile user10 = new UserProfile("Miguel", 27);

        EnterpriseProfile enterprise1 = new EnterpriseProfile("IBM");
        EnterpriseProfile enterprise2 = new EnterpriseProfile("Google");
        EnterpriseProfile enterprise3 = new EnterpriseProfile("Apple");
        EnterpriseProfile enterprise4 = new EnterpriseProfile("Microsoft");
        EnterpriseProfile enterprise5 = new EnterpriseProfile("Amazon");

        user1.addFollowing(user2, user3, enterprise1, enterprise2);
        user2.addFollowing(user4, user5, enterprise3);
        user3.addFollowing(user6, user7, enterprise4);
        user4.addFollowing(user8, enterprise5);
        user5.addFollowing(user9, user10, enterprise1, enterprise3);
        user6.addFollowing(user1, user2, enterprise4, enterprise5);
        user7.addFollowing(user3, user5, enterprise2);
        user8.addFollowing(user4, enterprise1, enterprise3);
        user9.addFollowing(user6, enterprise2, enterprise5);
        user10.addFollowing(user1, user7, enterprise4);

        user1.addFollowing(user4, user6, user9);
        user2.addFollowing(user3, user7, enterprise4);
        user5.addFollowing(user8, enterprise2);
        user7.addFollowing(user10, enterprise3);
        user9.addFollowing(user1, user5, enterprise1);
        user3.addFollowing(user9, enterprise5);

        //group 2
        UserProfile user11 = new UserProfile("Juan", 24);
        UserProfile user12 = new UserProfile("Paula", 29);
        UserProfile user13 = new UserProfile("Esteban", 33);
        UserProfile user14 = new UserProfile("Camila", 27);
        UserProfile user15 = new UserProfile("Javier", 22);
        UserProfile user16 = new UserProfile("Lucia", 26);
        UserProfile user17 = new UserProfile("Valentina", 31);
        UserProfile user18 = new UserProfile("Fernando", 35);
        UserProfile user19 = new UserProfile("Gloria", 28);
        UserProfile user20 = new UserProfile("Ricardo", 30);

        EnterpriseProfile enterprise6 = new EnterpriseProfile("Tesla");
        EnterpriseProfile enterprise7 = new EnterpriseProfile("Facebook");
        EnterpriseProfile enterprise8 = new EnterpriseProfile("Netflix");
        EnterpriseProfile enterprise9 = new EnterpriseProfile("Spotify");
        EnterpriseProfile enterprise10 = new EnterpriseProfile("SpaceX");

        user11.addFollowing(user12, user13, enterprise6, enterprise7);
        user12.addFollowing(user14, user15, enterprise8);
        user13.addFollowing(user16, user17, enterprise9);
        user14.addFollowing(user18, enterprise10);
        user15.addFollowing(user19, user20, enterprise6, enterprise8);
        user16.addFollowing(user11, user12, enterprise9, enterprise10);
        user17.addFollowing(user13, user15, enterprise7);
        user18.addFollowing(user14, enterprise6, enterprise8);
        user19.addFollowing(user16, enterprise7, enterprise10);
        user20.addFollowing(user11, user17, enterprise9);

        user11.addFollowing(user14, user16, user19);
        user12.addFollowing(user13, user17, enterprise9);
        user15.addFollowing(user18, enterprise7);
        user17.addFollowing(user20, enterprise8);
        user19.addFollowing(user11, user15, enterprise6);
        user13.addFollowing(user19, enterprise10);

        final var iterator = user1.iterator();
        while(iterator.hasNext()){
            final var profile = iterator.getNext();
            System.out.println(profile);
        }
    }
}