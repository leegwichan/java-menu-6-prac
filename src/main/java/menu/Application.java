package menu;

import menu.controller.ServiceManageController;

public class Application {
    public static void main(String[] args) {
        ServiceManageController serviceManageController = new ServiceManageController();
        serviceManageController.startRecommend();
    }
}
