package springio.techordag1.sprintask2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springio.techordag1.sprintask2.model.ApplicationRequest;
import springio.techordag1.sprintask2.repository.ApplicationRequestRepository;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ApplicationRequestRepository applicationRequestRepository;

    @GetMapping(value = "/home")
    public String getHomePage(Model model){
        List<ApplicationRequest> applicationRequestList = applicationRequestRepository.findAll();
        model.addAttribute("applicationRequest", applicationRequestList);
        return "home";
    }

    @GetMapping(value = "/AddRequest")
    public String getRequestPage(){
        return "Addrequest";
    }

    @PostMapping(value = "/AddRequest")
    public String addRequestSubmit(@RequestParam(value = "username") String userName,
                                   @RequestParam(value = "courseName") String courseName,
                                   @RequestParam(value = "phoneNumber") String phoneNumber,
                                   @RequestParam(value = "comment") String commentText){

        ApplicationRequest applicationRequest = new ApplicationRequest();
        applicationRequest.setUserName(userName);
        applicationRequest.setCourseName(courseName);
        applicationRequest.setCommentary(commentText);
        applicationRequest.setPhone(phoneNumber);
        applicationRequest.setHandled(false);
        applicationRequestRepository.save(applicationRequest);
        return "redirect:/home";
    }

    @GetMapping(value = "/DetailsRequest/{id}")
    public String getDetailsRequest(@PathVariable(value = "id") Long id, Model model){
        ApplicationRequest applicationRequest = applicationRequestRepository.findById(id).orElseThrow();
        model.addAttribute("appDetail", applicationRequest);
        return "DetailsRequest";
    }

    @PostMapping(value = "/removeRequest/{id}")
    public String removeRequestById(@PathVariable(value = "id") Long id){
        applicationRequestRepository.deleteById(id);
        return "redirect:/home";
    }

    @PostMapping(value = "/changeHandled/{id}")
    public String changeHandled(@PathVariable(value = "id") Long id){
        ApplicationRequest applicationRequest = applicationRequestRepository.findById(id).orElseThrow(null);
        applicationRequest.setHandled(true);
        applicationRequestRepository.save(applicationRequest);
        return "redirect:/home";
    }

}
