package com.example.challenge_chapter_4.Service;

import com.example.challenge_chapter_4.Model.DataTransactionEntity;
import com.example.challenge_chapter_4.Model.TransactionEntity;
import com.example.challenge_chapter_4.Repository.DataTransactionInterface;
import com.example.challenge_chapter_4.Repository.TransactionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataTransactionService {
    @Autowired
    DataTransactionInterface dataTransactionInterface;
    @Autowired
    TransactionInterface transactionInterface;

    public DataTransactionEntity saveDataTransaction(DataTransactionEntity dataTransactionEntity){
        TransactionEntity transaction = transactionInterface.getReferenceById(dataTransactionEntity.getUid_transaction());
        DataTransactionEntity transactionData = new DataTransactionEntity();
        transactionData.setUid_transaction(((TransactionEntity) transaction).getUid_transaction()); // Menetapkan ID dari TransactionEntity

        transactionData.setFilm_code(transaction.getFilm_code());
        transactionData.setId_user(transaction.getId_user());
        transactionData.setId_jadwal(transaction.getId_jadwal());
        transactionData.setHarga_tiket(transaction.getHarga_tiket());
        transactionData.setTanggal_tayang(transaction.getTanggal_tayang());
        transactionData.setFilm_name(transaction.getFilm_name());

        return dataTransactionInterface.save(transactionData);
    }
}
