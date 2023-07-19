package com.ltp.globalsuperstore.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import com.ltp.globalsuperstore.Constants;
import com.ltp.globalsuperstore.Item;
import com.ltp.globalsuperstore.service.StoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StoreController {
    StoreService storeService= new StoreService();


    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id) {
        model.addAttribute("item",storeService.getItemById(id) );
        return "form";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(@Valid Item item, BindingResult result) {
        if (item.getPrice() < item.getDiscount()) {
            result.rejectValue("price", "", "Price cannot be less than discount");
        }
        if (result.hasErrors()) return "form";
        storeService.submitItem( item );
//        int index = getIndexFromId(item.getId());
//        String status = Constants.SUCCESS_STATUS;
//        if (index == Constants.NOT_FOUND) {
//            items.add(item);
//        } else if (within5Days(item.getDate(), items.get(index).getDate())) {
//            items.set(index, item);
//        } else {
//            status = Constants.FAILED_STATUS;
//        }
     //   redirectAttributes.addFlashAttribute("status", status);
        return "redirect:/inventory";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model) {
        model.addAttribute("items", storeService.getItems());
        return "inventory";
   }
//
//    public int getIndexFromId(String id) {
//        for (int i = 0; i < items.size(); i++) {
//            if (items.get(i).getId().equals(id)) return i;
//        }
//        return Constants.NOT_FOUND;
//    }
//
//    public boolean within5Days(Date newDate, Date oldDate) {
//        long diff = Math.abs(newDate.getTime() - oldDate.getTime());
//        return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
//    }
//


}
