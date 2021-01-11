package org.kashisol.bottomoptiontraylib.exceptions;

public class TrayOptionsWithSameIdException extends Exception {

    public TrayOptionsWithSameIdException(int id) {
        super("Option with same Id : " + id + " exists in TrayOptionList");
    }
}
