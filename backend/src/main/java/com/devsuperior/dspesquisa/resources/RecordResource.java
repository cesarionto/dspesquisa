package com.devsuperior.dspesquisa.resources;

import com.devsuperior.dspesquisa.dto.RecordDTO;
import com.devsuperior.dspesquisa.dto.RecordInsertDTO;
import com.devsuperior.dspesquisa.services.RecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/records")
public class RecordResource {

    private RecordService recordService;

    public RecordResource(RecordService recordService) {
        this.recordService = recordService;
    }

    @PostMapping
    public ResponseEntity<RecordDTO> save(@RequestBody RecordInsertDTO recordInsertDTO){
        RecordDTO recordDTO = recordService.insert(recordInsertDTO);
        return ResponseEntity.ok().body(recordDTO);
    }
}
