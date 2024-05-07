package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Genero;
import application.repository.GeneroRepository;

@Controller
@RequestMapping("/generos")
public class GeneroController {
    @Autowired
    private GeneroRepository generoRepo;

    @RequestMapping("/insert")
    public String insert() {
        return "/genero/insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestParam("nome") String nome) {
        Genero genero = new Genero();
        genero.setNome(nome);
        generoRepo.save(genero);

        return "redirect:/generos/list";
    }

    @RequestMapping("/list")
    public String list(Model ui) {
        ui.addAttribute("generos", generoRepo.findAll());

        return "/genero/list";
    }

    @RequestMapping("/update")
    public String update(@RequestParam("id") long id, Model ui) {
        Optional<Genero> result = generoRepo.findById(id);
        if(result.isPresent()) {
            ui.addAttribute("genero", result.get());
            return "/genero/update";
        }
        return "redirect:/generos/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestParam("id") long id, @RequestParam("nome") String nome) {
        Optional<Genero> result = generoRepo.findById(id);
        if(result.isPresent()) {
            result.get().setNome(nome);

            generoRepo.save(result.get());
        }

        return "redirect:/generos/list";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam("id") long id, Model ui) {
        Optional<Genero> result = generoRepo.findById(id);
        if(result.isPresent()) {
            ui.addAttribute("genero", result.get());
            return "/genero/delete";
        }
        return "redirect:/generos/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") long id) {
        generoRepo.deleteById(id);
        return "redirect:/generos/list";
    }
}
