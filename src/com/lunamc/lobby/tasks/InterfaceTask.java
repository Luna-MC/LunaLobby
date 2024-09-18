package com.lunamc.lobby.tasks;

import com.lunamc.lobby.User;

public class InterfaceTask implements Runnable {

    @Override
    public void run() {
        for (User user : User.getUsers()) {
            user.displayActionbar();
            user.displayHeaderFooter();
        }
    }

}
