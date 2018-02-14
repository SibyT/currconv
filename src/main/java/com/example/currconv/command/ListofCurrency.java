package com.example.currconv.command;

import org.springframework.stereotype.Component;

import java.util.*;
/**
 * Displays list of currencies. Value is displayed as code - description
 * @author SibyThomas
 *
 */
@Component
public class ListofCurrency {

    public static HashMap<String,String> getAllCurrencies()
    {
        HashMap<String,String> toret = new HashMap<>();
        Locale[] locs = Locale.getAvailableLocales();

        for(Locale loc : locs) {
            try {
                Currency currency = Currency.getInstance( loc );
                String desc=currency + " - "+ Currency.getInstance(loc).getDisplayName();

                if ( currency != null ) {
                    toret.put(currency.toString(),desc);
                }
            } catch(Exception exc)
            {
                // Locale not found
            }
        }

        return toret;
    }
}
