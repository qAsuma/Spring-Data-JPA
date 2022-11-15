package solo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import solo.models.Account;
import solo.models.Client;
import solo.services.AccountService;
import solo.services.ClientService;


@Controller
@RequestMapping("/people")
public class ClientController {

    private final ClientService clientService;
    private final AccountService accountService;

    @Autowired
    public ClientController(ClientService clientService, AccountService accountService) {
        this.clientService = clientService;
        this.accountService = accountService;

    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", clientService.findAll());

//        accountService.findByEmail("slavikden2@gmail.com");
//        accountService.findByOwner(clientService.findAll().get(0));
//
//
//        clientService.test();

        return "/index";
    }



    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("client", clientService.findOne(id));
        return "/show";
    }


    @GetMapping("/new")
    public String newPerson(@ModelAttribute("client") Client client, @ModelAttribute("account")Account account) {
        return "/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("client") Client client,@ModelAttribute("account")Account account,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/new";

        clientService.save(client);
        accountService.save(account);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("client", clientService.findOne(id));
        return "/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("client") Client client, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "edit";

        clientService.update(id,client);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        clientService.delete(id);
        return "redirect:/people";
    }
}