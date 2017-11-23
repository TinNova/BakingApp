package com.example.tin.bakingapp.Models;

import org.parceler.Parcel;

@Parcel
public class TheSteps{

    int id;
    String shortDescription;
    String description;
    String videoURL;
    String thumbnailURL;

    public int getId() {
        return id;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    // empty constructor needed by the Parceler library
    public TheSteps() {
        
    }
    
    public TheSteps(int id, String shortDescription, String description, String videoURL, String thumbnailURL) {
        this.id = id;
        this.shortDescription = shortDescription;
        this.description = description;
        this.videoURL = videoURL;
        this.thumbnailURL = thumbnailURL;
    }
    
}
//import android.os.Parcel;
//import android.os.Parcelable;
//
//public class TheSteps implements Parcelable{
//
//    public static final Parcelable.Creator<TheSteps> CREATOR = new Creator<TheSteps>() {
//        @Override
//        public TheSteps createFromParcel(Parcel in) {
//            TheSteps instance = new TheSteps();
//            instance.id = ((int) in.readValue((int.class.getClassLoader())));
//            instance.shortDescription = ((String) in.readValue((String.class.getClassLoader())));
//            instance.description = ((String) in.readValue((String.class.getClassLoader())));
//            instance.videoURL = ((String) in.readValue((String.class.getClassLoader())));
//            instance.thumbnailURL = ((String) in.readValue((String.class.getClassLoader())));
//            return instance;
//        }
//
//        @Override
//        public TheSteps[] newArray(int size) {
//            return new TheSteps[size];
//        }
//    };
//
//    private int id;
//    private String shortDescription;
//    private String description;
//    private String videoURL;
//    private String thumbnailURL;
//
//    private TheSteps(){}
//
//    public TheSteps(int id, String shortDescription, String description, String videoURL, String thumbnailURL) {
//        super();
//        this.id = id;
//        this.shortDescription = shortDescription;
//        this.description = description;
//        this.videoURL = videoURL;
//        this.thumbnailURL = thumbnailURL;
//    }
//
//
////    protected TheSteps(Parcel in) {
////        id = in.readInt();
////        shortDescription = in.readString();
////        description = in.readString();
////        videoURL = in.readString();
////        thumbnailURL = in.readString();
////    }
//
//
//    public int getId() {
//        return id;
//    }
//
//    public String getShortDescription() {
//        return shortDescription;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public String getVideoURL() {
//        return videoURL;
//    }
//
//    public String getThumbnailURL() {
//        return thumbnailURL;
//    }
//
//
//
//    @Override
//    public void writeToParcel(Parcel parcel, int i) {
//        parcel.writeInt(id);
//        parcel.writeString(shortDescription);
//        parcel.writeString(description);
//        parcel.writeString(videoURL);
//        parcel.writeString(thumbnailURL);
//    }
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//}


