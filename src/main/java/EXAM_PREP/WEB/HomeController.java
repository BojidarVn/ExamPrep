package EXAM_PREP.WEB;

import EXAM_PREP.model.entities.enums.CategoryNameEnum;
import EXAM_PREP.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {

        if (httpSession.getAttribute("user") == null) {
            return "index";
        }

        model.addAttribute("totalSum", productService.getTotalSum());
        model.addAttribute("drinks", productService.findAllProductsByCategory(CategoryNameEnum.DRINK));
        model.addAttribute("food", productService.findAllProductsByCategory(CategoryNameEnum.FOOD));
        model.addAttribute("households", productService.findAllProductsByCategory(CategoryNameEnum.HOUSEHOLD));
        model.addAttribute("other", productService.findAllProductsByCategory(CategoryNameEnum.OTHER));

        return "home";
    }


}
