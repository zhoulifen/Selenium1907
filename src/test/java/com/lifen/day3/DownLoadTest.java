package com.lifen.day3;

import org.openqa.selenium.firefox.FirefoxProfile;

public class DownLoadTest {
        public void testChromeDownLoad(){
            FirefoxProfile firefoxProfile = new FirefoxProfile();
            firefoxProfile.setPreference("broswer.download.folderList","2");

        }
}
