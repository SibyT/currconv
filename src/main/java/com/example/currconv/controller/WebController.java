package com.example.currconv.controller;


import com.example.currconv.command.ListofCurrency;
import com.example.currconv.services.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
/**
 * 
 * @author SibyThomas
 *
 */
@Controller
public class WebController  {

    @Autowired
    RestService res ;
    @GetMapping("/")
        public String showForm(Model model) {
        HashMap<String,String> listofCurrencies= ListofCurrency.getAllCurrencies();

        Map<String,String> sortedList = new TreeMap<String,String>(listofCurrencies);
        model.addAttribute("list", sortedList);

            return "form";
        }

    @RequestMapping(
            value = "convertCurrency",
            params = {"convert=submit","amount", "baseCurrency" ,"targetCurrency"},
            method = RequestMethod.GET)

    public String convertCurrency(@RequestParam("amount" ) String amt, @RequestParam ("baseCurrency") String base,
                             @RequestParam ("targetCurrency") String target, Model model) {

        String errorMessage ;
        String view="result";

        if(amt.equalsIgnoreCase("")||amt==null){
        	
        	//error message is amount is blank
            errorMessage="Please enter the amount correctly.";
            model.addAttribute("error",errorMessage);
            //displays error html
            view="error";
        }else if(base.equalsIgnoreCase(target)){
        	
        	//error message if both currency is same
            errorMessage="Please provide different base and target currency";
            model.addAttribute("error",errorMessage);
            
            //displays error html
            view="error";
        } else {
        	//calls rest api fixer.io

            Double convertedCurrency = Double.parseDouble(amt) * Double.parseDouble(res.callCurrencyExchanger(base, target));

            model.addAttribute("amount", amt);
            model.addAttribute("baseCurrency", base);
            model.addAttribute("targetCurrency", target);
            model.addAttribute("convertedCurrency", convertedCurrency);
        }
        return view;
    }
}

