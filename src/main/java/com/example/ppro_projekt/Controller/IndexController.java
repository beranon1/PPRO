package com.example.ppro_projekt.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

  @GetMapping("/")
    public String index() {
      return "index";
  }

  @GetMapping("/403")
  public String forbidden() {
    return "403";
  }

  @ExceptionHandler(Exception.class)
  public String handleException() {
    return "error";
  }

  @GetMapping("/admin/")
  @ResponseBody
  public String admin() {
    return "<h1>Admin section</h1>";
  }

}
