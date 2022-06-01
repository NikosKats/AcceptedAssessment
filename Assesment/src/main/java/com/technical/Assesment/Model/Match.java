package com.technical.Assesment.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

enum Sport {
    FOOTBALL,
    BASKETBALL
}

@Entity
@Table(name = "match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @OneToMany
    @JoinColumn(name = "match_id", referencedColumnName = "id")
    private List<MatchOdds> match_id;

    @Column(name = "description", length = 50, nullable = false, unique = false)
    private String description;

    @Temporal(TemporalType.DATE)
    private Date match_date;

    @Temporal(TemporalType.DATE)
    private Date match_time;

    @Column(name = "team_A", length = 50, nullable = false, unique = false)
    private String team_a;

    @Column(name = "team_B", length = 50, nullable = false, unique = false)
    private String team_b;

    @Enumerated(EnumType.STRING)
    private Sport sport;

    public Match() {
    }

    public Match(Long id, List<MatchOdds> match_id, String description, Date match_date, Date match_time, String team_a,
            String team_b, Sport sport) {
        this.id = id;
        this.match_id = match_id;
        this.description = description;
        this.match_date = match_date;
        this.match_time = match_time;
        this.team_a = team_a;
        this.team_b = team_b;
        this.sport = sport;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MatchOdds> getMatch_id() {
        return this.match_id;
    }

    public void setMatch_id(List<MatchOdds> match_id) {
        this.match_id = match_id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getMatch_date() {
        return this.match_date;
    }

    public void setMatch_date(Date match_date) {
        this.match_date = match_date;
    }

    public Date getMatch_time() {
        return this.match_time;
    }

    public void setMatch_time(Date match_time) {
        this.match_time = match_time;
    }

    public String getTeam_a() {
        return this.team_a;
    }

    public void setTeam_a(String team_a) {
        this.team_a = team_a;
    }

    public String getTeam_b() {
        return this.team_b;
    }

    public void setTeam_b(String team_b) {
        this.team_b = team_b;
    }

    public Sport getSport() {
        return this.sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Match id(Long id) {
        setId(id);
        return this;
    }

    public Match match_id(List<MatchOdds> match_id) {
        setMatch_id(match_id);
        return this;
    }

    public Match description(String description) {
        setDescription(description);
        return this;
    }

    public Match match_date(Date match_date) {
        setMatch_date(match_date);
        return this;
    }

    public Match match_time(Date match_time) {
        setMatch_time(match_time);
        return this;
    }

    public Match team_a(String team_a) {
        setTeam_a(team_a);
        return this;
    }

    public Match team_b(String team_b) {
        setTeam_b(team_b);
        return this;
    }

    public Match sport(Sport sport) {
        setSport(sport);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Match)) {
            return false;
        }
        Match match = (Match) o;
        return Objects.equals(id, match.id) && Objects.equals(match_id, match.match_id)
                && Objects.equals(description, match.description) && Objects.equals(match_date, match.match_date)
                && Objects.equals(match_time, match.match_time) && Objects.equals(team_a, match.team_a)
                && Objects.equals(team_b, match.team_b) && Objects.equals(sport, match.sport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, match_id, description, match_date, match_time, team_a, team_b, sport);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", match_id='" + getMatch_id() + "'" +
                ", description='" + getDescription() + "'" +
                ", match_date='" + getMatch_date() + "'" +
                ", match_time='" + getMatch_time() + "'" +
                ", team_a='" + getTeam_a() + "'" +
                ", team_b='" + getTeam_b() + "'" +
                ", sport='" + getSport() + "'" +
                "}";
    }

}