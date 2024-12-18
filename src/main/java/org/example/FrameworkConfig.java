package org.example;

import org.aeonbits.owner.Config;

@Config.Sources("file:${user.dir}/src/test/resources/FrameworkConfig.properties")
public interface FrameworkConfig extends Config {
        BrowserType browser();

//        if the key in properties does not matches with name here, then use key annotation
        @Key("takesscreenshot")
        boolean takeScreenshot();
}