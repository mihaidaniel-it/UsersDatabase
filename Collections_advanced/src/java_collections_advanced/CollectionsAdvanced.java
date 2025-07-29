package java_collections_advanced;

import java_collections_advanced.services.FindUser;
import java_collections_advanced.services.MenuNavigator;

public class CollectionsAdvanced {
    public static void main(String[] args) {
//        Объекты
        MenuNavigator menuNavigator = new MenuNavigator();
        FindUser findUser = new FindUser();

        menuNavigator.checkOption(findUser);
    }
}
