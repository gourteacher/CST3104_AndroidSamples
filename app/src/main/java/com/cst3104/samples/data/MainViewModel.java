package com.cst3104.samples.data;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private String resultString;

    public String getResultString() {
        return resultString;
    }

    public void setResultString(String in) {
        resultString = in;
    }
}
