package duy.code.module04.controller;

import duy.code.module04.model.Brand;
import duy.code.module04.model.Employee;
import duy.code.module04.service.Icrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.ConstraintViolationException;
import java.util.List;

@RestController
@CrossOrigin("*")
public class EmployeeController {
    @Autowired
    private Icrud<Employee> employeeService;

    @Autowired
    private Icrud<Brand> brandService;

    @GetMapping("/")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("listEmployee");
        modelAndView.addObject("employees", employeeService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("employee", new Employee());
        modelAndView.addObject("brands", brandService.findAll());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("employee") Employee employee) {
        try {
            employeeService.save(employee);
        }catch (ConstraintViolationException e) {
            ModelAndView modelAndView = new ModelAndView("create");
            modelAndView.addObject("brands", brandService.findAll());
            modelAndView.addObject("message", "Fail format, Please Re-Enter!");
            return modelAndView;
        }
        List<Employee> employees = (List<Employee>) employeeService.findAll();
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/update/{id}")
    public ModelAndView update(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("create");
        Employee employee = employeeService.findById(id).get();
        modelAndView.addObject("employee", employee);
        modelAndView.addObject("brands", brandService.findAll());
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        employeeService.delete(id);
        return modelAndView;
    }

    @GetMapping("/search")
    public ModelAndView searchByName(@RequestParam("search") String name, Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("listEmployee");
        modelAndView.addObject("employees", employeeService.findAllByName(name));
        return modelAndView;
    }

    @GetMapping("/getByAgeAsc")
    public ModelAndView getByAgeAsc () {
        employeeService.getAllByAgeAsc();
        ModelAndView modelAndView = new ModelAndView("listEmployee");
        modelAndView.addObject("employees",employeeService.getAllByAgeAsc());
        return modelAndView;
    }

    @GetMapping ("/viewDetail/{id}")
    public ModelAndView viewDetail(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("employee", employeeService.findById(id).get());
        return modelAndView;
    }
}
