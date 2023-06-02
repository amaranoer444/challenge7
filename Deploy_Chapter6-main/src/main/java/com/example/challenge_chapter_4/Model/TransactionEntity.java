package com.example.challenge_chapter_4.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;
import java.util.UUID;

@Entity
@Data
@Table(name = "transaction")
@Getter
@Setter
public class TransactionEntity {
    @Id
    private UUID uid_transaction;
    private int id_user;
    private int id_jadwal;
    private String film_name;
    private String film_code;
    private Date tanggal_tayang;
    private int harga_tiket;

    public char getStudio_name() {
        return 0;
    }

    public int getNomor_kursi() {
        return 0;
    } 

    public void setUsername(String username) {
    }

    public void setStudio_name(char studioName) {
    }

    public void setNomor_kursi(int nomorKursi) {
    }

    public void setJam_mulai(Time jamMulai) {
    }

    public void setJam_selesai(Time jamSelesai) {
    }
}
