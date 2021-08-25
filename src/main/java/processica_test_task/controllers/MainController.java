package processica_test_task.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import processica_test_task.data_stats.Request;
import processica_test_task.data_stats.Stats;
import processica_test_task.service.impl.RequestServiceImpl;

import java.util.List;

@RestController
public class MainController {
    private final RequestServiceImpl requestServiceImpl;

    @Autowired
    public MainController(RequestServiceImpl requestServiceImpl) {
        this.requestServiceImpl = requestServiceImpl;
    }

    @GetMapping("/")
    public ModelAndView main(){
        ModelAndView mav = new ModelAndView("main");
        mav.addObject("request", new Request());
        return mav;
    }

    @PostMapping("/result")
    public List<Stats> result(@RequestBody JsonNode payload, @ModelAttribute("request") Request request ) {
        request.setPayload(payload.asText());
        return requestServiceImpl.save(request).getStatsList();
    }
}
