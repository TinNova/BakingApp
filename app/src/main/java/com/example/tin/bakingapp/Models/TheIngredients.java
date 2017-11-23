package com.example.tin.bakingapp.Models;

import org.parceler.Parcel;

@Parcel
public class TheIngredients {

    int quantity;
    String measure;
    String ingredient;

    public int getQuantity() {
        return quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public String getIngredient() {
        return ingredient;
    }

    // empty constructor needed by the Parceler library
    public TheIngredients() {

    }

    public TheIngredients(int quantity, String measure, String ingredient) {
        this.quantity = quantity;
        this.measure = measure;
        this.ingredient = ingredient;
    }

    
}
//
//import android.os.Parcel;
//import android.os.Parcelable;
//
//public class TheIngredients implements Parcelable {
//    public static final Parcelable.Creator<TheIngredients> CREATOR = new Creator<TheIngredients>() {
//        @Override
//        public TheIngredients createFromParcel(Parcel in) {
//            TheIngredients instance = new TheIngredients();
//            instance.quantity = ((int) in.readValue((int.class.getClassLoader())));
//            instance.measure = ((String) in.readValue((String.class.getClassLoader())));
//            instance.ingredient = ((String) in.readValue((String.class.getClassLoader())));
//            return instance;
//
//        }
//
//        @Override
//        public TheIngredients[] newArray(int size) {
//            return new TheIngredients[size];
//        }
//    };
//
//    private int quantity;
//    private String measure;
//    private String ingredient;
//
//    private TheIngredients() {
//    }
//
//    public TheIngredients(int quantity, String measure, String ingredient) {
//        super();
//        this.quantity = quantity;
//        this.measure = measure;
//        this.ingredient = ingredient;
//    }
//
//
//    protected TheIngredients(Parcel in) {
//        quantity = in.readInt();
//        measure = in.readString();
//        ingredient = in.readString();
//    }
//
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public String getMeasure() {
//        return measure;
//    }
//
//    public String getIngredient() {
//        return ingredient;
//    }
//
//
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeInt(quantity);
//        dest.writeString(measure);
//        dest.writeString(ingredient);
//    }
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//}

//package com.example.tin.bakingapp.Models;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//
//public class TheIngredients implements Parcelable {
//    public final static Parcelable.Creator<TheIngredients> CREATOR = new Creator<TheIngredients>() {
//        public TheIngredients createFromParcel(Parcel in) {
//            TheIngredients instance = new TheIngredients();
//            instance.quantity = ((long) in.readValue((long.class.getClassLoader())));
//            instance.measure = ((String) in.readValue((String.class.getClassLoader())));
//            instance.ingredient = ((String) in.readValue((String.class.getClassLoader())));
//            return instance;
//        }
//
//        public TheIngredients[] newArray(int size) {
//            return (new TheIngredients[size]);
//        }
//
//    };
//
//    private long quantity;
//
//    private String measure;
//
//    private String ingredient;
//
//    private TheIngredients() {
//    }
//
//    public TheIngredients(long quantity, String measure, String ingredient) {
//        this.quantity = quantity;
//        this.measure = measure;
//        this.ingredient = ingredient;
//    }
//
//    public float getQuantity() {
//        return quantity;
//    }
//
//    public String getMeasure() {
//        return measure;
//    }
//
//    public String getIngredient() {
//        return ingredient;
//    }
//
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeValue(quantity);
//        dest.writeValue(measure);
//        dest.writeValue(ingredient);
//    }
//
//    public int describeContents() {
//        return 0;
//    }
//}