package com.epam.store.web;

import com.epam.store.model.Cart;
import com.epam.store.model.Purchase;
import com.epam.store.model.User;
import com.epam.store.service.StoreService;
import com.epam.store.web.validation.UserRegistrationForm;
import com.epam.store.web.validation.UserRegistrationFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;


@Controller
public class UserController {
    private StoreService storeService;
    private MessageSource messageSource;
    private UserRegistrationFormValidator userValidator;

    @Autowired
    public UserController(StoreService storeService, MessageSource messageSource) {
        this.storeService = storeService;
        this.messageSource = messageSource;
        userValidator = new UserRegistrationFormValidator(storeService);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String initRegistrationForm(ModelMap model) {
        if (!model.containsAttribute("registrationForm")) {
            model.addAttribute("registrationForm", new UserRegistrationForm());
        }
        return "user/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseBody
    public Response processRegistrationForm(@RequestBody
                                            @Valid UserRegistrationForm registrationForm,
                                            BindingResult binding,
                                            Locale locale) {
        userValidator.validate(registrationForm, binding);
        Response response = new Response(messageSource, locale);
        if (binding.hasErrors()) {
            response.addErrorMessages(binding);
            response.setStatus(Response.Status.FAIL);
        } else {
            storeService.registerUser(
                    registrationForm.getName(),
                    registrationForm.getEmail(),
                    registrationForm.getPassword()
            );
            response.setStatus(Response.Status.SUCCESS);
        }
        return response;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String initLoginForm() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String processLoginForm(@RequestParam String email,
                                   @RequestParam String password,
                                   HttpSession session,
                                   RedirectAttributes attr) {
        User authenticatedUser = storeService.authenticateUser(email, password);
        if (authenticatedUser == null) {
            attr.addFlashAttribute("email", email);
            attr.addFlashAttribute("loginFailed", true);
            return "redirect:login";
        }
        session.setAttribute("user", authenticatedUser);
        return "redirect:/";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }

    @RequestMapping(value = "/changeLang", method = RequestMethod.GET)
    public String changeLocale(@RequestParam String language, HttpServletRequest req, HttpServletResponse resp) {
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(req);
        localeResolver.setLocale(req, resp, StringUtils.parseLocaleString(language));
        return "redirect:/";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String showProfile(HttpSession session, ModelMap model) {
        User user = (User) session.getAttribute("user");
        List<Purchase> userPurchaseList = storeService.getUserPurchaseList(user.getId());
        model.addAttribute("purchaseList", userPurchaseList);
        return "user/user";
    }

    @RequestMapping(value = "/user/confirmOrder", method = RequestMethod.POST)
    @ResponseBody
    public Response confirmOrder(HttpSession session, Locale locale) {
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");
        storeService.confirmOrder(user.getId(), cart);
        Response response = new Response(messageSource, locale);
        response.addMessageByKey("cart.message.success");
        response.setStatus(Response.Status.SUCCESS);
        return response;
    }
}
