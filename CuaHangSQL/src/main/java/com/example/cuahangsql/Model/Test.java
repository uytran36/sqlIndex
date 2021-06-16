package com.example.cuahangsql.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "testing")
@AllArgsConstructor
@NoArgsConstructor
public class Test {
    @Id
    @Column(name = "id")
    private String MaHD;
    @Column(name = "test")
    private String MaKH;

}
