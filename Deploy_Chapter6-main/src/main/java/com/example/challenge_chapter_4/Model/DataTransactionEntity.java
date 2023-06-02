package com.example.challenge_chapter_4.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@Entity
@Data
@Table(name = "data_transaction")
@Getter
@Setter
public class DataTransactionEntity {
    @Id
    private UUID uid_transaction;
    private int id_user;
    private int id_jadwal;
    private String film_name;
    private String film_code;
    private Date tanggal_tayang;
    private int harga_tiket;
}
}
