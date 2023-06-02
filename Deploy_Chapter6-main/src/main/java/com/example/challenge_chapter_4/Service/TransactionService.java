package com.example.challenge_chapter_4.Service;

import com.example.challenge_chapter_4.Model.*;
import com.example.challenge_chapter_4.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    TransactionInterface transactionInterface;
    @Autowired
    UsersInterface usersInterface;
    @Autowired
    JadwalInterface jadwalInterface;
    @Autowired
    StudioInterface studioInterface;
    @Autowired
    SeatsInterface seatsInterface;
    @Autowired
    FilmInterface filmInterface;

    public TransactionEntity buyTicket(TransactionEntity transaction) {
        UsersEntity users = usersInterface.getReferenceById(transaction.getId_user());
        JadwalEntity jadwal = jadwalInterface.getReferenceById(transaction.getId_jadwal());
        StudioEntity studio = studioInterface.getReferenceById(transaction.getStudio_name());
        SeatsEntity seats = seatsInterface.getByStudioSeat(transaction.getStudio_name(), transaction.getNomor_kursi());
        FilmEntity film = filmInterface.getReferenceById(transaction.getFilm_code());


        TransactionEntity existingTransaction = transactionInterface.findByStudioAndNomorKursi(transaction.getStudio_name(), transaction.getNomor_kursi());
        if (existingTransaction != null) {
            throw new RuntimeException("Nomor kursi dan studio sudah ada. Tidak dapat menyimpan transaksi.");
        }
        TransactionEntity transactionExist = transactionInterface.findById(transaction.getUid_transaction()).orElse(null);
        if (transactionExist == null) {
            transactionExist = new TransactionEntity();
            transactionExist.setUid_transaction(generateUUID());

            transactionExist.setFilm_code(film.getFilm_code());
            transactionExist.setUsername(users.getUsername());
            transactionExist.setId_user(users.getId_user());
            transactionExist.setId_jadwal(jadwal.getId_jadwal());
            transactionExist.setHarga_tiket(jadwal.getHarga_tiket());
            transactionExist.setStudio_name(studio.getStudio_name());
            transactionExist.setNomor_kursi(seats.getNomor_kursi());
            transactionExist.setJam_mulai(jadwal.getJam_mulai());
            transactionExist.setJam_selesai(jadwal.getJam_selesai());
            transactionExist.setTanggal_tayang(jadwal.getTanggal_tayang());
            transactionExist.setFilm_name(film.getFilm_name());
        }

        return transactionInterface.save(transactionExist);


    }

    private UUID generateUUID() {
        return UUID.randomUUID();
    }

    public void truncate(){
        transactionInterface.deleteAll();
    }

}
