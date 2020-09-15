package com.devsuperior.dspesquisa.services;

import com.devsuperior.dspesquisa.dto.RecordDTO;
import com.devsuperior.dspesquisa.dto.RecordInsertDTO;
import com.devsuperior.dspesquisa.entities.Game;
import com.devsuperior.dspesquisa.entities.Record;
import com.devsuperior.dspesquisa.repositories.GameRepository;
import com.devsuperior.dspesquisa.repositories.RecordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class RecordService {

    private RecordRepository recordRepository;
    private GameRepository gameRepository;

    public RecordService(RecordRepository recordRepository, GameRepository gameRepository) {
        this.recordRepository = recordRepository;
        this.gameRepository = gameRepository;
    }

    @Transactional
    public RecordDTO insert(RecordInsertDTO recordInsertDTO){

        Record record = new Record();
        record.setName(recordInsertDTO.getName());
        record.setAge(recordInsertDTO.getAge());
        record.setMoment(Instant.now());

        Game game = gameRepository.getOne(recordInsertDTO.getGameId());
        record.setGame(game);

        record = recordRepository.save(record);

        return new RecordDTO(record);
    }
}
