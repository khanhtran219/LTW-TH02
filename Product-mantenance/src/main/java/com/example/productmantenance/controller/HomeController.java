package com.example.productmantenance.controller;

import com.example.productmantenance.repository.ProductRepository;
import com.example.productmantenance.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/productMaint1")
public class HomeController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("/displayProducts")
    public String displayProducts(Model model){
        List<Product> products = productRepository.findAll();
        model.addAttribute("products",products);
        return "products";
    }

    @GetMapping ("/updateProduct/{code}")
    public String updateProduct(@PathVariable("code") String code,Model model){
        Product product = productRepository.findByCode(code);
        model.addAttribute("product",product);
        return "update";
    }

    @PostMapping("/updateProduct")
    public String processUpdate(@ModelAttribute Product product){
        productRepository.save(product);
        return "redirect:/productMaint1/displayProducts";
    }

    @GetMapping("/deleteProduct/{code}")
    public String deleteProduct(@PathVariable("code") String code,Model model){
        Product product = productRepository.findByCode(code);
        model.addAttribute("product",product);
        return "delete";
    }

    @PostMapping("/deleteProduct/{code}")
    public String processDelete(@PathVariable("code") String code){
        Product product = productRepository.findByCode(code);
        try {
            productRepository.delete(product);
        }catch (Exception e){

        }
        return "redirect:/productMaint1/displayProducts";
    }

    @GetMapping("/addProduct")
    public String addProduct(Model model){
        Product product = new Product();
        model.addAttribute(product);
        return "add";
    }

    @PostMapping("/addProduct")
    public String processAdd(@ModelAttribute Product product){
        productRepository.save(product);
        return "redirect:/productMaint1/displayProducts";
    }


}
