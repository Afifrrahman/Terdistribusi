/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.afif.matkul.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.afif.matkul.entity.matkul;
import java.util.Optional;
import org.springframework.stereotype.Repository;
/**
 *
 * @author ASUS
 */
@Repository
public interface matkulRepository extends JpaRepository<matkul, Long>{
    public Optional<matkul> findMatkulByNama(String nama);

    public Optional<matkul> findMatkulByKode(String kode);

    public Optional<matkul> findMatkulBySks(String sks);
}
