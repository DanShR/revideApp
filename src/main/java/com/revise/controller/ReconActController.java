package com.revise.controller;

import com.revise.controller.dto.ReconActDto;
import com.revise.model.ReconAct;
import com.revise.service.ReconActService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReconActController {

   private final ReconActService reconActService;

   public ReconActController(ReconActService reconActService) {
      this.reconActService = reconActService;
   }

   @PostMapping("/add")
   public HttpStatus addReconAct(@Validated @RequestBody ReconActDto reconActDto) {
      reconActService.addReconAct(reconActDto);
      return HttpStatus.OK;
   }

   @GetMapping("/getAll")
   public List<ReconAct> getAll() {

      List<ReconAct> reconActs = reconActService.getAll();
      return reconActs;
   }
}
