/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.afif.matkul.controller;

/**
 *
 * @author ASUS
 */

import com.afif.matkul.entity.matkul;
import com.afif.matkul.service.matkulService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/matkul")
public class matkulController {
    @Autowired
    private matkulService matkulservice;

    @GetMapping
    public List<matkul> getAll() {
        return matkulservice.getAll;
    }

    @PostMapping
    public void insert(@RequestBody matkul matkul) {
        matkulservice.insert(matkul);
    }

    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id) {
        matkulservice.delete(id);
    }

    @PutMapping(path = "{id}")
    public void update(@PathVariable("id") Long id, 
            @RequestParam(required = false) String kode,
            @RequestParam(required = false) String nama,
            @RequestParam(required = false) String sks) {
        matkulservice.update(id, kode, nama, sks);
    }
}
