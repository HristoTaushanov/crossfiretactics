package com.crossfiretactics.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.*;

@Entity
@Table(name = "tournaments")
public class Tournament extends BaseEntity {

    private String name;
    //    private TournamentType type;
    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Score> scores;

    public Tournament() {
        this.scores = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Score> getScores() {
        return scores;
    }

    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public void addScore(Shooter shooter, double score) {
        Score newScore = new Score();
        newScore.setShooter(shooter);
        newScore.setScore(score);
        newScore.setTournament(this);
        this.scores.add(newScore);
    }
}
