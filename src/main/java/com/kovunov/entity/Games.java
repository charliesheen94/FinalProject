package com.kovunov.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "game_details") // Database table
@NamedQueries({@NamedQuery(name = "findAllGames", query = "SELECT p FROM Games p")})
public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id",length = 20, nullable = false)
    private Long gameId;
    @Column(name = "name",length = 200, nullable = false)
    private String name;
    @Column(name = "price",length = 5, nullable = false)
    private Integer price;
    @Column(name = "publisher",length = 50, nullable = false)
    private String publisher;
    @Column(name = "console_name",length = 50, nullable = false)
    private String console;

    public Games(String name, Integer price, String publisher, String console) {
        this.name = name;
        this.price = price;
        this.publisher = publisher;
        this.console = console;
    }
}
