package com.myjavablog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TODO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Todo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;
    @Column
    private String desc;
    @Column
    private String status;

    public Todo(String name, String desc, String status) {
        this.name = name;
        this.desc = desc;
        this.status = status;
    }
}
