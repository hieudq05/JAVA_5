package org.labpoly.lab4.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.labpoly.lab4.model.Item;
import org.labpoly.lab4.repository.ItemDB;
import org.labpoly.lab4.service.ShoppingCartServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("shop")
public class CartController {
    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final ShoppingCartServiceImp shoppingCartServiceImp;

    public CartController(@Autowired HttpServletRequest request, @Autowired HttpServletResponse response, @Autowired ShoppingCartServiceImp shoppingCartServiceImp) {
        this.request = request;
        this.response = response;
        this.shoppingCartServiceImp = shoppingCartServiceImp;
    }

    @GetMapping("show")
    public String showShop() {
        request.setAttribute("items", ItemDB.items);
        request.setAttribute("cartItems", shoppingCartServiceImp.getAll());
        request.setAttribute("total", shoppingCartServiceImp.getTotal());
        request.setAttribute("count", shoppingCartServiceImp.getCount());
        return "shop";
    }

    @PostMapping("add")
    public String addItem(@RequestParam("id") String id) {
        Map<String, Item> items = shoppingCartServiceImp.getAll();
        if (items.get(id) != null) {
            shoppingCartServiceImp.update(id, 1);
        } else {
            for(Item item : ItemDB.items) {
                if(item.getId().equals(id)) {
                    item.setQty(1);
                    shoppingCartServiceImp.add(item);
                }
            }
        }
        return "redirect:/shop/show";
    }

    @PostMapping("clear")
    public String clear() {
        shoppingCartServiceImp.clear();
        return "redirect:/shop/show";
    }

    @PostMapping("update/{id}")
    public String updateItem(@PathVariable("id") String id, @RequestParam("method") String method) {
        Map<String, Item> items = shoppingCartServiceImp.getAll();
        Item item = items.get(id);
        if(method.equals("plus")) {
            shoppingCartServiceImp.update(id, 1);
        } else if(method.equals("minus")) {
            if(item.getQty()==1){
                shoppingCartServiceImp.remove(id);
            } else {
                shoppingCartServiceImp.update(id, -1);
            }
        }
        return "redirect:/shop/show";
    }

    @PostMapping("remove")
    public String removeItem(@RequestParam("id") String id) {
        shoppingCartServiceImp.remove(id);
        return "redirect:/shop/show";
    }
}
