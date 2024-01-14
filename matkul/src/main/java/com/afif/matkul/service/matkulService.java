/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.afif.matkul.service;

/**
 *
 * @author ASUS
 */

import com.afif.matkul.entity.matkul;
import com.afif.matkul.entity.matkul;
import com.afif.matkul.repository.matkulRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class matkulService {
     @Autowired
    private  matkulRepository matkulrepository;
    public List<matkul> getAll;
    
    public List<matkul>getAll(){
        return matkulrepository.findAll();
    }
    public void insert(matkul matkul){
        Optional<matkul> matkulOptional = matkulrepository.findMatkulByNama(matkul.getNama());
        Optional<matkul> matkulOptionalkode = matkulrepository.findMatkulByKode(matkul.getKode());
        if (matkulOptional.isPresent()) {
            throw new IllegalStateException("nama mata kuliah ini sudah ada");
        }
        if (matkulOptionalkode.isPresent()) {
            throw new IllegalStateException("kode mata kuliah ini sudah ada");
        }
        
        matkulrepository.save(matkul);
    }
    
    public void delete (Long id){
        boolean ada = matkulrepository.existsById(id);
        
        if (!ada) {
            throw new IllegalStateException("mata kuliah ini tidak ada");
        }
        matkulrepository.deleteById(id);
    }
    
    @Transactional
    public void update(Long id, String kode, String nama, String sks){
        matkul matkul = matkulrepository.findById(id).orElseThrow(()-> new IllegalStateException("mata kuliah ini tidak ada"));
        
        if (nama != null && nama.length()>0 && !Objects.equals(matkul.getNama(),nama)) {
            matkul.setNama(nama);
        }
        if (kode != null && kode.length()>0 && !Objects.equals(matkul.getKode(),kode)) {
            Optional<matkul> mahaOptionalkode = matkulrepository.findMatkulByKode(kode);
            if (mahaOptionalkode.isPresent()) {
                throw  new IllegalStateException("kode ini sudah ada");
            }
            matkul.setKode(kode);
        }
         if (nama != null && nama.length()>0 && !Objects.equals(matkul.getNama(),nama)) {
            Optional<matkul> mahaOptional = matkulrepository.findMatkulByNama(nama);
            if (mahaOptional.isPresent()) {
                throw  new IllegalStateException("nama mata kuliah ini sudah ada");
            }
            matkul.setKode(nama);
        }
         if (sks != null && sks.length()>0 && !Objects.equals(matkul.getSks(),sks)) {
            matkul.setNama(sks);
        }
        
    }
    
}
