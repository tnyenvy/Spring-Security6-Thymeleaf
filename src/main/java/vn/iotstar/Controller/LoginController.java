package vn.iotstar.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.model.Model;
import vn.iotstar.Entity.Product;
import vn.iotstar.Service.ProductServices;

@Controller
public class LoginController {

    @Autowired
    ProductServices service;

    @PostMapping("/login_success_handler")
    public String loginSuccessHandler() {
        System.out.println("Logging user login success...");
        return "index";
    }

    @PostMapping("/login_failure_handler")
    public String loginFailureHandler() {
        System.out.println("Login failure handler...");
        return "login";
    }

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);
        return "index";
    }
        @GetMapping("/new")
        public String showNewProductForm(Model model) {
            Product product = new Product();
            model.addAttribute("product", product);
            return "new_product";
        }

        @PostMapping("/save")
        public String saveProduct(@ModelAttribute("product") Product product) {
            productService.save(product);
            return "redirect:/";
        }

        @GetMapping("/edit/{id}")
        public String showEditProductForm(@PathVariable("id") Long id, Model model) {
            Product product = productService.get(id);
            model.addAttribute("product", product);
            return "edit_product";
        }

        @GetMapping("/delete/{id}")
        public String deleteProduct(@PathVariable("id") Long id) {
            productService.delete(id);
            return "redirect:/";
        }
    }

}

