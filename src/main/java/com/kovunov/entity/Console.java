package com.kovunov.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "console")
@NamedQueries({@NamedQuery(name = "findAllConsole", query = "SELECT c FROM Console c")})
public class Console {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "console_code",unique = true, length = 3, nullable = false)
    private String consoleCode;
    @Column(name = "console_name",unique = true, length = 100, nullable = false)
    private String consoleName;

    public Console(String consoleCode, String consoleName) {
        this.consoleCode = consoleCode;
        this.consoleName = consoleName;
    }

}
