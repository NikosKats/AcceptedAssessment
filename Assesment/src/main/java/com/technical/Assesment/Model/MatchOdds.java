package com.technical.Assesment.Model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "matchOdds")
public class MatchOdds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "specifier", length = 50, nullable = false, unique = false)
    private String specifier;

    @Column(name = "odd", length = 50, nullable = false, unique = false)
    private float odd;

    public MatchOdds() {
    }

    public MatchOdds(Long id, String specifier, float odd) {
        this.id = id;
        this.specifier = specifier;
        this.odd = odd;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecifier() {
        return this.specifier;
    }

    public void setSpecifier(String specifier) {
        this.specifier = specifier;
    }

    public float getOdd() {
        return this.odd;
    }

    public void setOdd(float odd) {
        this.odd = odd;
    }

    public MatchOdds id(Long id) {
        setId(id);
        return this;
    }

    public MatchOdds specifier(String specifier) {
        setSpecifier(specifier);
        return this;
    }

    public MatchOdds odd(float odd) {
        setOdd(odd);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MatchOdds)) {
            return false;
        }
        MatchOdds matchOdds = (MatchOdds) o;
        return Objects.equals(id, matchOdds.id) && Objects.equals(specifier, matchOdds.specifier)
                && odd == matchOdds.odd;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, specifier, odd);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", specifier='" + getSpecifier() + "'" +
                ", odd='" + getOdd() + "'" +
                "}";
    }

}