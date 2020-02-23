package ua.external.base.oop.droid.resource;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
    INSTANCE;
    private ResourceBundle resourceBundle;
    private final String resourceName = "property.messages";
    private ResourceManager(){
        ResourceBundle.getBundle(
                resourceName, new Locale("en", "EN"));
    }
    public void changeResource(Locale locale){
        resourceBundle=ResourceBundle.getBundle(
                resourceName, locale);
    }
    public String getString(String key){
        return resourceBundle.getString(key);
    }
}
