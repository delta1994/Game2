package com.tor.sukrit.marksman.myapplication;

/**
 * Created by MS-10403 on 11/9/2560.
 */

public class Getvalue1 {

    private  int intRadio, intButton=1;

    public interface OnMyModelChangeListener {
        void onMyModelChangeListener(Getvalue1 getvalue1);
    }

    private OnMyModelChangeListener onMyModelChangeListener;
    public  void setOnMyModelChangeListener(OnMyModelChangeListener onMyModelChangeListener) {

        this.onMyModelChangeListener = onMyModelChangeListener;
    }

    public int getIntRadio() {

        return intRadio;
    }

    public void setIntRadio(int intRadio) {
        this.intRadio = intRadio;

        if (this.onMyModelChangeListener != null) {
            this.onMyModelChangeListener.onMyModelChangeListener(this);
        }
    }

    public int getIntButton() {
        return intButton;
    }


    public void setIntButton(int intButton) {
        this.intButton = intButton;
        if (this.onMyModelChangeListener != null) {
            this.onMyModelChangeListener.onMyModelChangeListener(this);

        }

    }
}// end of Main Class