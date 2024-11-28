package org.generation.italy.houseCup.model.services;

import org.generation.italy.houseCup.model.entities.Score;
import org.generation.italy.houseCup.model.repositories.ScoreRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreServiceJpa implements ScoreService{
    private ScoreRepositoryJpa scoreRepositoryJpa;
    @Autowired
    public ScoreServiceJpa(ScoreRepositoryJpa scoreRepositoryJpa) {
        this.scoreRepositoryJpa = scoreRepositoryJpa;
    }

    @Override
    public Score addScore(Score score) {
        return scoreRepositoryJpa.save(score);
    }
}