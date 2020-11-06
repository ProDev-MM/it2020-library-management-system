package com.mds.libraryMgmtSystem.constant;

public class GlobalConstant {

    public static final int success = 0;
    public static final int fail = 1;

    public interface Message{
    String success_message = "Successful !!!";
    String fail_message = "Fail !!!";
    }



    public interface FolderLocation {
        Integer LOCATION_BOOK = 1;
        Integer LOCATION_PROFILE = 2;


    }

    public interface FolderName {
        String FOLDER_ROOT = "upload";
        String  BOOKURL = "BOOKURL";
        String  PROFILE = "PROFILE";
        String FOLDER_OTHER = "other";

    }

}
