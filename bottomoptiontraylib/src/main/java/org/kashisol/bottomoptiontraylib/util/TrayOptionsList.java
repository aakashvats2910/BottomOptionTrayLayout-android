package org.kashisol.bottomoptiontraylib.util;

import android.graphics.drawable.Drawable;


import org.kashisol.bottomoptiontraylib.exceptions.TrayOptionsWithSameIdException;

import java.util.ArrayList;
import java.util.HashSet;

public class TrayOptionsList {

    private ArrayList<Option> optionsList;
    private HashSet<Option> hashSet;

    public TrayOptionsList() {
        optionsList = new ArrayList<>();
        hashSet = new HashSet<>();
    }

    public void add(String optionText, Drawable optionDrawable, int optionId) {
        Option option = new Option(optionText, optionDrawable, optionId);
        optionsList.add(option);
        if (hashSet.contains(option)) {
            try {
                throw new TrayOptionsWithSameIdException(optionId);
            } catch (TrayOptionsWithSameIdException e) {
                e.printStackTrace();
            }
        }
        hashSet.add(option);
    }

    public void add(String optionText, int optionDrawableId, int optionId) throws TrayOptionsWithSameIdException {
        Option option = new Option(optionText, optionDrawableId, optionId);
        optionsList.add(option);
        if (hashSet.contains(option))
            throw new TrayOptionsWithSameIdException(optionId);
        hashSet.add(option);
    }

    public void add(Option option) {
        optionsList.add(option);
        if (hashSet.contains(option)) {
            try {
                throw new TrayOptionsWithSameIdException(option.optionId);
            } catch (TrayOptionsWithSameIdException e) {
                e.printStackTrace();
            }
        }
        hashSet.add(option);
    }

    public ArrayList<Option> getOptionsList() {
        return optionsList;
    }

    public static class Option {

        public String optionText;
        public Drawable optionDrawable;
        public int optionDrawableId = -1;
        public int optionId;

        public Option(String optionText, Drawable optionDrawable, int optionId) {
            this.optionText = optionText;
            this.optionDrawable = optionDrawable;
            this.optionId = optionId;
        }

        public Option(String optionText, int optionDrawableId, int optionId) {
            this.optionText = optionText;
            this.optionDrawableId = optionDrawableId;
            this.optionId = optionId;
        }
    }
}
